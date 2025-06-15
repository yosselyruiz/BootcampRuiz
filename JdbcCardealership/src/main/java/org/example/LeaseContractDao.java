package org.example;


import java.time.LocalDate;

public class LeaseContractDao {
    private LocalDate date ;
    private String name;
    private int id;
    private int vin;

    public LeaseContractDao (){

    }

    public LeaseContractDao(LocalDate date, String name, int id, int vin) {
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
        return "LeaseContractDao{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", vin=" + vin +
                '}';
    }
}
