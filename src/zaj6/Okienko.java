package zaj6;

import java.util.Random;

public class Okienko {

    public Okienko (char nazwa)  {this.nazwa=nazwa;}

    private char nazwa;
    private Random rand = new Random(); //generator liczb pseudolosobwych

    public void obslugaKlienta(Klient k) throws InterruptedException {
        System.out.println("Klient " + k + " podszedl do okienka " + nazwa);
        int czas = rand.nextInt(50);
        Thread.sleep(czas + 30);
        System.out.println("Klient " + k + " odchodzi od okienka " + nazwa);
    }

}
