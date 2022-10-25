package dad.calculadora;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Implementaci�n de la l�gica de una calculadora.
 * @author Fran Vargas
 */
public class Calculadora {
	
	public static final char IGUAL = '='; 
	public static final char SUMAR = '+'; 
	public static final char RESTAR = '-'; 
	public static final char DIVIDIR = '/'; 
	public static final char MULTIPLICAR = '*';
	
	private static final char COMA = '.'; 
	
	private DoubleProperty operando = new SimpleDoubleProperty();
	private StringProperty operador = new SimpleStringProperty();
	private BooleanProperty nuevoOperando = new SimpleBooleanProperty();
	private StringProperty pantalla = new SimpleStringProperty();
	
	public Calculadora() {
		borrar();
	}
	
	/**
	 * Devuelve el contenido de la pantalla de la calculadora.
	 * @return Cadena de texto con el contenido de la pantalla de la calculdora.
	 */
	public StringProperty getPantalla() {
		return pantalla;
	}

	/**
	 * Inicializa por completo la calculadora, borrando la informaci�n que tiene memorizada y la pantalla.
	 */
	public void borrar() {
		operando.setValue(0.0);
		operador.setValue("=");
		borrarTodo();
	}
	
	/**
	 * Borra lo que hay en la pantalla (el �ltimo operando introducido).
	 */
	public void borrarTodo() {
		nuevoOperando.setValue(true);
		pantalla.setValue("0.0");
	}
	
	/**
	 * Indica a la calculadora que realice la operaci�n indicada. 
	 * @param operador Operaci�n a realizar; usar una constante: IGUAL, SUMAR, RESTAR, MULTIPLCIAR, DIVIDIR.
	 */
	
 //.add no suma
	public void operar(char operador) {
		nuevoOperando.setValue(true);
		double operando2 = Double.parseDouble(pantalla.getValue());
		switch (this.operador.getValue().charAt(0)) {
			case SUMAR: operando.setValue(operando.getValue()+operando2); break;
			case RESTAR: operando.setValue(operando.getValue()-operando2); break;
			case MULTIPLICAR: operando.setValue(operando.getValue()*operando2); break;
			case DIVIDIR: operando.setValue(operando.getValue()/operando2); break;
			case IGUAL: operando.setValue(operando2); break;
		}
		this.operador.setValue(String.valueOf(operador));
		pantalla.setValue("" + operando.getValue());
	}
	
	/**
	 * Inserta una coma en el operando actual (pantalla).
	 */
	public void insertarComa() {
		if (!pantalla.getValue().contains("" + COMA)) {
			pantalla.setValue(pantalla.getValue()+COMA);
		}
	}
	
	/**
	 * Inserta un d�gito en el operando actual (pantalla).
	 * @param digito Digito a introducir en la pantalla.
	 */
	public void insertar(char digito) {
		if (digito >= '0' && digito <= '9') {
			if (nuevoOperando.getValue()) {
				nuevoOperando.setValue(false);;
				pantalla.setValue("");
			}
			pantalla.setValue(pantalla.getValue()+digito);;
		} else if (digito == COMA) {
			insertarComa();
		}
	}
	
}
