package commands;

import Control.Storage;
import collection.Vehicle;
import utils.ConvertorFromVehicleToCvs;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Save {
    public static void save(Storage storage, File file) throws IOException {
        Vehicle[] vehicles = storage.getVehicles().toArray(new Vehicle[0]);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if (vehicles.length == 0) {
                bufferedWriter.write("");
            } else {
                for (Vehicle vehicle : vehicles) {
                    bufferedWriter.write(ConvertorFromVehicleToCvs.convert(vehicle));
                }
            }
            bufferedWriter.close();
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("access denied");
        }
    }
}
