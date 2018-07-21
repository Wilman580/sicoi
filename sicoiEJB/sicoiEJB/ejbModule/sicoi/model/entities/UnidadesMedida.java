package sicoi.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidades_medida database table.
 * 
 */
@Entity
@Table(name="unidades_medida")
@NamedQuery(name="UnidadesMedida.findAll", query="SELECT u FROM UnidadesMedida u")
public class UnidadesMedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNIDADES_MEDIDA_IDUMEDIDA_GENERATOR", sequenceName="SEQ_UNIDADES_MEDIDA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIDADES_MEDIDA_IDUMEDIDA_GENERATOR")
	@Column(name="id_umedida")
	private Integer idUmedida;

	@Column(name="descripcion_umedida")
	private String descripcionUmedida;

	@Column(name="tipo_umedida")
	private String tipoUmedida;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="unidadesMedida")
	private List<Producto> productos;

	public UnidadesMedida() {
	}

	public Integer getIdUmedida() {
		return this.idUmedida;
	}

	public void setIdUmedida(Integer idUmedida) {
		this.idUmedida = idUmedida;
	}

	public String getDescripcionUmedida() {
		return this.descripcionUmedida;
	}

	public void setDescripcionUmedida(String descripcionUmedida) {
		this.descripcionUmedida = descripcionUmedida;
	}

	public String getTipoUmedida() {
		return this.tipoUmedida;
	}

	public void setTipoUmedida(String tipoUmedida) {
		this.tipoUmedida = tipoUmedida;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setUnidadesMedida(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setUnidadesMedida(null);

		return producto;
	}

}