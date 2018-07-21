package sicoi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the detalle_compra database table.
 * 
 */
@Entity
@Table(name="detalle_compra")
@NamedQuery(name="DetalleCompra.findAll", query="SELECT d FROM DetalleCompra d")
public class DetalleCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETALLE_COMPRA_IDDETALLECOMPRA_GENERATOR", sequenceName="SEQ_DETALLE_COMPRA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLE_COMPRA_IDDETALLECOMPRA_GENERATOR")
	@Column(name="id_detallecompra")
	private Integer idDetallecompra;

	@Column(name="cantidad_detallecompra")
	private Integer cantidadDetallecompra;

	@Column(name="descripcion_detallecompra")
	private String descripcionDetallecompra;

	@Column(name="iva_detallecompra")
	private Integer ivaDetallecompra;

	@Column(name="subtotal_detallecompra")
	private double subtotalDetallecompra;

	@Column(name="valorunit_detallecompra")
	private double valorunitDetallecompra;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="id_compra")
	private Compra compra;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	//bi-directional many-to-one association to Kardex
	@OneToMany(mappedBy="detalleCompra")
	private List<Kardex> kardexs;

	public DetalleCompra() {
	}

	public Integer getIdDetallecompra() {
		return this.idDetallecompra;
	}

	public void setIdDetallecompra(Integer idDetallecompra) {
		this.idDetallecompra = idDetallecompra;
	}

	public Integer getCantidadDetallecompra() {
		return this.cantidadDetallecompra;
	}

	public void setCantidadDetallecompra(Integer cantidadDetallecompra) {
		this.cantidadDetallecompra = cantidadDetallecompra;
	}

	public String getDescripcionDetallecompra() {
		return this.descripcionDetallecompra;
	}

	public void setDescripcionDetallecompra(String descripcionDetallecompra) {
		this.descripcionDetallecompra = descripcionDetallecompra;
	}

	public Integer getIvaDetallecompra() {
		return this.ivaDetallecompra;
	}

	public void setIvaDetallecompra(Integer ivaDetallecompra) {
		this.ivaDetallecompra = ivaDetallecompra;
	}

	public double getSubtotalDetallecompra() {
		return this.subtotalDetallecompra;
	}

	public void setSubtotalDetallecompra(double subtotalDetallecompra) {
		this.subtotalDetallecompra = subtotalDetallecompra;
	}

	public double getValorunitDetallecompra() {
		return this.valorunitDetallecompra;
	}

	public void setValorunitDetallecompra(double valorunitDetallecompra) {
		this.valorunitDetallecompra = valorunitDetallecompra;
	}

	public Compra getCompra() {
		return this.compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Kardex> getKardexs() {
		return this.kardexs;
	}

	public void setKardexs(List<Kardex> kardexs) {
		this.kardexs = kardexs;
	}

	public Kardex addKardex(Kardex kardex) {
		getKardexs().add(kardex);
		kardex.setDetalleCompra(this);

		return kardex;
	}

	public Kardex removeKardex(Kardex kardex) {
		getKardexs().remove(kardex);
		kardex.setDetalleCompra(null);

		return kardex;
	}

}