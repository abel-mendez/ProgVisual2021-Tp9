package ar.edu.unju.fi.tp9.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name="COMPRAS")
@Component ("unaCompra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COM_ID")
	private Long id;
	
	@Valid
	@Autowired
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="PRO_CODIGO")
	private Producto producto;
	
	@Min(value=1,message="La compra minima es de 1 producto")
	@Column(name="COM_CANTIDAD")
	private int cantidad;
	
	@Column(name="COM_TOTAL")
	private Double total;

public Compra() {
	// TODO Auto-generated constructor stub
}


/**
 * @param id
 * @param producto
 * @param cantidad
 * @param total
 */
public Compra(Producto producto, int cantidad) {
	super();
	this.producto = producto;
	this.cantidad = cantidad;
}



/**
 * @return the id
 */
public Long getId() {
	return id;
}


/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}


/**
 * @return the producto
 */
public Producto getProducto() {
	return producto;
}


/**
 * @param producto2 the producto to set
 */
public void setProducto(Producto producto2) {
	this.producto = producto2;
}


/**
 * @return the cantidad
 */
public int getCantidad() {
	return cantidad;
}


/**
 * @param cantidad the cantidad to set
 */
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}


/**
 * @param total the total to set
 */
public void setTotal(Double total) {
	this.total = total;
}



@Override
public String toString() {
	return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
}


public double getTotal() {
	this.total=this.producto.getPrecio()*this.cantidad;
	return this.total;
}
 

}
