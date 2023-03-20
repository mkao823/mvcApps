package minefield;

import mvc.*;
import javax.swing.*;

public class MinefieldPanel extends AppPanel{
    public MinefieldPanel(AppFactory factory) {
        super(factory);
        JButton north = new JButton("N");
        north.addActionListener(this);
        super.addControl(north);
        JButton south = new JButton("S");
        south.addActionListener(this);
        super.addControl(south);
        JButton east = new JButton("E");
        east.addActionListener(this);
        super.addControl(east);
        JButton west = new JButton("W");
        west.addActionListener(this);
        super.addControl(west);
        JButton northeast = new JButton("NE");
        northeast.addActionListener(this);
        super.addControl(northeast);
        JButton northwest = new JButton("NW");
        northwest.addActionListener(this);
        super.addControl(northwest);
        JButton southeast = new JButton("SE");
        southeast.addActionListener(this);
        super.addControl(southeast);
        JButton southwest = new JButton("SW");
        southwest.addActionListener(this);
        super.addControl(southwest);
    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }

}
