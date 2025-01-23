public class Associacio {
    private int numSocis;
    private Soci[] socis;

    public Associacio() {
        numSocis = 1000;
        this.socis = new Soci[numSocis];
    }
    public void iniciaCompteTempsSocis() {
        for (int i = 1; i < socis.length; i++) {
            socis[i] = new Soci();
            socis[i].start();
        }
    }
    public void esperaPeriodeSocis() {
        for (int i = 1; i < socis.length; i++) {
            try {
                socis[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void mostraBalancComptes() {
        System.out.printf("Saldo: %.2f%n", Compte.getInstance().getSaldo());   
    }
    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }
}