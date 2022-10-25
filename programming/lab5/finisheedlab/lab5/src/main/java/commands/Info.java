package commands;

import Control.Storage;

public class Info {
    public static void info(Storage storage){
        System.out.println("type="+storage.getVehicles().getClass().getName());
        System.out.println("date="+storage.date);
        System.out.println("number Of Elements="+storage.getVehiclesArray().length);
    }
}
