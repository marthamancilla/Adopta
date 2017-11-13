/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author usuario
 */

@Entity
@Table(name="elemento", catalog="wololo")
public class Elemento {
    
    @Id @GeneratedValue
    @Column(name="idElemento")
    private int idElemento;
    
    @Column(name="Id")
    private String id;
    
    @Column(name="Clase")
    private String clase;

    /**
     * @return the idElemento
     */
    public int getIdElemento() {
        return idElemento;
    }

    /**
     * @param idElemento the idElemento to set
     */
    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }
}
