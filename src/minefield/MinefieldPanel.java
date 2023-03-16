package minefield;

import StopLight.StoplightFactory;
import StopLight.StoplightPanel;
import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;

public class MinefieldPanel extends AppPanel{
    private JButton change;
    public MinefieldPanel(AppFactory factory) {
        super(factory);
        change = new JButton("Change");
        change.addActionListener(this);
        controlPanel.add(change);
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new StoplightPanel(factory);
        panel.display();
    }

}
