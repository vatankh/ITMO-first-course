package commands;

import Control.Storage;
import collection.Vehicle;
import handlers.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class Remove_greater {
    public static void remove(Storage storage){
        Vehicle vehicle = InputHandler.handleVechile();
        Vehicle[] vehiclesArray= storage.getVehiclesArray();
        List<Integer> integerList=new ArrayList<>();
        for (int i=0;i< vehiclesArray.length;i++){
            if (vehicle.getEnginePower() < vehiclesArray[i].getEnginePower()){
                integerList.add(i);
            }
        }
        for (int i=0;i<integerList.size();i++){
            storage.removeAtIndex(integerList.get(i)-i);
        }
    }
}
