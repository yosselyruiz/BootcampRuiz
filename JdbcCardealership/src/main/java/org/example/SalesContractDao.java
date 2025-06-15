package org.example;

import java.time.LocalDate;
import java.util.Date;

public class SalesContractDao {
    private LocalDate date;
    private String name;
    private int id;
    private int vin;

    public SalesContractDao(){

    }

    public SalesContractDao(LocalDate date, String name, int id, int vin) {
        this.date = date;
        this.name = name;
        this.id = id;
        this.vin = vin;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "SalesContractDao{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", vin=" + vin +
                '}';
    }
}
