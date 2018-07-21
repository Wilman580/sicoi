package sicoi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the compra database table.
 * 
 */
@Entity
@NamedQuery(name="Compra.findAll", query="SELECT c FROM Compra c")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPRA_IDCOMPRA_GENERATOR", sequenceName="SEQ_COMPRA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPRA_IDCOMPRA_GENERATOR")
	@Column(name="id_compra")
	private Integer idCompra;

	@Column(name="descuento_compra")
	private double descuentoCompra;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_compra")
	private Date fechaCompra;

	@Column(name="formapago_compra")
	private String formapagoCompra;

	@Column(name="ivatotal_compra")
	private double ivatotalCompra;

	@Column(name="observacion_compra")
	private String observacionCompra;

	@Column(name="subtotal_compra")
	private double subtotalCompra;

	@Column(name="valortotal_compra")
	private double valortotalCompra;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to DetalleCompra
	@OneToMany(mappedBy="compra")
	private List<DetalleCompra> detalleCompras;

	public Compra() {
	}

	public Integer getIdCompra() {
		return this.idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public double getDescuentoCompra() {
		return this.descuentoCompra;
	}

	public void setDescuentoCompra(double descuentoCompra) {
		this.descuentoCompra = descuentoCompra;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getFormapagoCompra() {
		return this.formapagoCompra;
	}

	public void setFormapagoCompra(String formapagoCompra) {
		this.formapagoCompra = formapagoCompra;
	}

	public double getIvatotalCompra() {
		return this.ivatotalCompra;
	}

	public void setIvatotalCompra(double ivatotalCompra) {
		this.ivatotalCompra = ivatotalCompra;
	}

	public String getObservacionCompra() {
		return this.observacionCompra;
	}

	public void setObservacionCompra(String observacionCompra) {
		this.observacionCompra = observacionCompra;
	}

	public double getSubtotalCompra() {
		return this.subtotalCompra;
	}

	public void setSubtotalCompra(double subtotalCompra) {
		this.subtotalCompra = subtotalCompra;
	}

	public double getValortotalCompra() {
		return this.valortotalCompra;
	}

	public void setValortotalCompra(double valortotalCompra) {
		this.valortotalCompra = valortotalCompra;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleCompra> getDetalleCompras() {
		return this.detalleCompras;
	}

	public void setDetalleCompras(List<DetalleCompra> detalleCompras) {
		this.detalleCompras = detalleCompras;
	}

	public DetalleCompra addDetalleCompra(DetalleCompra detalleCompra) {
		getDetalleCompras().add(detalleCompra);
		detalleCompra.setCompra(this);

		return detalleCompra;
	}

	public DetalleCompra removeDetalleCompra(DetalleCompra detalleCompra) {
		getDetalleCompras().remove(detalleCompra);
		detalleCompra.setCompra(null);

		return detalleCompra;
	}

}