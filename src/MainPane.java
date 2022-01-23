import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class MainPane extends JPanel {
    public MainPane(){

        setLayout(new BorderLayout());
        setVisible(true);

        TopPage topPage = new TopPage();
        add(topPage,BorderLayout.CENTER);
        //Options to Select
        options = null ;
        //TypeMessage
        typeMessage = 0 ;
        typeMessageConfirm = 0 ;
        //Set elements for work
        chain = "MENSAJILLO";
        icon = new ImageIcon("src/Image/pngegg.png");
        Image image = icon.getImage();
        Image imageN = image.getScaledInstance(50,50,Image.SCALE_FAST);
        icon = new ImageIcon(imageN);
        component = new JPanel();
        component.setBackground(Color.CYAN);
        date = new Date();
        message = chain ;
        //BUTTON THINKS
        show = new JButton("Mostrar Mensaje");

        //RESIZE IMAGE


        icon1 = new ImageIcon("src/Image/azul.png");
        icon2 = new ImageIcon("src/Image/rojo.png");
        icon3 = new ImageIcon("src/Image/amarillo.png");

        Image image1 = icon1.getImage();
        Image image2 = image1.getScaledInstance(50,50,Image.SCALE_FAST);
        icon1 = new ImageIcon(image2);
        image1 = icon2.getImage();
        image2 = image1.getScaledInstance(50,50,Image.SCALE_FAST);
        icon2 = new ImageIcon(image2);
        image1 = icon3.getImage();
        image2 = image1.getScaledInstance(50,50,Image.SCALE_FAST);
        icon3 = new ImageIcon(image2);

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] selections = new String[10];
                for (int i = 0; i < topPage.getComponentCount(); i++) {
                    MyPane myPane = (MyPane) topPage.getComponent(i);
                    try {
                        selections[i]=myPane.getSelectedButton().getActionCommand();
                    } catch (FuckTheProgramException ex) {
                        ex.printStackTrace();
                    }
                }

                if (selections[2].equals("Icono")){
                    message = icon ;
                }else if (selections[2].equals("Componente")){
                    message = component ;
                }else if (selections[2].equals("Otros")){
                    message = date ;
                }else if (selections[2].equals("Object[]")){
                    Object[] objects = { chain, icon,component,date};
                    message = objects ;
                }


                if (selections[4].equals("String[]")){
                    options = new String[]{"Opción1", "Opción2", "Opción3"};
                }else if (selections[4].equals("Icon[]")){
                    options = new ImageIcon[]{icon1,icon2,icon3};
                }else if (selections[4].equals("Object[]")){
                    options = new Object[]{chain,icon,date};
                }

                boolean num = false ;

                if (selections[5].equals("Campo de Texto")){
                    num = true ;
                }

                if (selections[0].equals("Mensaje")){
                    JOptionPane.showMessageDialog(topPage,message,"Ventana",procesTypess(selections[1]));
                }else if (selections[0].equals("Confirmar")){
                    JOptionPane.showConfirmDialog(topPage,message,"Ventana de Confirmación",procesTypess(selections[3]),procesTypess(selections[1]));
                }else if (selections[0].equals("Opción")){
                    JOptionPane.showOptionDialog(topPage,message,"Ingrese Opción",procesTypess(selections[3]),procesTypess(selections[1]),icon,options,options[0]);
                }else {
                    if (num){
                        JOptionPane.showInputDialog(topPage,message,"Escriba algo",procesTypess(selections[1]));
                    }else {
                        JOptionPane.showInputDialog(topPage,message,"Ingrese un valor",procesTypess(selections[1]),icon,new String[]{ "combo1" , "combo2" , "combo3"} , "combo1" );
                    }
                }
            }
        });
        add(show,BorderLayout.SOUTH);

    }

    private int procesTypess( String s ){
        if (s.equals("YES_NO_OPTION") || s.equals("ERROR_MESSAGE")){
            return 0;
        }else if (s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")){
            return 1;
        }else if (s.equals("OK_CANCEL_OPTION") || s.equals("WARNING_MESSAGE")){
            return 2;
        }else if (s.equals("DEFAULT_OPTION") || s.equals("PLAIN_MESSAGE")){
            return -1;
        }
        return 0;
    }

    Object message ;
    Object[] options ;
    JButton show ;
    String chain;
    ImageIcon icon;
    JPanel component ;
    Date date ;
    ImageIcon icon1 ;
    ImageIcon icon2 ;
    ImageIcon icon3 ;
    int typeMessage ;
    int typeMessageConfirm ;
}

class TopPage extends JPanel{
    public TopPage(){

        setLayout(new GridLayout(2,3));
        PaneFactory paneFactory = PaneFactory.getInstance();

        ArrayList<String> elementName = new ArrayList<>();
        elementName.add("Mensaje");
        elementName.add("Confirmar");
        elementName.add("Opción");
        elementName.add("Entrada");
        add(paneFactory.getjPanel("Tipo",elementName));

        elementName = new ArrayList<>();
        elementName.add("ERROR_MESSAGE");
        elementName.add("INFORMATION_MESSAGE");
        elementName.add("WARNING_MESSAGE");
        elementName.add("QUESTION_MESSAGE");
        elementName.add("PLAIN_MESSAGE");
        add(paneFactory.getjPanel("Tipo Mensaje",elementName));

        elementName = new ArrayList<>();
        elementName.add("Cadena");
        elementName.add("Icono");
        elementName.add("Componente");
        elementName.add("Otros");
        elementName.add("Object[]");
        add(paneFactory.getjPanel("Mensaje",elementName));

        elementName = new ArrayList<>();
        elementName.add("DEFAULT_OPTION");
        elementName.add("YES_NO_OPTION");
        elementName.add("YES_NO_CANCEL_OPTION");
        elementName.add("OK_CANCEL_OPTION");
        add(paneFactory.getjPanel("Confirmar",elementName));

        elementName = new ArrayList<>();
        elementName.add("String[]");
        elementName.add("Icon[]");
        elementName.add("Object[]");
        add(paneFactory.getjPanel("Opción",elementName));

        elementName = new ArrayList<>();
        elementName.add("Campo de Texto");
        elementName.add("Combo");
        add(paneFactory.getjPanel("Entrada",elementName));

    }
}
