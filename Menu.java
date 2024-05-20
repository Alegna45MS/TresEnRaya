package TRESENRAYA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	private JPanel panel;
	private JButton JBEstadisticas,JBJugar,JBSalir,JBRecrear;
	private InicioSesion inicio;
	private Estadisticas estadisticas;
	
	public Menu() {
		super("Menu");
		setBounds(150, 150, 250, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		construirPanel();
		setVisible(false);
	}
	public void setInicio(InicioSesion ventana) {
		this.inicio=ventana;
	}
	public void setEstadisticas(Estadisticas ventana) {
		this.estadisticas=ventana;
	}
	public void construirPanel() {
		panel=new JPanel();
		add(panel);
		JBJugar=new JButton("Jugador vs Maquina");
		panel.add(JBJugar);
		JBJugar.addActionListener(this);
		JBEstadisticas=new JButton("Ver estadisticas");
		JBRecrear=new JButton("Recrear partida");
		JBSalir=new JButton("Salir");
		panel.add(JBJugar);
		panel.add(JBEstadisticas);
		panel.add(JBRecrear);
		panel.add(JBSalir);
		JBJugar.addActionListener(this);
		JBEstadisticas.addActionListener(this);
		JBRecrear.addActionListener(this);
		JBSalir.addActionListener(this);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JBSalir) {
			setVisible(false);
			inicio.setVisible(true);
		}if(e.getSource()==JBEstadisticas) {
			setVisible(false);
			estadisticas.setVisible(true);
		}
	}

}
