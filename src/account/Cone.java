package account;
public class Cone extends Shape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }

    @Override
    public double volume() {
        return (1/3) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return "Cone with radius " + radius + " and height " + height + " has surface area " + surface_area() + " and volume " + volume();
    }
}
