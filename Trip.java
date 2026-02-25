public class Trip implements Trackable {
    private Vehicle vehicle;
    private Driver driver;
    private Passenger passenger;
    private double distanceKm;
    private String status;

    public Trip(Vehicle vehicle, Driver driver, Passenger passenger, double distanceKm) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.passenger = passenger;
        this.distanceKm = distanceKm;
        this.status = "CREATED";
    }

    public void startTrip() {
        status = "STARTED";
        System.out.println("Trip started...");
        System.out.println("Driver: " + driver.getName() + " (" + driver.getRoleDescription() + ")");
        System.out.println("Passenger: " + passenger.getName() + " (" + passenger.getRoleDescription() + ")");

        vehicle.displayVehicleInfo();

        double fare = vehicle.calculateFare(distanceKm); 
        System.out.printf("Distance: %.2f km%n", distanceKm);
        System.out.printf("Fare: KES %.2f%n", fare);

        passenger.makePayment(fare);

        status = "COMPLETED";
        System.out.println("Trip completed.");
    }

    @Override
    public String getStatus() {
        return status;
    }

    
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("distanceKm must be > 0");
        }
        this.distanceKm = distanceKm;
    }
}