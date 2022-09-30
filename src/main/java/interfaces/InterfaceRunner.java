package interfaces;

public class InterfaceRunner {

    public static void main(String[] args) {

        /*
        Consider using interfaces if any of these statements apply:
        - You expect that unrelated classes would implement your interface.
        - You want to specify the behavior of a particular data type,
            but not concerned about who implements its behavior.
        - You want to take advantage of multiple inheritance of type.
         */

        /*
        Car class and Train class are unrelated, but both implement the Drivable interface.
        Car class and Train class may need to implement multiple inheritance of type,
            i.e. Repairable interface, and other interfaces.
         */


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

        /* Output:
        Car{type='SEDAN', model='Audi A4', color='white', speed=0}
        Start engine of car
        Open sunroof of car
        Change speed of car to 60
        Change speed of car to 0
        Close sunroof of car
        Stop engine of car
         */


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

        /* Output:
        Train{type='DIESEL_ENGINE', model='GE Dash 8-40CM', trackGauge='1435', railway='CN Railway', speed=0}
        Start engine of train
        Change speed of train to 10
        Change speed of train to 0
        Connect caboose to train
        Add bogie to train
        Change speed of train to 40
        Change speed of train to 0
        Add bogie to train
        Add bogie to train
        Add bogie to train
        Change speed of train to 100
        Change speed of train to 0
        Stop engine of train
         */

    }
}
