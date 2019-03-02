package com.hogam.contasys.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the mat_factura database table.
 * 
 */
@Entity
@Table(name="mat_factura")
@NamedQuery(name="MatFactura.findAll", query="SELECT m FROM MatFactura m")
public class MatFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFac;

	@Temporal(TemporalType.DATE)
	private Date fechaFac;

	private BigDecimal subTotalFac;

	private BigDecimal totalFac;

	private BigDecimal valorIvaFac;

	//bi-directional many-to-one association to MatDetalleFactura
	@OneToMany(mappedBy="matFactura")
	private Set<MatDetalleFactura> matDetalleFacturas;

	//bi-directional many-to-one association to MatCliente
	@ManyToOne
	@JoinColumn(name="MAT_CLIENTE_idCli")
	private MatCliente matCliente;

	public MatFactura() {
	}

	public int getIdFac() {
		return this.idFac;
	}

	public void setIdFac(int idFac) {
		this.idFac = idFac;
	}

	public Date getFechaFac() {
		return this.fechaFac;
	}

	public void setFechaFac(Date fechaFac) {
		this.fechaFac = fechaFac;
	}

	public BigDecimal getSubTotalFac() {
		return this.subTotalFac;
	}

	public void setSubTotalFac(BigDecimal subTotalFac) {
		this.subTotalFac = subTotalFac;
	}

	public BigDecimal getTotalFac() {
		return this.totalFac;
	}

	public void setTotalFac(BigDecimal totalFac) {
		this.totalFac = totalFac;
	}

	public BigDecimal getValorIvaFac() {
		return this.valorIvaFac;
	}

	public void setValorIvaFac(BigDecimal valorIvaFac) {
		this.valorIvaFac = valorIvaFac;
	}

	public Set<MatDetalleFactura> getMatDetalleFacturas() {
		return this.matDetalleFacturas;
	}

	public void setMatDetalleFacturas(Set<MatDetalleFactura> matDetalleFacturas) {
		this.matDetalleFacturas = matDetalleFacturas;
	}

	public MatDetalleFactura addMatDetalleFactura(MatDetalleFactura matDetalleFactura) {
		getMatDetalleFacturas().add(matDetalleFactura);
		matDetalleFactura.setMatFactura(this);

		return matDetalleFactura;
	}

	public MatDetalleFactura removeMatDetalleFactura(MatDetalleFactura matDetalleFactura) {
		getMatDetalleFacturas().remove(matDetalleFactura);
		matDetalleFactura.setMatFactura(null);

		return matDetalleFactura;
	}

	public MatCliente getMatCliente() {
		return this.matCliente;
	}

	public void setMatCliente(MatCliente matCliente) {
		this.matCliente = matCliente;
	}

}