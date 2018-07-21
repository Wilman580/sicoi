package sicoi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_producto")
	private String idProducto;

	@Column(name="cantidad_producto")
	private Integer cantidadProducto;

	@Column(name="cantmax_producto")
	private Integer cantmaxProducto;

	@Column(name="cantmin_producto")
	private Integer cantminProducto;

	@Column(name="descripcion_producto")
	private String descripcionProducto;

	@Column(name="estado_producto")
	private Boolean estadoProducto;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaingreso_producto")
	private Date fechaingresoProducto;

	@Column(name="iva_producto")
	private Integer ivaProducto;

	@Column(name="marca_producto")
	private String marcaProducto;

	@Column(name="nombre_producto")
	private String nombreProducto;

	@Column(name="precioventa_producto")
	private double precioventaProducto;

	@Column(name="tipo_producto")
	private String tipoProducto;

	@Column(name="unidadmedida_producto")
	private String unidadmedidaProducto;

	//bi-directional many-to-one association to DetalleCompra
	@OneToMany(mappedBy="producto")
	private List<DetalleCompra> detalleCompras;

	//bi-directional many-to-one association to Kardex
	@OneToMany(mappedBy="producto")
	private List<Kardex> kardexs;

	//bi-directional many-to-one association to TipoProducto
	@ManyToOne
	@JoinColumn(name="id_tipoproducto")
	private TipoProducto tipoProductoBean;

	//bi-directional many-to-one association to UnidadesMedida
	@ManyToOne
	@JoinColumn(name="id_umedida")
	private UnidadesMedida unidadesMedida;

	public Producto() {
	}

	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidadProducto() {
		return this.cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Integer getCantmaxProducto() {
		return this.cantmaxProducto;
	}

	public void setCantmaxProducto(Integer cantmaxProducto) {
		this.cantmaxProducto = cantmaxProducto;
	}

	public Integer getCantminProducto() {
		return this.cantminProducto;
	}

	public void setCantminProducto(Integer cantminProducto) {
		this.cantminProducto = cantminProducto;
	}

	public String getDescripcionProducto() {
		return this.descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public Boolean getEstadoProducto() {
		return this.estadoProducto;
	}

	public void setEstadoProducto(Boolean estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	public Date getFechaingresoProducto() {
		return this.fechaingresoProducto;
	}

	public void setFechaingresoProducto(Date fechaingresoProducto) {
		this.fechaingresoProducto = fechaingresoProducto;
	}

	public Integer getIvaProducto() {
		return this.ivaProducto;
	}

	public void setIvaProducto(Integer ivaProducto) {
		this.ivaProducto = ivaProducto;
	}

	public String getMarcaProducto() {
		return this.marcaProducto;
	}

	public void setMarcaProducto(String marcaProducto) {
		this.marcaProducto = marcaProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioventaProducto() {
		return this.precioventaProducto;
	}

	public void setPrecioventaProducto(double precioventaProducto) {
		this.precioventaProducto = precioventaProducto;
	}

	public String getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getUnidadmedidaProducto() {
		return this.unidadmedidaProducto;
	}

	public void setUnidadmedidaProducto(String unidadmedidaProducto) {
		this.unidadmedidaProducto = unidadmedidaProducto;
	}

	public List<DetalleCompra> getDetalleCompras() {
		return this.detalleCompras;
	}

	public void setDetalleCompras(List<DetalleCompra> detalleCompras) {
		this.detalleCompras = detalleCompras;
	}

	public DetalleCompra addDetalleCompra(DetalleCompra detalleCompra) {
		getDetalleCompras().add(detalleCompra);
		detalleCompra.setProducto(this);

		return detalleCompra;
	}

	public DetalleCompra removeDetalleCompra(DetalleCompra detalleCompra) {
		getDetalleCompras().remove(detalleCompra);
		detalleCompra.setProducto(null);

		return detalleCompra;
	}

	public List<Kardex> getKardexs() {
		return this.kardexs;
	}

	public void setKardexs(List<Kardex> kardexs) {
		this.kardexs = kardexs;
	}

	public Kardex addKardex(Kardex kardex) {
		getKardexs().add(kardex);
		kardex.setProducto(this);

		return kardex;
	}

	public Kardex removeKardex(Kardex kardex) {
		getKardexs().remove(kardex);
		kardex.setProducto(null);

		return kardex;
	}

	public TipoProducto getTipoProductoBean() {
		return this.tipoProductoBean;
	}

	public void setTipoProductoBean(TipoProducto tipoProductoBean) {
		this.tipoProductoBean = tipoProductoBean;
	}

	public UnidadesMedida getUnidadesMedida() {
		return this.unidadesMedida;
	}

	public void setUnidadesMedida(UnidadesMedida unidadesMedida) {
		this.unidadesMedida = unidadesMedida;
	}

}