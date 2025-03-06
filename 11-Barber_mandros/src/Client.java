public class Client {
    private String nom;

    public Client(int id) {
        nom = "Client -" + id;
    }

    public void tallarseElCabell() {
        System.out.println("Tallant cabell a " + this.getNom());
    }

    public String getNom() {
        return nom;
    }  
}