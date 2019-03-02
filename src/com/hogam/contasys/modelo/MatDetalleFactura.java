package com.hogam.contasys.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mat_detalle_factura database table.
 * 
 */
@Entity
@Table(name="mat_detalle_factura")
@NamedQuery(name="MatDetalleFactura.findAll", query="SELECT m FROM MatDetalleFactura m")
public class MatDetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDetFac;

	private double cantidadDetFac;

	private String descripcionDetFac;

	//bi-directional many-to-one association to MatFactura
	@ManyToOne
	@JoinColumn(name="MAT_FACTURA_idFac")
	private MatFactura matFactura;

	//bi-directional many-to-one association to MatProducto
	@ManyToOne
	@JoinColumn(name="MAT_PRODUCTO_idPro")
	private MatProducto matProducto;

	public MatDetalleFactura() {
	}

	public int getIdDetFac() {
		return this.idDetFac;
	}

	public void setIdDetFac(int idDetFac) {
		this.idDetFac = idDetFac;
	}

	public double getCantidadDetFac() {
		return this.cantidadDetFac;
	}

	public void setCantidadDetFac(double cantidadDetFac) {
		this.cantidadDetFac = cantidadDetFac;
	}

	public String getDescripcionDetFac() {
		return this.descripcionDetFac;
	}

	public void setDescripcionDetFac(String descripcionDetFac) {
		this.descripcionDetFac = descripcionDetFac;
	}

	public MatFactura getMatFactura() {
		return this.matFactura;
	}

	public void setMatFactura(MatFactura matFactura) {
		this.matFactura = matFactura;
	}

	public MatProducto getMatProducto() {
		return this.matProducto;
	}

	public void setMatProducto(MatProducto matProducto) {
		this.matProducto = matProducto;
	}

}