package commands;

import Control.Storage;
import utils.Parser;

public class Filter_by_engine_power {
    public static void filter(Storage storage, String power){
        String messege = Parser.ParseDouble(power);
        if (messege.isEmpty()){
            storage.filter_by_engine_power(Double.parseDouble(power));
        }else {
            System.out.println(messege);
        }

    }
}
