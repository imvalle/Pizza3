package clases;

import java.sql.Timestamp;

public class Venta {
	
	private int clienteid;
	private int productoid;
	private int cantidad;
	private Timestamp fecha;
	private int facturaid;
	
	//Constructor sin parametros
	public Venta() {
		super();
		this.clienteid = 0;
		this.productoid = 0;
		this.cantidad = 0;
		this.fecha = null;
		this.facturaid = 0;
	}
	
	
    //Constructor con todos los parametros
	public Venta(int clienteid, int productoid, int cantidad, Timestamp fecha,
			int facturaid) {
		super();
		this.clienteid = clienteid;
		this.productoid = productoid;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.facturaid = facturaid;
	}



	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public int getProductoid() {
		return productoid;
	}

	public void setProductoid(int productoid) {
		this.productoid = productoid;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getFacturaid() {
		return facturaid;
	}

	public void setFacturaid(int facturaid) {
		this.facturaid = facturaid;
	}

	@Override
	public String toString() {
		return "Venta [clienteid=" + clienteid + ", productoid=" + productoid
				+ ", cantidad=" + cantidad + ", fecha=" + fecha
				+ ", facturaid=" + facturaid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + clienteid;
		result = prime * result + facturaid;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		Venta other = (Venta) obj;
		if (cantidad != other.cantidad)
			return false;
		if (clienteid != other.clienteid)
			return false;
		if (facturaid != other.facturaid)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (productoid != other.productoid)
			return false;
		return true;
	}
	
	
}
