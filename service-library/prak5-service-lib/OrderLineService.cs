using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace prak5_service_lib
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "OrderLineService" in both code and config file together.
    public class OrderLineService : IOrderLineService
    {
        public List<BoughtProduct> PerProductByCustomer(int CustomerId)
        {
            using (prac5_dbEntities db = new prac5_dbEntities())
            {
                return db.orderLineSets
                    .Where(ol => ol.orderSet.customer_Id == CustomerId)
                    .GroupBy(ol => ol.product_Id)
                    .Select(olg => new BoughtProduct
                    {
                        ProductId = olg.FirstOrDefault().product_Id,
                        Name = olg.FirstOrDefault().productSet.name,
                        Amount = olg.Sum(l => l.amount),
                    }).ToList();
            }
        }
    }
}
