package dad.calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {

	@FXML
	private Button ButtonDec;

	@FXML
	private Button ButtonDiv;

	@FXML
	private Button ButtonIgual;

	@FXML
	private Button ButtonPor;

	@FXML
	private Button ButtonRes;

	@FXML
	private Button ButtonSum;

	@FXML
	private Button Button_0;

	@FXML
	private Button Button_1;

	@FXML
	private Button Button_2;

	@FXML
	private Button Button_3;

	@FXML
	private Button Button_4;

	@FXML
	private Button Button_5;

	@FXML
	private Button Button_6;

	@FXML
	private Button Button_7;

	@FXML
	private Button Button_8;

	@FXML
	private Button Button_9;

	@FXML
	private Button Button_C;

	@FXML
	private Button Button_CE;

	@FXML
	private TextField Text;

	@FXML
	private GridPane view;

	public GridPane getView() {
		return view;
	}
	
	private Calculadora calculadora;

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Calculadora.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		calculadora = new Calculadora();
		
		Text.textProperty().bind(calculadora.getPantalla());
		
		Button_CE.setOnAction(e -> limpiar(e));
		Button_C.setOnAction(e -> borrar(e));
		ButtonDec.setOnAction(e -> decimal(e));
		ButtonIgual.setOnAction(e -> igual(e));
		ButtonSum.setOnAction(e -> sumar(e));
		ButtonRes.setOnAction(e -> restar(e));
		ButtonDiv.setOnAction(e -> dividir(e));
		ButtonPor.setOnAction(e -> multiplicar(e));
		Button_0.setOnAction(e -> numero(e));
		Button_1.setOnAction(e -> numero(e));
		Button_2.setOnAction(e -> numero(e));
		Button_3.setOnAction(e -> numero(e));
		Button_4.setOnAction(e -> numero(e));
		Button_5.setOnAction(e -> numero(e));
		Button_6.setOnAction(e -> numero(e));
		Button_7.setOnAction(e -> numero(e));
		Button_8.setOnAction(e -> numero(e));
		Button_9.setOnAction(e -> numero(e));
		
	}
	
	private void numero(ActionEvent e) {

		String text = ((Button)e.getSource()).getText(); 
		calculadora.insertar(text.charAt(0));
	}

	private void multiplicar(ActionEvent e) {
		calculadora.operar(Calculadora.MULTIPLICAR);
	}

	private void dividir(ActionEvent e) {
		calculadora.operar(Calculadora.DIVIDIR);
	}

	private void restar(ActionEvent e) {
		calculadora.operar(Calculadora.RESTAR);
	}

	private void sumar(ActionEvent e) {
		calculadora.operar(Calculadora.SUMAR);
	}

	private void igual(ActionEvent e) {
		calculadora.operar(Calculadora.IGUAL);
	}

	private void decimal(ActionEvent e) {
		calculadora.insertarComa();
	}

	private void limpiar(ActionEvent e) {
		calculadora.borrarTodo();
	}
	
	private void borrar(ActionEvent e) {
		calculadora.borrar();
	}

	
}
