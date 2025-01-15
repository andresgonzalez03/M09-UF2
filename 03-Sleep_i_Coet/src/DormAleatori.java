public class DormAleatori extends Thread {
    private final long temps;

    public DormAleatori(String name) {
        super(name);
        this.temps = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long totalElapsedTime = System.currentTimeMillis() - temps;
            System.out.printf("%s(%d) a dormir %dms total %d\n", getName(), i, totalElapsedTime, totalElapsedTime);
            try {
                Thread.sleep(totalElapsedTime);
            } catch (InterruptedException e) {
                System.err.println(getName() + " ha estat interromput.");
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();   

        System.out.println("-- Fi de main -----------");

        try {
            joan.join();
            pep.join();
        } catch (InterruptedException e) {
            System.err.println("El main ha estat interromput.");
        } 
    }
}