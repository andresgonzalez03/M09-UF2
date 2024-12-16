public class Principal {
    public static void main(String[] args) throws Exception  {
        Fil filJ = new Fil("Juan");
        Fil filP = new Fil("Pepe");
        System.out.println("Termina thread main");

        filJ.start();
        filP.start();

        filJ.join();
        filP.join();  
    }
}