package com.example.fueling_project.station;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StationConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StationRepository stationRepository) {
        return args -> {

            Station station_one = new Station("Shell", "Turnhoutsebaan 366", 1.95,2140);

            Station station_two = new Station("Maes", "Antwerpsesteenweg 60", 1.68,2070);

            stationRepository.saveAll(List.of(station_one, station_two));
        };


    }
}
