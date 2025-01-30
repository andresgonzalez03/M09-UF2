import java.util.LinkedList;
import java.util.List;

public class Esdeveniment {

    private List<Assistent> assistents;
    private int placesDisponibles;
    
    public Esdeveniment(int placesDisponibles) {
        setPlacesDisponibles(placesDisponibles);
        assistents = new LinkedList<>();
    }
    public void setPlacesDisponibles(int placesDisponibles) {
        if(placesDisponibles <= 0) {
            this.placesDisponibles = 10;
        } else {
            this.placesDisponibles = placesDisponibles;
        }
    }
    public synchronized void ferReserva(Assistent assistent) {
        while(placesDisponibles <= 0) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(placesDisponibles > 0) {
            assistents.add(assistent);
            placesDisponibles--;
            System.out.println(assistent.getName() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
        }
    }
    public synchronized void cancelaReserva(Assistent assistent) {
        if(assistents.contains(assistent)) {    
            assistents.remove(assistent);
            placesDisponibles++;
            System.out.println(assistent.getName() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll();
        } else {
            System.out.println(assistent.getName() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDisponibles);
        }
    }  
}