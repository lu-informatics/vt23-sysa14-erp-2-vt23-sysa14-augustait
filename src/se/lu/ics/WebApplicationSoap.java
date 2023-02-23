/**
 * WebApplicationSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package se.lu.ics;

public interface WebApplicationSoap extends java.rmi.Remote {

    /**
     * Returns an employee with the specified id
     */
    public se.lu.ics.Employee getEmployeeByNo(java.lang.String no) throws java.rmi.RemoteException;

    /**
     * Returns the number of all tables in the database!
     */
    public int getTableCount() throws java.rmi.RemoteException;

    /**
     * Returns the number of all columns in the database!
     */
    public int getColumnCount() throws java.rmi.RemoteException;

    /**
     * Returns the names of all the Primary Keys in the database!
     */
    public java.lang.String[] getPrimaryKeyConstraints() throws java.rmi.RemoteException;

    /**
     * Returns the names of all the Columns in the CRONUS Sverige
     * AB$Item table!
     */
    public java.lang.String[] getItemTableColumnNames() throws java.rmi.RemoteException;

    /**
     * Create an Employee with this button!
     */
    public void addEmployee(java.lang.String no, java.lang.String firstName, java.lang.String lastName, java.lang.String jobTitle, java.lang.String city) throws java.rmi.RemoteException;

    /**
     * Delete an Employee with this button!
     */
    public void deleteEmployee(java.lang.String no) throws java.rmi.RemoteException;

    /**
     * Update an Employee with this button!
     */
    public void updateEmployee(java.lang.String no, java.lang.String firstName, java.lang.String lastName, java.lang.String jobTitle, java.lang.String city) throws java.rmi.RemoteException;
}
