/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import Modelo.Hilo_vehiculo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author USUARIO
 */
public class FXMLDocumentController implements Initializable {
    
    double posicionInicialCarro1;
    double posicionInicialCarro2;
    Long tiempoIncial;
    
       @FXML
    private ImageView carro1;

    @FXML
    private ImageView carro2;
    
      @FXML
    private TextField VCarro1;

    @FXML
    private TextField VCarro2;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        posicionInicialCarro1 = carro1.getX();
        posicionInicialCarro2 = carro2.getX();
        
        tiempoIncial = System.currentTimeMillis();
        
    }
    
    @FXML
    void event_guardarV(ActionEvent event) {
        
        Hilo_vehiculo hilo1 = new Hilo_vehiculo("carro1",carro1.getX(),Integer.parseInt(VCarro1.getText()), carro1,tiempoIncial);
        Hilo_vehiculo hilo2 = new Hilo_vehiculo("carro2",carro2.getX(),Integer.parseInt(VCarro2.getText()), carro2,tiempoIncial);
        hilo1.start();
        hilo2.start();
    }

    @FXML
    void event_guardarVCarro1(ActionEvent event) {

    }

    @FXML
    void event_guardarVcarro2(ActionEvent event) {

    }
    
     @FXML
    void event_reiniciar(ActionEvent event) {

    }
    
}
