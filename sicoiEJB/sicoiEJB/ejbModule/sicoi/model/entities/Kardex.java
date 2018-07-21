package sicoi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kardex database table.
 * 
 */
@Entity
@NamedQuery(name="Kardex.findAll", query="SELECT k FROM Kardex k")
public class Kardex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KARDEX_IDKARDEX_GENERATOR", sequenceName="SEQ_KARDEX", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KARDEX_IDKARDEX_GENERATOR")
	@Column(name="id_kardex")
	private Integer idKardex;

	@Column(name="concepto_kardex")
	private String conceptoKardex;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_kardex")
	private Date fechaKardex;

	@Column(name="observacion_kardex")
	private String observacionKardex;

	@Column(name="uentradas_kardex")
	private Integer uentradasKardex;

	@Column(name="usalidas_kardex")
	private Integer usalidasKardex;

	//bi-directional many-to-one association to DetalleCompra
	@ManyToOne
	@JoinColumn(name="id_detallecompra")
	private DetalleCompra detalleCompra;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	public Kardex() {
	}

	public Integer getIdKardex() {
		return this.idKardex;
	}

	public void setIdKardex(Integer idKardex) {
		this.idKardex = idKardex;
	}

	public String getConceptoKardex() {
		return this.conceptoKardex;
	}

	public void setConceptoKardex(String conceptoKardex) {
		this.conceptoKardex = conceptoKardex;
	}

	public Date getFechaKardex() {
		return this.fechaKardex;
	}

	public void setFechaKardex(Date fechaKardex) {
		this.fechaKardex = fechaKardex;
	}

	public String getObservacionKardex() {
		return this.observacionKardex;
	}

	public void setObservacionKardex(String observacionKardex) {
		this.observacionKardex = observacionKardex;
	}

	public Integer getUentradasKardex() {
		return this.uentradasKardex;
	}

	public void setUentradasKardex(Integer uentradasKardex) {
		this.uentradasKardex = uentradasKardex;
	}

	public Integer getUsalidasKardex() {
		return this.usalidasKardex;
	}

	public void setUsalidasKardex(Integer usalidasKardex) {
		this.usalidasKardex = usalidasKardex;
	}

	public DetalleCompra getDetalleCompra() {
		return this.detalleCompra;
	}

	public void setDetalleCompra(DetalleCompra detalleCompra) {
		this.detalleCompra = detalleCompra;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}