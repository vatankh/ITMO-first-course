package commands;

import Control.Storage;

public class remove_first {
    public static void remove(Storage storage){
        if (storage.getVehiclesArray().length ==0){
            System.out.println("stack is already empty");
        }else {
            storage.removeAtIndex(0);
        }
    }
}
