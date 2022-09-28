package interfaces;

import java.util.HashSet;
import java.util.Objects;

public class AudiCar implements Car {

    private enum DriveMode { P, D, R, N }
    public HashSet<String> driveMode;
    public static final int fullTank = 70; //liters

    /*
    model, color, numberOfDoors
    These properties are initialized by the constructor.
    Once the object has been created, then these cannot be changed.
    These will only have getters.

    isEngineOn, currentSpeed, currentMode
    These will be initialized by the constructor.
    These properties will only have getters.
    The values of these properties can only be updated through the implemented methods of the Car interface.

    gasolineInTank
    This is the only property that is allowed to be updated through a setter method.
    This will have both a getter and a setter method.
     */

    private String model;
    private String color;
    private int numberOfDoors;
    private boolean isEngineOn;
    private int currentSpeed;
    private String currentMode;
    private int gasolineInTank; //liters

    public AudiCar(String model, String color, int numberOfDoors) {
        this.model = model;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.isEngineOn = false;

        this.currentSpeed = 0;
        this.currentMode = "P";
        this.gasolineInTank = 0;

        this.driveMode = getEnums();
    }

    @Override
    public String toString() {
        return "AudiCar{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AudiCar audiCar = (AudiCar) o;
        return numberOfDoors == audiCar.numberOfDoors && model.equals(audiCar.model) && color.equals(audiCar.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, numberOfDoors);
    }

    public static HashSet<String> getEnums() {
        HashSet<String> values = new HashSet<String>();
        for (DriveMode c : DriveMode.values()) {
            values.add(c.name());
        }
        return values;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public boolean getIsEngineOn() {
        return isEngineOn;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public String getCurrentMode() {
        return currentMode;
    }

    public int getGasolineInTank() {
        return gasolineInTank;
    }

    public void setGasolineInTank(int gasolineInTank) {
        this.gasolineInTank = gasolineInTank;
    }

    @Override
    public boolean startEngine() {
        System.out.println("Starting engine...");
        if (gasolineInTank > 0) {
            isEngineOn = true;
            System.out.println("Engine started.");
            return true;
        } else {
            System.out.println("Engine not started... Gasoline tank is empty.");
            return false;
        }
    }

    @Override
    public boolean changeMode(String mode) {
        System.out.println("Changing mode...");
        if (!driveMode.contains(mode)) {
            System.out.println("Mode not changed... Invalid mode requested.");
            return false;
        }
        if (!isEngineOn) {
            System.out.println("Mode not changed... Engine has not started.");
            return false;
        }
        if (currentSpeed == 0) {
            currentMode = mode.toString();
            System.out.println("Mode changed to " + mode + ".");
            return true;
        } else {
            System.out.println("Mode not changed... Car is in motion.");
            return false;
        }
    }

    @Override
    public boolean changeSpeed(int targetSpeed) {
        System.out.println("Changing speed...");
        if (!isEngineOn) {
            System.out.println("Speed not changed... Engine has not started");
            return false;
        }
        if (currentMode != "D" && currentMode != "R") {
            System.out.println("Speed not changed... Car mode is not in Drive or Reverse");
            return false;
        }
        if (targetSpeed >= 0) {
            currentSpeed = targetSpeed;
            System.out.println("Speed changed to " + targetSpeed + ".");
            return true;
        } else {
            System.out.println("Speed not changed... Invalid target speed requested");
            return false;
        }
    }

    @Override
    public boolean stopEngine() {
        System.out.println("Stopping engine...");
        if (currentSpeed == 0) {
            if (isEngineOn == true) {
                isEngineOn = false;
                System.out.println("Engine stopped.");
                return true;
            } else {
                System.out.println("Request ignored... Engine is already stopped.");
                return false;
            }
        } else {
            System.out.println("Engine not stopped... Car is in motion.");
            return false;
        }
    }

    public boolean addGasoline(int liters) {
        System.out.println("Adding gasoline into tank...");
        if (gasolineInTank == fullTank) {
            System.out.println("Gasoline not added into tank... tank is full.");
            return false;
        } else {
            int gasAdded = liters;
            int capacity = fullTank - gasolineInTank;
            if (liters > capacity) {
                gasAdded = liters - capacity;
            }
            gasolineInTank = gasolineInTank + gasAdded;
            System.out.println("Added " + gasAdded + " liters of gasoline into tank.");
        }
        return true;
    }
}
