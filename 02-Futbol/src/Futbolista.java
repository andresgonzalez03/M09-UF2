public class Futbolista extends Thread {
    private static final int NUM_JUGADORS = 11;
    private final int NUM_TIRADES = 20;
    private final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        ngols = 0;
        ntirades = 0;
    }
    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            if((float) Math.random() > PROBABILITAT) {
                ngols++;
            }
            ntirades++;
        }
    }
    public int getNgols() {return ngols;}

    public static void main(String[] args) throws InterruptedException {
        String [] noms = {"Piqué","Vinicius","Torres","Ramos","Ronaldo","Lewan","Belli","Arnau","Aspas","Messi","Mbappé"};
        Futbolista[] futbolistas = new Futbolista[NUM_JUGADORS];
        for (int i = 0; i < noms.length; i++) {
            futbolistas[i] = new Futbolista(noms[i]);
        }
        System.out.println("Inici dels xuts --------------------");
        for(Futbolista futbolista : futbolistas) {
            futbolista.start();
        }
        for (Futbolista futbolista : futbolistas) {
            futbolista.join();
        }
        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");
        for (Futbolista futbolista : futbolistas) {
            System.out.println(futbolista.getName() + "-> " + futbolista.getNgols() + " gols");  
        } 
    }
}