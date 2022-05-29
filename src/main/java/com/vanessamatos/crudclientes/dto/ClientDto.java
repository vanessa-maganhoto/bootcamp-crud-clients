package com.vanessamatos.crudclientes.dto;

import com.vanessamatos.crudclientes.model.Client;

import java.time.Instant;

public class ClientDto {

    private Long id;

    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private String children;

    public ClientDto(){}

    public ClientDto(Long id, String name, String cpf, Double income, Instant birthDate, String children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Client toEntity(){
        return new Client(this.id, this.name, this.cpf, this.income, this.birthDate, this.children);
    }

    public ClientDto(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }
}
