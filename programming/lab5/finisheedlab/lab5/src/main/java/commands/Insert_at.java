package commands;

import Control.Storage;
import collection.Vehicle;
import handlers.InputHandler;
import utils.Parser;

public class Insert_at {
    public static void insert(Storage storage,String index){
        String text=Parser.ParseInt(index);
        if (text.equals("")){
            int intIndex=Integer.parseInt(index);
            Vehicle[] vehicles = storage.getVehiclesArray();
            if (intIndex > vehicles.length){
                System.out.println("index is bigget than stack choose a smaller index");
            }else if (intIndex == vehicles.length){
                Add.add(storage);
            }else if (intIndex < vehicles.length){
                Vehicle vehicle = InputHandler.handleVechile();
                storage.insert_at_index(intIndex,vehicle);
            }
        }else System.out.println(text);
    }
}
