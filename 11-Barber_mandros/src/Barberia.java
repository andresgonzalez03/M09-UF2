import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {

    public final Object condBarber = new Object();
    public static Barberia barberia;
    private int cadires;
    private Queue<Client> cua;


    public Barberia(int cadires) {
        this.cadires = cadires;
        cua = new LinkedList<>();
    }

    public Client seguentClient() {
        return cua.poll();
    }

    public synchronized void entrarClient(Client client) {
        if (cua.size() >= cadires) {
            System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
        } else {
            synchronized (condBarber) {
                cua.add(client);
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notify(); 
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 10; i < 20; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        barberia = new Barberia(3);
        Barber barber = new Barber("Creta");
        barber.start();
        barberia.start();
    }
}
