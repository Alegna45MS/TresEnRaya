package TRESENRAYA;

import java.awt.Component;
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

public class Estadisticas extends JFrame implements ActionListener {
	private static Connection miConexion;
	private static Statement miStatement;
	private JPanel panel;
	private JLabel jugadores;
	private JButton JBVolver;
	private Menu menu;
	
	
	public Estadisticas() {
		super("Estadisticas");
		setBounds(200, 200, 800, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		construirPanel();
		setVisible(false);
	}
	public void setMenu(Menu ventana) {
		this.menu=ventana;
	}
	public void construirPanel() {
		panel=new JPanel();
		add(panel);
		jugadores=new JLabel(listarJugadores());
		panel.add(jugadores);
		JBVolver=new JButton("Volver");
		panel.add(JBVolver);
		JBVolver.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		menu.setVisible(true);
	}
	public String listarJugadores() {
		String jugadoresLista="";
		String consulta="select * from Jugador order by puntos desc limit 3;";
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/TresEnRaya", "user","password");
			miStatement = miConexion.createStatement();
			ResultSet miResultset=miStatement.executeQuery(consulta);
			while(miResultset.next()) {
				Usuario u=new Usuario(miResultset.getString("usuario"),miResultset.getString("contraseña"),miResultset.getInt("puntos"));
				jugadoresLista=jugadoresLista+"  "+u.toString();
				
				
			}
			System.out.println(jugadoresLista);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jugadoresLista;
	}


}
