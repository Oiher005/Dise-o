package adapter;

import java.util.List;
import java.util.Vector;
import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientIterAdapter implements InvertedIterator {
    private List<Symptom> symptoms;
    private int position;

    public Covid19PacientIterAdapter(Covid19Pacient pacient) {
        this.symptoms = new Vector<Symptom>(pacient.getSymptoms());
        goLast();
    }

    @Override
    public void goLast() {
        position = symptoms.size() - 1;
    }

    @Override
    public boolean hasPrevious() {
        return position >= 0;
    }

    @Override
    public Object previous() {
        if (hasPrevious()) {
            return symptoms.get(position--);
        }
        return null;
    }
}
