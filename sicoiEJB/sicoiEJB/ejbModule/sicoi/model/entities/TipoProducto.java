package sicoi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_producto database table.
 * 
 */
@Entity
@Table(name="tipo_producto")
@NamedQuery(name="TipoProducto.findAll", query="SELECT t FROM TipoProducto t")
public class TipoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_PRODUCTO_IDTIPOPRODUCTO_GENERATOR", sequenceName="SEQ_TIPO_PRODUCTO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_PRODUCTO_IDTIPOPRODUCTO_GENERATOR")
	@Column(name="id_tipoproducto")
	private Integer idTipoproducto;

	@Column(name="descripcion_tipoproducto")
	private String descripcionTipoproducto;

	@Column(name="tipo_tipoproducto")
	private String tipoTipoproducto;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="tipoProductoBean")
	private List<Producto> productos;

	public TipoProducto() {
	}

	public Integer getIdTipoproducto() {
		return this.idTipoproducto;
	}

	public void setIdTipoproducto(Integer idTipoproducto) {
		this.idTipoproducto = idTipoproducto;
	}

	public String getDescripcionTipoproducto() {
		return this.descripcionTipoproducto;
	}

	public void setDescripcionTipoproducto(String descripcionTipoproducto) {
		this.descripcionTipoproducto = descripcionTipoproducto;
	}

	public String getTipoTipoproducto() {
		return this.tipoTipoproducto;
	}

	public void setTipoTipoproducto(String tipoTipoproducto) {
		this.tipoTipoproducto = tipoTipoproducto;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setTipoProductoBean(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setTipoProductoBean(null);

		return producto;
	}

}