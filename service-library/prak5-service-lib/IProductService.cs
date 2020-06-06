using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;


namespace prak5_service_lib
{

    [ServiceContract]
    interface IProductService
    {
        [OperationContract]
        List<Product> All();

        [OperationContract]
        Product Find(int id);
    }

    [DataContract]
    public class Product
    {
        [DataMember]
        public int Id { get; set; }

        [DataMember]
        public string Name { get; set; }

        [DataMember]
        public double Price { get; set; }

        [DataMember]
        public int Stock { get; set; }
    }
}
