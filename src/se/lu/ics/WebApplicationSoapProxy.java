package se.lu.ics;

public class WebApplicationSoapProxy implements se.lu.ics.WebApplicationSoap {
  private String _endpoint = null;
  private se.lu.ics.WebApplicationSoap webApplicationSoap = null;
  
  public WebApplicationSoapProxy() {
    _initWebApplicationSoapProxy();
  }
  
  public WebApplicationSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebApplicationSoapProxy();
  }
  
  private void _initWebApplicationSoapProxy() {
    try {
      webApplicationSoap = (new se.lu.ics.WebApplicationLocator()).getWebApplicationSoap();
      if (webApplicationSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webApplicationSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webApplicationSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webApplicationSoap != null)
      ((javax.xml.rpc.Stub)webApplicationSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public se.lu.ics.WebApplicationSoap getWebApplicationSoap() {
    if (webApplicationSoap == null)
      _initWebApplicationSoapProxy();
    return webApplicationSoap;
  }
  
  public se.lu.ics.Employee getEmployeeByNo(java.lang.String no) throws java.rmi.RemoteException{
    if (webApplicationSoap == null)
      _initWebApplicationSoapProxy();
    return webApplicationSoap.getEmployeeByNo(no);
  }
  
  public int getTableCount() throws java.rmi.RemoteException{
    if (webApplicationSoap == null)
      _initWebApplicationSoapProxy();
    return webApplicationSoap.getTableCount();
  }
  
  public int getColumnCount() throws java.rmi.RemoteException{
    if (webApplicationSoap == null)
      _initWebApplicationSoapProxy();
    return webApplicationSoap.getColumnCount();
  }
  
  public java.lang.String[] getPrimaryKeyConstraints() throws java.rmi.RemoteException{
    if (webApplicationSoap == null)
      _initWebApplicationSoapProxy();
    return webApplicationSoap.getPrimaryKeyConstraints();
  }
  
  public java.lang.String[] getItemTableColumnNames() throws java.rmi.RemoteException{
    if (webApplicationSoap == null)
      _initWebApplicationSoapProxy();
    return webApplicationSoap.getItemTableColumnNames();
  }
  
  public void addEmployee(java.lang.String no, java.lang.String firstName, java.lang.String lastName, java.lang.String jobTitle, java.lang.String city) throws java.rmi.RemoteException{
    if (webApplicationSoap == null)
      _initWebApplicationSoapProxy();
    webApplicationSoap.addEmployee(no, firstName, lastName, jobTitle, city);
  }
  
  public void deleteEmployee(java.lang.String no) throws java.rmi.RemoteException{
    if (webApplicationSoap == null)
      _initWebApplicationSoapProxy();
    webApplicationSoap.deleteEmployee(no);
  }
  
  public void updateEmployee(java.lang.String no, java.lang.String firstName, java.lang.String lastName, java.lang.String jobTitle, java.lang.String city) throws java.rmi.RemoteException{
    if (webApplicationSoap == null)
      _initWebApplicationSoapProxy();
    webApplicationSoap.updateEmployee(no, firstName, lastName, jobTitle, city);
  }
  
  
}