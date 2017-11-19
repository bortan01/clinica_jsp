/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinica.control;

import com.clinica.dao.pacienteDaoImpl;
import com.clinica.entidad.Paciente;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "control_clinica")
@SessionScoped
public class control_clinica implements Serializable{
    
    private Paciente paci;
    private List<Paciente> lista_paciente;
    @ManagedProperty("#{AeropuertoDaoImpl}")
    private pacienteDaoImpl pacienteDI;
    
     @PostConstruct
    public void init() {
        try {
           paci = pacienteDI.create();
        } catch (Exception e) {
        }
    }

    public Paciente getPaci() {
        return paci;
    }

    public void setPaci(Paciente paci) {
        this.paci = paci;
    }

    public List<Paciente> getLista_paciente() {
        return lista_paciente;
    }

    public void setLista_paciente(List<Paciente> lista_paciente) {
        this.lista_paciente = lista_paciente;
    }

    public pacienteDaoImpl getPacienteDI() {
        return pacienteDI;
    }

    public void setPacienteDI(pacienteDaoImpl pacienteDI) {
        this.pacienteDI = pacienteDI;
    }


}
