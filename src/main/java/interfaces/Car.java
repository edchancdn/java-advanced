package interfaces;

import java.util.Objects;

public class Car implements Drivable{
    private String type;
    private String model;
    private String color;
    private int speed;

    // Constructor
    public Car(String type, String model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.speed = 0;
    }


    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Override toString, equals, hashCode
    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed && type.equals(car.type) && model.equals(car.model) && color.equals(car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, model, color, speed);
    }

    // Implement Drivable interface methods
    @Override
    public void startEngine() {
        System.out.println("Start engine of car");
    }

    @Override
    public void changeSpeed(int targetSpeed) {
        System.out.println("Change speed of car to " + targetSpeed);
    }

    @Override
    public void stopEngine() {
        System.out.println("Stop engine of car");
    }

    // Car methods
    public void operateSunroof(boolean open) {
        if (open) {
            System.out.println("Open sunroof of car");
        } else {
            System.out.println("Close sunroof of car");
        }
    }

}
