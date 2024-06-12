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

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author USUARIO
 */
public class FXMLDocumentController implements Initializable {
    
    double posicionInicialCarro1;
    double posicionInicialCarro2;
    long tiempoIncial;
    
    //hilos
     Hilo_vehiculo hilo1;
     Hilo_vehiculo hilo2;
    
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
        posicionInicialCarro1 = carro1.getLayoutX();
        posicionInicialCarro2 = carro2.getLayoutX();
        
        tiempoIncial = System.currentTimeMillis();
        
    }
    
    @FXML
    void event_guardarV(ActionEvent event) {
        detenerHilos();
        hilo1 = new Hilo_vehiculo("carro1", carro1.getLayoutX(), Integer.parseInt(VCarro1.getText()), carro1, tiempoIncial, carro1, carro2);
        hilo2 = new Hilo_vehiculo("carro2", carro2.getLayoutX(), Integer.parseInt(VCarro2.getText()), carro2, tiempoIncial, carro1, carro2);
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
            detenerHilos();
            carro1.setLayoutX(posicionInicialCarro1);
            carro2.setLayoutX(posicionInicialCarro2);
            tiempoIncial=System.currentTimeMillis();
    }
    
     private void detenerHilos() {
        if (hilo1 != null) {
            hilo1.detener();
            hilo1 = null;
        }
        
        if (hilo2 != null) {
            hilo2.detener();
            hilo2 = null;
        }
    }
}
