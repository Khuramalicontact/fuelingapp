package com.example.fueling_project.station;

import javax.persistence.*;

@Entity
@Table
public class Station {

    @Id
    @SequenceGenerator(
            name = "station_sequence",
            sequenceName = "station_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "station_sequence"
    )

    private Long id;
    private String name;
    private String adress;
    private double price;
    private int zip;

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public Station() {
    }

    public Station(String name, String adress, double price, int zip) {
        this.name = name;
        this.adress = adress;
        this.price = price;
        this.zip = zip;
    }

    public Station(Long id, String name, String adress, double price, int zip) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.price = price;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", price=" + price +
                ", zip=" + zip +
                '}';
    }
}
