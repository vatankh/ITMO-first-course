package handlers;

import Control.Storage;
import commands.*;

import java.io.File;

public class CommandHandler {
    File file;
    Storage storage;
    public CommandHandler(File file , Storage storage){
        this.file=file;
        this.storage=storage;
    }
    public  boolean handle(String command) throws Exception {
        int len =command.split(" ").length;
        if (len==1) {
            switch (command.trim()) {
                case "clear":
                    Clear.clear(storage);
                    break;
                case "add":
                    Add.add(storage);
                    break;
                case "show":
                    Show.show(storage);
                    break;
                case "remove_first":
                    remove_first.remove(storage);
                    break;
                case "save":
                    Save.save(storage,file);
                    break;
                case "help":
                    Help.help();
                    break;
                case "info":
                    Info.info(storage);
                    break;
                case "remove_greater":
                    Remove_greater.remove(storage);
                    break;
                case "exit":
                    return false;
            }
        }else if (len ==2){
            String[] splited=command.split(" ");
            String theCommand =splited[0];
            String theValue =splited[1];
            switch (theCommand) {
                case "update":
                    Update.update(storage,theValue);
                    break;
                case "remove_by_id":
                    Remove_by_id.remove(storage,theValue);
                    break;
                case "insert_at":
                    Insert_at.insert(storage,theValue);
                    break;
                case "count_greater_than_engine_power":
                    Count_greater_than_engine_power.count(storage,theValue);
                    break;
                case "filter_greater_than_engine_power":
                    Filter_greater_than_engine_power.filter(storage,theValue);
                    break;
                case "filter_by_engine_power":
                    Filter_by_engine_power.filter(storage,theValue);
                    break;
                case "execute_script":
                    Execute_script execute_script =new Execute_script();
                    execute_script.execute(theValue);
            }
        }
        return true;
    }
}
