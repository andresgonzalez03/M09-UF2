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
        this.saldo = saldo;
    }
    public float getSaldo() {
        return saldo;
    }
}