package zaj6;

import java.util.ArrayList;
import java.util.List;

public class Licznik implements Runnable {

    private static int x;   //static pracuja na jednym x
    private int id;
    private static Object synchMonitor = new Object(); //bo x tez jest static
    public Licznik (int id){this.id=id;}

    private static synchronized void next(){ //synchronized jest this dlatego musimy dodac static zeby zamiast this byl Object(synchMonitor)
        x++;
    }

    @Override
    public void run() {
        for(int i = 0; i<1000 ; i++){
            /*synchronized (synchMonitor){
                x++;
            }*/
            next();
            if(x%50==0) //co 50 wypisuje na ekran
                System.out.println("w" + id + " --> " + x);
        }
    }

    //watki
    public static void main(String[] args) throws InterruptedException {
        List<Thread> th = new ArrayList<>();
        for(int i = 0; i<100; i++){
            Thread t = new Thread(new Licznik(i+1));
            t.start();
            th.add(t);
        }

        for(Thread t: th){
            t.join();
        }

        System.out.println(x);
        System.out.println("Koniec Programu");
    }
}

/*
-----1------

package zaj6;

        import java.util.ArrayList;
        import java.util.List;

public class Licznik implements Runnable {

    private int x;   //static pracuja na jednym x
    private int id;
    public Licznik (int id){this.id=id;}

    @Override
    public void run() {
        for(int i = 0; i<1000 ; i++){
            x++;
            if(x%50==0) //co 50 wypisuje na ekran
                System.out.println("w" + id + " --> " + x);
        }
    }

 public static void main(String[] args) throws InterruptedException {
/*        Thread t1 = new Thread(new Licznik(1));
        Thread t2 = new Thread(new Licznik(2));
        t1.start();
        t2.start();
        t2.join();
        t1.join();

        System.out.println("Koniec Programu");
    }
}*/



/*
----2----
package zaj6;

import java.util.ArrayList;
import java.util.List;

public class Licznik implements Runnable {

    private int x;   //static pracuja na jednym x
    private int id;
    public Licznik (int id){this.id=id;}

    @Override
    public void run() {
        for(int i = 0; i<1000 ; i++){
            x++;
            if(x%50==0) //co 50 wypisuje na ekran
                System.out.println("w" + id + " --> " + x);
        }
    }

    //watki
    public static void main(String[] args) throws InterruptedException {
        List<Thread> th = new ArrayList<>();
        for(int i = 0; i<100; i++){
            Thread t = new Thread(new Licznik(i+1));
            t.start();
            th.add(t);
        }

        for(Thread t: th){
            t.join();
        }

        System.out.println(x);
        System.out.println("Koniec Programu");
* */

/*
---3---

package zaj6;

import java.util.ArrayList;
import java.util.List;

public class Licznik implements Runnable {

    private static int x;   //static pracuja na jednym x
    private int id;
    private static Object synchMonitor = new Object(); //bo x tez jest static
    public Licznik (int id){this.id=id;}

    @Override
    public void run() {
        for(int i = 0; i<1000 ; i++){
            synchronized (synchMonitor){
                x++;
            }
            if(x%50==0) //co 50 wypisuje na ekran
                System.out.println("w" + id + " --> " + x);
        }
    }

    //watki
    public static void main(String[] args) throws InterruptedException {
        List<Thread> th = new ArrayList<>();
        for(int i = 0; i<100; i++){
            Thread t = new Thread(new Licznik(i+1));
            t.start();
            th.add(t);
        }

        for(Thread t: th){
            t.join();
        }

        System.out.println(x);
        System.out.println("Koniec Programu");
    }
}

* */