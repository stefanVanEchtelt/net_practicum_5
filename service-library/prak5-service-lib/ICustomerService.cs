using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace prak5_service_lib
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ICustomerService" in both code and config file together.
    [ServiceContract]
    public interface ICustomerService
    {
        [OperationContract]
        Customer registerCustomer(string username);

        [OperationContract]
        Customer loginCustomer(string username, string password);

        [OperationContract]
        Customer Find(int id);
    }

    [DataContract]
    public class Customer
    {
        [DataMember]
        public int Id { get; set; }

        [DataMember]
        public string UserName { get; set; }

        [DataMember]
        public double Balance { get; set; }

        [DataMember]
        public string Password { get; set; }
    }
}
