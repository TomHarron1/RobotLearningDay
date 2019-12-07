package frc.robot;

public class Circle {
    double radius;
    final double PI = 3.1415926;

    // constructor for Circle object
    // set the 'radius' member variable with value
    // that the user passed in 'rad'
    public Circle(double rad) {
        this.radius = rad;
    }

    // using the object's 'radius' value, return Area
    public double getArea() {
        return(PI * this.radius * this.radius);
    }

    // update the 'radius' value in this object
    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    // return the current value of 'radius' in this object
    public double getRadius() {
        return(this.radius);
    }
}