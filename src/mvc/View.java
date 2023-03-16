package mvc;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JPanel implements PropertyChangeListener {
    private Model model;

    public View(Model m) {
        model = m;
    }

    public void setModel(Model newModel) {
        model.removePropertyChangeListener(this);
        model = newModel;
        model.addPropertyChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent event) {

    }

}
