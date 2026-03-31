public class Trip {
    private Driver driver;
    private Passenger passenger;
    private Vehicle vehicle;
    private String status;

    public Trip(Driver driver, Passenger passenger, Vehicle vehicle) {
        this.driver = driver;
        this.passenger = passenger;
        this.vehicle = vehicle;
        this.status = "Scheduled";
    }

    public void startTrip() {
        status = "In Progress";
    }

    public void completeTrip() {
        status = "Completed";
    }

    public String getStatus() {
        return status;
    }

    public String toFileString() {
        return driver.getId() + "," +
               passenger.getId() + "," +
               vehicle.getVehicleId() + "," +
               status;
    }

    public void displayTrip() {
        System.out.println("Driver: " + driver.getName());
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Vehicle: " + vehicle.getPlateNumber());
        System.out.println("Status: " + status);
    }
}
