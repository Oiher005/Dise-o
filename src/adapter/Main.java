package adapter;

import java.util.Comparator;
import java.util.Iterator;

import domain.Covid19Pacient;
import factory.SymptomFactory;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient pacient = new Covid19Pacient("aitor", 35, new SymptomFactory());
		
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);
		pacient.addSymptomByName("mialgia", 5);
		pacient.addSymptomByName("tos seca", 4);
		
		InvertedIterator ii = new Covid19PacientIterAdapter(pacient);
		
		Comparator<Object> compName = new NameComparator();
		Comparator<Object> compSeverity = new SeverityComparator();
		
		Iterator<Object> i = Sorting.sortedIterator(ii, compName);
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		ii.goLast();
		
		i = Sorting.sortedIterator(ii, compSeverity);
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
