package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "expenditure")
public class Expenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expenditure_id;
    private String expenditure_name;
    private int expenditure_money;
    @ManyToOne
    @JoinColumn(name = "expenditures_id")
    private Expenditures expenditures;

    public Expenditure() {
    }

    public Long getExpenditure_id() {
        return expenditure_id;
    }

    public void setExpenditure_id(Long expenditure_id) {
        this.expenditure_id = expenditure_id;
    }

    public String getExpenditure_name() {
        return expenditure_name;
    }

    public void setExpenditure_name(String expenditure_name) {
        this.expenditure_name = expenditure_name;
    }

    public int getExpenditure_money() {
        return expenditure_money;
    }

    public void setExpenditure_money(int expenditure_money) {
        this.expenditure_money = expenditure_money;
    }

    public Expenditures getExpenditures() {
        return expenditures;
    }

    public void setExpenditures(Expenditures expenditures) {
        this.expenditures = expenditures;
    }
}
