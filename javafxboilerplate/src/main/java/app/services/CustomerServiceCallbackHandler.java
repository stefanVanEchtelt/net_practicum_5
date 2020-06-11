/**
 * CustomerServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package app.services;


/**
 *  CustomerServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class CustomerServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public CustomerServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public CustomerServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for registerCustomer method
     * override this method for handling normal response from registerCustomer operation
     */
    public void receiveResultregisterCustomer(
        app.services.CustomerServiceStub.RegisterCustomerResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from registerCustomer operation
     */
    public void receiveErrorregisterCustomer(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for loginCustomer method
     * override this method for handling normal response from loginCustomer operation
     */
    public void receiveResultloginCustomer(
        app.services.CustomerServiceStub.LoginCustomerResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from loginCustomer operation
     */
    public void receiveErrorloginCustomer(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for find method
     * override this method for handling normal response from find operation
     */
    public void receiveResultfind(
        app.services.CustomerServiceStub.FindResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from find operation
     */
    public void receiveErrorfind(java.lang.Exception e) {
    }
}
