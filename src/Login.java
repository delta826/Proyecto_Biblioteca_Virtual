

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import java.awt.List;
import javax.swing.ButtonGroup;
import java.awt.Choice;
import java.io.File;
import java.util.Scanner;

public class Login extends JFrame {

	
    ImageIcon image;

    private JPanel contentPane;
    private JPasswordField passwordField;
    public HashTable H;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {


            EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            try {
                                    Login frame = new Login();
                                    frame.setVisible(true);
                            } catch (Exception e) {
                                    e.printStackTrace();
                            }
                    }
            });
    }

    /**
     * Create the frame.
     */
    public void leerUsuarios(){
        //Crear documentos leyendo el archivo txt y meterlos a la lista
        File fichero = new File("usuarios.txt");
        Scanner s = null;
        try {
            s = new Scanner(fichero);

            while (s.hasNextLine()) {
                String datos=s.nextLine();
                String [] partes = datos.split("-");
                User usuario = new User(partes[0], partes[1], partes[2], partes[3]);
                H.insert(usuario);
            }
        } catch (Exception ex) {
                System.out.println( ex.getMessage());
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (Exception ex2) {
                System.out.println(ex2.getMessage());
            }
        }
    }

    public Login() {
            this.H = new HashTable();
            leerUsuarios();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(500, 200, 450, 300);
            contentPane = new JPanel();
            contentPane.setBackground(new Color(255, 239, 213));
            contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            
            
            
            JTextField jTextField1 = new JTextField();
            jTextField1.setBounds(72, 107, 260, 24);
            contentPane.add(jTextField1);
            setUndecorated(true);


            JButton btnNewButton_2 = new JButton("Registrarse");				//Ventana de Registro
            btnNewButton_2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterMouseClicked(evt);
            }
            });
            btnNewButton_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
            btnNewButton_2.setBounds(217, 234, 115, 30);
            contentPane.add(btnNewButton_2);

            JLabel lblNewLabel_3 = new JLabel("");
            lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("logo.png")));
            lblNewLabel_3.setBounds(368, 50, 60, 60);
            contentPane.add(lblNewLabel_3);

            JButton btnNewButton_1 = new JButton("X");
            btnNewButton_1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    dispose();
                    }

            });
            btnNewButton_1.setBounds(404, 0, 46, 30);
            contentPane.add(btnNewButton_1);

            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("user.png")));
            lblNewLabel.setBounds(45, 107, 21, 30);
            contentPane.add(lblNewLabel);

            JLabel lblNewLabel_2 = new JLabel("Ingrese su rol de usuario y contrase\u00F1a");
            lblNewLabel_2.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
            lblNewLabel_2.setBounds(45, 55, 260, 32);
            contentPane.add(lblNewLabel_2);

            JLabel lblNewLabel_4 = new JLabel("");
            lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("lock.png")));
            lblNewLabel_4.setBounds(43, 173, 46, 30);
            contentPane.add(lblNewLabel_4);		

            passwordField = new JPasswordField();
            passwordField.setBounds(72, 173, 260, 24);
            contentPane.add(passwordField);

            JButton btnNewButton = new JButton("Ingresar");
            btnNewButton.addMouseListener(new MouseAdapter() {
                    @Override

                    public void mouseClicked(MouseEvent e) {
                            User ingresado = new User(jTextField1.getText(),passwordField.getText(),null,null);
                            User encontrado = H.find(ingresado);
                            if(encontrado!=null) {
                                    VentanaPrincipal ventanaPrincipal1;
                                    ventanaPrincipal1 = new VentanaPrincipal();
                                    ventanaPrincipal1.setVisible(true);
                                    dispose();

                            }else {
                                    JOptionPane.showMessageDialog(null,"Usuario o Contraseña erroneos. Por favor verifique.", "Login Error", JOptionPane.ERROR_MESSAGE);
                            }
                    }
            });
            btnNewButton.setBounds(71, 234, 115, 30);
            contentPane.add(btnNewButton);

            JLabel lblNewLabel_1 = new JLabel("");
            lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("back.jpg")));
            lblNewLabel_1.setBounds(0, 0, 450, 300);
            contentPane.add(lblNewLabel_1);


    }
    private void RegisterMouseClicked(java.awt.event.MouseEvent evt) {                                     
        Register v = new Register(this, true);
        this.setVisible(false);
        v.setVisible(true);
        this.setVisible(true);
    }   
}