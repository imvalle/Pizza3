package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;



public class ProductoDaoImp implements ProductoDao {

	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;

	public ProductoDaoImp(Connection con) {

		this.con = con;
	}

	@Override
	public ArrayList<Producto> verProductos(HttpSession sesion) {
		// TODO Auto-generated method stub
		ArrayList <Producto> carta = new ArrayList <Producto> ();
		String sql = "select * from productosp";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				
				carta.add(new Producto(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		sesion.setAttribute("carta", carta);
		return carta;
	
	}
 
	@Override
	public void listaProductos(HttpSession sesion){
		
		HashMap <Integer, Producto> listaProductos = new HashMap <Integer, Producto> ();
		String sql = "select * from productosp";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				
				listaProductos.put(rs.getInt(1),(new Producto(rs.getInt(1), rs.getString(2), rs.getDouble(3))));
				sesion.setAttribute("listaProductos", listaProductos);
				System.out.println(listaProductos);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		
	}
/**
 * Este es el método que estoy utilizando para cargar los articulos
 * @param sesion
 * @throws SQLException
 */
public void listar(HttpSession sesion) throws SQLException{
		
		HashMap <Integer, Producto> hm = new HashMap <Integer, Producto> ();
		
		ps=con.prepareStatement("select * from productosp");
		rs=ps.executeQuery();
		
		
		while(rs.next()){
			
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
			hm.put(rs.getInt(1), new Producto(rs.getInt(1), rs.getString(2), rs.getDouble(3)));

		}
		
		sesion.setAttribute("lista", hm);
		
	}
	


}
