import javax.swing.*;

public class MyPane extends JPanel {
    public MyPane(){
        box = null;
    }

    public Box getBox(){
        return (Box) this.getComponent(0);
    }

    public JRadioButton getSelectedButton() throws FuckTheProgramException {
        for (int i = 0; i < box.getComponentCount(); i++) {
            JRadioButton jRadioButton = (JRadioButton) box.getComponent(i);
            if (jRadioButton.isSelected()){
                return jRadioButton;
            }
        }
        throw new FuckTheProgramException("Ningun Radio Button esta seleccionado");
    }

    public void setBox(){
        this.box = (Box) this.getComponent(0);
    }

    Box box ;

}
