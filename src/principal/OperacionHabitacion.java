/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author areka
 */
public class OperacionHabitacion{
    private Habitacion[] vHabitaciones = new Habitacion[60];
   
 /** Metodo previamente usado para crear el array de habitaciones, usado sólamente durante la primera ejecución */
    
/**    public void guardarHabitaciones(){
        for (int i=0;i<5;i++) {
            vHabitaciones[i] = new Habitacion(101+i,"DUI");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+5] = new Habitacion(106+i,"DB");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+10] = new Habitacion(111+i,"TR");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+15] = new Habitacion(116+i,"SUITE");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+20] = new Habitacion(201+i,"DUI");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+25] = new Habitacion(206+i,"DB");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+30] = new Habitacion(211+i,"TR");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+35] = new Habitacion(216+i,"SUITE");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+40] = new Habitacion(301+i,"DUI");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+45] = new Habitacion(306+i,"DB");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+50] = new Habitacion(311+i,"TR");
        }
        for (int i=0;i<5;i++) {
            vHabitaciones[i+55] = new Habitacion(316+i,"SUITE");
        }
        for (int i=0;i<vHabitaciones.length;i++) {
            System.out.println(vHabitaciones[i]);
        }
        File fichero = new File(".\\recursos\\habitaciones.dat");
            try {
                if (!fichero.exists()) {
                    fichero.createNewFile();
                }
                FileOutputStream fo = new FileOutputStream(fichero);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(vHabitaciones);
                oo.close();
            } catch (IOException ex) {
                Logger.getLogger(OperacionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } */
    
    public void cargarHabitaciones() {
        File fichero = new File(".\\recursos\\habitaciones.dat");
            try {
                if (!fichero.exists()) {
                    fichero.createNewFile();
                }
                FileInputStream fi = new FileInputStream(fichero);
                ObjectInputStream oi = new ObjectInputStream(fi);
                vHabitaciones = (Habitacion[]) oi.readObject();
                oi.close();
            } catch (IOException ex) {
                Logger.getLogger(OperacionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
    public void guardarHabitaciones() {
        File fichero = new File(".\\recursos\\habitaciones.dat");
            try {
                if (!fichero.exists()) {
                    fichero.createNewFile();
                }
                FileOutputStream fo = new FileOutputStream(fichero);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(vHabitaciones);
                oo.close();
            } catch (IOException ex) {
                Logger.getLogger(OperacionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    public void imprimirHabitaciones() {
        for (int i=0;i<vHabitaciones.length;i++) {
            System.out.println(vHabitaciones[i]);
        }
    }
}
