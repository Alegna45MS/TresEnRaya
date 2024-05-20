package TRESENRAYA;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TresEnRaya extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton[] botones;
	private JButton reiniciar;
	private JLabel etiquetaResultado;
	private boolean esTurnoJugador1;

	private int [] tablero;

	public TresEnRaya() {
		super("Tres en Raya");
		setBounds(100, 100, 250, 270);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		construirPanel();
		setVisible(true);
		esTurnoJugador1 = true;
	}

	public void construirPanel() {
		panel = new JPanel();
		botones = new JButton[9];
		for (int i = 0; i < 9; i++) {
			botones[i] = new JButton("");
			botones[i].setPreferredSize(new Dimension(60, 60));
			botones[i].addActionListener(this);
			panel.add(botones[i]);
		}
		etiquetaResultado = new JLabel("Se esta jugando");
		reiniciar = new JButton("Reiniciar");
		reiniciar.addActionListener(this);
		panel.add(reiniciar);
		panel.add(etiquetaResultado);
		add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int numeroBotonPulsado = 0;
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == botones[i]) {
				numeroBotonPulsado = i;
			}
		}
		if (movimientoValido(numeroBotonPulsado)) {
			if ((esTurnoJugador1) && (casillaVacia(numeroBotonPulsado)) && (!ganaJugador(2)) && (quedanCasillas())) {
				// si el turno es del jugador 1
				tablero[numeroBotonPulsado]=1;
				botones[numeroBotonPulsado].setText("X");
				esTurnoJugador1 = false;
			} else if ((!esTurnoJugador1) && (casillaVacia(numeroBotonPulsado)) && (!ganaJugador(1)) && (quedanCasillas())) {
				tablero[numeroBotonPulsado]=2;
				botones[numeroBotonPulsado].setText("O");
				esTurnoJugador1 = true;
			}
			if (ganaJugador(1)) {
				etiquetaResultado.setText("Ha ganado jugador 1");
				for (int i = 0; i < 9; i++) {
					botones[i].setEnabled(false);
				}
			} if (ganaJugador(2)) {
				etiquetaResultado.setText("Ha ganado jugador 2");
				for (int i = 0; i < 9; i++) {
					botones[i].setEnabled(false);
				}
			}

			if(!ganaJugador(1)&& !ganaJugador(2) && !quedanCasillas()) {
				etiquetaResultado.setText("Empate");
			}
		}
		if (e.getSource() == reiniciar) {
			reiniciarJuego();
		}
	}
	/*
	private boolean ganaJugador1() {
		// Revisar todas las combinaciones ganadoras
		return (botonIgual(0, 1, 2, "X") || botonIgual(3, 4, 5, "X") || botonIgual(6, 7, 8, "X")
				|| botonIgual(0, 3, 6, "X") || botonIgual(1, 4, 7, "X") || botonIgual(2, 5, 8, "X")
				|| botonIgual(0, 4, 8, "X") || botonIgual(2, 4, 6, "X"));
	}

	private boolean ganaJugador2() {
		// Revisar todas las combinaciones ganadoras
		return (botonIgual(0, 1, 2, "O") || botonIgual(3, 4, 5, "O") || botonIgual(6, 7, 8, "O")
				|| botonIgual(0, 3, 6, "O") || botonIgual(1, 4, 7, "O") || botonIgual(2, 5, 8, "O")
				|| botonIgual(0, 4, 8, "O") || botonIgual(2, 4, 6, "O"));
	}

	private boolean botonIgual(int a, int b, int c, String icono) {
		return (botones[a].getText().equals(icono) && botones[b].getText().equals(icono)
				&& botones[c].getText().equals(icono));
	}
	*/
	private boolean movimientoValido(int indice) {
		return botones[indice].getText().isEmpty();
	}

	private void reiniciarJuego() {
		for (int i = 0; i < 9; i++) {
			botones[i].setText("");
			botones[i].setEnabled(true);
		}
		etiquetaResultado.setText("Se esta jugando");
		esTurnoJugador1 = true;
	}

	public boolean casillaVacia(int pos) {
		if (tablero[pos] == 0) {
			return true;
		}
		return false;
	}

	public boolean ganaJugador(int jugador) {
		// columnas
		for (int i = 0; i < 3; i++) {
			if ((tablero[i] == jugador) && (tablero[3 + i] == jugador) && (tablero[6 + i]==jugador)) {
				return true;
			}
		}
		// filas
		for (int i = 0; i < 9; i = i + 3) {
			if ((tablero[i] == jugador) && (tablero[1 + i] == jugador) && (tablero[2 + i]==jugador)) {
				return true;
			}
		}
		// diagonal
		if ((tablero[0] == jugador) && (tablero[4] == jugador) && (tablero[8] == jugador)) {
			return true;
		}
		if ((tablero[0] == jugador) && (tablero[4] == jugador) && (tablero[8] == jugador)) {
			return true;
		}
		return false;
	}

	public boolean quedanCasillas() {
		for (int i = 0; i < 9; i++) {
			if (tablero[i] == 0) {
				return true;
			}
		}
		return false;
	}
}
