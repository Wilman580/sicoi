package sicoi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private String idUsuario;

	@Column(name="apellidos_usuario")
	private String apellidosUsuario;

	@Column(name="direccion_usuario")
	private String direccionUsuario;

	@Column(name="email_usuario")
	private String emailUsuario;

	@Column(name="estado_usuario")
	private Boolean estadoUsuario;

	@Temporal(TemporalType.DATE)
	@Column(name="fechanac_usuario")
	private Date fechanacUsuario;

	@Column(name="nacionalidad_usuario")
	private String nacionalidadUsuario;

	@Column(name="nombres_usuario")
	private String nombresUsuario;

	@Column(name="password_usuario")
	private String passwordUsuario;

	@Column(name="sexo_usuario")
	private String sexoUsuario;

	@Column(name="telefono_usuario")
	private Integer telefonoUsuario;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="usuario")
	private List<Compra> compras;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

	public Usuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidosUsuario() {
		return this.apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getDireccionUsuario() {
		return this.direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Boolean getEstadoUsuario() {
		return this.estadoUsuario;
	}

	public void setEstadoUsuario(Boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public Date getFechanacUsuario() {
		return this.fechanacUsuario;
	}

	public void setFechanacUsuario(Date fechanacUsuario) {
		this.fechanacUsuario = fechanacUsuario;
	}

	public String getNacionalidadUsuario() {
		return this.nacionalidadUsuario;
	}

	public void setNacionalidadUsuario(String nacionalidadUsuario) {
		this.nacionalidadUsuario = nacionalidadUsuario;
	}

	public String getNombresUsuario() {
		return this.nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	public String getPasswordUsuario() {
		return this.passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String getSexoUsuario() {
		return this.sexoUsuario;
	}

	public void setSexoUsuario(String sexoUsuario) {
		this.sexoUsuario = sexoUsuario;
	}

	public Integer getTelefonoUsuario() {
		return this.telefonoUsuario;
	}

	public void setTelefonoUsuario(Integer telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setUsuario(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setUsuario(null);

		return compra;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}