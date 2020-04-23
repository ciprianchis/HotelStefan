package principal;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionReserva {
	ArrayList<Reserva> listaReservas;
	
	@SuppressWarnings("unchecked")
	public void cargarReservas(String usuario) {
        File fichero = new File(".\\recursos\\reservas" + usuario + ".dat");
            try {
                if (!fichero.exists()) {
                    fichero.createNewFile();
                    listaReservas = new ArrayList<Reserva>();
                } else {
                	 FileInputStream fi = new FileInputStream(fichero);
                     ObjectInputStream oi = new ObjectInputStream(fi);
                     listaReservas = (ArrayList<Reserva>) oi.readObject();
                     oi.close();
                }
            } catch (EOFException ef) {
            	listaReservas = new ArrayList<Reserva>();
            } 
            catch (IOException ex) {
                Logger.getLogger(OperacionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
                
        } 
            catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = listaReservas.iterator();
        while (it.hasNext()) {
        	System.out.println(it.next());
        }
    };
    
    public void anadirReserva(Reserva reserva) {
    	listaReservas.add(reserva);
    }
    
    public String cargarArray() {
    	String contenido = "";
    	Iterator it = listaReservas.iterator();
        while (it.hasNext()) {
        	contenido += it.next() + "\n";
        	
        }
        return contenido;
    }
    
    public void guardarReservas(String usuario) {
        File fichero = new File(".\\recursos\\reservas" + usuario + ".dat");
            try {
                if (!fichero.exists()) {
                    fichero.createNewFile();
                }
                FileOutputStream fo = new FileOutputStream(fichero);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(listaReservas);
                oo.close();
            } catch (IOException ex) {
                Logger.getLogger(OperacionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
	
}
