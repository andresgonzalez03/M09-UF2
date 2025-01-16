import java.util.Scanner;

public class Coet {
    private Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor("Motor " + i);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error: Potència ha de ser entre 0 i 10.");
            return;
        }

        System.out.println("Passant a potència " + p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        Scanner scanner = new Scanner(System.in);

        int potencia = scanner.nextInt();

        coet.passaAPotencia(potencia);
        coet.arranca();

        while (true) {
            potencia = scanner.nextInt();
            coet.passaAPotencia(potencia);
            if (potencia == 0) {
                break;
            }
        }
        try {
            for (Motor motor : coet.motors) {
                motor.join();
            }
        } catch (InterruptedException e) {
            System.err.println("El main ha estat interromput.");
        }

        System.out.println("-- Fi de main -----------");
        scanner.close();
    }
}