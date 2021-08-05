package com.example.passengerdata.controller;

import com.example.passengerdata.model.Passenger;
import com.example.passengerdata.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    //Create passenger RESTAPI

    @PostMapping
    public ResponseEntity<Passenger> savePassenger(@RequestBody Passenger passenger) {
        return new ResponseEntity<Passenger>(passengerService.savePassenger(passenger), HttpStatus.CREATED);
    }

    //Get all Passengers
    @GetMapping
    public List<Passenger> getAllPassengers() {

        return passengerService.getAllPassengers();
    }

    //Get passenger by ID
    @GetMapping("{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable("id") long id) {
        return new ResponseEntity<Passenger>(passengerService.getPassengerById(id), HttpStatus.OK);
    }

    //Update passenger
    @PutMapping({"{id}"})
    public ResponseEntity<Passenger> updatePassenger(@PathVariable("id") long id, @RequestBody Passenger passenger) {
        return new ResponseEntity<Passenger>(passengerService.updatePassenger(passenger, id), HttpStatus.OK);
    }

    //Delete one Passenger
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable("id") long id) {
        passengerService.deletePassenger(id);
        return new ResponseEntity<String>("Passenger is deleted !", HttpStatus.OK);
    }

    //Delete all passeners
    @DeleteMapping
    public ResponseEntity<String> deleteAllPassenger() {
        passengerService.deleteAllPassengers();
        return new ResponseEntity<String>("All Data was deleted", HttpStatus.OK);
    }

}
