package adapter2;

import java.util.Observable;
import java.util.Observer; 
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel implements Observer {
    protected Covid19Pacient pacient;
    protected String[] columnNames = new String[] {"Symptom", "Weight" };
    protected Vector<Symptom> sintomas;

    public Covid19PacientTableModelAdapter(Covid19Pacient p) {
        this.pacient = p;
        sintomas = new Vector<Symptom>(p.getSymptoms());
        
        this.pacient.addObserver(this); 
    }

    @Override
    public void update(Observable o, Object arg) {
       
        sintomas = new Vector<Symptom>(pacient.getSymptoms());
       
        fireTableDataChanged();
    }

    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int i) {
        return columnNames[i];
    }

    public int getRowCount() {
        return sintomas.size();
    }

    public Object getValueAt(int row, int col) {
        if (col == 0)  
            return sintomas.get(row).getName();
        if (col == 1)
            return pacient.getWeight(sintomas.get(row));
        return null;
    }
}
