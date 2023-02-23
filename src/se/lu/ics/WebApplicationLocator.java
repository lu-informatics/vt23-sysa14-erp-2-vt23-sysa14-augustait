/**
 * WebApplicationLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package se.lu.ics;

public class WebApplicationLocator extends org.apache.axis.client.Service implements se.lu.ics.WebApplication {

    public WebApplicationLocator() {
    }


    public WebApplicationLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebApplicationLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebApplicationSoap
    private java.lang.String WebApplicationSoap_address = "http://localhost/ERPWEB/WebApplication.asmx";

    public java.lang.String getWebApplicationSoapAddress() {
        return WebApplicationSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebApplicationSoapWSDDServiceName = "WebApplicationSoap";

    public java.lang.String getWebApplicationSoapWSDDServiceName() {
        return WebApplicationSoapWSDDServiceName;
    }

    public void setWebApplicationSoapWSDDServiceName(java.lang.String name) {
        WebApplicationSoapWSDDServiceName = name;
    }

    public se.lu.ics.WebApplicationSoap getWebApplicationSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebApplicationSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebApplicationSoap(endpoint);
    }

    public se.lu.ics.WebApplicationSoap getWebApplicationSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            se.lu.ics.WebApplicationSoapStub _stub = new se.lu.ics.WebApplicationSoapStub(portAddress, this);
            _stub.setPortName(getWebApplicationSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebApplicationSoapEndpointAddress(java.lang.String address) {
        WebApplicationSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (se.lu.ics.WebApplicationSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                se.lu.ics.WebApplicationSoapStub _stub = new se.lu.ics.WebApplicationSoapStub(new java.net.URL(WebApplicationSoap_address), this);
                _stub.setPortName(getWebApplicationSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebApplicationSoap".equals(inputPortName)) {
            return getWebApplicationSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ics.lu.se", "WebApplication");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ics.lu.se", "WebApplicationSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebApplicationSoap".equals(portName)) {
            setWebApplicationSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
