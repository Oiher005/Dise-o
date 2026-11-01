package observer;

import java.util.Observable;

import adapter2.ShowPacientTableGUI;
import domain.Covid19Pacient;
import factory.SymptomFactory;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String args[]){
		Covid19Pacient pacient=new Covid19Pacient("aitor", 35,new SymptomFactory());
		new PacientObserverGUI (pacient);
		new PacientSymptomGUI (pacient);
		new PacientThermometerGUI(pacient);
		ShowPacientTableGUI gui=new ShowPacientTableGUI (pacient);
		gui.setPreferredSize(new java.awt.Dimension(300,200));
		gui.setVisible(true);
		}


}
