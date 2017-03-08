package com.ep.gojekleveluno.parkingslot;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class ParkingSlot {

    private String registrationNumber;
    private String carColor;

    public ParkingSlot() {
    }

    public ParkingSlot(String registrationNumber, String carColor) {
        this.registrationNumber = registrationNumber;
        this.carColor = carColor;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getCarColor() {
        return carColor;
    }

    public boolean hasCarColor(String carColor) {
        return this.carColor.equalsIgnoreCase(carColor);
    }

    public boolean hasRegistrationNumber(String registrationNumber) {
        return this.registrationNumber.equalsIgnoreCase(registrationNumber);
    }
}
