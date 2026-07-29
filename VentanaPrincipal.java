import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame implements ActionListener{
    JTextField Nombre,correo,telefono,ciudad; 
    JButton Guardar,Listar; 
    JPanel N,C,T,CI,BT,Izquierda,Derech; 
    JTable tabla;
    DefaultTableModel modeloTabla;

    public VentanaPrincipal(){
        configurarVentana();
        cargarComponentes();
    }

    public void configurarVentana(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,400);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
    }

    public void cargarComponentes(){
        Nombre = new JTextField(15);
        correo = new JTextField(15);
        telefono = new JTextField(15);
        ciudad = new JTextField(15);

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
        Guardar = new JButton("Guardar"); 
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

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Ciudad");
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        Derech.add(scroll);

        add(Izquierda);
        add(Box.createHorizontalStrut(10));
        add(Derech);

        Guardar.addActionListener(this);
        Listar.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Guardar) {
            String nombre = Nombre.getText();
            String correo = this.correo.getText();
            String telefono = this.telefono.getText();
            String ciudad = this.ciudad.getText();

            Object[] datos = { modeloTabla.getRowCount()+1,nombre, correo, telefono, ciudad};
            modeloTabla.addRow(datos);
        }
    }
}
