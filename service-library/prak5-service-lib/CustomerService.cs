using System;
using System.Collections.Generic;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace prak5_service_lib {
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "CustomerService" in both code and config file together.
    public class CustomerService : ICustomerService {
        public Customer loginCustomer(string username, string password) {
            using (prac5_dbEntities db = new prac5_dbEntities()) {

                return (from c in db.customerSets
                        where c.username == username
                        && c.password == password
                        select new Customer
                        {
                            Id = c.Id,
                            UserName = c.username,
                            Balance = c.balance,
                            Password = c.password
                        }).First();
            }
        }

        public customerSet registerCustomer(string newUsername, string newPassword) {

            // TODO check if use exists
            var newCustomer = new customerSet {
                username = newUsername,
                password = newPassword,
                balance = 20
            };

            using (prac5_dbEntities db = new prac5_dbEntities()) {
                customerSet customer = db.customerSets.Add(newCustomer);
                db.SaveChanges();
                return customer;
            }
        }
        
        public Customer Find(int id)
        {
            using (prac5_dbEntities db = new prac5_dbEntities())
            {
                return (from c in db.customerSets
                        where c.Id == id
                        select new Customer
                        {
                            Id = c.Id,
                            UserName = c.username,
                            Balance = c.balance
                        }).First();
            }
        }
    }
}
