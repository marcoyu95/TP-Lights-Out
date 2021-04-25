package forms;

import javax.swing.JFrame;
import java.awt.TextArea;

@SuppressWarnings("serial")
public class VistaPuntaje extends JFrame{
	public TextArea textArea;
	
	public VistaPuntaje() {
		setTitle("Puntajes");
		setBounds(100, 100, 250, 300);
		getContentPane().setLayout(null);
		
		textArea = new TextArea();
		textArea.setBounds(0, 0, 234, 261);
		getContentPane().add(textArea);
		
	}
}
