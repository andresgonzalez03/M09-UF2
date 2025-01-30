import java.util.Random;

public class Assistent extends Thread {

    private Esdeveniment esdeveniment;
    private Random rnd;
    
    public Assistent(String name, Esdeveniment esdeveniment) {
        super(name);
        this.esdeveniment = esdeveniment;
        rnd = new Random();
    }
    @Override
    public void run() {
        while(true) {
            if(rnd.nextInt() < 0.5) {
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}