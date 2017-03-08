package com.ep.gojekleveluno.parkingslot;

import com.ep.gojekleveluno.parkingslot.service.ParkingLotService;
import com.ep.gojekleveluno.parkingslot.service.ParkingLotServiceImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class ParkingSlotMain {

    private static final ParkingLotService parkingLotService = new ParkingLotServiceImpl();

    public static void main(String[] args) throws Exception {
        String line;
        if (args.length > 0) {
            String filename = args[0];
            System.out.println("Processing: " + filename);

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null) {
                processCommand(line);
            }

            br.close();
            fr.close();
        } else {
            System.out.println("Interactive Command: ");
            Scanner stdin = new Scanner(System.in);
            while (stdin.hasNextLine()) {
                line = stdin.nextLine();
                processCommand(line);
            }
        }
    }

    private static void processCommand(String line) throws Exception {
        String[] tokens = line.split(" ");
        String command = tokens[0];
        String carColor;
        String registrationNumber;
        switch (command) {
            case "create_parking_lot":
                int size = Integer.parseInt(tokens[1]);
                parkingLotService.createParkingLot(size);
                break;
            case "park":
                registrationNumber = tokens[1];
                carColor = tokens[2];
                parkingLotService.allocateSlot(registrationNumber, carColor);
                break;
            case "leave":
                int index = Integer.parseInt(tokens[1]);
                parkingLotService.deallocateSlot(index);
                break;
            case "status":
                parkingLotService.getStatus();
                break;
            case "registration_numbers_for_cars_with_colour":
                carColor = tokens[1];
                parkingLotService.getRegistrationNumbersByColor(carColor);
                break;
            case "slot_numbers_for_cars_with_colour":
                carColor = tokens[1];
                parkingLotService.getSlotNumbersByColor(carColor);
                break;
            case "slot_number_for_registration_number":
                registrationNumber = tokens[1];
                parkingLotService.getSlotNumberByRegistrationNumber(registrationNumber);
                break;
            default:
                System.out.println("Unrecognized command.");
                break;
        }
    }

}
