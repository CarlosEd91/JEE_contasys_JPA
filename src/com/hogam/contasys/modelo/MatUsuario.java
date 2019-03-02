package com.hogam.contasys.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mat_usuario database table.
 * 
 */
@Entity
@Table(name="mat_usuario")
@NamedQuery(name="MatUsuario.findAll", query="SELECT m FROM MatUsuario m")
public class MatUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsu;

	private String confirmacionConUsu;

	private String contraseniaUsu;

	@Temporal(TemporalType.DATE)
	private Date fechaCaducidadUsu;

	private String nombreUsu;

	//bi-directional many-to-one association to MatRol
	@ManyToOne
	@JoinColumn(name="MAT_ROL_idRol")
	private MatRol matRol;

	public MatUsuario() {
	}

	public int getIdUsu() {
		return this.idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}

	public String getConfirmacionConUsu() {
		return this.confirmacionConUsu;
	}

	public void setConfirmacionConUsu(String confirmacionConUsu) {
		this.confirmacionConUsu = confirmacionConUsu;
	}

	public String getContraseniaUsu() {
		return this.contraseniaUsu;
	}

	public void setContraseniaUsu(String contraseniaUsu) {
		this.contraseniaUsu = contraseniaUsu;
	}

	public Date getFechaCaducidadUsu() {
		return this.fechaCaducidadUsu;
	}

	public void setFechaCaducidadUsu(Date fechaCaducidadUsu) {
		this.fechaCaducidadUsu = fechaCaducidadUsu;
	}

	public String getNombreUsu() {
		return this.nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public MatRol getMatRol() {
		return this.matRol;
	}

	public void setMatRol(MatRol matRol) {
		this.matRol = matRol;
	}

}