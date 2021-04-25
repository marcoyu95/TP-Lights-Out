package forms;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controls.ControladorFueraLuces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;

@SuppressWarnings("serial")
public class Tablero extends JFrame{
	private JButton[][] tablero;
	private int nBotones;
	private JPanel panel;
	public JLabel lbMovimientos;
	public JLabel cantMovimientos;

	public Tablero(int cantBotones) {
		nBotones=cantBotones;
		panel= new JPanel();
		panel.setBounds(10, 11, 287, 239);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(nBotones,nBotones, 0, 0));
		setTitle("Fuera Luces");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lbMovimientos = new JLabel("Movimientos: ");
		lbMovimientos.setBounds(310, 26, 84, 14);
		getContentPane().add(lbMovimientos);
		
		cantMovimientos = new JLabel("0");
		cantMovimientos.setBounds(320,60, 84,14);
		getContentPane().add(cantMovimientos);
		
		tablero = new JButton[nBotones][nBotones];
		for(int fila=0; fila<nBotones; fila++) {
			for(int col=0; col<nBotones; col++) {
				JButton btnNuevo = new JButton();
				btnNuevo.setBackground(Color.white);
				btnNuevo.addActionListener(new ButtonPress()); 
				tablero[fila][col] = btnNuevo;
				panel.add(tablero[fila][col]);
				panel.validate();
				panel.repaint();
			}
		}
		
		Random ranGen = new Random();

		for (JButton[] buttonrow : tablero) {//prendo las luces aleatoriamente
			for (JButton button : buttonrow) {
				boolean temp = ranGen.nextBoolean();
				
				if (temp) {
					button.setBackground(Color.black);
				}
			}
		}
	}
	
	private class ButtonPress implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent ea) {
			ControladorFueraLuces.cantClick++;
			cantMovimientos.setText(""+ControladorFueraLuces.cantClick);
			boolean done = false;
			int x = 0;
			int y = 0;
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					if (((JButton) ea.getSource()).equals(tablero[i][j])) {
						done = true;
						x = i;
						y = j;
						break;
					}
				}
				if (done) {
					break;
				}
			}
			switchColor(tablero[x][y]);//cambia el color donde se hizo click
			if (x > 0) {// Check if there is a space available to the left of the selected tile
				switchColor(tablero[x - 1][y]);
			}
			if (x < tablero.length - 1) {// Check if there is a space available to the right of the selected tile
				switchColor(tablero[x + 1][y]);
			}
			if (y > 0) {// Check if there is a space available to the top of the selected tile
				switchColor(tablero[x][y - 1]);
			}
			if (y < tablero[x].length - 1) {// Check if there is a space available to the bottom of the selected tile
				switchColor(tablero[x][y + 1]);
			}
			if (checkWin()) {// Checks for a winner and executes freeze and toggles gameDone variable

				ControladorFueraLuces.gameOver=true;
				ControladorFueraLuces.cont=0;
		
			}
		}

		private boolean checkWin() {// Checks for all tiles to be black
			for (JButton[] buttonrow : tablero) {//verifica si todos los botones estan apagados
				for (JButton button : buttonrow) {
					if (button.getBackground() == Color.white) {
						return false;
					}
				}
			}
			return true;
		}

		public void switchColor(JButton button) {// Used to switch color from black to white or vice versa.
			if (button.getBackground().equals(Color.black)) {
				button.setBackground(Color.white);
			} else {
				button.setBackground(Color.black);
			}
		}
	}
	
}
