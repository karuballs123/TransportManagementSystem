public class Driver extends Person {
    private String licenseNumber;
    private Vehicle assignedVehicle;

    public Driver(String driverId, String name, String licenseNumber) {
        super(driverId, name);
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String getRoleDescription() {
        return "Driver";
    }

    public void assignVehicle(Vehicle vehicle) {
        this.assignedVehicle = vehicle;
        System.out.println(getName() + " assigned to vehicle " + vehicle.getPlateNumber());
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Vehicle getAssignedVehicle() {
        return assignedVehicle;
    }
}