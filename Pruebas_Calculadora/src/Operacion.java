/**
 * Esta es una clase del proyecto Calculadora que realiza operaciones
 * 
 * @author Carlos Rabinal Mínguez
 * @version 1.0
 * @since 30/01/2021
 * 
 * CASO ESPECIAL: Si la calculadora no pudiera utilizar números negativos,
 * mostraremos un mensaje por pantalla para advertir que sólo podemos introducir números positivos
 *
 * 
 */
public class Operacion {
	
/**
 * Este es un método constructor vacío (sin parámetros)
 */
	public Operacion() {
		super();
	}
	
/**
 * Este es el método booleano para calcular si un número es primo o no
 * 
 * @param n es el parámetro que introducimos para averiguar si dicho número es primo o no
 * @return true si el número es primo y false si no es número primo
 * 
 *  CASO ESPECIAL: Si introducimos un cero como parámetro, el método nos devuelve false
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

}