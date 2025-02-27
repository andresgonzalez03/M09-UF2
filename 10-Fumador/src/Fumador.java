import java.util.Random;

public class Fumador extends Thread {

    private Estanc estanc;
    private int id;
    private Llumi llumi;
    private Tabac tabac;
    private Paper paper;
    private int fumades;
    private Random rnd;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
        rnd = new Random();
    }

    public void compraTabac() {
        tabac = estanc.venTabac();
        if (tabac != null) {
            System.out.println("Fumador " + id + " comprant tabac");
        }
    }

    public void compraPaper() {
        paper = estanc.venPaper();
        if (paper != null) {
            System.out.println("Fumador " + id + " comprant paper");
        }
    }
    
    public void compraLlumi() {
        llumi = estanc.venLlumi();
        if (llumi != null) {
            System.out.println("Fumador " + id + " comprant llumí");
        }
    }

    public boolean fuma() {
        if (llumi != null && paper != null && tabac != null) {
            delay(500, 1000);
            llumi = null;
            paper = null;
            tabac = null;
            return true;
        }
        return false;
    }
    
    private void delay(int inici, int fi) {
        try {
            Thread.sleep(rnd.nextInt(inici, fi));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getFumades() {
        return fumades;
    }
    
    @Override
    public void run() {
        fumades = 0;
        while (fumades < 3) {
            compraTabac();
            compraLlumi();
            compraPaper();
            if (fuma()) {
                System.out.println("Fumador " + id + " fumant");
                fumades++;
                System.out.println("Fumador "+ id + " ha fumat " + fumades + " vegades");
            }
        }
    }   
}