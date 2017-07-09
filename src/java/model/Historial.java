package model;
// Generated 07/07/2017 04:04:23 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Historial generated by hbm2java
 */
@Entity
@Table(name="Historial"
    ,catalog="bancario"
)
public class Historial  implements java.io.Serializable {


     private Integer idHistorial;
     private Cuenta cuenta;
     private Date fecha;
     private String tipo;
     private double saldoAnterior;
     private double monto;
     private double saldoPosterior;
     private String cometario;

    public Historial() {
    }

	
    public Historial(Cuenta cuenta, Date fecha, String tipo, double saldoAnterior, double monto, double saldoPosterior) {
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.tipo = tipo;
        this.saldoAnterior = saldoAnterior;
        this.monto = monto;
        this.saldoPosterior = saldoPosterior;
    }
    public Historial(Cuenta cuenta, Date fecha, String tipo, double saldoAnterior, double monto, double saldoPosterior, String cometario) {
       this.cuenta = cuenta;
       this.fecha = fecha;
       this.tipo = tipo;
       this.saldoAnterior = saldoAnterior;
       this.monto = monto;
       this.saldoPosterior = saldoPosterior;
       this.cometario = cometario;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idHistorial", unique=true, nullable=false)
    public Integer getIdHistorial() {
        return this.idHistorial;
    }
    
    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cuenta_idCuenta", nullable=false)
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="Fecha", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="tipo", nullable=false, length=1)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="saldo_anterior", nullable=false, precision=22, scale=0)
    public double getSaldoAnterior() {
        return this.saldoAnterior;
    }
    
    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    
    @Column(name="monto", nullable=false, precision=22, scale=0)
    public double getMonto() {
        return this.monto;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }

    
    @Column(name="saldo_posterior", nullable=false, precision=22, scale=0)
    public double getSaldoPosterior() {
        return this.saldoPosterior;
    }
    
    public void setSaldoPosterior(double saldoPosterior) {
        this.saldoPosterior = saldoPosterior;
    }

    
    @Column(name="cometario", length=45)
    public String getCometario() {
        return this.cometario;
    }
    
    public void setCometario(String cometario) {
        this.cometario = cometario;
    }




}

