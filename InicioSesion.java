package TRESENRAYA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InicioSesion extends JFrame implements ActionListener {
	private static Connection miConexion;
	private static Statement miStatement;
	private JPanel panel;
	private JLabel usuario, contraseña,validar;
	private JTextField JTUsuario, JTContraseña;
	private JButton inicio;
	private Menu menu;

	public InicioSesion() {
		super("Iniciar sesion");
		setBounds(100, 100, 250, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		construirPanel();
		setVisible(true);
	}

	public void setMenu(Menu ventana) {
		this.menu = ventana;
	}

	public void construirPanel() {
		panel = new JPanel();
		add(panel);
		usuario = new JLabel("Usuario");
		panel.add(usuario);
		JTUsuario = new JTextField(10);
		panel.add(JTUsuario);
		contraseña = new JLabel("Contraseña");
		panel.add(contraseña);
		JTContraseña = new JTextField(10);
		panel.add(JTContraseña);
		inicio = new JButton("INICIAR");
		panel.add(inicio);
		validar=new JLabel("¿Es valido?");
		panel.add(validar);
		inicio.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(validarUsuario()) {
			setVisible(false);
			menu.setVisible(true);
		}else {
			validar.setText("Usuario o contraseña no correcto");
		}
	}

	public boolean validarUsuario() {
		String usuario=JTUsuario.getText();
		String contraseña=JTContraseña.getText();
		String consulta="Select usuario,contraseña from Jugador where usuario='"+usuario+"';";
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/TresEnRaya", "user","password");
			miStatement = miConexion.createStatement();
			ResultSet miResultset=miStatement.executeQuery(consulta);
			while(miResultset.next()) {
				if(miResultset.getString("contraseña").equals(contraseña)) {
					return true;
				}else {
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}
	public String getUsuario() {
		return JTUsuario.getText();
	}
	public String getContraseña() {
		return JTContraseña.getText();
	}

}
