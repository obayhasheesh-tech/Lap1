public class Seat {
    private int seatNumber;
    private String passengerName;

    // Constructor
    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.passengerName = null;
    }

    // Getters and Setters
    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    // Check if the seat is empty (if passengerName is null)
    public boolean isEmpty() {
        return this.passengerName == null;
    }

    // Static method: Check if seat number is valid (1 to 92)
    public static boolean isValid(int seatNumber) {
        return seatNumber >= 1 && seatNumber <= 92;
    }

    // Static method: Get row number (1 to 23)
    public static int getRow(int seatNumber) {
        if (!isValid(seatNumber)) {
            return -1; // Invalid seat
        }
        return (seatNumber - 1) / 4 + 1;
    }

    // Static method: Get column number (1 to 4)
    public static int getColumn(int seatNumber) {
        if (!isValid(seatNumber)) {
            return -1; // Invalid seat
        }
        return (seatNumber - 1) % 4 + 1;
    }

    // toString method
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Seat " + seatNumber + " [Empty]";
        }
        return "Seat " + seatNumber + " [Passenger: " + passengerName + "]";
    }
}
