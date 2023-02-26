package se.lu.ics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	               
				  
				}catch (RemoteException ex) {
	                    
					ex.printStackTrace();
	                    // handle the remote exception here
	                }
			}
		});	 
		
		//CREATE
		gui.getBtnCreate().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the values from the text fields
		        String firstName = gui.getTextFieldFirstName().getText();
		        String lastName = gui.getTextFieldLastName().getText();
		        String jobTitle = gui.getTextFieldJobTitle().getText();
		        String city = gui.getTextFieldCity().getText();
		        String id = gui.getTextFieldID().getText();

		        // Check if all the fields are filled in
		        if (firstName.isEmpty() || lastName.isEmpty() || jobTitle.isEmpty() || city.isEmpty() || id.isEmpty()) {
		            gui.getTextPane().setText("Please fill in all fields.");
		            return;
		        }

		        try {
		            // Check if the employee ID already exists
		            Employee employee = webService.getEmployeeByNo(id);
		            if (employee != null) {
		                gui.getTextPane().setText("Employee with ID: " + id + " already exists.");
		                return;
		            }

		            // Create the employee
		            webService.addEmployee(id, firstName, lastName, jobTitle, city);
		            gui.getTextPane().setText("Employee created with ID: " + id);
		            System.out.println("Employee created with ID: " + id);
		        } catch (RemoteException ex) {
		            ex.printStackTrace();
		            // handle the remote exception here
		        }
		    }
		});
		
		//FIND
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
		                String message = "Employee details:\n\n" +
		                        "ID: " + employee.getNo() + "\n" +
		                        "First Name: " + employee.getFirstName() + "\n" +
		                        "Last Name: " + employee.getLastName() + "\n" +
		                        "Job Title: " + employee.getJobTitle() + "\n" +
		                        "City: " + employee.getCity();
		                gui.getTextPane().setText(message);
		            } else {
		                gui.getTextPane().setText("Employee with ID " + id + " not found.");
		            }
		        } catch (RemoteException ex) {
		            ex.printStackTrace();
		            // handle the remote exception here
		        }
		    }
		});
		
		// UPDATE
		gui.getBtnUpdate().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the values from the text fields
		        String id = gui.getTextFieldID().getText();
		        String firstName = gui.getTextFieldFirstName().getText();
		        String lastName = gui.getTextFieldLastName().getText();
		        String jobTitle = gui.getTextFieldJobTitle().getText();
		        String city = gui.getTextFieldCity().getText();

		        // Check if all the fields are filled in
		        if (firstName.isEmpty() || lastName.isEmpty() || jobTitle.isEmpty() || city.isEmpty() || id.isEmpty()) {
		            gui.getTextPane().setText("Please fill in all fields.");
		            return;
		        }

		        try {
		            // Check if the employee exists
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
		            // handle the remote exception here
		        }
		    }
		});
		
		// DELETE
		gui.getBtnDelete().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the employee ID from the text field
		        String id = gui.getTextFieldID().getText();

		        // Check if the ID field is empty
		        if (id.isEmpty()) {
		            gui.getTextPane().setText("Please enter an ID.");
		            return;
		        }

		        try {
		            // Check if the employee with the given ID exists
		            Employee employee = webService.getEmployeeByNo(id);
		            if (employee == null) {
		                gui.getTextPane().setText("Employee with ID: " + id + " does not exist.");
		                return;
		            }

		            // Delete the employee
		            webService.deleteEmployee(id);
		            gui.getTextPane().setText("Employee with ID: " + id + " deleted.");
		            System.out.println("Employee with ID: " + id + " deleted.");
		        } catch (RemoteException ex) {
		            ex.printStackTrace();
		            // handle the remote exception here
		        }
		    }
		});
		
		
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
		            ex.printStackTrace();
		            // handle the remote exception here
		        }
		    }
		});
		
		gui.getBtnTotalNumberOfColumns().addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            int columnCount = webService.getColumnCount();
		            gui.getTextPane().setText("Total number of columns: " + columnCount);
		            System.out.println("btnTotalNumberOfColumns: " + columnCount);
		        } catch (RemoteException ex) {
		            ex.printStackTrace();
		            // handle the remote exception here
		        }
		    }
		});
		
		
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
		            // handle the remote exception here
		        }
		    }
		});
		
		
		
		
	}
		
}
