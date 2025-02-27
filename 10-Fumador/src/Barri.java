public class Barri {

    private Estanc estanc;
    private Fumador[] fumadors;

    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];
    }

    public void marxaFumadors() {
        for (int i = 0; i < fumadors.length; i++) {
            fumadors[i] = new Fumador(estanc, i);
        }
        for (int i = 0; i < fumadors.length; i++) {
            fumadors[i].start();
        }
    }

    public void marxaEstanc() {
        estanc.start();
        System.out.println("Estanc obert");
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.marxaFumadors();
        barri.marxaEstanc();
        int c = 0;
        while (c < 3) {
            c = 0;
            for (Fumador fumador : barri.fumadors) {
                if (fumador.getFumades() >= 3) {
                    c++;
                }
            }
        }
        barri.estanc.tancarEstanc();
        System.out.println("Estanc tancat");
    }
}
