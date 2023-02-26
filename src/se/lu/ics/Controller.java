package se.lu.ics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

public class Controller {

	private GUI gui;

	public GUI getGui() {
		return gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}

	public Controller(GUI gui) {
		this.gui = gui;
		declareListener();
	}

	private void declareListener() {

		WebApplicationSoap webService = new WebApplicationSoapProxy();

		gui.getBtnTotalNumberOfTables().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int tableCount = webService.getTableCount();
					gui.getTextPane().setText("Total number of tables: " + tableCount);
					System.out.println("btnTotalNumberOfTables: " + webService.getTableCount());
				} catch (RemoteException ex) {
					ex.printStackTrace();
					gui.getTextPane().setText("Error: Unable to connect to server. Please try again later.");
				} catch (IOException ex) {
					ex.printStackTrace();
					gui.getTextPane().setText("Error: Unable to read data from server. Please try again later.");
				}
			}
		});

		// CREATE
		gui.getBtnCreate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String firstName = gui.getTextFieldFirstName().getText();
				String lastName = gui.getTextFieldLastName().getText();
				String jobTitle = gui.getTextFieldJobTitle().getText();
				String city = gui.getTextFieldCity().getText();
				String id = gui.getTextFieldID().getText();

				if (firstName.isEmpty() || lastName.isEmpty() || jobTitle.isEmpty() || city.isEmpty() || id.isEmpty()) {
					gui.getTextPane().setText("Please fill in all fields.");
					return;
				}

				try {
					Employee employee = webService.getEmployeeByNo(id);
					if (employee != null) {
						gui.getTextPane().setText("Employee with ID: " + id + " already exists.");
						return;
					}

					webService.addEmployee(id, firstName, lastName, jobTitle, city);
					gui.getTextPane().setText("Employee created with ID: " + id);
					System.out.println("Employee created with ID: " + id);
				} catch (RemoteException ex) {
					gui.getTextPane().setText("Error: Could not connect to server. Please try again later.");
					System.err.println("RemoteException occurred: " + ex.getMessage());
					ex.printStackTrace();
				} catch (IOException ex) {
					gui.getTextPane().setText("Error: Could not read from server. Please try again later.");
					System.err.println("IOException occurred: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});

		// FIND
		gui.getBtnFind().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = gui.getTextFieldID().getText();
				if (id.isEmpty()) {
					gui.getTextPane().setText("Please enter an employee ID.");
					return;
				}
				try {
					Employee employee = webService.getEmployeeByNo(id);
					if (employee != null) {
						String message = "Employee details:\n\n" + "ID: " + employee.getNo() + "\n" + "First Name: "
								+ employee.getFirstName() + "\n" + "Last Name: " + employee.getLastName() + "\n"
								+ "Job Title: " + employee.getJobTitle() + "\n" + "City: " + employee.getCity();
						gui.getTextPane().setText(message);
					} else {
						gui.getTextPane().setText("Employee with ID " + id + " not found.");
					}
				} catch (RemoteException ex) {
					gui.getTextPane().setText(
							"An error occurred while trying to retrieve employee information. Please try again later.");
					ex.printStackTrace();
				} catch (IOException ex) {
					gui.getTextPane().setText(
							"An I/O error occurred while trying to retrieve employee information. Please check your internet connection and try again.");
					ex.printStackTrace();
				}
			}
		});

		// UPDATE
		gui.getBtnUpdate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = gui.getTextFieldID().getText();
				String firstName = gui.getTextFieldFirstName().getText();
				String lastName = gui.getTextFieldLastName().getText();
				String jobTitle = gui.getTextFieldJobTitle().getText();
				String city = gui.getTextFieldCity().getText();

				if (firstName.isEmpty() || lastName.isEmpty() || jobTitle.isEmpty() || city.isEmpty() || id.isEmpty()) {
					gui.getTextPane().setText("Please fill in all fields.");
					return;
				}

				try {
					Employee employee = webService.getEmployeeByNo(id);
					if (employee == null) {
						gui.getTextPane().setText("Employee with ID: " + id + " does not exist.");
						return;
					}

					webService.updateEmployee(id, firstName, lastName, jobTitle, city);
					gui.getTextPane().setText("Employee with ID: " + id + " updated.");
					System.out.println("Employee with ID: " + id + " updated.");
				} catch (RemoteException ex) {
					ex.printStackTrace();
					gui.getTextPane().setText("Error updating employee: " + ex.getMessage());
				} catch (IOException ex) {
					ex.printStackTrace();
					gui.getTextPane().setText("Error communicating with server: " + ex.getMessage());
				}
			}
		});

		// DELETE
		gui.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = gui.getTextFieldID().getText();

				if (id.isEmpty()) {
					gui.getTextPane().setText("Please enter an ID.");
					return;
				}

				try {
					Employee employee = webService.getEmployeeByNo(id);
					if (employee == null) {
						gui.getTextPane().setText("Employee with ID: " + id + " does not exist.");
						return;
					}

					
					webService.deleteEmployee(id);
					gui.getTextPane().setText("Employee with ID: " + id + " deleted.");
					System.out.println("Employee with ID: " + id + " deleted.");
				} catch (RemoteException ex) {
					ex.printStackTrace();
					gui.getTextPane().setText("Error: " + ex.getMessage());
				} catch (IOException ex) {
					ex.printStackTrace();
					gui.getTextPane().setText("Error: " + ex.getMessage());
				}
			}
		});

		// Names of all columns in the CRONUS Sverige AB$Item table
		gui.getBtnNamesOfAllColumns().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] columnNames = webService.getItemTableColumnNames();
					StringBuilder sb = new StringBuilder();
					sb.append("Column names:\n");
					for (String name : columnNames) {
						sb.append(name).append("\n");
					}
					gui.getTextPane().setText(sb.toString());
				} catch (RemoteException ex) {
					gui.getTextPane()
							.setText("RemoteException: Failed to connect to the web service. Please try again later.");
					ex.printStackTrace();
				} catch (IOException ex) {
					gui.getTextPane()
							.setText("IOException: Failed to read data from the web service. Please try again later.");
					ex.printStackTrace();
				}
			}
		});

		// Total number of columns in the database

		gui.getBtnTotalNumberOfColumns().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int columnCount = webService.getColumnCount();
					gui.getTextPane().setText("Total number of columns: " + columnCount);
					System.out.println("btnTotalNumberOfColumns: " + columnCount);
				} catch (RemoteException ex) {
					gui.getTextPane()
							.setText("Error: A remote exception occurred while getting the total number of columns.");
					ex.printStackTrace();
					
				} catch (IOException ex) {
					gui.getTextPane()
							.setText("Error: An I/O exception occurred while getting the total number of columns.");
					ex.printStackTrace();
					
				}
			}
		});

		// Names of all primary key constraints in the CRONUS Sverige database

		gui.getBtnAllPrimaryKeys().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] primaryKeysArray = webService.getPrimaryKeyConstraints();
					List<String> primaryKeys = Arrays.asList(primaryKeysArray);
					StringBuilder sb = new StringBuilder();
					sb.append("Primary Keys: \n");
					for (String primaryKey : primaryKeys) {
						sb.append(primaryKey + "\n");
					}
					gui.getTextPane().setText(sb.toString());
					System.out.println("Primary Keys: " + primaryKeys);
				} catch (RemoteException ex) {
					ex.printStackTrace();
					gui.getTextPane().setText(
							"An error occurred while communicating with the web service. Please try again later.");
				} catch (IOException ex) {
					ex.printStackTrace();
					gui.getTextPane().setText(
							"An error occurred while reading data from the web service. Please try again later.");
				}
			}
		});

	}

}
