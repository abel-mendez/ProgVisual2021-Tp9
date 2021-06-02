package ar.edu.unju.fi.tp9.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="CUENTAS")
@Component("unaCuenta")
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cue_Id")
	private Long id;
	
	
	@Min(value=10,message="Saldo minimo es 0")
	@Column(name="cue_Saldo")
	private Double saldo;
	
	@NotNull(message="El campo fecha no debe estar vacio")
	@Column(name="cue_FechaCreacion")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion;
	
	@NotBlank(message="El campo estado debe seleccionar un estado")
	@Column(name="cue_Estado")
	private String estado;
	
//	@Autowired
//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
//	@JoinColumn(name="cli_Id")
	
	@Valid
	@OneToOne(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private Cliente cliente;
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

	public Cuenta(Double saldo, LocalDate fechaCreacion, String estado) {
		super();
		this.saldo = saldo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ ", cliente=" + cliente + "]";
	}


	
	
}
