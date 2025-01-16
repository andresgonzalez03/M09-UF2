public class Administracio {
    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administracio() {
        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i] = new Treballador(String.valueOf(i), 25000,20 ,65);
        }
    }

    public static void main(String[] args) {
        Administracio admin = new Administracio();
        for(Treballador t : admin.poblacio_activa) {
            t.start();
        }
        for(Treballador t : admin.poblacio_activa) {
            try {
                t.join();
                System.out.printf("Ciutadà-%s -> edat: %d / total: %.2f%n", t.getName(), t.getEdat(), t.getCobrat());
            } catch (InterruptedException e) {
                System.out.println("error");
            }    
        }
    }
}