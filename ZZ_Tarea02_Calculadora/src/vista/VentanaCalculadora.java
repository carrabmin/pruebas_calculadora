package vista;

// Importamos librerías:
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

// Clase VentanaCalculadora que extiende de JFrame (nos permite crear ventanas):
public class VentanaCalculadora extends JFrame {
	
	// Declaramos los paneles y componentes de nuestra ventana Calculadora:
	private JPanel contentPane;
	private JPanel panelImagen;
	private JLabel etiquetaImagen;
	private JPanel panelResultado;
	public JLabel etiquetaResultado;
	private JPanel panelNumeros; 
	
	// Array de botones:
	private JButton[] botones = {
	        new JButton("1"),  new JButton("2"), new JButton("3"), new JButton("+"),
	        new JButton("4"),  new JButton("5"), new JButton("6"), new JButton("-"),  
	        new JButton("7"),  new JButton("8"), new JButton("9"), new JButton("*"),
	        new JButton("C"),  new JButton("0"), new JButton(","), new JButton("/"),
	        new JButton("Raiz 2"), new JButton ("Raiz 3"), new JButton("=")
	    };
	
	private JPanel panelRaiz;
	private JPanel panelIgual; 
	
	// Declaramos variables:
	private double resultado = 0;
	private double numero;
	private static final int SUMA = 1;
	private static final int RESTA = 2;
	private static final int MULTIPLICACION = 3;
	private static final int DIVISION = 4;
	private static final int RAIZ2 = 5;
	private static final int RAIZ3 = 6;
	private static final int NINGUNO = 0;
	private int operador = VentanaCalculadora.NINGUNO;
	private boolean hayPunto = false;
	private boolean nuevoNumero = true;
	private NumberFormat nf = NumberFormat.getInstance();

	// Constructor de nuestra ventana Calculadora:
	public VentanaCalculadora () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Calculadora");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Logo_calculadora_03.jpg"));
		setResizable(false);
		setLocationRelativeTo(null);
		
		// Llamada al método inicializarComponentes:
		inicializarComponentes();
		
		setVisible(true);
		
	}
	
	// Método inicializarComponentes:
	private void inicializarComponentes () {
		
		// Declaramos y creamos un objeto de la clase PulsaRaton
		// Nos servirar para gestionar la interacción de nuestros eventos:
		PulsaRaton pr = new PulsaRaton();
		
		// Inicializamos y damos estilo al panel que contendrá nuestra imagen:
		panelImagen = new JPanel();
		panelImagen.setBounds(5, 5, 316, 83);
		panelImagen.setBackground(new Color(33, 97, 140));
		contentPane.add(panelImagen);
		panelImagen.setLayout(null);
		
		// Inicializamos nuestra etiquetaImagen con nuestra imagen
		// y le damos estilo:
		etiquetaImagen = new JLabel(new ImageIcon("Imagen_Final.jpg"));
		etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaImagen.setBounds(0, 0, 316, 83);
		etiquetaImagen.setBorder(new MatteBorder(3, 3, 3, 3, new Color(52, 152, 219)));
		// Añadimos la etiquetaImagen al panelImagen:
		panelImagen.add(etiquetaImagen);
		
		// Inicializamos y damos estilo a nuestro panelResultado
		// (que contendrá la etiquetaResultado):
		panelResultado = new JPanel();
        panelResultado.setBounds(5, 87, 316, 42);
        contentPane.add(panelResultado);
        panelResultado.setLayout(null);
		
        // Inicializamos y damos estilo a nuestra etiquetaResultado:
		etiquetaResultado = new JLabel(" ");
        etiquetaResultado.setBounds(0, 0, 316, 42);
        etiquetaResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        etiquetaResultado.setBackground(Color.white);
        etiquetaResultado.setBorder(new MatteBorder(5, 3, 3, 3, new Color(52, 152, 219)));
        etiquetaResultado.setOpaque(true);
        etiquetaResultado.setBackground(new Color(133, 193, 233));
        etiquetaResultado.setFont(new Font("Courier New", Font.PLAIN + Font.BOLD,32));
        etiquetaResultado.setForeground(new Color(33, 97, 140));
        etiquetaResultado.setText("0,0");
        // Añadimos la etiquetaResultado a nuestro panelResultado:
        panelResultado.add(etiquetaResultado);
        
        // Inicializamos nuestro panelNumeros y le damos estilo:
		panelNumeros = new JPanel(new GridLayout(4,4));
		panelNumeros.setForeground(Color.BLACK);
		panelNumeros.setBounds(5, 129, 316, 200);
		contentPane.add(panelNumeros);
		
		// Con una estructura de control "for" recorremos el array botones[]
		// e inicializamos y damos estilo a nuestros botones: 
		for (int i=0; i<botones.length-1;i++){
        	botones[i].setFont(new Font("Courier New", Font.PLAIN + Font.BOLD,25));
        	botones[i].setBackground(new Color(133, 193, 233));
        	botones[i].setForeground(new Color(33, 97, 140));
        	botones[i].setBorder(new MatteBorder(3, 3, 3, 3, new Color(52, 152, 219)));
            // Añadimos nuestros botones al panelNumeros:
        	panelNumeros.add(botones[i]);
            
            //Ponemos nuestros botones a la escucha:
            botones[i].addActionListener(pr);
            
        
        }
		
		// Cambiamos el estilo de determinados botones de nuestro array botones[]:
		botones[3].setBackground(new Color(33, 97, 140));
        botones[3].setForeground(new Color(133, 193, 233));
        botones[7].setBackground(new Color(33, 97, 140));
        botones[7].setForeground(new Color(133, 193, 233));
        botones[11].setBackground(new Color(33, 97, 140));
        botones[11].setForeground(new Color(133, 193, 233));
        botones[15].setBackground(new Color(33, 97, 140));
        botones[15].setForeground(new Color(133, 193, 233));
        botones[16].setBackground(new Color(33, 97, 140));
        botones[16].setForeground(new Color(133, 193, 233));
        botones[17].setBackground(new Color(33, 97, 140));
        botones[17].setForeground(new Color(133, 193, 233));
		
        // Inicalizamos y damos estilo a nuestro panelRaiz:
        panelRaiz = new JPanel(new GridLayout(1,2));
	    panelRaiz.setBounds(5, 326, 316, 38);
	    contentPane.add(panelRaiz);
	    // Añadimos los botones Raiz2 y Raiz3 al panelRaiz:
	    panelRaiz.add(botones[botones.length-3]);
	    panelRaiz.add(botones[botones.length-2]);
	    
	    // Inicializamos y damos estilo a nuestro panelIgual:
		panelIgual = new JPanel(new GridLayout(1,1));
		panelIgual.setBounds(5, 361, 316, 29);
		contentPane.add(panelIgual);
		// Damos estilo personalizado a nuestro boton "=":
		botones[botones.length-1].setFont(new Font("Courier New", Font.PLAIN + Font.BOLD,25 ));
        botones[botones.length-1].setBackground(new Color(133, 193, 233));
        botones[botones.length-1].setForeground(new Color(33, 97, 140));
        botones[botones.length-1].setBorder(new MatteBorder(3, 3, 3, 3, new Color(52, 152, 219)));
        // Añadimos nuestro boton "=" a nuestro panelIgual:
        panelIgual.add(botones[botones.length-1]);
        // Ponemos a la escucha a nuestro boton "=":
        botones[botones.length-1].addActionListener(pr);
          
        // Llamada al método cambioColorRaton (que cambiará los colores de los 
        // botones cuando pasemos por encima el ratón:
        cambioColorRaton();
	}
	
	// Clase main para crear una nueva Ventanacalculadora y lanzar la aplicación:
	public static void main(String[] args) {
        new VentanaCalculadora();
    }
	
	// Clase PulsaRaton que controla la interacción con los botones:
	class PulsaRaton implements ActionListener {
		// Sobrescribimos el método actionPerformed para dar funcionalidad
		// a nuestra calculadora:
		@Override
	     public void actionPerformed(ActionEvent e) {
	         JButton origen = (JButton) e.getSource();
	         String texto = origen.getText();
	         /* Estructura de control "switch" que llamará al método operar()
	            y realizará distintas operaciones matemáticas según el botón
	            accionado (Suma/Resta/Producto/División...)
	         */
	         switch (texto) {
	             case "+":
	                 operar(VentanaCalculadora.SUMA);
	                 break;
	             case "-":
	                 operar(VentanaCalculadora.RESTA);
	                 break;
	             case "*":
	                 operar(VentanaCalculadora.MULTIPLICACION);
	                 break;
	             case "/":
	                 operar(VentanaCalculadora.DIVISION);
	                 break;
	             
	             // En el caso de presionar el boton Raiz2 nos mostrará una 
	             // ventana emergente de información del tipo JOptionPane:
	             case "Raiz 2":
	            	 JOptionPane.showMessageDialog(null, "Funcionalidad no disponible",
                             "Raíz cuadrada", JOptionPane.INFORMATION_MESSAGE);
	            	 // operar(VentanaCalculadora.RAIZ2);
	            	 break;
	            	
	             /* En el caso de presionar el boton Raiz3 nos mostrará una ventana
	                emergente para introducir una contraseña y permitir realizar
	                la operación si introducimos la clave correcta:
	             */
	             case "Raiz 3":
	            	 // Inicializamos un nuevo panelPassword 
	            	 // y un nuevo JPasswordField:
	               	 JPanel panelPassword = new JPanel();
	                 JPasswordField clave = new JPasswordField();
	            	           	 
	               	 panelPassword.setLayout(new BorderLayout());
	                 panelPassword.add(BorderLayout.NORTH, new JLabel("Ingrese la contraseña"));
	                 panelPassword.add(BorderLayout.CENTER, clave);                                             
	                 
	                 // Declaramos una variable entera que mostrará la 
	                 // ventana emergente de solicitud de contraseña:
	                 int okCxl = JOptionPane.showConfirmDialog(null, panelPassword, "Contraseña", JOptionPane.OK_CANCEL_OPTION);          
	            	 
	                 // Con un condicional "if" establecemos el funcionamiento
	                 // si hemos introducido la clave correcta:
	            	 if (okCxl == JOptionPane.OK_OPTION) {
	            		 String password = new String(clave.getPassword());
	            		 	if (password.equalsIgnoreCase("raizCubica")) {
	            		 		// Si la contraseña es correcta llamamos al
	            		 		// método operar que realizará el cálculo:
	            		 		operar(VentanaCalculadora.RAIZ3);
	            		 	
	            		 	// En el caso de no introducir la clave correcta
	            		 	// mostramos una ventana emergente de error:
	            		 	}else {
	            		 		JOptionPane.showMessageDialog(null, "Contraseña incorrecta",
	                                    "Aviso", JOptionPane.WARNING_MESSAGE);
	            		 	}
	            	 }
	            	 break;
	             
	             // Comportamiento del botón para establecer números con decimales:
	             case ",":
	                 if (!nuevoNumero){
	                     if (!hayPunto){
	                         String rdo = etiquetaResultado.getText();
	                         etiquetaResultado.setText(rdo+",");
	                     }
	                 } else {
	                     etiquetaResultado.setText("0,");
	                     nuevoNumero = false;
	                 }
	                 hayPunto = true;
	                 break;
	             
	             // Comportamiento del boton "C" que resetea los valores
	             // de la etiquetaResultado:
	             case "C":
	                 etiquetaResultado.setText("0,0");
	                 nuevoNumero = true;
	                 hayPunto = false;
	                 break;
	                 
	             // Comporamiento del botón "=" que calculará el resultado
	             // de la operación:
	             case "=":
	                 if (operador != VentanaCalculadora.NINGUNO){
	                     String rdo = etiquetaResultado.getText();
	                     if (!rdo.isEmpty()){
	                         Number n = null;
	                         
	                         // Damos formato numérico a nuestro resultado:
	                         try {
	                             n = (Number) nf.parse(rdo);
	                             numero = n.doubleValue();
	                         } catch (ParseException ex) {
	                             numero = 0;
	                         }
	                         
	                         // Estructura de control "switch" que realiza
	                         // cálculos mátematicos según el operador elegido:
	                         switch (operador) {
	                             case VentanaCalculadora.SUMA:
	                                 resultado += numero;
	                                 break;
	                             case VentanaCalculadora.RESTA:
	                                 resultado -= numero;
	                                 break;
	                             case VentanaCalculadora.MULTIPLICACION:
	                                 resultado *= numero;
	                                 break;
	                             case VentanaCalculadora.DIVISION:
	                                 resultado /= numero;
	                                 break;
	                                 
	                             case VentanaCalculadora.RAIZ2:
	                            	 resultado = Math.sqrt(numero);	                                               
	                            	 nuevoNumero = false;
	                            	 
	                            	 break;
	                             case VentanaCalculadora.RAIZ3:
	                            	 resultado = Math.pow(numero, (double) 1 / 3);
	                            	 nuevoNumero = false;
	                            	 break;
	                            	
	                             default:
	                                 resultado = numero;
	                                 break;
	                         }
	                         operador = VentanaCalculadora.NINGUNO;
	                         etiquetaResultado.setText(nf.format(resultado));
	                     }
	                 }
	                 break;
	             default:
	                 String rdo = etiquetaResultado.getText();
	                 if (nuevoNumero){
	                     etiquetaResultado.setText(texto);
	                 } else {
	                     etiquetaResultado.setText(rdo + texto);
	                 }
	                 nuevoNumero = false;
	                 break;
	         }
	     }
		
	}
		
	// Método operar que realiza los cálculos:
	public void operar(int operacion){
        if (!nuevoNumero){
            String rdo = etiquetaResultado.getText();
            if (!rdo.isEmpty()){
                Number n = null;
                try {
                    n = (Number) nf.parse(rdo);
                    numero = n.doubleValue();
                } catch (ParseException ex) {
                    
                }
                switch (operador) {
                    case VentanaCalculadora.SUMA:
                        resultado += numero;
                        break;
                    case VentanaCalculadora.RESTA:
                        resultado -= numero;
                        break;
                    case VentanaCalculadora.MULTIPLICACION:
                        resultado *= numero;
                        break;
                    case VentanaCalculadora.DIVISION:
                        resultado /= numero;
                        break;
                      
                    case VentanaCalculadora.RAIZ2:
                    	resultado = Math.sqrt(numero);
                   
                   	 	break;
                    case VentanaCalculadora.RAIZ3:
                   	 	resultado = Math.pow(numero, (double) 1 / 3);
                   	 	break;
                        
                    default:
                        resultado = numero;
                }
                operador = operacion;
                etiquetaResultado.setText(nf.format(resultado));
                nuevoNumero = true;
                hayPunto = false;
            }
        }
    }
	
	/* Método cambioColorRaton que cambia el color de los botones cuando
	   pasemos por encima con el ratón o salgamos de ellos con el ratón
	   (al utilizar un array de botones[] tenemos que especificar en cada
	   uno su comportamiento individual):
	*/
	private void cambioColorRaton() {

		botones[0].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					botones[0].setBackground(new Color(195, 155, 211));
					
        		}
				
				@Override
				public void mouseExited(MouseEvent e) {
					botones[0].setBackground(new Color(133, 193, 233));
					}
				
			});
		
		botones[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[1].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[1].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[2].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[2].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[4].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[4].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[5].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[5].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[6].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[6].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[8].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[8].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[9].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[9].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[10].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[10].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[12].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[12].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[13].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[13].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[13].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[14].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[14].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[14].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[18].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[18].setBackground(new Color(195, 155, 211));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[18].setBackground(new Color(133, 193, 233));
				}
			
		});
		
		botones[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[3].setBackground(new Color(155, 89, 182));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[3].setBackground(new Color(33, 97, 140));
				}
			
		});
		
		botones[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[7].setBackground(new Color(155, 89, 182));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[7].setBackground(new Color(33, 97, 140));
				}
			
		});
		
		botones[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[11].setBackground(new Color(155, 89, 182));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[11].setBackground(new Color(33, 97, 140));
				}
			
		});
		
		botones[15].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[15].setBackground(new Color(155, 89, 182));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[15].setBackground(new Color(33, 97, 140));
				}
			
		});
		
		botones[16].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[16].setBackground(new Color(155, 89, 182));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[16].setBackground(new Color(33, 97, 140));
				}
			
		});
		
		botones[17].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botones[17].setBackground(new Color(155, 89, 182));
				
    		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				botones[17].setBackground(new Color(33, 97, 140));
				}
			
		});
	}

}

