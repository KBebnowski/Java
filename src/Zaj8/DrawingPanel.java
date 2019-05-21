package Zaj8;

import Zaj8.figures.Circle;
import Zaj8.figures.Rectangle;
import Zaj8.figures.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {

    List<Figure> figures = new ArrayList<>();

    @Override
    public void paint(Graphics g){
        for(Figure f : figures){
            f.draw(g);
        }
    }


    public double mesaure(MeasurerType type){
        Measurer m = Measurer.createInstance(type);//mozemy tu zrobic tak mierniczego ktory bedzie sprawdzal figury w jakis sposob
        for(Figure f : figures){
            f.accept(m);
        }
       return m.total;
    }
// Dodanie nowych figur wymusza aby poprawic mierniczyk, dodanie mierniczego nie wymusza dodanie nowych figur,
// jesli bedzie wiedzial ze zle jest wyliczone pole to wiemy gdzie szukac (w mierniczym w jakiej klasie w jakiej metodzie)
// w main dodawanie figur

    public static void main(String[] args) {
        DrawingPanel dp = new DrawingPanel();
        dp.figures.add(new Circle(234,132,15));
        dp.figures.add(new Circle(14,75,21));
        dp.figures.add(new Rectangle(33,271,12,15));
        dp.figures.add(new Triangle(
                22,25,
                32,25,
                12,12));
        //DOTO Drawing and GUI
        double f = dp.mesaure(MeasurerType.FieldMeasurer);
        System.out.println(f);
        double p = dp.mesaure(MeasurerType.PerimeterMeasurer);
        System.out.println(p);

    }
}
