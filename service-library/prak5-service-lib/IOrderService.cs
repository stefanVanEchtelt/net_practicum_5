using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace prak5_service_lib
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IOrderService" in both code and config file together.
    [ServiceContract]
    public interface IOrderService
    {
        [OperationContract]
        [FaultContract(typeof(MyServiceFault))]
        bool Order(int customerId, int storeId, List<BuyingProduct> products);
    }

    [DataContract]
    public class BuyingProduct
    {
        [DataMember]
        public int Id { get; set; }

        [DataMember]
        public int Amount { get; set; }

    }

    [DataContract]
    public class MyServiceFault
    {
        private string _message;

        public MyServiceFault(string message)
        {
            _message = message;
        }

        [DataMember]
        public string Message { get { return _message; } set { _message = value; } }
    }
}
