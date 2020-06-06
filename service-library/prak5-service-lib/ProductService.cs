using System;
using System.Collections.Generic;
using System.Linq;

namespace prak5_service_lib
{
    public class ProductService : IProductService
    {

        public List<Product> All()
        {
            List<Product> productList = new List<Product>();

            try
            {
                using (prac5_dbEntities db = new prac5_dbEntities())
                {
                    IQueryable<Product> products = from p in db.productSets
                                                   select new Product
                                                   {
                                                       Name = p.name,
                                                       Stock = p.stock,
                                                       Price = p.price,
                                                       Id = p.Id
                                                   };

                    productList = products.ToList();
                }
            }
            catch
            {
                throw new Exception("Could not fetch the products");
            }

            return productList;
        }

        public Product Find(int id)
        {
            try
            {
                using (prac5_dbEntities db = new prac5_dbEntities())
                {
                    return (from p in db.productSets
                                    where p.Id == id
                                    select new Product
                                    {
                                        Name = p.name,
                                        Stock = p.stock,
                                        Price = p.price,
                                        Id = p.Id
                                    }).First();
                }
            }
            catch
            {
                throw new Exception("Could not find the product");
            }
        }
    }
}
