/*package fr.miage.moureypierson.dicegame.model;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Asus on 08/01/2017.
 */
/*public class ListeScoreGuillaume implements TableModel {

    private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();

    public ArrayList<Score> scores = new ArrayList<Score>();

    public void ajouter(Joueur j, int value){
        this.scores.add(new Score(j,value));
        this.listeners.forEach(listener -> {
            listener.tableChanged(new TableModelEvent(this));
        });
    }

    public ArrayList<Score> getScores() {
        return scores;
    }

    private static final String[] columnsName = new String[]{"Nom", "Prenom", "Score"};
    private static final Class[] columns = new Class[]{String.class, String.class, Integer.class};

    public int getRowCount() {
        return scores.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public String getColumnName(int columnIndex) {
        return columnsName[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        return columns[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Score score = this.getScores().get(rowIndex);
        if(score != null){
            switch (columnIndex){
                case 0:
                    return score.j.getNomJoueur();
                case 1:
                    return score.j.getPrenomJoueur();
                case 2:
                    return score.value;
            }
        }
        return null;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) { }

    public void addTableModelListener(TableModelListener l) {
        if(!listeners.contains(l))
            listeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
}*/