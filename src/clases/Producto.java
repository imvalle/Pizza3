package clases;

public class Producto {
	
	private int productoid;
	private String nompro;
	private Double precio;
	
	//Contructor sin parametros
	public Producto() {
		super();
	}

	//Contructor con nompro y precio
	public Producto(String nompro, Double precio) {
		super();
		this.nompro = nompro;
		this.precio = precio;
	}
	
	

	public Producto(int productoid, String nompro, Double precio) {
		super();
		this.productoid = productoid;
		this.nompro = nompro;
		this.precio = precio;
	}

	public int getProductoid() {
		return productoid;
	}

	public void setProductoid(int productoid) {
		this.productoid = productoid;
	}

	public String getNompro() {
		return nompro;
	}

	public void setNompro(String nompro) {
		this.nompro = nompro;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nompro == null) ? 0 : nompro.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + productoid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nompro == null) {
			if (other.nompro != null)
				return false;
		} else if (!nompro.equals(other.nompro))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (productoid != other.productoid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [productoid=" + productoid + ", nompro=" + nompro
				+ ", precio=" + precio + "]";
	}
	
}
