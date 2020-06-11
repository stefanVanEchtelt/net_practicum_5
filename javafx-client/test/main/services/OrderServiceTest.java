/**
 * OrderServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package main.services;


/*
 *  OrderServiceTest Junit test case
 */
public class OrderServiceTest extends junit.framework.TestCase {
    /**
     * Auto generated test method
     */
    public void testorder() throws java.lang.Exception {
        main.services.OrderServiceStub stub = new main.services.OrderServiceStub(); //the default implementation should point to the right endpoint

        main.services.OrderServiceStub.Order order4 = (main.services.OrderServiceStub.Order) getTestObject(main.services.OrderServiceStub.Order.class);
        // TODO : Fill in the order4 here
        assertNotNull(stub.order(order4));
    }

    /**
     * Auto generated test method
     */
    public void testStartorder() throws java.lang.Exception {
        main.services.OrderServiceStub stub = new main.services.OrderServiceStub();
        main.services.OrderServiceStub.Order order4 = (main.services.OrderServiceStub.Order) getTestObject(main.services.OrderServiceStub.Order.class);
        // TODO : Fill in the order4 here
        stub.startorder(order4, new tempCallbackN1000C());
    }

    //Create an ADBBean and provide it as the test object
    public org.apache.axis2.databinding.ADBBean getTestObject(
        java.lang.Class type) throws java.lang.Exception {
        return (org.apache.axis2.databinding.ADBBean) type.newInstance();
    }

    private class tempCallbackN1000C extends main.services.OrderServiceCallbackHandler {
        public tempCallbackN1000C() {
            super(null);
        }

        public void receiveResultorder(
            main.services.OrderServiceStub.OrderResponse result) {
        }

        public void receiveErrororder(java.lang.Exception e) {
            fail();
        }
    }
}
