package commands;

import Control.Storage;


import java.util.Stack;

public class Clear {
    public static void clear(Storage storage)  {
        storage.setVehicles(new Stack<>());
        System.out.println("cleared");
    }
}
