/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;


import java.util.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author usuario
 */

@Entity
@Table(name="Click", catalog="wololo")
public class Click {
    @Id @GeneratedValue
    @Column(name="idClick")
    private int idClick;
    
    @Column(name="fecha")
    private Date Fecha;
    
    
    @ManyToOne
    @JoinColumn(name="idElemento")
    private Elemento idElemento;

    /**
     * @return the idClick
     */
    public int getIdClick() {
        return idClick;
    }

    /**
     * @param idClick the idClick to set
     */
    public void setIdClick(int idClick) {
        this.idClick = idClick;
    }

    /**
     * @return the Fecha
     */
    public Date getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    

    

    /**
     * @return the idElemento
     */
    public Elemento getIdElemento() {
        return idElemento;
    }

    /**
     * @param idElemento the idElemento to set
     */
    public void setIdElemento(Elemento idElemento) {
        this.idElemento = idElemento;
    }
    
}
