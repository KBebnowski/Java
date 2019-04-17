package zaj4;

import java.util.*;

public class Listy {

    public static void main(String[] args) {

        List<Car> samochody = new ArrayList<>();

        samochody.add(new Car("Daewoo", "Matiz", 2001));
        samochody.add(new Car("Fiat", "Panda", 2011));
        samochody.add(new Car("Volkswagen", "Passat", 1998));

        System.out.println(samochody.size());
        System.out.println(samochody);
        System.out.println(samochody.get(1).getBrand());

        System.out.println("..." + "\n");



        Iterator<Car> it = samochody.iterator(); //iterator porusza sie po kolekcji (od 0 do maks, mozna za pomoca metod uzyskac np. odwrotna kolejnosc)
        //Collections.sort(samochody);  - blad, miedzy stworzeniem iteratora a jego wykorzystaniem nie mozna zmieniac listy
        while(it.hasNext()){ //iterator ustawia sie przed 0
            Car c= it.next();
            System.out.println(c.getBrand());
        }

        System.out.println("..." + "\n");        System.out.println("Sortowanie");
        Collections.sort(samochody);

        System.out.println("..." + "\n");

        for(Car c: samochody) { //co, skad, co z tym zrobic
            System.out.println(c.getBrand());
        }



    }
}
