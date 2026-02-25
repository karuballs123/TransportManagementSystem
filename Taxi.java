public class Taxi extends Vehicle {
    private double baseFare;
    private double ratePerKm;

    public Taxi(String vehicleId, String plateNumber, int capacity, double baseFare, double ratePerKm) {
        super(vehicleId, plateNumber, capacity);
        this.baseFare = baseFare;
        this.ratePerKm = ratePerKm;
    }

    @Override
    public double calculateFare(double distanceKm) {
        return baseFare + (ratePerKm * distanceKm);
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        if (baseFare < 0) {
            throw new IllegalArgumentException("baseFare cannot be negative");
        }
        this.baseFare = baseFare;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm < 0) {
            throw new IllegalArgumentException("ratePerKm cannot be negative");
        }
        this.ratePerKm = ratePerKm;
    }
}