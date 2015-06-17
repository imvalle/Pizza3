package clases;

import javax.servlet.http.HttpSession;

public interface VentaDao {
	
	public void factura(HttpSession sesion);
	
	public void saveVta(Venta venta);

}
