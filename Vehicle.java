public class Vehicle {
    private String vehicleId;
    private String plateNumber;
    private int capacity;

    public Vehicle(String vehicleId, String plateNumber, int capacity) {
        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.capacity = capacity;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void displayVehicleInfo() {
        System.out.println("ID: " + vehicleId);
        System.out.println("Plate: " + plateNumber);
        System.out.println("Capacity: " + capacity);
    }
}
