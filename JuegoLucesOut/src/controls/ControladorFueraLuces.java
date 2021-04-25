package controls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import forms.Tablero;
import forms.VistaInicio;
import forms.VistaPuntaje;
import forms.VistaWin;

public class ControladorFueraLuces {
	
	public volatile static boolean gameOver = false;
	public static int cantClick=0;
	public static Tablero tablaJuego;
	public static int cont=0;
	public static VistaInicio vista;
	
	public static void main(String[] args) {
		
		vista = new VistaInicio();
		vista.setVisible(true);
		// tomamos el Action del boton para inicializar un tablero de 3X3
		vista.btnBasico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablaJuego = new Tablero(3);
				tablaJuego.setBounds(vista.getX(), vista.getY(), vista.getWidth(), vista.getHeight());
				tablaJuego.setVisible(true);
				vista.dispose();
			}
		});
		// tomamos el Action del boton para inicializar un tablero de 4X4
		vista.btnIntermedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablaJuego = new Tablero(4);
				tablaJuego.setBounds(vista.getX(), vista.getY(), vista.getWidth(), vista.getHeight());
				tablaJuego.setVisible(true);
				vista.dispose();
			}
		});
		
		//tomamos el Action del boton para inicializar la vista de puntajes
		vista.btnPuntaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaPuntaje puntajes = new VistaPuntaje();
				
				puntajes.textArea.setEditable(false);
				File archivo = null;
		        FileReader fr = null;
		        BufferedReader br = null;
		        String linea = null;

		        try {
		            //Cargamos el archivo de la ruta relativa
		            archivo = new File("usuariosYpuntajes.txt");
		            //Cargamos el objeto FileReader
		            if(archivo.exists()) {
			            fr = new FileReader(archivo);
			            //Creamos un buffer de lectura
			            br = new BufferedReader(fr);
			            //Leemos hasta que se termine el archivo
			            while ((linea = br.readLine()) != null) {
			                //Utilizamos el separador para los datos
			                puntajes.textArea.append(linea+"\n");
			            }
			            puntajes.setVisible(true);
		            }
		            //Capturamos las posibles excepciones
		        } catch (Exception e5) {
		            e5.printStackTrace();
		        } finally {
		            try {
		                if (fr != null) {
		                    fr.close();
		                }
		            } catch (Exception e2) {
		                e2.printStackTrace();
		            }
		        }
			}
			
		});

		while(true){
			if(!gameOver) {
				}
			else {
				if(cont==0) {
					VistaWin finJuego = new VistaWin();
					finJuego.setBounds(tablaJuego.getX(), tablaJuego.getY(), tablaJuego.getWidth(), tablaJuego.getHeight());
					finJuego.setVisible(true);
					tablaJuego.dispose();
					
					finJuego.btnSalir.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							finJuego.dispose();	
						}
					});
					finJuego.btnSeguirJuego.addActionListener(new ActionListener() {
			
						@Override
						public void actionPerformed(ActionEvent e) {
							gameOver=false;
							vista.setVisible(true);
							vista.setBounds(finJuego.getX(), finJuego.getY(), finJuego.getWidth(), finJuego.getHeight());
							finJuego.dispose();
							cantClick=0;
						}
					});
					
					finJuego.btnGuardar.addActionListener(new ActionListener() {
			
						@Override
						public void actionPerformed(ActionEvent e) {
							if(!finJuego.textNombreJugador.getText().equals("")){
								try {
							        File file = new File("otroArchivo.txt");
							        if (!file.exists()) {// if file doesnt exists, then create it
							            file.createNewFile();
							        }
			
							        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
							        BufferedWriter bw = new BufferedWriter(fw);
							        bw.write(finJuego.textNombreJugador.getText()+"\t"+cantClick+"\r\n");
							        bw.close();
			
							    } catch (IOException e1) {
							        e1.printStackTrace();
							    }
								finJuego.textNombreJugador.setText("");
								finJuego.textNombreJugador.setVisible(false);
								
							}	
						}
					});
					
					cont=1;
				}else {
				}
			}
		}
	
	}
	
}