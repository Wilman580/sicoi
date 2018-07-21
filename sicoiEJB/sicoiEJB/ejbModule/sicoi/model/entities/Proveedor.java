package sicoi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROVEEDOR_IDPROVEEDOR_GENERATOR", sequenceName="SEQ_PROVEEDOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROVEEDOR_IDPROVEEDOR_GENERATOR")
	@Column(name="id_proveedor")
	private Integer idProveedor;

	@Column(name="ciudad_proveedor")
	private String ciudadProveedor;

	@Column(name="direccion_proveedor")
	private String direccionProveedor;

	@Column(name="estado_proveedor")
	private Boolean estadoProveedor;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaingreso_proveedor")
	private Date fechaingresoProveedor;

	@Column(name="nombre_proveedor")
	private String nombreProveedor;

	@Column(name="telefono_proveedor")
	private Integer telefonoProveedor;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="proveedor")
	private List<Compra> compras;

	public Proveedor() {
	}

	public Integer getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getCiudadProveedor() {
		return this.ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

	public String getDireccionProveedor() {
		return this.direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public Boolean getEstadoProveedor() {
		return this.estadoProveedor;
	}

	public void setEstadoProveedor(Boolean estadoProveedor) {
		this.estadoProveedor = estadoProveedor;
	}

	public Date getFechaingresoProveedor() {
		return this.fechaingresoProveedor;
	}

	public void setFechaingresoProveedor(Date fechaingresoProveedor) {
		this.fechaingresoProveedor = fechaingresoProveedor;
	}

	public String getNombreProveedor() {
		return this.nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public Integer getTelefonoProveedor() {
		return this.telefonoProveedor;
	}

	public void setTelefonoProveedor(Integer telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setProveedor(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setProveedor(null);

		return compra;
	}

}