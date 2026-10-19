public class Train {
    // Ragged array reflecting 23 rows, each with 4 seats
    private static Seat[][] seats = new Seat[23][4];

    // Static block to initialize all seats in the train
    static {
        int currentSeatNumber = 1;
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 4; j++) {
                seats[i][j] = new Seat(currentSeatNumber++);
            }
        }
    }

    // Method to reserve a seat
    public boolean reserveSeat(int seatNumber, String passengerName) {
        if (!Seat.isValid(seatNumber) || passengerName == null) {
            return false;
        }

        int row = Seat.getRow(seatNumber) - 1;
        int col = Seat.getColumn(seatNumber) - 1;

        if (seats[row][col].isEmpty()) {
            seats[row][col].setPassengerName(passengerName);
            return true; // Reservation successful
        }

        return false; // Seat is already taken
    }

    // Method to delete a reserved seat
    public boolean deleteReservedSeat(int seatNumber) {
        if (!Seat.isValid(seatNumber)) {
            return false;
        }

        int row = Seat.getRow(seatNumber) - 1;
        int col = Seat.getColumn(seatNumber) - 1;

        if (!seats[row][col].isEmpty()) {
            seats[row][col].setPassengerName(null);
            return true; // Cancellation successful
        }

        return false; // Seat was already empty
    }

    // Method to delete all reserved seats
    public void deleteAllReservedSeats() {
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 4; j++) {
                seats[i][j].setPassengerName(null);
            }
        }
    }
}
