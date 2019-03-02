package com.hogam.contasys.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the mat_producto database table.
 * 
 */
@Entity
@Table(name="mat_producto")
@NamedQuery(name="MatProducto.findAll", query="SELECT m FROM MatProducto m")
public class MatProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPro;

	private String codigoPro;

	private String descripcionPro;

	private String nombrePro;

	private BigDecimal precioComPro;

	private BigDecimal precioVenPro;

	//bi-directional many-to-one association to MatDetalleFactura
	@OneToMany(mappedBy="matProducto")
	private Set<MatDetalleFactura> matDetalleFacturas;

	//bi-directional many-to-one association to MatTipoProducto
	@ManyToOne
	@JoinColumn(name="MAT_TIPO_PRODUCTO_idTipPro")
	private MatTipoProducto matTipoProducto;

	public MatProducto() {
	}

	public int getIdPro() {
		return this.idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	public String getCodigoPro() {
		return this.codigoPro;
	}

	public void setCodigoPro(String codigoPro) {
		this.codigoPro = codigoPro;
	}

	public String getDescripcionPro() {
		return this.descripcionPro;
	}

	public void setDescripcionPro(String descripcionPro) {
		this.descripcionPro = descripcionPro;
	}

	public String getNombrePro() {
		return this.nombrePro;
	}

	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}

	public BigDecimal getPrecioComPro() {
		return this.precioComPro;
	}

	public void setPrecioComPro(BigDecimal precioComPro) {
		this.precioComPro = precioComPro;
	}

	public BigDecimal getPrecioVenPro() {
		return this.precioVenPro;
	}

	public void setPrecioVenPro(BigDecimal precioVenPro) {
		this.precioVenPro = precioVenPro;
	}

	public Set<MatDetalleFactura> getMatDetalleFacturas() {
		return this.matDetalleFacturas;
	}

	public void setMatDetalleFacturas(Set<MatDetalleFactura> matDetalleFacturas) {
		this.matDetalleFacturas = matDetalleFacturas;
	}

	public MatDetalleFactura addMatDetalleFactura(MatDetalleFactura matDetalleFactura) {
		getMatDetalleFacturas().add(matDetalleFactura);
		matDetalleFactura.setMatProducto(this);

		return matDetalleFactura;
	}

	public MatDetalleFactura removeMatDetalleFactura(MatDetalleFactura matDetalleFactura) {
		getMatDetalleFacturas().remove(matDetalleFactura);
		matDetalleFactura.setMatProducto(null);

		return matDetalleFactura;
	}

	public MatTipoProducto getMatTipoProducto() {
		return this.matTipoProducto;
	}

	public void setMatTipoProducto(MatTipoProducto matTipoProducto) {
		this.matTipoProducto = matTipoProducto;
	}

}