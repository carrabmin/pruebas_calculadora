/**
 * Esta es una clase del proyecto Calculadora que realiza operaciones
 * 
 * @author Carlos Rabinal M�nguez
 * @version 1.0
 * @since 30/01/2021
 * 
 * CASO ESPECIAL: Si la calculadora no pudiera utilizar n�meros negativos,
 * mostraremos un mensaje por pantalla para advertir que s�lo podemos introducir n�meros positivos
 *
 * 
 */
public class Operacion {
	
/**
 * Este es un m�todo constructor vac�o (sin par�metros)
 */
	public Operacion() {
		super();
	}
	
/**
 * Este es el m�todo booleano para calcular si un n�mero es primo o no
 * 
 * @param n es el par�metro que introducimos para averiguar si dicho n�mero es primo o no
 * @return true si el n�mero es primo y false si no es n�mero primo
 * 
 *  CASO ESPECIAL: Si introducimos un cero como par�metro, el m�todo nos devuelve false
 */
	public boolean esPrimo(int n){
	    int a = 0;
	        for (int i = 1; i < (n + 1); i++) 
	            if (n % i == 0) 
	                a++;
	        if (a != 2) 
	           return false;
	         else 
	          return true;
    }

	public void Saludo () {
		system.out.println("Hola");
	}

}