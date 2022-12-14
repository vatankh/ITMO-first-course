package handlers;

import collection.Coordinates;
import collection.FuelType;
import collection.Vehicle;
import collection.VehicleType;
import Control.Work;
import utils.Parser;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public  class InputHandler {
    static   Scanner scanner=Work.scanner;
    public static Vehicle handleVechile(){
        scanner=Work.scanner;
        String name=handleName();
        long x=handleLong("Enter Coordinate.X");
        int  y=handleInteger("Enter Coordinate.Y");
        Coordinates coordinates= new Coordinates(x,y);
        Date date =new Date(System.currentTimeMillis());
        double enginePower =handleDouble("enter Engine Power");
        VehicleType vehicleType=handleVehicleType();
        FuelType fuelType=handleFuelType();

        return new Vehicle(name,coordinates,date,enginePower,vehicleType,fuelType);

    }
    public static long handleLong(String text){
        while (true) {
            System.out.println(text);
            if (scanner.hasNextLine()) {
                String value = scanner.nextLine();
                String messege = Parser.parsLong(value);
                if (messege.isEmpty()) {
                    return Long.parseLong(value);
                }
                System.out.println(messege);
            }
        }

    }
    public static int handleInteger(String text){
        while (true) {
            System.out.println(text);
            if (scanner.hasNextLine()) {
                String value = scanner.nextLine();
                String messege = Parser.ParseInt(value);
                if (messege.isEmpty()) {
                    return Integer.parseInt(value);
                }
                System.out.println(messege);
            }
        }
    }
    public static String  handleName(){
        String name="";
        while (true){
            System.out.println("enter name:");
            name = scanner.nextLine();
             if (name.isEmpty() || name.trim().isEmpty()){
                 System.out.println("name can not be empty");
             }else {
                 if (name.contains(",")){
                     System.out.println("name can not contain ,");
                 }else {
                     return name;
                 }
            }

        }
    }
    static Double handleDouble(String text){
        while (true) {
            System.out.println(text);
            if (scanner.hasNextLine()) {
                String value = scanner.nextLine();
                String messege = Parser.ParseDouble(value);
                if (messege.isEmpty()) {
                    return Double.parseDouble(value);
                }
                System.out.println(messege);
            }
        }
    }
    static VehicleType handleVehicleType(){
        System.out.println("choose VechileType number");
        while (true) {
            VehicleType[] arr = VehicleType.values();
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i] +"["+(i+1)+"]-");
            }
            System.out.println();
            if (scanner.hasNextLine()) {
                String value = scanner.nextLine();
                String messege=Parser.ParseInt(value);
                if (messege.isEmpty()){
                    int num = Integer.parseInt(value);
                    if (num >4 || num <1){
                        System.out.println("enter number between 1-4");
                    }
                    switch (num){
                        case 1:
                            return  VehicleType.PLANE;
                        case 2:
                            return  VehicleType.SHIP;
                        case 3:
                            return VehicleType.MOTORCYCLE;
                        case 4:
                            return VehicleType.HOVERBOARD;
                    }
                }else {
                    System.out.println(messege);
                }
            }
        }
    }
    static FuelType handleFuelType(){
        System.out.println("choose fuelType number");
        while (true) {
            FuelType[] arr = FuelType.values();
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i] +"["+(i+1)+"]-");
            }
            System.out.println();
            if (scanner.hasNextLine()) {
                String value = scanner.nextLine();
                String messege=Parser.ParseInt(value);
                if (messege.isEmpty()){
                    int num = Integer.parseInt(value);
                    if (num >4 || num <1){
                        System.out.println("enter number between 1-4");
                    }
                    switch (num){
                        case 1:
                            return  FuelType.GASOLINE;
                        case 2:
                            return  FuelType.MANPOWER;
                        case 3:
                            return FuelType.NUCLEAR;
                        case 4:
                            return FuelType.PLASMA;
                    }
                }else {
                    System.out.println(messege);
                }
            }
        }
    }
}
