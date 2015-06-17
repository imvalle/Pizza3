package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Principal {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	

	public Principal() {
		con = null;
		ps = null;
		rs = null;
		conectar();
	}

	public void conectar() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://151.80.142.105:3306/isabel_14";
			con = DriverManager.getConnection(url, "isabel_14", "isabel_14");

			System.out.println("Conexion realizada");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public void cerrarconexion() {
		try {
			con.close();
			System.out.println("Conexion cerrada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String consulta = "select * from productosp";
		
		Principal p = new Principal();
		
	    try {
	    	
			p.ps = p.con.prepareStatement(consulta);
			p.rs = p.ps.executeQuery();
			
			while(p.rs.next()){
				
				System.out.println(p.rs.getObject(1) + " " +p.rs.getObject(2)+ " " +p.rs.getObject(3));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    HashMap <Integer, Producto> mapa = new HashMap <Integer, Producto> ();
	    
	    mapa.put(1, new Producto (1, "uno", 10.25));
	    mapa.put(2, new Producto (2, "dos", 12.25));
	    mapa.put(3, new Producto (3, "tres", 12.25));
	    
	    System.out.println(mapa);
	    System.out.println(mapa.get(1).getNompro());
	    System.out.println(mapa.get(1).getProductoid());
	    System.out.println(mapa.get(1).getPrecio());
	}

}
