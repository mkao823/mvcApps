package mvc;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JPanel implements PropertyChangeListener {
    public Model model;

    public View(Model m) {
        model = m;
        model.addPropertyChangeListener(this);
    }

    public void setModel(Model newModel) {
        model.removePropertyChangeListener(this);
        model = newModel;
        this.model.initSupport();
        model.addPropertyChangeListener(this);
        repaint();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        //System.out.println("Property Changed");
        if(evt.getPropertyName().equals("unsavedChanges"))
            repaint();
    }
}
