/**
 * ProductServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package main.services;


/*
 *  ProductServiceTest Junit test case
 */
public class ProductServiceTest extends junit.framework.TestCase {
    /**
     * Auto generated test method
     */
    public void testall() throws java.lang.Exception {
        main.services.ProductServiceStub stub = new main.services.ProductServiceStub(); //the default implementation should point to the right endpoint

        main.services.ProductServiceStub.All all8 = (main.services.ProductServiceStub.All) getTestObject(main.services.ProductServiceStub.All.class);
        // TODO : Fill in the all8 here
        assertNotNull(stub.all(all8));
    }

    /**
     * Auto generated test method
     */
    public void testStartall() throws java.lang.Exception {
        main.services.ProductServiceStub stub = new main.services.ProductServiceStub();
        main.services.ProductServiceStub.All all8 = (main.services.ProductServiceStub.All) getTestObject(main.services.ProductServiceStub.All.class);
        // TODO : Fill in the all8 here
        stub.startall(all8, new tempCallbackN1000C());
    }

    /**
     * Auto generated test method
     */
    public void testfind() throws java.lang.Exception {
        main.services.ProductServiceStub stub = new main.services.ProductServiceStub(); //the default implementation should point to the right endpoint

        main.services.ProductServiceStub.Find find10 = (main.services.ProductServiceStub.Find) getTestObject(main.services.ProductServiceStub.Find.class);
        // TODO : Fill in the find10 here
        assertNotNull(stub.find(find10));
    }

    /**
     * Auto generated test method
     */
    public void testStartfind() throws java.lang.Exception {
        main.services.ProductServiceStub stub = new main.services.ProductServiceStub();
        main.services.ProductServiceStub.Find find10 = (main.services.ProductServiceStub.Find) getTestObject(main.services.ProductServiceStub.Find.class);
        // TODO : Fill in the find10 here
        stub.startfind(find10, new tempCallbackN10035());
    }

    //Create an ADBBean and provide it as the test object
    public org.apache.axis2.databinding.ADBBean getTestObject(
        java.lang.Class type) throws java.lang.Exception {
        return (org.apache.axis2.databinding.ADBBean) type.newInstance();
    }

    private class tempCallbackN1000C extends main.services.ProductServiceCallbackHandler {
        public tempCallbackN1000C() {
            super(null);
        }

        public void receiveResultall(
            main.services.ProductServiceStub.AllResponse result) {
        }

        public void receiveErrorall(java.lang.Exception e) {
            fail();
        }
    }

    private class tempCallbackN10035 extends main.services.ProductServiceCallbackHandler {
        public tempCallbackN10035() {
            super(null);
        }

        public void receiveResultfind(
            main.services.ProductServiceStub.FindResponse result) {
        }

        public void receiveErrorfind(java.lang.Exception e) {
            fail();
        }
    }
}
