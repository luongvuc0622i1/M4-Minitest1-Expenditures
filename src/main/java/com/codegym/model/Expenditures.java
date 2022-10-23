package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "expenditures")
public class Expenditures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expenditures_id;
    private String expenditures_name;
    private int expenditures_money;
    private String expenditures_description;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Expenditure> listExpenditure;
    private String expenditures_image;

    public Expenditures() {
    }

    public Expenditures(Long expenditures_id, String expenditures_name, int expenditures_money, String expenditures_description, List<Expenditure> listExpenditure, String expenditures_image) {
        this.expenditures_id = expenditures_id;
        this.expenditures_name = expenditures_name;
        this.expenditures_money = expenditures_money;
        this.expenditures_description = expenditures_description;
        this.listExpenditure = listExpenditure;
        this.expenditures_image = expenditures_image;
    }

    public Long getExpenditures_id() {
        return expenditures_id;
    }

    public void setExpenditures_id(Long expenditures_id) {
        this.expenditures_id = expenditures_id;
    }

    public String getExpenditures_name() {
        return expenditures_name;
    }

    public void setExpenditures_name(String expenditures_name) {
        this.expenditures_name = expenditures_name;
    }

    public int getExpenditures_money() {
        return expenditures_money;
    }

    public void setExpenditures_money(int expenditures_money) {
        this.expenditures_money = expenditures_money;
    }

    public String getExpenditures_description() {
        return expenditures_description;
    }

    public void setExpenditures_description(String expenditures_description) {
        this.expenditures_description = expenditures_description;
    }

    public List<Expenditure> getListExpenditure() {
        return listExpenditure;
    }

    public void setListExpenditure(List<Expenditure> listExpenditure) {
        this.listExpenditure = listExpenditure;
    }

    public String getExpenditures_image() {
        return expenditures_image;
    }

    public void setExpenditures_image(String expenditures_image) {
        this.expenditures_image = expenditures_image;
    }
}
