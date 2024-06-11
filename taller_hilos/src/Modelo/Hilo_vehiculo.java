/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javafx.scene.image.ImageView;

/**
 *
 * @author USUARIO
 */
public class Hilo_vehiculo extends Thread {
    
    String nombreCarro;
    double posicionInicial;
    int velocidad;
    ImageView imagen;
    
    public Hilo_vehiculo(String nombre, double posicionInicial,int velocidad,ImageView imagen){
        this.nombreCarro = nombre;
        this.velocidad = velocidad;
        this.posicionInicial = posicionInicial;
        this.imagen = imagen;
    }
    
    
    @Override
    public void run(){
        
        //logica
    }
    
    
}
