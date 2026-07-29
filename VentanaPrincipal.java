import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
    JTextField Nombre,correo,telefono,ciudad; 
    JButton Guardar,Listar; 
    JPanel N,C,T,CI,BT,Izquierda,Derech; 

    public VentanaPrincipal(){
        configurarVentana();
        cargarComponentes();
    }

    public void configurarVentana(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2));
    }

    public void cargarComponentes(){
        Nombre = new JTextField(5);
        correo = new JTextField(5);
        telefono = new JTextField(5);
        ciudad = new JTextField(5);

        N = new JPanel(new FlowLayout(FlowLayout.LEFT,4,4)); 
        N.add(new JLabel("Nombre: "));
        N.add(Nombre);
        
        

        C = new JPanel(new FlowLayout(FlowLayout.LEFT,4,4));
        C.add(new JLabel("Correo:  ")); 
        C.add(correo); 
        
        

        T = new JPanel(new FlowLayout(FlowLayout.LEFT,2,3)); 
        T.add(new JLabel("Telefono:"));
        T.add(telefono);
        
        

        CI = new JPanel(new FlowLayout(FlowLayout.LEFT,4,4));
        CI.add(new JLabel("Ciudad:  "));
        CI.add(ciudad); 
        
        

        
        BT = new JPanel(new FlowLayout(FlowLayout.LEFT,4,4));
        Guardar = new JButton("Guardad"); 
        Listar = new JButton("Listar");
        BT.add(Listar,FlowLayout.LEFT);
        BT.add(Guardar,FlowLayout.LEFT);
        ;
        
        Izquierda = new JPanel(new GridLayout(5,1));
        Izquierda.setBorder(BorderFactory.createTitledBorder("Gestion de Datos")); 
        Izquierda.add(N);
        Izquierda.add(C);
        Izquierda.add(T);
        Izquierda.add(CI);
        Izquierda.add(BT);
        
        


        Derech = new JPanel();




        add(Izquierda);
        add(Derech);



    }

    public void actionPerformed(ActionEvent e){

    }
}
