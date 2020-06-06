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
        public customerSet loginCustomer(string username, string password) {
            using (prac5_dbEntities db = new prac5_dbEntities()) {
                var query = db.customerSets.Where(c => c.username == username && c.password == password).FirstOrDefault<customerSet>();
                return query;
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
    }
}
