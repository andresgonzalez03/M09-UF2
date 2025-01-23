public class Compte {
    private float saldo;
    private static Compte instance;

    private Compte() {

    }
    public static Compte getInstance() {
        if(instance == null) {
            instance = new Compte();
        }
        return instance;
    }
    public void setSaldo(float saldo) {
        if(saldo > 0) {
            this.saldo = saldo;
        }
    }
    public float getSaldo() {
        return saldo;
    }
}