package se.lu.ics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

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
			}
		});
		
		gui.getBtnUpdate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		gui.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		gui.getBtnNamesOfAllColumns().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		gui.getBtnTotalNumberOfColumns().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		gui.getBtnAllPrimaryKeys().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
	}
		
}
