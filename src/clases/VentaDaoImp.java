package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

public class VentaDaoImp implements VentaDao {

	public Connection con;
	public PreparedStatement ps, ps_aux;
	public ResultSet rs, rs_aux;
	int facturaid = 0;

	public VentaDaoImp(Connection con) {
		super();
		this.con = con;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void factura(HttpSession sesion) {
		// TODO Auto-generated method stub
		// Variables

		int clienteid = 0;
		
		// Instancias para la facturacion
		Factura factura = null;
		
		
		//Obtenemos el numero de factura
		try {
			ps = con.prepareStatement("select MAX(facturaid) as facturaid from ventas");
			rs = ps.executeQuery();
			if(rs.next())
			facturaid = rs.getInt("facturaid");
            facturaid++;
			System.out.println(facturaid);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Cliente cl = (Cliente) sesion.getAttribute("cliente");

		HashMap<String, Integer> venta = new HashMap<String, Integer>();
		HashMap<Integer, Producto> productos = new HashMap<Integer, Producto>();

		if (sesion.getAttribute("carrito") != null) {

			venta.putAll((HashMap <String, Integer>) sesion
					.getAttribute("carrito"));
		}

		if (sesion.getAttribute("lista") != null) {

			productos.putAll((HashMap <Integer, Producto>) sesion
					.getAttribute("lista"));
		}
		// Datos del cliente de la sesion
		String nomf = cl.getNombre();
		String niff = cl.getNif();

		sesion.getAttribute("lista");
		String sql = "select * from clientesp where nombre=? and nif=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nomf);
			ps.setString(2, niff);
			rs = ps.executeQuery();

			while (rs.next()) {
				
				//String nom = rs.getString("nombre");
				//String dom = rs.getString("domicilio");
				//String nifc = rs.getString("nif");
				clienteid = rs.getInt("clienteid");
			}//cierre while

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Datos de los productos y la venta
		
		double total=0.0;
		
		Timestamp fecha = new Timestamp(new Date().getTime());
		
		String vta = "insert into ventas (clienteid, productoid, cantidad, fecha, facturaid)"
				+ " values(?,?,?,?,?)";
	
		Iterator<Entry<Integer, Producto>> it = productos.entrySet().iterator();
		
		while (it.hasNext()) {
		  Map.Entry <Integer, Producto> me = (Map.Entry <Integer, Producto>)it.next();
		  me.getKey();
		  String art = (String) me.getValue().getNompro();
 
		  if(venta.containsKey(art) && venta.get(art)>0){
			  
		    total += me.getValue().getPrecio()*venta.get(art);
		  
		  try {
				ps = con.prepareStatement(vta);
				ps.setInt(1, clienteid);
				ps.setInt(2, me.getValue().getProductoid());
				ps.setInt(3, venta.get(art));
				ps.setTimestamp(4, fecha);
				ps.setInt(5, facturaid);
				ps.executeUpdate();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }//fin del if
		}//fin del while

		factura = new Factura(facturaid, clienteid, fecha, venta, total);
		sesion.setAttribute("factura", factura);

	}

	@Override
	public void saveVta(Venta venta) {
		// TODO Auto-generated method stub

	}

}
