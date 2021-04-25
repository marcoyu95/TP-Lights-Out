package forms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings({ "serial", "unused" })
public class VistaWin extends JFrame{
	protected JFrame winner;
	protected JLabel lb_SaludoWin;
	public JButton btnSeguirJuego;
	public JButton btnSalir;
	public JTextField textNombreJugador;
	public JButton btnGuardar;
	
	public VistaWin() {
		
		
		lb_SaludoWin = new JLabel("Felicitaciones!!!");
		lb_SaludoWin.setFont(new Font("Tahoma", Font.BOLD, 22));
		lb_SaludoWin.setToolTipText("");
		lb_SaludoWin.setBounds(122, 51, 213, 38);
		getContentPane().add(lb_SaludoWin);
		setTitle("Final del Juego");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnSeguirJuego = new JButton("Jugar");
		btnSeguirJuego.setBounds(67, 162, 89, 23);
		getContentPane().add(btnSeguirJuego);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(294, 162, 89, 23);
		getContentPane().add(btnSalir);
		
		btnGuardar = new JButton("Guardar nombre");
		btnGuardar.setBounds(152, 203, 146, 23);
		getContentPane().add(btnGuardar);
		
		textNombreJugador = new JTextField();
		textNombreJugador.setBounds(183, 163, 86, 20);
		getContentPane().add(textNombreJugador);
		textNombreJugador.setColumns(10);
		
		winner = new JFrame();
		winner.setBounds(100, 100, 450, 300);
		winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
