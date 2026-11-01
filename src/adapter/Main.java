package adapter;

import java.util.Comparator;
import java.util.Iterator;

import domain.Covid19Pacient;
import factory.SymptomFactory;

public class Main {

	public static void main(String[] args) {
Covid19Pacient pacient=new Covid19Pacient("aitor", 35,new SymptomFactory());
		
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);
		InvertedIterator ii=new Covid19PacientIterAdapter(pacient);
		Comparator compName=new NameComparator();
		Comparator compSeverity= new SeverityComparator();
		Iterator i =Sorting.sortedIterator(ii, compName);
		while(i.hasNext()) {
			System.out.println(i.hasNext());
		}
		ii.goLast();
		i =Sorting.sortedIterator(ii, compSeverity);
		while(i.hasNext()) {
			System.out.println(i.hasNext());
		}

	}

}
