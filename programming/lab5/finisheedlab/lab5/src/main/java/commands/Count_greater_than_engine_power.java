package commands;

import Control.Storage;
import utils.Parser;

public class Count_greater_than_engine_power {
    public static void count(Storage storage,String enginepower){
        String messege= Parser.ParseDouble(enginepower);
        if (messege.equals("")){
            int count = storage.count_greater_than_engine_power(Double.parseDouble(enginepower));
            System.out.println("the number of vechiles that have greater power is "+ count);
        }else {
            System.out.println(messege);
        }
    }
}
