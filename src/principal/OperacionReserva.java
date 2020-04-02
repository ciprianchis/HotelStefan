package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionReserva {
	ArrayList<Reserva> listaReservas;
	
	@SuppressWarnings("unchecked")
	public void cargarReservas() {
        File fichero = new File(".\\recursos\\reservas.dat");
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
            } catch (IOException ex) {
                Logger.getLogger(OperacionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
    public void anadirReserva(Reserva reserva) {
    	listaReservas.add(reserva);
    }
    
    public ArrayList<Reserva> cargarReservasPorNombre(String usuario) {
    	ArrayList<Reserva> reservasUsuario = new ArrayList<Reserva>();
    	for (int i=0;i<listaReservas.size();i++) {
    		if (listaReservas.get(i).getUsuario()==usuario) {
    			reservasUsuario.add(listaReservas.get(i));
    		}
    	}
    	return reservasUsuario;
    }
    
    public void guardarReservas() {
        File fichero = new File(".\\recursos\\reservas.dat");
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
    
	
	public void anadirReserva() {
		
	}
}
