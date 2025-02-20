package src;

public class Taula {
    private static Filosof[] comensals;
    private static Forquilla[] forquilles;

    public Taula(int noComensals) {
        comensals = new Filosof[noComensals];
        forquilles = new Forquilla[noComensals];
        for (int i = 0; i < noComensals; i++) {
            forquilles[i] = new Forquilla(i);
        }
    }

    public void showTaula() {
        for (int i = 0; i < comensals.length; i++) {
            System.out.println("Comensal:" + "fil" + i + " esq:" +  forquilles[i].getNumero() + " dret:" + forquilles[(i+1) % comensals.length].getNumero());
        } 
        System.out.println("------------------------------");
    }

    public void cridarATaula() {
        for (int i = 0; i < comensals.length; i++) {
            comensals[i] = new Filosof("fil" + i , forquilles[i], forquilles[(i+1) % comensals.length]);
        }
        for (int i = 0; i < comensals.length; i++) {
            comensals[i].start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}