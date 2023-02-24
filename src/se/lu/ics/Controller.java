package se.lu.ics;

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

	public void declareListener() {
	
		
}
	
}
