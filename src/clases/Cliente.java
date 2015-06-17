package clases;

public class Cliente {
	
	private int clienteid;
	private String nombre;
	private String domicilio;
	private String nif;
	
	//Constructor sin parametros
	public Cliente() {
		super();
	}
	
	//Constructor conn todos los parametros
	public Cliente(int clienteid, String nombre, String direccion, String nif) {
		super();
		this.clienteid = clienteid;
		this.nombre = nombre;
		this.domicilio = direccion;
		this.nif = nif;
	}


	public Cliente(String nombre, String direccion, String nif) {
		super();
		
		this.nombre = nombre;
		this.domicilio = direccion;
		this.nif = nif;
	}



	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	//Constructor con nombre y direccion
	public Cliente(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.domicilio = direccion;
	}

	
	public int getClienteid() {
		return clienteid;
	}
	
	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return domicilio;
	}
	public void setDireccion(String direccion) {
		this.domicilio = direccion;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clienteid;
		result = prime * result
				+ ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Cliente other = (Cliente) obj;
		if (clienteid != other.clienteid)
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cliente [clienteid=" + clienteid + ", nombre=" + nombre
				+ ", direccion=" + domicilio + ", nif=" + nif + "]";
	}


	

}
