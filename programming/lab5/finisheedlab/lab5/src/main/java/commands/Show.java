package commands;

import Control.Storage;
import collection.Vehicle;

public class Show {
    public static void show(Storage storage){
        Vehicle[] array = storage.getVehicles().toArray(new Vehicle[0]);
        for (Vehicle vehicle :
                array) {
            System.out.println(vehicle.toString());
        }
    }
}
