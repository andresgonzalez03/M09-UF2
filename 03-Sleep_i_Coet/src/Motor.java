public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;

    public Motor(String name) {
        super(name);
    }

    public void setPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error: Potència no vàlida. Ha de ser entre 0 i 10.");
            return;
        }
        this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        while (potenciaActual != potenciaObjectiu) {
            try {
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.printf("%s: Incre. Objectiu: %d Actual: %d\n", getName(), potenciaObjectiu, potenciaActual);
                } else if (potenciaActual > potenciaObjectiu) {
                    potenciaActual--;
                    System.out.printf("%s: Decre. Objectiu: %d Actual: %d\n", getName(), potenciaObjectiu, potenciaActual);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(getName() + " ha estat interromput.");
            }
        }
        System.out.printf("%s: FerRes Objectiu: %d Actual: %d\n", getName(), potenciaObjectiu, potenciaActual);
    }
    public int getPotenciaActual() {
        return potenciaActual;
    }
}