package org.launchcode.bills.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Records {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String month;

    @NotNull
    @Size(min=4, max=4)
    private int year;

    @ManyToMany
    private List<Bills> pastbills = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<Bills> getPastbills() {
        return pastbills;
    }

    public void addBills (Bills bill) {
        pastbills.add(bill);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Records(){}

    public Records(int id, String month, int year, List pastbills) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.pastbills = pastbills;}
}
