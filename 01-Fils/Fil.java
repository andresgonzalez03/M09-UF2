public class Fil extends Thread {
    public Fil(String name) {
        super(name);
    }
    @Override
    public void run() {
        for(int i = 1; i <= 9; i++) {
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Termina el fil " + getName());
    }
}