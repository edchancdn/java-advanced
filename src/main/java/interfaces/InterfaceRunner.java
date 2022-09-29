package interfaces;

public class InterfaceRunner {

    public static void main(String[] args) {


        // Create an instance of the Car class
        Car audiA4 = new Car("SEDAN", "Audi A4", "white");
        System.out.println(audiA4);

        // method from the Drivable interface, implemented by the Car class
        audiA4.startEngine();

        // method from the Car class
        audiA4.operateSunroof(true);

        audiA4.changeSpeed(60);
        audiA4.changeSpeed(0);
        audiA4.operateSunroof(false);
        audiA4.stopEngine();

        System.out.println("");



        // Create an instance of the Train class
        Train cn2430 = new Train("DIESEL_ENGINE", "GE Dash 8-40CM", 1435, "CN Railway");
        System.out.println(cn2430);

        // method from the Drivable interface, implemented by the Train class
        cn2430.startEngine();

        cn2430.changeSpeed(10);
        cn2430.changeSpeed(0);

        // method from the Train class
        cn2430.connectCaboose();
        cn2430.addBogie();

        cn2430.changeSpeed(40);
        cn2430.changeSpeed(0);
        cn2430.addBogie();
        cn2430.addBogie();
        cn2430.addBogie();
        cn2430.changeSpeed(100);
        cn2430.changeSpeed(0);
        cn2430.stopEngine();

    }
}
