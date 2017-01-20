package fr.miage.moureypierson.dicegame.view;

import fr.miage.moureypierson.dicegame.model.ListeScore;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * Created by Guillaume on 19/01/2017.
 */
public class ScoreView extends JPanel {

    private ListeScore scores;

    public ScoreView(ListeScore scores) {
        this.scores = scores;
        JTable table = new JTable(scores);
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(boxLayout);
        this.add(new JLabel("Tableau des scores"));
        this.add(table);
    }
}
