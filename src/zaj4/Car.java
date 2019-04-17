package zaj4;

public class Car implements Comparable<Car>{

    private String brand;
    private String model;
    private int  year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Car o) {
        return year-o.year;       //sortowanie od najstarszego do najmlodszego
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;
        return model != null ? model.equals(car.model) : car.model == null;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;              //int result = brand != null ? brand.toLowerCase().hashCode() : 0;  - nie bedzie sprawdzal po wielkosci liter
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}
