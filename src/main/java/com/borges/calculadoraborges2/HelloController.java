package com.borges.calculadoraborges2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;


public class HelloController implements Initializable {


    private DecimalFormat decimalFormat;


    @FXML
    private TextField txtNumero1;

    @FXML
    private GridPane pnlGrid;

    @FXML
    private Label lblNumero1;

    @FXML
    private Label lblResultadoSomar;

    @FXML
    private TextField txtNumero2;

    @FXML
    private Button btnSomar;

    @FXML
    private AnchorPane pnlPrincipal;

    @FXML
    private Label lblNumero2;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnLimpar;


    @FXML
    void onClickBtnSomar(ActionEvent event) {
        try {





            double numero1 = Double.parseDouble(this.txtNumero1.getText());


            double firstCalculedValue = (30.58 / 100) * numero1;

            double secondCalculedValue = numero1 - firstCalculedValue;

            double thirdCalculedValue = (10.52 / 100) * secondCalculedValue;

            double finalCalculed = secondCalculedValue - thirdCalculedValue;

            String formattedResult = String.format("%.2f", finalCalculed);


            lblResultadoSomar.setText((formattedResult));


        } catch (NumberFormatException e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            String textError = stringWriter.toString();

            //mostrar os erros

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Aconteceu um erro de conversão numérica.");

            Label label = new Label("Segue a pilha de exceção:");

            TextArea textArea = new TextArea(textError);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxWidth(Double.MAX_VALUE);
            GridPane.setVgrow(textArea, Priority.ALWAYS);
            GridPane.setHgrow(textArea, Priority.ALWAYS);

            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            expContent.add(label, 0, 0);
            expContent.add(textArea, 0, 1);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();

        }

    }

    @FXML
    void onClickBtnLimpar(ActionEvent event) {
        this.txtNumero1.setText("");
        this.lblResultadoSomar.setText("0");
        this.txtNumero1.requestFocus();

    }


    public boolean onCloseQuery() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Pergunta");
        alerta.setHeaderText("Deseja Sair?");
        ButtonType botaoNao = ButtonType.NO;
        ButtonType botaoSim = ButtonType.YES;
        alerta.getButtonTypes().setAll(botaoSim, botaoNao);
        Optional<ButtonType> opcaoClicada = alerta.showAndWait();

        return opcaoClicada.get() == botaoSim;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.txtNumero1.requestFocus();
//        configureNumero1TextField();
    }

//    private void configureNumero1TextField() {
//        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
//        symbols.setDecimalSeparator(',');
//
//        decimalFormat = new DecimalFormat();
//        decimalFormat.setParseBigDecimal(true);
//
//        txtNumero1.setTextFormatter(new TextFormatter<>(c -> {
//            if (c.getControlNewText().isEmpty()) {
//                return c;
//            }
//
//            try {
//                DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(locale);
//                df.setParseBigDecimal(true);
//                df.parse(c.getControlNewText());
//                return c;
//            } catch (Exception e) {
//                return null;
//            }
//        }));
//    }


    @FXML
    void onLblResultadoSomarClicked(MouseEvent event) {
        String resultado = lblResultadoSomar.getText();
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(resultado);
        clipboard.setContent(content);
    }
}


