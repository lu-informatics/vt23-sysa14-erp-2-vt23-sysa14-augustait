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
