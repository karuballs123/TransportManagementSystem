public class Passenger extends Person implements Payable {

    public Passenger(String passengerId, String name) {
        super(passengerId, name);
    }

    @Override
    public String getRoleDescription() {
        return "Passenger";
    }

    @Override
    public void makePayment(double amount) {
        System.out.printf("%s paid KES %.2f%n", getName(), amount);
    }
}