package se.lu.ics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	private GUI gui;

	public GUI getGui() {
		return gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}

	public Controller(GUI gui) {
		super();
		this.gui = gui;
		declareListener();
	}
	
	private void declareListener() {
		
//		gui.getBtnNamesOfAllColumns().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				gui.getTextPane().setText("Hej");
//				
//			}
//		});
		
	}
	
	

	
	
	
}
