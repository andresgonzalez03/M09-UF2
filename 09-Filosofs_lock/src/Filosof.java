package src;

import java.util.Random;

public class Filosof extends Thread {
    private long iniciGana;
    private long fiGana;
    private long gana = calcularGana();
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private Random rnd;

    public Filosof(String nombre, Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        super(nombre);
        resetGana();
        rnd = new Random();
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
    }
    
    public void menjar() {
        fiGana = System.currentTimeMillis() / 1000;
        gana = calcularGana();
        System.out.println(getName() + " menja amb gana " + gana);
        delay(1000, 2000);
        resetGana();
        System.out.println(getName() + " ha acabat de menjar");
    }
    
    public void agafarForquillaEsquerra(Forquilla forquillaEsquerra) {
        forquillaEsquerra.agafar();
    }
    
    public void agafarForquillaDreta(Forquilla forquillaDreta) {
        forquillaDreta.agafar();
    }
    
    public void agafarForquilles() {
        agafarForquillaEsquerra(forquillaEsquerra);
        agafarForquillaDreta(forquillaDreta);
        System.out.println(getName() + " té forquilles esq(" + forquillaEsquerra.getNumero() + ") dreta(" + forquillaDreta.getNumero() + ")");
    }
    
    public void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.println(getName() + " deixa les forquilles");    
    }

    public void pensar() {
        System.out.println(getName() + " pensant...");
        delay(1000, 2000);
    }

    private long calcularGana() {
        return fiGana - iniciGana;
    }
    
    private void resetGana() {
        iniciGana = System.currentTimeMillis() / 1000;
        gana = 0;
    }

    private void delay(int inici, int fi) {
        try {
            Thread.sleep(rnd.nextInt(inici, fi));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        while (true) {
            resetGana();
            agafarForquilles();
            menjar();
            deixarForquilles();
            pensar();
        }
    }
}   
