package interfaces;

public interface Car {
    public boolean startEngine();
    public boolean changeMode(String mode);
    public boolean changeSpeed(int targetSpeed);
    public boolean stopEngine();
}
