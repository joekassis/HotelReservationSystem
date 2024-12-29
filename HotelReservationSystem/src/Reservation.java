class Reservation {
    private String customerName;
    private int roomNumber;
    private int numberOfNights;
    private double totalCost;

    public Reservation(String customerName, int roomNumber, int numberOfNights, double totalCost) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.numberOfNights = numberOfNights;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Reservation Details:\n" +
               "Customer Name: " + customerName + "\n" +
               "Room Number: " + roomNumber + "\n" +
               "Nights: " + numberOfNights + "\n" +
               "Total Cost: $" + totalCost;
    }
}
