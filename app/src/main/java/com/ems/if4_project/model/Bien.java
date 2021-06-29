package com.ems.if4_project.model;

import java.io.Serializable;


public class Bien implements Serializable {
    private int id;
    private String descri;
    private String nom;
    private String dateBien;
    private String typeBien;
    public Bien(){

    }


    public Bien(int id, String descri, String nom, String dateBien, String typeBien) {
        this.id = id;
        this.descri = descri;
        this.nom = nom;
        this.dateBien = dateBien;
        this.typeBien = typeBien;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return descri;
    }

    public void setDescription(String descri) {
        this.descri = descri;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateBien() {
        return dateBien;
    }

    public void setDateBien(String dateBien) {
        this.dateBien = dateBien;
    }

    public String getTypeBien() {
        return typeBien;
    }

    public void setTypeBien(String typeBien) {
        this.typeBien = typeBien;
    }


    @Override
    public String toString() {
        return nom;
    }

    public String getDados() {
        return "ID: " + id + "\n" +
                "Description: " + descri + "\n" +
                "Nom: " + nom + "\n" +
                "DateBien: " + dateBien + "\n" +
                "TypeBien: " + typeBien;
    }
}