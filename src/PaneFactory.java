import javax.swing.*;
import java.util.ArrayList;

public class PaneFactory {
    public PaneFactory(){
    }

    public static PaneFactory getInstance(){
        if (instance == null){
            instance = new PaneFactory();
            return instance ;
        }else {
            return instance ;
        }
    }

    public JPanel getjPanel(String name , ArrayList<String> buttonsName){
        myPane = new MyPane();
        myPane.setBorder(BorderFactory.createTitledBorder(name));
        myPane.setLayout(new BoxLayout(myPane,BoxLayout.Y_AXIS));
        Box box = Box.createVerticalBox();
        ButtonGroup buttonGroup = new ButtonGroup();
        for (String s : buttonsName) {
            JRadioButton jRadioButton = new JRadioButton(s,true);
            buttonGroup.add(jRadioButton);
            box.add(jRadioButton);
        }
        myPane.add(box);
        myPane.setBox();
        return myPane;
    }

    private static PaneFactory instance ;
    MyPane myPane;

}
