using PasswordGenerator;
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

                try {
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
                } catch (Exception err) {
                    Console.WriteLine(err.Message);
                    return null;
                }

            }
        }

        public Customer registerCustomer(string newUsername) {
            var pwd = new Password().IncludeLowercase().IncludeUppercase().IncludeSpecial();
            var newPassword = pwd.Next();

            // TODO check if customer exists / create customer if so and redirect to product screen logged in?
            customerSet newCustomer = new customerSet {
                username = newUsername,
                password = newPassword,
                balance = 20
            };

            using (prac5_dbEntities db = new prac5_dbEntities()) {
                customerSet c = db.customerSets.Add(newCustomer);
                db.SaveChanges();
                return new Customer {
                    Id = c.Id,
                    UserName = c.username,
                    Balance = c.balance,
                    Password = c.password
                };
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
