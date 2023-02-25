package se.lu.ics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;

public class Controller {
	
	private GUI gui;
	private WebApplicationSoapProxy webService = new WebApplicationSoapProxy();

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
		
		
		
		
	    JButton btnTotalNumberOfTables = gui.getBtnTotalNumberOfTables();
	    if (gui.getBtnTotalNumberOfTables() != null) {
	        gui.getBtnTotalNumberOfTables().addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    int tableCount = webService.getTableCount();
	                    gui.getTextPane().setText("Total number of tables: " + tableCount);
	                    System.out.println("btnTotalNumberOfTables: " + webService.getTableCount());
	                } catch (RemoteException ex) {
	                    ex.printStackTrace();
	                    // handle the remote exception here
	                }
	            }
	        });
	    } else {
	        System.err.println("Button not found in GUI layout.");
	    }
	}
	
	

	
	
	
}
