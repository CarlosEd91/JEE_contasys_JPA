package com.hogam.contasys.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the mat_tipo_producto database table.
 * 
 */
@Entity
@Table(name="mat_tipo_producto")
@NamedQuery(name="MatTipoProducto.findAll", query="SELECT m FROM MatTipoProducto m")
public class MatTipoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipPro;

	private String descripcionTipPro;

	private String nombreTipPro;

	//bi-directional many-to-one association to MatProducto
	@OneToMany(mappedBy="matTipoProducto")
	private Set<MatProducto> matProductos;

	public MatTipoProducto() {
	}

	public int getIdTipPro() {
		return this.idTipPro;
	}

	public void setIdTipPro(int idTipPro) {
		this.idTipPro = idTipPro;
	}

	public String getDescripcionTipPro() {
		return this.descripcionTipPro;
	}

	public void setDescripcionTipPro(String descripcionTipPro) {
		this.descripcionTipPro = descripcionTipPro;
	}

	public String getNombreTipPro() {
		return this.nombreTipPro;
	}

	public void setNombreTipPro(String nombreTipPro) {
		this.nombreTipPro = nombreTipPro;
	}

	public Set<MatProducto> getMatProductos() {
		return this.matProductos;
	}

	public void setMatProductos(Set<MatProducto> matProductos) {
		this.matProductos = matProductos;
	}

	public MatProducto addMatProducto(MatProducto matProducto) {
		getMatProductos().add(matProducto);
		matProducto.setMatTipoProducto(this);

		return matProducto;
	}

	public MatProducto removeMatProducto(MatProducto matProducto) {
		getMatProductos().remove(matProducto);
		matProducto.setMatTipoProducto(null);

		return matProducto;
	}

}