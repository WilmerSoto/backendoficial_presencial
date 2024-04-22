package co.udea.airline.api.service;

import co.udea.airline.api.model.jpa.model.Passenger;
import co.udea.airline.api.model.jpa.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerService {
    PassengerRepository passengerRepository;

    public List<Passenger> getPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassenger(Long id) {
        return passengerRepository.findById(id);
    }

    public void saveOrUpdate(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public void delete(Long id){
        passengerRepository.deleteById(id);
    }
}
