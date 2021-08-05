package com.example.passengerdata.service.implementation;

import com.example.passengerdata.exception.ResourceNotFoundException;
import com.example.passengerdata.model.Passenger;
import com.example.passengerdata.repository.PassengerRepository;
import com.example.passengerdata.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImplementation implements PassengerService {

    private PassengerRepository passengerRepository;


    public PassengerServiceImplementation(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getPassengerById(long id) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        if (passenger.isPresent()) {
            return passenger.get();
        } else {
            throw new ResourceNotFoundException("passenger", "id", id);
        }
    }

    @Override
    public Passenger updatePassenger(Passenger passenger, long id) {
        Passenger existingPassenger = passengerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Passenger", "Id", id));
        existingPassenger.setFirstName(passenger.getFirstName());
        existingPassenger.setLastName(passenger.getLastName());
        existingPassenger.setPassportID(passenger.getPassportID());
        existingPassenger.setEmail(passenger.getEmail());
        passengerRepository.save(existingPassenger);

        return existingPassenger;

    }

    @Override
    public void deletePassenger(long id) {
        passengerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Passenger", "Id", id));
        passengerRepository.deleteById(id);
    }

    @Override
    public void deleteAllPassengers() {
        passengerRepository.findAll();
        passengerRepository.deleteAll();
    }
}
