package commands;

import Control.Storage;
import collection.Vehicle;
import handlers.InputHandler;

public class Add {
    public  static void add(Storage storage) {
        Vehicle vehicle= InputHandler.handleVechile();
        storage.add(vehicle);
        System.out.println("added");
    }
}
