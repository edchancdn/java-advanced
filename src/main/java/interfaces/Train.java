package interfaces;

import java.util.Objects;

public class Train implements Drivable {
    private String type;
    private String model;
    private String railway;
    private int trackGauge;
    private int speed;

    // Constructor
    public Train(String type, String model, int trackGauge, String railway) {
        this.type = type;
        this.model = model;
        this.trackGauge = trackGauge;
        this.railway = railway;
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

    public int getTrackGauge() {
        return trackGauge;
    }

    public void setTrackGauge(int trackGauge) {
        this.trackGauge = trackGauge;
    }

    public String getRailway() {
        return railway;
    }

    public void setRailway(String railway) {
        this.railway = railway;
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
        return "Train{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", trackGauge='" + trackGauge + '\'' +
                ", railway='" + railway + '\'' +
                ", speed=" + speed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trackGauge == train.trackGauge &&
                speed == train.speed &&
                type.equals(train.type) &&
                model.equals(train.model) &&
                railway.equals(train.railway);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, model, trackGauge, railway, speed);
    }

    // Implement the Drivable interface methods
    @Override
    public void startEngine() {
        System.out.println("Start engine of train");
    }

    @Override
    public void changeSpeed(int targetSpeed) {
        System.out.println("Change speed of train to " + targetSpeed);
    }

    @Override
    public void stopEngine() {
        System.out.println("Stop engine of train");
    }

    // Train methods
    public void connectCaboose() {
        System.out.println("Connect caboose to train");
    }

    public void addBogie() {
        System.out.println("Add bogie to train");
    }

    public void removeBogie() {
        System.out.println("Remove bogie from train");
    }


}
