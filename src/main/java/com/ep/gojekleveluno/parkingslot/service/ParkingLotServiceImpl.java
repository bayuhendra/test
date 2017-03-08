package com.ep.gojekleveluno.parkingslot.service;

import com.ep.gojekleveluno.parkingslot.ParkingSlot;
import com.ep.gojekleveluno.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class ParkingLotServiceImpl implements ParkingLotService {

    private ParkingSlot[] parkingSlots = new ParkingSlot[0];

    @Override
    public void createParkingLot(int size) throws Exception {
        parkingSlots = new ParkingSlot[size];
        System.out.println("Created a parking lot with " + parkingSlots.length + " slots");
    }

    @Override
    public void allocateSlot(String registrationNumber, String carColor) throws Exception {
        boolean isAllocatedToSlot = false;
        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i] == null) {
                parkingSlots[i] = new ParkingSlot(registrationNumber, carColor);
                isAllocatedToSlot = true;
                System.out.println("Allocated slot number: " + (i + 1));
                break;
            }
        }

        if (!isAllocatedToSlot) {
            System.out.println("Sorry, parking lot is full");
        }
    }

    @Override
    public void deallocateSlot(int slotNumber) throws Exception {
        int index = slotNumber - 1;
        if (index >= parkingSlots.length) {
            System.out.println("Slot number " + slotNumber + " does not exist");
        } else if (parkingSlots[index] != null) {
            parkingSlots[index] = null;
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot number " + slotNumber + " is already empty");
        }
    }

    @Override
    public void getStatus() throws Exception {
        /* header */
        printPaddedValue("No.", "Registration Slot No.", "Colour");

        /* body */
        for (int i = 0; i < parkingSlots.length; i++) {
            ParkingSlot parkingSlot = parkingSlots[i];
            int slotNumber = i + 1;
            if (parkingSlot != null) {
                printPaddedValue(
                        String.valueOf(slotNumber),
                        parkingSlot.getRegistrationNumber(),
                        parkingSlot.getCarColor());
            }
        }
    }

    @Override
    public void getRegistrationNumbersByColor(String carColor) throws Exception {
        List<String> registrationNumbers = new ArrayList<>();
        for (ParkingSlot parkingSlot : parkingSlots) {
            if (parkingSlot.hasCarColor(carColor)) {
                registrationNumbers.add(parkingSlot.getRegistrationNumber());
            }
        }

        if (registrationNumbers.isEmpty()) {
            System.out.println("Not found.");
        } else {
            System.out.println(StringUtil.implode(registrationNumbers));
        }
    }

    @Override
    public void getSlotNumbersByColor(String carColor) throws Exception {
        List<String> slotNumbers = new ArrayList<>();
        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i].hasCarColor(carColor)) {
                slotNumbers.add(String.valueOf(i + 1));
            }
        }

        if (slotNumbers.isEmpty()) {
            System.out.println("Not found.");
        } else {
            System.out.println(StringUtil.implode(slotNumbers));
        }
    }

    @Override
    public void getSlotNumberByRegistrationNumber(String registrationNumber) throws Exception {
        int slotNumber = 0;
        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i].hasRegistrationNumber(registrationNumber)) {
                slotNumber = i + 1;
            }
        }

        if (slotNumber > 0) {
            System.out.println(slotNumber);
        } else {
            System.out.println("Not found.");
        }
    }

    private void printPaddedValue(String string0, String string1, String string2) {
        System.out.println(String.format("%-3s %-21s %s", string0, string1, string2));
    }

}
