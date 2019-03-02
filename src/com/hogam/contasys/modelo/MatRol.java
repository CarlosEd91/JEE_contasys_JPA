package com.hogam.contasys.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the mat_rol database table.
 * 
 */
@Entity
@Table(name="mat_rol")
@NamedQuery(name="MatRol.findAll", query="SELECT m FROM MatRol m")
public class MatRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRol;

	private String descripcionRol;

	private String nombreRol;

	//bi-directional many-to-one association to MatUsuario
	@OneToMany(mappedBy="matRol")
	private Set<MatUsuario> matUsuarios;

	public MatRol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcionRol() {
		return this.descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Set<MatUsuario> getMatUsuarios() {
		return this.matUsuarios;
	}

	public void setMatUsuarios(Set<MatUsuario> matUsuarios) {
		this.matUsuarios = matUsuarios;
	}

	public MatUsuario addMatUsuario(MatUsuario matUsuario) {
		getMatUsuarios().add(matUsuario);
		matUsuario.setMatRol(this);

		return matUsuario;
	}

	public MatUsuario removeMatUsuario(MatUsuario matUsuario) {
		getMatUsuarios().remove(matUsuario);
		matUsuario.setMatRol(null);

		return matUsuario;
	}

}