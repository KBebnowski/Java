package Zaj8.measurers;

import Zaj8.Measurer;
import Zaj8.figures.Circle;
import Zaj8.figures.Rectangle;
import Zaj8.figures.Triangle;

public class FieldMeasurer extends Measurer {//POLA



    @Override
    public void visit(Circle circle) {
        double f = Math.PI*circle.r*circle.r;
        total+=f;
    }

    @Override
    public void visit(Rectangle rectangle) {
        double f = rectangle.w*rectangle.h;
        total+=f;
    }

    @Override
    public void visit(Triangle triangle) {
        double f = 0; //nie wiemy jak policzyc narazie
        total +=f;
    }
}
