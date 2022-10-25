package commands;

import Control.Storage;
import Control.VerifyIdInStorage;

public class Remove_by_id {
    public static void remove(Storage storage, String id){
        long[] index = VerifyIdInStorage.verify(storage,id);
        if (index[0] ==-1){
            System.out.println("there is no vehicle with this id");
        }else {
            storage.removeAtIndex((int) index[0]);
        }
    }
}
