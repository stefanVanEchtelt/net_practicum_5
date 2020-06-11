/**
 * CustomerServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package main.services;


/*
 *  CustomerServiceTest Junit test case
 */
public class CustomerServiceTest extends junit.framework.TestCase {
    /**
     * Auto generated test method
     */
    public void testregisterCustomer() throws java.lang.Exception {
        main.services.CustomerServiceStub stub = new main.services.CustomerServiceStub(); //the default implementation should point to the right endpoint

        main.services.CustomerServiceStub.RegisterCustomer registerCustomer12 = (main.services.CustomerServiceStub.RegisterCustomer) getTestObject(main.services.CustomerServiceStub.RegisterCustomer.class);
        // TODO : Fill in the registerCustomer12 here
        assertNotNull(stub.registerCustomer(registerCustomer12));
    }

    /**
     * Auto generated test method
     */
    public void testStartregisterCustomer() throws java.lang.Exception {
        main.services.CustomerServiceStub stub = new main.services.CustomerServiceStub();
        main.services.CustomerServiceStub.RegisterCustomer registerCustomer12 = (main.services.CustomerServiceStub.RegisterCustomer) getTestObject(main.services.CustomerServiceStub.RegisterCustomer.class);
        // TODO : Fill in the registerCustomer12 here
        stub.startregisterCustomer(registerCustomer12, new tempCallbackN1000C());
    }

    /**
     * Auto generated test method
     */
    public void testloginCustomer() throws java.lang.Exception {
        main.services.CustomerServiceStub stub = new main.services.CustomerServiceStub(); //the default implementation should point to the right endpoint

        main.services.CustomerServiceStub.LoginCustomer loginCustomer14 = (main.services.CustomerServiceStub.LoginCustomer) getTestObject(main.services.CustomerServiceStub.LoginCustomer.class);
        // TODO : Fill in the loginCustomer14 here
        assertNotNull(stub.loginCustomer(loginCustomer14));
    }

    /**
     * Auto generated test method
     */
    public void testStartloginCustomer() throws java.lang.Exception {
        main.services.CustomerServiceStub stub = new main.services.CustomerServiceStub();
        main.services.CustomerServiceStub.LoginCustomer loginCustomer14 = (main.services.CustomerServiceStub.LoginCustomer) getTestObject(main.services.CustomerServiceStub.LoginCustomer.class);
        // TODO : Fill in the loginCustomer14 here
        stub.startloginCustomer(loginCustomer14, new tempCallbackN1004C());
    }

    /**
     * Auto generated test method
     */
    public void testfind() throws java.lang.Exception {
        main.services.CustomerServiceStub stub = new main.services.CustomerServiceStub(); //the default implementation should point to the right endpoint

        main.services.CustomerServiceStub.Find find16 = (main.services.CustomerServiceStub.Find) getTestObject(main.services.CustomerServiceStub.Find.class);
        // TODO : Fill in the find16 here
        assertNotNull(stub.find(find16));
    }

    /**
     * Auto generated test method
     */
    public void testStartfind() throws java.lang.Exception {
        main.services.CustomerServiceStub stub = new main.services.CustomerServiceStub();
        main.services.CustomerServiceStub.Find find16 = (main.services.CustomerServiceStub.Find) getTestObject(main.services.CustomerServiceStub.Find.class);
        // TODO : Fill in the find16 here
        stub.startfind(find16, new tempCallbackN1008C());
    }

    //Create an ADBBean and provide it as the test object
    public org.apache.axis2.databinding.ADBBean getTestObject(
        java.lang.Class type) throws java.lang.Exception {
        return (org.apache.axis2.databinding.ADBBean) type.newInstance();
    }

    private class tempCallbackN1000C extends main.services.CustomerServiceCallbackHandler {
        public tempCallbackN1000C() {
            super(null);
        }

        public void receiveResultregisterCustomer(
            main.services.CustomerServiceStub.RegisterCustomerResponse result) {
        }

        public void receiveErrorregisterCustomer(java.lang.Exception e) {
            fail();
        }
    }

    private class tempCallbackN1004C extends main.services.CustomerServiceCallbackHandler {
        public tempCallbackN1004C() {
            super(null);
        }

        public void receiveResultloginCustomer(
            main.services.CustomerServiceStub.LoginCustomerResponse result) {
        }

        public void receiveErrorloginCustomer(java.lang.Exception e) {
            fail();
        }
    }

    private class tempCallbackN1008C extends main.services.CustomerServiceCallbackHandler {
        public tempCallbackN1008C() {
            super(null);
        }

        public void receiveResultfind(
            main.services.CustomerServiceStub.FindResponse result) {
        }

        public void receiveErrorfind(java.lang.Exception e) {
            fail();
        }
    }
}
