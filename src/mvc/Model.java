package mvc;

public class Model extends Bean {
    boolean unsavedChanges = false;
    String fileName;

    public Model() {}

    public void changed() {
        //boolean oldValue = unsavedChanges;
        unsavedChanges = true;
        //System.out.println();
        firePropertyChange("model", 0,1);
        //fire property change when unsaved changes becomes true
        //firePropertyChange("unsavedChanges", oldValue , unsavedChanges);
    }

    public String getFileName(){
        return fileName;
    }

    public void setFileName(String fName){
        fileName = fName;
    }

    public boolean getUnsavedChanges(){
        return unsavedChanges;
    }

    public void setUnsavedChanges(boolean i){
        unsavedChanges = i;
    }
}