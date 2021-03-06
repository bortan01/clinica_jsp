package com.clinica.entidad;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="paciente"   ,catalog="clinica"
)
public class Paciente  implements java.io.Serializable {


     private int iddoctor;
     private String nombre;
     private String direccion;
     private String apellido;
     private Integer edad;
     private Date fechaNacimiento;
     private Set<Cita> citas = new HashSet<Cita>(0);

    public Paciente() {
    }

	
    public Paciente(int iddoctor) {
        this.iddoctor = iddoctor;
    }
    public Paciente(int iddoctor, String nombre, String direccion, String apellido, Integer edad, Date fechaNacimiento, Set<Cita> citas) {
       this.iddoctor = iddoctor;
       this.nombre = nombre;
       this.direccion = direccion;
       this.apellido = apellido;
       this.edad = edad;
       this.fechaNacimiento = fechaNacimiento;
       this.citas = citas;
    }
   
     @Id 

    
    @Column(name="iddoctor", unique=true, nullable=false)
    public int getIddoctor() {
        return this.iddoctor;
    }
    
    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    
    @Column(name="nombre", length=20)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="direccion", length=50)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="apellido", length=20)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="edad")
    public Integer getEdad() {
        return this.edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_nacimiento", length=10)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="paciente")
    public Set<Cita> getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set<Cita> citas) {
        this.citas = citas;
    }




}


