/**
 * OrderLineServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package main.services;


/*
 *  OrderLineServiceTest Junit test case
 */
public class OrderLineServiceTest extends junit.framework.TestCase {
    /**
     * Auto generated test method
     */
    public void testperProductByCustomer() throws java.lang.Exception {
        main.services.OrderLineServiceStub stub = new main.services.OrderLineServiceStub(); //the default implementation should point to the right endpoint

        main.services.OrderLineServiceStub.PerProductByCustomer perProductByCustomer4 =
            (main.services.OrderLineServiceStub.PerProductByCustomer) getTestObject(main.services.OrderLineServiceStub.PerProductByCustomer.class);
        // TODO : Fill in the perProductByCustomer4 here
        assertNotNull(stub.perProductByCustomer(perProductByCustomer4));
    }

    /**
     * Auto generated test method
     */
    public void testStartperProductByCustomer() throws java.lang.Exception {
        main.services.OrderLineServiceStub stub = new main.services.OrderLineServiceStub();
        main.services.OrderLineServiceStub.PerProductByCustomer perProductByCustomer4 =
            (main.services.OrderLineServiceStub.PerProductByCustomer) getTestObject(main.services.OrderLineServiceStub.PerProductByCustomer.class);
        // TODO : Fill in the perProductByCustomer4 here
        stub.startperProductByCustomer(perProductByCustomer4,
            new tempCallbackN1000C());
    }

    //Create an ADBBean and provide it as the test object
    public org.apache.axis2.databinding.ADBBean getTestObject(
        java.lang.Class type) throws java.lang.Exception {
        return (org.apache.axis2.databinding.ADBBean) type.newInstance();
    }

    private class tempCallbackN1000C extends main.services.OrderLineServiceCallbackHandler {
        public tempCallbackN1000C() {
            super(null);
        }

        public void receiveResultperProductByCustomer(
            main.services.OrderLineServiceStub.PerProductByCustomerResponse result) {
        }

        public void receiveErrorperProductByCustomer(java.lang.Exception e) {
            fail();
        }
    }
}
