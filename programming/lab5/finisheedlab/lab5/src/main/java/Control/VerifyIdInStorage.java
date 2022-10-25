package Control;

import Control.Storage;
import collection.Vehicle;
import handlers.InputHandler;
import utils.Parser;

import java.lang.reflect.Array;
import java.util.Arrays;

public class VerifyIdInStorage {
    public static long[] verify(Storage storage, String id){
        long longId;
        if (!Parser.parsLong(id).equals("")){
            longId= InputHandler.handleLong("type ID:");
        }else {
            longId=Long.parseLong(id);
        }
        Vehicle[] vehicles = storage.getVehiclesArray();
        int index=-1;
        for (int i=0;i< vehicles.length;i++){
            if (vehicles[i].getId() ==longId){
                index=i;
                break;
            }
        }
        return new long[]{index, longId};
    }
}
