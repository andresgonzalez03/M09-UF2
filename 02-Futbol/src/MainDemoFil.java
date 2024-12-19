public class MainDemoFil {
    public static void main(String[] args) {
        Thread fil = Thread.currentThread();
        System.out.println("MainDemoFil.main:");
        System.out.println("Prioritat -> " + fil.getPriority() + ", " + "Nom -> " + fil.getName());
        System.out.println("toString() -> " + fil.toString());
    }
}
