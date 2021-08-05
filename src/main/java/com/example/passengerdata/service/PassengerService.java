package com.example.passengerdata.service;

import com.example.passengerdata.model.Passenger;

import java.util.List;

public interface PassengerService {

    Passenger savePassenger(Passenger passenger);

    List<Passenger> getAllPassengers();

    Passenger getPassengerById(long id);

    Passenger updatePassenger(Passenger passenger, long id);

    void deletePassenger(long id);

    void deleteAllPassengers();

}
