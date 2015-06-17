package clases;


import javax.servlet.http.HttpSession;

public interface ClienteDao {
	
	public void save (Cliente cl);

	public void save (HttpSession sesion);
	
	public void getCliente (HttpSession sesion);
	
	public void comprobarCliente (String nif, String nombre, HttpSession sesion);

}
