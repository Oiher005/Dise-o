package adapter;

import java.util.Vector;

import adapter.InvertedIterator;
import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientIterAdapter implements InvertedIterator {
	Vector<Symptom> sintomas;
	int pos=0;
	
	public Covid19PacientIterAdapter(Covid19Pacient p) {
		sintomas =new Vector(p.getSymptoms());
	}

	@Override
	public Object previous() {
		Symptom s=sintomas.elementAt(pos);
		return s;
	}

	@Override
	public boolean hasPrevious() {
		return pos >= 0;
		
	}

	@Override
	public void goLast() {
		// TODO Auto-generated method stub
		
	}
 
}
