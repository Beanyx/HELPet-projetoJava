package br.org.helpet.listaadocao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Animais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipoAnimal;
    private String sexo;
    private String raca;

    @ManyToOne
    @JsonBackReference
    private LarTemp larTemp;
    
    public Animais() {
    }
    public Animais(String tipoAnimal, String sexo, String raca) {
        this.tipoAnimal = tipoAnimal;
        this.sexo = sexo;
        this.raca = raca;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipoAnimal() {
        return tipoAnimal;
    }
    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public LarTemp getLarTemp() {
        return larTemp;
    }
    public void setLarTemp(LarTemp larTemp) {
        this.larTemp = larTemp;
    }

    
}
