package ar.edu.unju.fi.tp9.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Entity
@Table(name="CLIENTES")
@Component("clienteObj")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cli_Id")
	private Long id;
	
	@Min(value=100000,message = "Debe Contener al Menos 6 caracteres")
	@Column(name = "cli_DNI")
	private int nroDocumento;
	
	@Column(name = "cli_TipoDoc")
	private String tipoDocumento;
	
	@NotBlank(message = "Esta Campo no puede estar vacio")
	@Size(min = 10,max = 50,message ="Debe contener de  10 a 50 caracteres" )
	@Column(name = "cli_NombreApeLLido")
	private String nombreApellido;
	
	@NotBlank(message = "Esta Campo no puede estar vacio")
	@Size(min = 10,max = 50,message ="debe de contener 10 a 50 caracteres" )
	@Email(message = "debe ser un formate de email valido")
	@Column(name = "cli_Email")
	private String email;
	
	@NotBlank(message = "Esta Campo no puede estar vacio")
	@Size(min = 8,max = 50,message ="debe de contener 8 a 50 caracteres" )
	@Column(name = "cli_Password")
	private String password;
	
	@NotNull(message = "Debe seleccionar una fecha")
	@Column(name = "cli_FechaNacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	@Column(name = "cli_Edad")
	private int edad;
	
	@Min(value=10,message = "Debe Contener al Menos 2 caracteres")
	@Column(name = "cli_CodigoATel")
	private int codigoAreaTelefono;
	
	@Min(value=100000,message = "Debe Contener al Menos 6 caracteres")
	@Column(name = "cli_Telefono")
	private int nroTelefono;
	@NotNull(message = "Debe seleccionar una fecha")
	@Column(name = "cli_FechaUComp")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cue_Id")
	private Cuenta cuenta;
	
	private List<Beneficio> beneficios=new ArrayList<Beneficio>();
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	


	public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, int codigoAreaTelefono, int nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}


	

	public String getTipoDocumento() {
		return tipoDocumento;
	}




	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}




	public int getNroDocumento() {
		return nroDocumento;
	}




	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}




	public String getNombreApellido() {
		return nombreApellido;
	}




	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}




	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}




	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}




	public int getNroTelefono() {
		return nroTelefono;
	}




	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}




	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}




	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	

	public int getEdad() {
		
	    this.edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, hoy);
		this.edad = periodo.getYears();
			return this.edad;
		}
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nroDocumento=" + nroDocumento + ", tipoDocumento=" + tipoDocumento
				+ ", nombreApellido=" + nombreApellido + ", email=" + email + ", password=" + password
				+ ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", codigoAreaTelefono="
				+ codigoAreaTelefono + ", nroTelefono=" + nroTelefono + ", fechaUltimaCompra=" + fechaUltimaCompra
				+ ", cuenta=" + cuenta + "]";
	}



	public String getTiempoDesdeUltimaCompra(){
		LocalDate hoy = LocalDate.now();
		LocalDate fechaInicial=this.fechaUltimaCompra;
		LocalDate fechaFinal=hoy;
		Period periodo = Period.between(fechaInicial, fechaFinal);
		String fecha = " Año:" + periodo.getYears() + " años / Mes:" + periodo.getMonths() + " meses / Dia:" + periodo.getDays() + " dias";
		
		return "Tiempo desde Ultima compra : "+fecha;
	}
	
	public String getDiasDesdeMiNacimiento() {
		long diashhoy =0;
		LocalDate hoy = LocalDate.now();
		diashhoy= ChronoUnit.DAYS.between(fechaNacimiento, hoy);
		return "Dias desde mi Nacimiento hasta hoy : " + diashhoy + " dias";
	}

	public String getTiempoCumple() {
		String texto = "";
		LocalDate hoy = LocalDate.now();
		LocalDate proxCump = this.fechaNacimiento.withYear(hoy.getYear());
			if (proxCump.isBefore(hoy) || proxCump.isEqual(hoy)) {
				proxCump = proxCump.plusYears(1);
			}

		Period periodo = Period.between(hoy, proxCump);

		texto = " Año: " + String.valueOf(periodo.getYears()) + " años/ Mes : " + String.valueOf(periodo.getMonths()) + String.valueOf( " meses / Dia : " + periodo.getDays())+ " dias" ;

		LocalDateTime CumpleAhora = LocalDateTime.now();
		LocalDateTime HastaCumpleEnHora = LocalDateTime.of(proxCump.getYear(), proxCump.getMonth(),
				proxCump.getDayOfMonth(), 0, 0, 0);

		Duration duracion = Duration.between(CumpleAhora, HastaCumpleEnHora);

		texto = texto + " / Hora: " + String.valueOf(duracion.toHoursPart()) + " horas / Min : "+ String.valueOf(duracion.toMinutesPart()) + "minutos / Seg : " + String.valueOf(duracion.toSecondsPart())+" segundos";

		return "Tiempo hasta proximo cump: "+texto;

	}




	
	  public Cuenta getCuenta() { 
		  return cuenta; 
	  }
	  
	  public void setCuenta(Cuenta cuenta) {
		  this.cuenta = cuenta;
	  }
	 
	
}
