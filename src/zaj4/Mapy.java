package zaj4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapy {
    public static void main(String[] args) {
        Map<String,List<Car>> pojazdy = new HashMap<>();

        List<Car> l = new ArrayList<>();

        l.add(new Car("Fiat","Panda",2010));
        pojazdy.put("Jan Kowalski", l);

        l=new ArrayList<>();

        l.add(new Car("Skoda","Oktawia",2016));
        pojazdy.put("Janina Kowalska", l);

        l=new ArrayList<>();

        l.add(new Car("Volksvagen","Golf",2000));
        pojazdy.put("Izabela Kania", l);


        pojazdy.get("Jan Kowalski")
                .add(new Car("Audi", "Q4", 2017));

        for(String osoba : pojazdy.keySet()){
            System.out.print(osoba + " => ");
            for (Car c: pojazdy.get(osoba)){
                System.out.print(c.getModel() + "");
            }
            System.out.println();
        }







    }
}
