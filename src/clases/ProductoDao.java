package clases;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;


public interface ProductoDao {
	
	public ArrayList<Producto> verProductos (HttpSession sesion);
    
	void listaProductos(HttpSession sesion);

}
