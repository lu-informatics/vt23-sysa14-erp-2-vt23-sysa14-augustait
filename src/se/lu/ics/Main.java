package se.lu.ics;

import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) {
		GUI gui = new GUI ();
		Controller controller = new Controller(gui);

	}

}
