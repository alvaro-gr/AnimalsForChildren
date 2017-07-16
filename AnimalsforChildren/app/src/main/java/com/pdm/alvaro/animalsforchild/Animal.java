package com.pdm.alvaro.animalsforchild;

/**
 * Created by alvaro on 27/04/17.
 */

public class Animal {

    private String nombre;
    private int animal_id;
    private int imagen;
    private String tipo;
    private String clasifcación;

    public Animal (String nom, int ani_id, int img, String tipo, String c){
        this.nombre = nom;
        this.animal_id = ani_id;
        this.imagen = img;
        this.tipo = tipo;
        this.clasifcación = c;
    }

    public void setClasifcación(String clasifcación) {
        this.clasifcación = clasifcación;
    }

    public String getClasifcación() {
        return clasifcación;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAnimal_id(Integer animal_id) {
        this.animal_id = animal_id;
    }

    public Integer getAnimal_id() {
        return animal_id;
    }
}
