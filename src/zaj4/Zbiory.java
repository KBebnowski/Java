package zaj4;

import java.util.HashSet;
import java.util.Set;

public class Zbiory {

    public static void main(String[] args) {

        Set<Car> samochody = new HashSet<>();

        samochody.add(new Car("Daewoo", "Matiz", 2001));
        samochody.add(new Car("Fiat", "Panda", 2011));
        samochody.add(new Car("Volkswagen", "Passat", 1998));
        //samochody.add(new Car("Volkswagen", "Passat", 1998)); //dodajemy zeby sprawdzic czy doda sie tylko raz

        System.out.println(samochody.size());
        System.out.println(samochody);
        //System.out.println(samochody.get(1).getBrand());   - get nie ma metody takiej w HashSet, nie mozna pobrac po indeksie

        System.out.println("..." + "\n");

        for(Car c:samochody){
            System.out.println(c + "\t" + c.hashCode());       // sortowanie jest zwiazane z hashCode, hascocde nie musi byc unikatowy, moze w 1000 elementach byc 3, jesli sa takie same to porownujemy je i sprawdzamy czy sa to te same obiekty
        }                                                      // zgodnosc hashy mowi tylko ze jest szansa ze obiekty sa takie same

        System.out.println("..." + "\n");

        Car c = new Car("Volkswagen", "Passat", 1998); //doda mimo tego ze wyzej jest ten sam passat bo on nie sprawdza po danych tylko porownuje obiekty
                                                                          // dlatego tego nizej nie doda do Zbioru,
                                                                          // jak dodamy w klasie car equals i hashCode to nie doda bo wtedy sprawdza po zawartosci jaka wybralismy

        samochody.add(c);
        System.out.println(samochody);
        samochody.add(c);
        System.out.println(samochody);



    }


}
