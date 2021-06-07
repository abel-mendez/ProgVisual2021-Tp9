package ar.edu.unju.fi.tp9.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Entity
@Table(name="BENEFICIOS")
@Component
public class Beneficio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ben_id")
	private int id;
	
	@Size(min = 10,max = 50,message ="Debe contener de  10 a 50 caracteres" )
	@NotBlank(message = "Esta Campo no puede estar vacio")
	@Column(name="ben_descripcion")
	private String descripcion;
	@ManyToMany(mappedBy = "beneficios")
	private List<Cliente> clientes=new ArrayList<Cliente>();
	
	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}
	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Beneficio() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @param id
	 * @param descripcion
	 * @param clientes
	 */
	public Beneficio(Integer id,
			String descripcion,
			List<Cliente> clientes) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.clientes = clientes;
	}

	
	
}
