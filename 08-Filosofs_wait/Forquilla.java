public class Forquilla {

    private int numero;
    private int propietari;
    private final int LLIURE = -1;

    public Forquilla(int numero) {
        this.numero = numero;
        this.propietari = LLIURE;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }

    public int getLLIURE() {
        return LLIURE;
    }
    
    

}