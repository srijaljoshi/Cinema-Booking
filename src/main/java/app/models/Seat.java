package app.models;

public class Seat {
    private SeatShowtime sst;
    private Hall hall;
    private int id;
    private int hallId;
    private String location;
    private int seatNo;
    private boolean seatTaken;

    public Seat(int id, int hallId, String location, int seatNo, boolean seatTaken) {
        this.id = id;
        this.hallId = hallId;
        this.location = location;
        this.seatNo = seatNo;
        this.seatTaken = seatTaken;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void getSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public void setSeatTaken(boolean seatTaken) {
        this.seatTaken = seatTaken;
    }

    public boolean getSeatTaken() {
        return seatTaken;
    }

    public void SeatShowtime(SeatShowtime sst) {
        this.sst = sst;
    }

    public void Hall(Hall hall) {
        this.hall = hall;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
