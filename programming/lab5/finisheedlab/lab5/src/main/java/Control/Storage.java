package Control;

import collection.Vehicle;

import java.util.Arrays;
import java.util.Date;
import java.util.Stack;

public class Storage {
    private Stack<Vehicle> vehicles = new Stack<>();
    public Date date;
    public static long id=1;

    public Storage(Stack<Vehicle> vehicles){
        this.vehicles=vehicles;
        this.date=new Date(System.currentTimeMillis());
        if(!vehicles.isEmpty()){
            long maxID=1;
            for (Vehicle vehicle :
                    getVehicles()) {
                long srcId= vehicle.getId();
                if(srcId > maxID){
                    maxID=srcId;
                }
            }
            id=maxID;
        }
    }

    public Stack<Vehicle> getVehicles() {
        return vehicles;
    }
    public void add(Vehicle vehicle){
        id++;
        vehicle.setId(id);
        vehicles.push(vehicle);
    }
    public void updateId(Vehicle vehicle, int index){
        vehicles.setElementAt(vehicle,index);
        System.out.println("worked");

    }
    public void removeAtIndex(int index){
        vehicles.removeElementAt(index);
    }
    public Vehicle[] getVehiclesArray(){
        return vehicles.toArray(new Vehicle[0]);
    }
    public void insert_at_index(int index,Vehicle vehicle){
        id++;
        vehicle.setId(id);
        vehicles.insertElementAt(vehicle,index);
    }
    public  int count_greater_than_engine_power(Double power){
        Vehicle[] vehiclesArray=getVehiclesArray();
        int count=0;
        for (Vehicle vehicle :
                vehiclesArray) {
            if (vehicle.getEnginePower() >power){
                count++;
            }
        }
        return count;
    }

    public void filter_by_engine_power(Double power){
        Vehicle[] array = getVehiclesArray();
        for (Vehicle vehicle :
                array) {
            if (vehicle.getEnginePower().equals(power)) {
                System.out.println(vehicle.toString());
            }
            }
    }
    public void filter_greater_than_engine_power(Double power){
        Vehicle[] array = getVehiclesArray();
        for (Vehicle vehicle :
                array) {
            if (vehicle.getEnginePower() >power) {
                System.out.println(vehicle.toString());
            }
        }
    }
    public void setVehicles(Stack<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
