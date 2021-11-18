package com.example.fueling_project.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void updateStation(Long stationId, String name, String adress) {
        Station station = stationRepository.findById(stationId).orElseThrow(() -> new IllegalStateException("Station with id" + stationId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(station.getName(), name)) {
            station.setName(name);
        }
        if (adress != null && adress.length() > 0 && !Objects.equals(station.getAdress(), adress)) {
            Optional<Station> stationOptional = stationRepository.findStationByAdress(adress);
            throw new IllegalStateException("This adress allready exists");
        }
        station.setAdress(adress);
    }

//       @Transactional
//    public void updateStudent(Long studentId, String name, String email) {
//        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));
//
//        if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
//            student.setName(name);
//        }
//        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
//            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
//            if(studentOptional.isPresent()){
//                throw new IllegalStateException("Email already in use");
//            }
//            student.setEmail(email);
//        }


}
