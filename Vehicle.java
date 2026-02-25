public abstract class Vehicle {
    private static int totalVehicles = 0; 

    private final String vehicleId;
    private String plateNumber;
    private int capacity;

    public Vehicle(String vehicleId, String plateNumber, int capacity) {
        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.capacity = capacity;
        totalVehicles++;
    }

   
    public abstract double calculateFare(double distanceKm);

    public void displayVehicleInfo() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Plate Number: " + plateNumber);
        System.out.println("Capacity: " + capacity);
    }

    public static int getTotalVehicles() {
        return totalVehicles;
    }

   
    public String getVehicleId() {
        return vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        this.capacity = capacity;
    }
}