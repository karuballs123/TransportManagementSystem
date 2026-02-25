public class Bus extends Vehicle {
    private double farePerKm;

    public Bus(String vehicleId, String plateNumber, int capacity, double farePerKm) {
        super(vehicleId, plateNumber, capacity); 
        this.farePerKm = farePerKm;              
    }

    @Override
    public double calculateFare(double distanceKm) {
        return farePerKm * distanceKm;
    }

    public double getFarePerKm() {
        return farePerKm;
    }

    public void setFarePerKm(double farePerKm) {
        if (farePerKm < 0) {
            throw new IllegalArgumentException("farePerKm cannot be negative");
        }
        this.farePerKm = farePerKm;
    }
}