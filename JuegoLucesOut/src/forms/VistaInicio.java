package forms;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VistaInicio extends JFrame{
	public JButton btnIntermedio;
	public JButton btnBasico;
	private JLabel lblElijaUnNivel;
	public JButton btnPuntaje;
	
	static public boolean finjuego;
	
	public VistaInicio() {
		finjuego=false;
		setTitle("Fuera Luces");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lblElijaUnNivel = new JLabel("Bienvenido! Elija un nivel :");
		lblElijaUnNivel.setBounds(136, 100, 196, 29);
		getContentPane().add(lblElijaUnNivel);
		
		btnBasico = new JButton("Basico");
		btnBasico.setBounds(38, 196, 89, 23);
		getContentPane().add(btnBasico);
		
		btnIntermedio = new JButton("Intermedio");
		btnIntermedio.setBounds(299, 196, 102, 23);
		getContentPane().add(btnIntermedio);
		
		btnPuntaje = new JButton("Puntaje");
		btnPuntaje.setBounds(173, 227, 89, 23);
		getContentPane().add(btnPuntaje);
		
	}
}
