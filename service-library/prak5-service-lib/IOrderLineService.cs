using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace prak5_service_lib
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IOrderLineService" in both code and config file together.
    [ServiceContract]
    public interface IOrderLineService
    {
        [OperationContract]
        List<BoughtProduct> PerProductByCustomer(int CustomerId);
    }

    [DataContract]
    public class BoughtProduct
    {
        [DataMember]
        public int ProductId { get; set; }

        [DataMember]
        public string Name { get; set; }

        [DataMember]
        public int Amount { get; set; }
    }
}
