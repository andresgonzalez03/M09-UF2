package src;

import java.util.concurrent.locks.*;

public class Forquilla {
    private int numero;
    private final Lock bloqueig = new ReentrantLock();

    public Forquilla(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
    public void agafar() {
        bloqueig.lock();
    }

    public void deixar() {
        bloqueig.unlock();
    }
}