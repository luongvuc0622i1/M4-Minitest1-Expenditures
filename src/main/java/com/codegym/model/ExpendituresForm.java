package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ExpendituresForm {
    private Long expenditures_id;
    private String expenditures_name;
    private int expenditures_money;
    private String expenditures_description;
    private List<Expenditure> listExpenditure;
    private MultipartFile expenditures_image;

    public ExpendituresForm() {
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

    public MultipartFile getExpenditures_image() {
        return expenditures_image;
    }

    public void setExpenditures_image(MultipartFile expenditures_image) {
        this.expenditures_image = expenditures_image;
    }
}
