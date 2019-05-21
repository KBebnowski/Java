package Zaj8;

import Zaj8.figures.Circle;
import Zaj8.figures.Rectangle;
import Zaj8.figures.Triangle;
import Zaj8.measurers.FieldMeasurer;
import Zaj8.measurers.PerimeterMeasurer;

public abstract class Measurer {


    public double total;

    public static Measurer createInstance(MeasurerType type) {
        Measurer m = null;
        switch (type){
            case FieldMeasurer: m = new FieldMeasurer(); break;
            case PerimeterMeasurer: m = new PerimeterMeasurer(); break;
        }
        return m;
    }

    public abstract void visit(Circle circle);

    public abstract void visit(Rectangle rectangle);

    public abstract void visit(Triangle triangle);
}

enum MeasurerType {
    FieldMeasurer,
    PerimeterMeasurer;
}
