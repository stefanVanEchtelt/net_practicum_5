/**
 * ICustomerService_RegisterCustomer_CustomerFaultServiceFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package main.services;

public class ICustomerService_RegisterCustomer_CustomerFaultServiceFault_FaultMessage
    extends java.lang.Exception {
    private static final long serialVersionUID = 1591878149927L;
    private main.services.CustomerServiceStub.CustomerFaultServiceE faultMessage;

    public ICustomerService_RegisterCustomer_CustomerFaultServiceFault_FaultMessage() {
        super(
            "ICustomerService_RegisterCustomer_CustomerFaultServiceFault_FaultMessage");
    }

    public ICustomerService_RegisterCustomer_CustomerFaultServiceFault_FaultMessage(
        java.lang.String s) {
        super(s);
    }

    public ICustomerService_RegisterCustomer_CustomerFaultServiceFault_FaultMessage(
        java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public ICustomerService_RegisterCustomer_CustomerFaultServiceFault_FaultMessage(
        java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(
        main.services.CustomerServiceStub.CustomerFaultServiceE msg) {
        faultMessage = msg;
    }

    public main.services.CustomerServiceStub.CustomerFaultServiceE getFaultMessage() {
        return faultMessage;
    }
}
