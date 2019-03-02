package com.hogam.contasys.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the mat_cliente database table.
 * 
 */
@Entity
@Table(name="mat_cliente")
@NamedQuery(name="MatCliente.findAll", query="SELECT m FROM MatCliente m")
public class MatCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCli;

	private String apellidoCli;

	private String identificacionCli;

	private String nombreCli;

	//bi-directional many-to-one association to MatFactura
	@OneToMany(mappedBy="matCliente")
	private Set<MatFactura> matFacturas;

	public MatCliente() {
	}

	public int getIdCli() {
		return this.idCli;
	}

	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}

	public String getApellidoCli() {
		return this.apellidoCli;
	}

	public void setApellidoCli(String apellidoCli) {
		this.apellidoCli = apellidoCli;
	}

	public String getIdentificacionCli() {
		return this.identificacionCli;
	}

	public void setIdentificacionCli(String identificacionCli) {
		this.identificacionCli = identificacionCli;
	}

	public String getNombreCli() {
		return this.nombreCli;
	}

	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}

	public Set<MatFactura> getMatFacturas() {
		return this.matFacturas;
	}

	public void setMatFacturas(Set<MatFactura> matFacturas) {
		this.matFacturas = matFacturas;
	}

	public MatFactura addMatFactura(MatFactura matFactura) {
		getMatFacturas().add(matFactura);
		matFactura.setMatCliente(this);

		return matFactura;
	}

	public MatFactura removeMatFactura(MatFactura matFactura) {
		getMatFacturas().remove(matFactura);
		matFactura.setMatCliente(null);

		return matFactura;
	}

}