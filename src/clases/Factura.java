package clases;

import java.sql.Timestamp;
import java.util.HashMap;

public class Factura {

	private int facturaid;
	private int clienteid;
	private Timestamp fecha;
	private HashMap <String, Integer> productos;
	private double total;
	
	public Factura() {
		super();
	}

	public Factura(int factnum, int clienteid, Timestamp fecha,
			HashMap <String, Integer> productos, double total) {
		super();
		this.facturaid = factnum;
		this.clienteid = clienteid;
		this.fecha = fecha;
		this.productos = productos;
		this.total = total;
	}


	public int getFacturaid() {
		return facturaid;
	}

	public void setFacturaid(int facturaid) {
		this.facturaid = facturaid;
	}

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public HashMap<String, Integer> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<String, Integer> productos) {
		this.productos = productos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [factnum=" + facturaid + ", clienteid=" + clienteid
				+ ", fecha=" + fecha + ", productos=" + productos + ", total="
				+ total + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clienteid;
		result = prime * result + facturaid;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result
				+ ((productos == null) ? 0 : productos.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Factura other = (Factura) obj;
		if (clienteid != other.clienteid)
			return false;
		if (facturaid != other.facturaid)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		if (Double.doubleToLongBits(total) != Double
				.doubleToLongBits(other.total))
			return false;
		return true;
	}
	
	
}
