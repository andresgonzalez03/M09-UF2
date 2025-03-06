import java.util.Random;

public class Barber extends Thread {

    private Random rnd;
    
    public Barber(String name) {
        super(name);
        rnd = new Random();
    }

    @Override
    public void run() {
        while (true) {
            Client client = Barberia.barberia.seguentClient();
            if (client == null) {
                synchronized (Barberia.barberia.condBarber) {
                    try {
                        System.out.println("Ningú en espera\n" + "Barber " + getName() + " dormint");
                        Barberia.barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Li toca al client " + client.getNom());
                client.tallarseElCabell();
                try {
                    Thread.sleep(900 + rnd.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}