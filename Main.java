public class Main {
    public static void main(String[] args) {
       
        Vehicle bus = new Bus("V001", "KDA 123A", 45, 30.0);
        Vehicle taxi = new Taxi("V002", "KBC 456B", 4, 150.0, 60.0);

       
        Driver driver = new Driver("D001", "Francis", "DL-778899");
        Passenger passenger = new Passenger("P001", "Jermaine");

        
        System.out.println("Driver role: " + driver.getRoleDescription());
        System.out.println("Passenger role: " + passenger.getRoleDescription());

        
        driver.assignVehicle(taxi);

        
        Trip trip1 = new Trip(taxi, driver, passenger, 12.5);
        System.out.println("Trip1 status: " + trip1.getStatus());
        trip1.startTrip();
        System.out.println("Trip1 status: " + trip1.getStatus());

        System.out.println("----------------------------------");

       
        driver.assignVehicle(bus);
        Trip trip2 = new Trip(bus, driver, passenger, 10.0);
        trip2.startTrip();

        System.out.println("----------------------------------");
        System.out.println("Total Vehicles Created: " + Vehicle.getTotalVehicles());
    }
}