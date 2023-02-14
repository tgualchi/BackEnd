/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.tob.Dto;

import javax.validation.constraints.NotBlank;



public class dtoProyectos {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String img;

//Constructores

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String descripcionP, String img) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.img = img;
    }
    //Getters & Setters

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
    
}