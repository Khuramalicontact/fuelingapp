package com.example.fueling_project.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StationService {

    private final StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public void addNewStation(Station station) {
        Optional<Station> stationOptional = stationRepository.findStationByAdress(station.getAdress());

        if (stationOptional.isPresent()) throw new IllegalStateException("This adress is already in our list");

        stationRepository.save(station);
    }


    public void deleteStation(Long stationId) {
        stationRepository.findById(stationId);
        boolean exists = stationRepository.existsById(stationId);
        if (!exists) {
            throw new IllegalStateException("The station with ID: " + stationId + "does not exist");
        }
        stationRepository.deleteById(stationId);
    }


    @Transactional
    public void updateStation(Long stationId, String name, String adress, double price) {
        Station station = stationRepository.findById(stationId).orElseThrow(() -> new IllegalStateException("Station with id" + stationId + " does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(station.getName(),name)){
            station.setName(name);
        }if(adress != null){
            Optional<Station> stationOptional = stationRepository.findStationByAdress(adress);
            if(stationOptional.isPresent()){
                throw new IllegalStateException("Adress already exists");
            }
            station.setAdress(adress);
        }if(price != 0){
            station.setPrice(price);
        }

    }
}