package interfaces;

public class Interfaces {

    public static void main(String[] args) {

        AudiCar car1 = new AudiCar("A4", "White", 4);


        /* Scenario: Normal path
         */

        if (car1.addGasoline(30)) {
            if (car1.startEngine()) {
                if (car1.changeMode("D")) {
                    if (car1.changeSpeed(60)) {
                        car1.changeSpeed(0);
                    }
                }
                car1.stopEngine();
            }
        }


        /* Scenario: No gas

        //if (car1.addGasoline(30)) {
            if (car1.startEngine()) {
                if (car1.changeMode("D")) {
                    if (car1.changeSpeed(60)) {
                        car1.changeSpeed(0);
                    }
                }
                car1.stopEngine();
            }
        //}

         */


        /* Scenario: Not in D(rive) or R(everse) mode

         */

        if (car1.addGasoline(30)) {
            if (car1.startEngine()) {
                //if (car1.changeMode("D")) {
                    if (car1.changeSpeed(60)) {
                        car1.changeSpeed(0);
                    }
                //}
                car1.stopEngine();
            }
        }



    }


}
