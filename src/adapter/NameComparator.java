package adapter;

import java.util.Comparator;

import domain.Symptom;

public class NameComparator implements Comparator<Symptom> {

	@Override
	public int compare(Symptom s1, Symptom s2) {
		return s1.getName().compareTo(s2.getName());
	}
}
