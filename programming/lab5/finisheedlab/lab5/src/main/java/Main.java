import Control.Storage;
import collection.Vehicle;
import Control.Work;
import handlers.InputHandler;
import utils.CvsReader;
import utils.Parser;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;
import java.util.logging.Handler;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName="mydata.csv";
        if (args.length >0){
            System.out.println(args[0]);
            fileName=args[0];
        }
        String path =getPath(fileName);
        File file =new File(path);
        Stack<Vehicle> stack = CvsReader.getInStack(readFile(file));
        Storage storage=new Storage(stack);
        Work work =new Work(storage,file);
        work.work();
    }
    public static   String  readFile(File file)
            throws IOException {
        InputStream is = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = is.read()) != -1; ) {
            sb.append((char) ch);
        }

        return sb.toString();
    }
    public  static String getPath(String file) throws URISyntaxException, IOException {
        String path;
        System.out.println("исползоват свой файл [1]");
        System.out.println("укажети путь к файл и мы сделаем файл [2]");
        Scanner scanner =new Scanner(System.in);
        String val =scanner.nextLine();
        while (val.length() != 1 || (val.charAt(0) != '1' && val.charAt(0) != '2')){
            System.out.println("please choose 1 or two");
            val=scanner.nextLine();
        }
        if (val.equals("1")){
         path =handleFile();
        }
        else {
            path =handleDir() +"/"+file;
            File file1=new File(path);
            if (!file1.exists()){
                file1.createNewFile();
            }
        }
        return path;
    }
    public static String handleFile( ) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("укажите путь к файл (с имя файл):");
        String path =scanner.nextLine();
        File file1 = new File(path);
        while (!file1.exists() || !file1.canRead() ||!file1.canWrite()) {
            while (!file1.exists()) {
                System.out.println("file does not exist");
                System.out.println("укажите путь к файл (с имя файл):");
                path = scanner.nextLine();
                file1 = new File(path);
            }
            while (!file1.canRead()) {
                System.out.println("no premisions for reading file please choose another file");
                System.out.println("укажите путь к файл (с имя файл):");
                path = scanner.nextLine();
                file1 = new File(path);
            }
            while (!file1.canWrite()) {
                System.out.println("no premisions for writing to file please choose another file");
                System.out.println("укажите путь к файл (с имя файл):");
                path = scanner.nextLine();
                file1 = new File(path);
            }
        }
            for (String line :
                    readFile(file1).split("\n")) {
                if (line.split(",").length != 8) {
                    System.out.println("file have data already . choose another file please" );
                    path=handleFile();
                }
                }

        return path;
    }
    public static String handleDir(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("укажети путь к каталог и мы сделаем файл:");
        String dir=scanner.nextLine();
        File dirFile = new File(dir);
        while (!dirFile.exists() || !dirFile.canExecute()|| !dirFile.canRead()) {
            while (!dirFile.exists()) {
                System.out.println("dirictory does not exist");
                System.out.println("укажети путь к каталог:");
                dir = scanner.nextLine();
                dirFile = new File(dir);
            }
            while (!dirFile.canExecute()) {
                System.out.println("no premisions for executing  choose another directory");
                System.out.println("укажети путь к каталог");
                dir = scanner.nextLine();
                dirFile = new File(dir);
            }
            while (!dirFile.canWrite()) {
                System.out.println("no premisions for writing to directory please choose another directory");
                System.out.println("укажети путь к каталог");
                dir = scanner.nextLine();
                dirFile = new File(dir);
            }
        }
        return dir;
    }
}