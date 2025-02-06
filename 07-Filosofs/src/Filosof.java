import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana;
    private Random rnd;

    public Filosof(String name, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        super(name);
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
        rnd = new Random();
        gana = 0;
    }

    public void menjar() {
        while (true) {
            if (!forquillaEsquerra.isEnUs()) {
                agafaForquilla(forquillaEsquerra);
                System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra" + forquillaEsquerra.getNumero());
                if (!forquillaDreta.isEnUs()) {
                    agafaForquilla(forquillaDreta);
                    System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNumero());
                    System.out.println("Filòsof: " + getName() + " menja");
                    delay(1000, 2000);
                    gana = 0;
                    deixaForquilla(forquillaEsquerra);
                    deixaForquilla(forquillaDreta);
                    System.out.println("Filòsof: " + getName() + " ha acabat de menjar");
                    break;
                } else {
                    deixaForquilla(forquillaEsquerra); 
                    System.out.println("Filòsof: " + getName() +  " deixa l'esquerra " + "(" + forquillaEsquerra.getNumero() + ")" );
                    gana++;                    
                    System.out.println("Filòsof: " + getName() + " gana = " + gana);
                    delay(500, 1000);
                }
            } else {
                gana++;
                System.out.println("Filòsof: " + getName() + " gana = " + gana);
                delay(500, 1000);
            }

        }
    }

    public void pensar() {
        delay(1000, 2000);
    }

    @Override
    public void run() {
        while(true) {
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

    private void agafaForquilla(Forquilla forquilla) {
        forquilla.setEnUs(true);
    }

    private void deixaForquilla(Forquilla forquilla) {
        forquilla.setEnUs(false);
    }
}