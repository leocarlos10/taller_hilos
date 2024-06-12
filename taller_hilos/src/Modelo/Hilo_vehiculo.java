/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

/**
 *
 * @author USUARIO
 */
public class Hilo_vehiculo extends Thread {

    String nombreCarro;
    double posicionInicial;
    int velocidad;
    ImageView imagen, carro1, carro2;
    long tiempoInicial;
    boolean running;

    public Hilo_vehiculo(String nombre, double posicionInicial, int velocidad, ImageView imagen, long tiempoInicial, ImageView carro1, ImageView carro2) {
        this.nombreCarro = nombre;
        this.velocidad = velocidad;
        this.posicionInicial = posicionInicial;
        this.imagen = imagen;
        this.tiempoInicial = tiempoInicial;
        this.running = true;
        this.carro1 = carro1;
        this.carro2 = carro2;
    }

    @Override
    public void run() {
        movimiento();
    }

    public void movimiento() {

        while (running) {
            try {
                Thread.sleep(200); // Control de la frecuencia de actualización
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Calcular el tiempo transcurrido
            long tiempoTranscurrido = System.currentTimeMillis();
            double tiempoSegundos = (tiempoTranscurrido - tiempoInicial) / 1000.0; // Tiempo en segundos

            // Calcular el nuevo desplazamiento usando x = vt
            double desplazamiento = velocidad * tiempoSegundos;

            // si el hilo que ejecuta el metodo es carro1 se suma de lo contrario se resta
            double newX;
            if (nombreCarro.equals("carro1")) {
                newX = posicionInicial + desplazamiento;
            } else {
                newX = posicionInicial - desplazamiento;
            }

            // Actualizar la posición del carro
            Platform.runLater(() -> {
                imagen.setLayoutX(newX); // Actualizar la posición en X

                // Comprobar colisión
                if (carro1.getBoundsInParent().intersects(carro2.getBoundsInParent())) {
                    detener();
                }
            });
        }
    }
    
    public synchronized void detener(){
        
       this.running = false; 
    }

}
