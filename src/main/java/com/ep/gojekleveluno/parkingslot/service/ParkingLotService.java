package com.ep.gojekleveluno.parkingslot.service;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface ParkingLotService {

    void createParkingLot(int size) throws Exception;

    void allocateSlot(String registrationNumber, String carColor) throws Exception;

    void deallocateSlot(int index) throws Exception;

    void getStatus() throws Exception;

    void getRegistrationNumbersByColor(String carColor) throws Exception;

    void getSlotNumbersByColor(String carColor) throws Exception;

    void getSlotNumberByRegistrationNumber(String registrationNumber) throws Exception;
}
