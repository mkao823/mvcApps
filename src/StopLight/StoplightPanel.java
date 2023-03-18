package StopLight;

import java.awt.*;
import javax.swing.*;
import StopLight.StoplightFactory;
import mvc.*;


public class StoplightPanel extends AppPanel {
    private JButton change;
    public StoplightPanel(AppFactory factory) {
        super(factory);
        change = new JButton("Change");
        change.addActionListener(this);
        //need to add change to control panel
        //controlPanel.add(change);
        super.addControl(change);
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new StoplightPanel(factory);
        panel.display();
    }

}

