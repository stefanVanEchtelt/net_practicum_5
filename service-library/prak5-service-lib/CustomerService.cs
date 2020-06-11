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
        public Customer LoginCustomer(string username, string password) {
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

        public Customer RegisterCustomer(string newUsername) {
            var pwd = new Password().IncludeLowercase().IncludeUppercase().IncludeSpecial();
            var newPassword = pwd.Next();
            // TODO check if customer exists / create customer if so and redirect to product screen logged in?
            Customer x = this.FindByUsername(newUsername);
            if (x == null) {
                customerSet newCustomer = new customerSet
                {
                    username = newUsername,
                    password = newPassword,
                    balance = new Random().Next(5, 105)
                };

                using (prac5_dbEntities db = new prac5_dbEntities())
                {
                    customerSet c = db.customerSets.Add(newCustomer);
                    db.SaveChanges();
                    return new Customer
                    {
                        Id = c.Id,
                        UserName = c.username,
                        Balance = c.balance,
                        Password = c.password
                    };
                }
            } else
            {
                throw new FaultException<CustomerFaultService>(new CustomerFaultService("User bestaat al..."));
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
                        }).FirstOrDefault();
            }
        }

        public Customer FindByUsername(string username)
        {
            using (prac5_dbEntities db = new prac5_dbEntities())
            {
                return (from c in db.customerSets
                        where c.username == username
                        select new Customer
                        {
                            Id = c.Id,
                            UserName = c.username,
                            Balance = c.balance,
                            Password = c.password
                        }).FirstOrDefault();
            }
        }
    }
}
