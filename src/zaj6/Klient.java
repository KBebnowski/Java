package zaj6;

public class Klient implements Runnable { //ma byc watkiem wiec implements Runnable
    private int id;
    Poczta poczta;

    public Klient(int id, Poczta p){
        this.id=id;
        this.poczta = p;
    }

    @Override
    public void run() {
        try {
        System.out.println("Klient " + this +" przyszedl na pocztę");
        Okienko o;
        do {
            o = poczta.zajmijOkienko();
            Thread.sleep(5);
        }while(o==null);

        o.obslugaKlienta(this);
        poczta.zwolnijOkienko(o);
        System.out.println("Klient " + this+ " idzie do domu");
    } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return Integer.toString(id);
    }

    public static void main(String[] args) {
        Poczta p = new Poczta();
        for(int i=0; i<10000; i++){
            Thread t = new Thread (new Klient(i+1,p)); //robimy watek dla kazdego klienta
            t.start();
        }
    }
}
