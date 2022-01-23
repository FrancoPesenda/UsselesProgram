import javax.swing.*;
import java.awt.*;

public class PrincipalFrame extends JFrame {

    public PrincipalFrame(){

        setSize(new Dimension(toolkit.getScreenSize().width /3 , toolkit.getScreenSize().height / 2 ));
        setLocation(toolkit.getScreenSize().width / 2 - this.getWidth() / 2 , toolkit.getScreenSize().height / 2 - this.getHeight() / 2 );
        setVisible(true);
        MainPane mainPane = new MainPane();
        add(mainPane);

    }

    Toolkit toolkit = Toolkit.getDefaultToolkit();

}
