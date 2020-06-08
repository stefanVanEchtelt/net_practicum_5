using System;
using System.Collections.Generic;
using System.Data.Entity.Migrations;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace prak5_service_lib
{
    public class OrderService : IOrderService
    {
        public bool Order(int customerId, int storeId, List<BuyingProduct> products)
        {
            orderSet Order = new orderSet {
                customer_Id = customerId,
                date = DateTime.Now,
            };

            using (prac5_dbEntities db = new prac5_dbEntities())
            {
                customerSet customer = (from c in db.customerSets
                                where c.Id == customerId
                                select c).First();

                double price = (
                    from p2 in products
                    select p2.Amount * (
                        from p in db.productSets
                        where p.Id == p2.Id
                        select p.price
                    ).First()
                ).Sum();

                int lowestStock = (
                    from p2 in products
                    select (
                        from p in db.productSets
                        where p.Id == p2.Id
                        select p.stock
                    ).First() - p2.Amount
                ).Min();

                if (lowestStock < 0) {
                    throw new FaultException<MyServiceFault>(new MyServiceFault("Not enough Stok"));
                }

                if (price > customer.balance) {
                    throw new FaultException<MyServiceFault>(new MyServiceFault("Not enough balance to pay for this."));
                }

                customer.balance -= price; 

                db.customerSets.AddOrUpdate(customer);
                orderSet SavedOrder = db.orderSets.Add(Order);

                foreach (BuyingProduct bp in products)
                {
                    productSet product = (from p in db.productSets
                                           where p.Id == bp.Id
                                           select p).First();

                    product.stock -= bp.Amount;

                    orderLineSet orderLine = new orderLineSet
                    {
                        amount = bp.Amount,
                        order_Id = SavedOrder.Id,
                        product_Id = bp.Id,
                    };

                    db.orderLineSets.Add(orderLine);
                    db.productSets.AddOrUpdate(product);
                }


                db.SaveChanges();
            }

            return true;
        }
    }
}
