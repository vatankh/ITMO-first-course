package Control;
import handlers.CommandHandler;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Work {
    public  static  Scanner scanner;
    static CommandHandler commandHandler;
    public Work(Storage storage,File file){
        commandHandler=new CommandHandler(file, storage);
    }
    public static void work() throws Exception {
        scanner=new Scanner(System.in);
        boolean work=true;
        while (work){
            if (scanner.hasNext()){
                String command =scanner.nextLine();
                work=commandHandler.handle(command);
            }
        }
    }
    public static void workWithFile(InputStream inputStream) throws Exception {
         scanner=new Scanner(inputStream);
        boolean work=true;
        while (work&& scanner.hasNext()){
                String command =scanner.nextLine();
                work=commandHandler.handle(command);
        }
        scanner=new Scanner(System.in);
        System.out.println("finished");
    }

}

