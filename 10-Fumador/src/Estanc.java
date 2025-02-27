import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Estanc extends Thread {
    private List<Tabac> tabacs;
    private List<Llumi> llumins;
    private List<Paper> papers;
    private Random rnd;
    private boolean isObert;

    public Estanc() {
        tabacs = new ArrayList<>();
        llumins = new ArrayList<>();
        papers = new ArrayList<>();
        rnd = new Random();
        isObert = true;
    }

    private void delay(int inici, int fi) {
        try {
            Thread.sleep(rnd.nextInt(inici, fi));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void nouSubministrament() {
        int random = rnd.nextInt(1,4);
        switch (random) {
            case 1 -> {
                addLlumi();
            }
            case 2 -> {
                addPaper();
            }
            case 3 -> {
                addTabac();
            }
        }
    }

    public synchronized void addTabac() {
        tabacs.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll();
    }
    
    public synchronized void addLlumi() {
        llumins.add(new Llumi());
        System.out.println("Afegint llumí");
        notifyAll();
    }

    public synchronized void addPaper() {
        papers.add(new Paper());
        System.out.println("Afegint paper");
        notifyAll();
    }

    public synchronized Tabac venTabac() {
        while (tabacs.isEmpty()) { 
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tabacs.remove(0);
    }
    
    public synchronized Llumi venLlumi() {
        while (llumins.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return llumins.remove(0);
    }
    
    public synchronized Paper venPaper() {
        while (papers.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return papers.remove(0);
    }
    

    public void tancarEstanc() {
        isObert = false;
    }

    @Override
    public void run() {
        while (isObert) {
            nouSubministrament();
            delay(500, 1500);
        }
    }
}