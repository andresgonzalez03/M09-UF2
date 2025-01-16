import java.util.Random;

public class Treballador extends Thread {
    private int sou_actual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private Random rdn;
    private float cobrat;

    public Treballador(String name, int souAnual, int edatInici, int edatFinal) {
        super(name);
        edat_actual = 0;
        cobrat = 0.0f;
        sou_actual_brut = souAnual;
        edat_inici_treball = edatInici;
        edat_fi_treball = edatFinal;
        rdn = new Random();
    }

    public void cobra() {
        cobrat += sou_actual_brut / 12;
    }

    public void pagaImpostos() {
        cobrat -= cobrat * 0.24f;
    }

    public float getCobrat() {return cobrat;}
    public int getEdat() {return edat_actual;}

    @Override
    public void run() {
        try {
            for(edat_actual = edat_inici_treball; edat_actual < edat_fi_treball; edat_actual++) {
                cobra();
                Thread.sleep(rdn.nextInt(100));
                pagaImpostos();
                Thread.sleep(rdn.nextInt(100));
            }
        } catch(InterruptedException e) {
            System.err.println(getName() + " ha estat interromput.");
        }
    }
}