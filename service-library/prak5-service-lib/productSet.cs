//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace prak5_service_lib
{
    using System;
    using System.Collections.Generic;
    
    public partial class productSet
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public productSet()
        {
            this.orderLineSets = new HashSet<orderLineSet>();
        }
    
        public int Id { get; set; }
        public string name { get; set; }
        public double price { get; set; }
        public int stock { get; set; }
        public int store_Id { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<orderLineSet> orderLineSets { get; set; }
        public virtual storeSet storeSet { get; set; }
    }
}