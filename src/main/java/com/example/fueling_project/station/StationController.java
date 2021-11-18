package com.example.fueling_project.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/station")
public class StationController {
    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public List<Station> getStation() {
        return stationService.getAllStations();
    }

//    @GetMapping
//    public String welcomeToMyApp(){
//      return "welcome to my application";
//    }

    @PostMapping
    public void registerNewStation(@RequestBody Station station) {
        stationService.addNewStation(station);
    }

    @DeleteMapping(path = "{stationId}")
    public void deleteStudent(@PathVariable("stationId") Long stationId) {
        stationService.deleteStation(stationId);
    }

    @PutMapping(path = "{stationdId}")
    public void updateStudent(@PathVariable("stationId") Long stationId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String adress) {
        stationService.updateStation(stationId, name, adress);
    }

    //  @PutMapping(path = "{studentId}")
    //    public void updateStudent(@PathVariable("studentId") Long studentId,
    //                              @RequestParam(required = false) String name,
    //                              @RequestParam(required = false) String email){
    //                        studentService.updateStudent(studentId, name, email);
    //    }
}



