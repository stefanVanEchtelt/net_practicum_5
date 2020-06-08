using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace prak5_service_lib
{
    [ServiceContract]
    public interface ICustomerService
    {
        [OperationContract]
        [FaultContract(typeof(CustomerFaultService))]
        Customer RegisterCustomer(string username);

        [OperationContract]
        [FaultContract(typeof(CustomerFaultService))]
        Customer LoginCustomer(string username, string password);

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

    [DataContract]
    public class CustomerFaultService
    {
        private string _message;

        public CustomerFaultService(string message)
        {
            _message = message;
        }

        [DataMember]
        public string Message { get { return _message; } set { _message = value; } }
    }
}
