package commands;

import Control.Work;


import java.io.*;

public class Execute_script {
    public  void execute(String filename) throws Exception {
        try {
            File file=new File(filename);
            if (!file.exists()){
                System.out.println("file does not exist");
            }else {
                if (!file.canRead()){
                    System.out.println("no permission for reading");
                }else {
                    InputStream in = new FileInputStream(file);
                    Work.workWithFile(in);
                }
            }

        } catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
            System.out.println("file not found ");
        } catch (NullPointerException nullPointerException){
            nullPointerException.printStackTrace();

        }
    }
}
