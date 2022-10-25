package commands;

import Control.Storage;
import Control.VerifyIdInStorage;
import collection.Vehicle;
import handlers.InputHandler;


public class Update {
    public static void update(Storage storage, String id){
        long[] index = VerifyIdInStorage.verify(storage,id);
            if (index[0] ==-1){
                System.out.println("there is no vehicle with this id");
            }else {
                Vehicle vehicle= InputHandler.handleVechile();
                vehicle.setId(index[1]);
                storage.updateId(vehicle, (int) index[0]);
            }

    }
}
