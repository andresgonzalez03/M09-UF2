import java.util.Random;

public class Soci extends Thread {

    private Compte CompteInstance;
    private float aportacio;
    private int experaMax;
    private Random rnd;
    private int maxAnys;

    public Soci() {
        experaMax = 100;
        maxAnys = 10;
        aportacio = 10f;
        rnd = new Random();
    }
    public Compte getCompteInstance() {
        CompteInstance =  Compte.getInstance();
        return CompteInstance;

    }
    @Override
    public void run() {
        float saldo = CompteInstance.getSaldo();
        for (int i = 0; i < maxAnys; i++) {
            for (int j = 1; j <= 12; j++) {
                if(j%2 == 0) {
                    saldo += aportacio; 
                } else {
                    saldo -= aportacio;
                }
                CompteInstance.setSaldo(saldo);
            }            
            try {
                Thread.sleep(rnd.nextInt(experaMax));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }   
}