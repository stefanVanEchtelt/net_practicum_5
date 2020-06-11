/**
 * IOrderService_Order_OrderServiceFaultFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package app.services;

public class IOrderService_Order_OrderServiceFaultFault_FaultMessage extends java.lang.Exception {
    private static final long serialVersionUID = 1591878049704L;
    private app.services.OrderServiceStub.OrderServiceFaultE faultMessage;

    public IOrderService_Order_OrderServiceFaultFault_FaultMessage() {
        super("IOrderService_Order_OrderServiceFaultFault_FaultMessage");
    }

    public IOrderService_Order_OrderServiceFaultFault_FaultMessage(
        java.lang.String s) {
        super(s);
    }

    public IOrderService_Order_OrderServiceFaultFault_FaultMessage(
        java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public IOrderService_Order_OrderServiceFaultFault_FaultMessage(
        java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(
        app.services.OrderServiceStub.OrderServiceFaultE msg) {
        faultMessage = msg;
    }

    public app.services.OrderServiceStub.OrderServiceFaultE getFaultMessage() {
        return faultMessage;
    }
}
