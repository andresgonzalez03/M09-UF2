import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana;
    private Random rnd;
    private int noComensal;

    public Filosof(int noComensal, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        super("Filòsof " + noComensal);
        this.noComensal = noComensal;
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
        rnd = new Random();
        gana = 0;
    }

    public void menjar() {
        while (true) {
            synchronized(forquillaEsquerra) {
                
            }
            
        }
    }

    public void pensar() {
        delay(1000, 2000);
    }

    @Override
    public void run() {
        while (true) {
            menjar();
            pensar();
        }
    }

    private void delay(int inici, int fi) {
        try {
            Thread.sleep(rnd.nextInt(inici, fi));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void agafaForquillaEsquerra(Forquilla forquilla) {
        forquilla.setPropietari(this.get);
    }

    private void agafaForquillaDreta(Forquilla forquilla) {
        
    }

    private void deixarForquilles(Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        
    }

    private void agafarForquilles(Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        
    }

}
