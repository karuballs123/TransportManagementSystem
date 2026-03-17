public class Driver extends Person {
    private String licenseNumber;
    private Vehicle assignedVehicle;

    public Driver(String driverId, String name, String licenseNumber) {
        super(driverId, name);
        validateLicenseNumber(licenseNumber);
        this.licenseNumber = licenseNumber;
    }
    
    private void validateLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("License number cannot be null or empty");
        }
        // Basic license number format validation
        if (!licenseNumber.matches("^[A-Z0-9-]+$")) {
            throw new IllegalArgumentException("Invalid license number format");
        }
    }

    @Override
    public String getRoleDescription() {
        return "Driver";
    }

    public void assignVehicle(Vehicle vehicle) {
        try {
            if (vehicle == null) {
                throw new IllegalArgumentException("Cannot assign null vehicle");
            }
            this.assignedVehicle = vehicle;
            System.out.println(getName() + " assigned to vehicle " + vehicle.getPlateNumber());
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to assign vehicle: " + e.getMessage());
            throw e;
        }
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        validateLicenseNumber(licenseNumber);
        this.licenseNumber = licenseNumber;
    }

    public Vehicle getAssignedVehicle() {
        return assignedVehicle;
    }
}
