package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class ClienteDaoImp implements ClienteDao{
	
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public ClienteDaoImp(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public void save(Cliente cl) {
		// TODO Auto-generated method stub
		String sql = "insert into clientesp (nombre, nif, domicilio) "
	            +" values (?,?,?)";
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, cl.getNombre());
		ps.setString(2, cl.getNif());
		ps.setString(3, cl.getDireccion());
		ps.executeUpdate();
		
		System.out.println("Nuevo cliente agregado");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public void save(HttpSession sesion) {
		// TODO Auto-generated method stub
		String sql = "inser into clientesp (nombre, nif, domicilio) "
		            +" values (?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        
		
	}

	@Override
	public void comprobarCliente(String nifc, String nomc,
			HttpSession sesion) {
		// TODO Auto-generated method stub
		Cliente cliente = null;
		
		String sql = "select * from clientesp where nif=? and nombre=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nifc);
			ps.setString(2, nomc);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				if(rs.getString("nif").equalsIgnoreCase(nifc) && rs.getString("nombre").equalsIgnoreCase(nomc)){
					int clienteid = rs.getInt("clienteid");
					String nombre = rs.getString("nombre");
					String domicilio = rs.getString("domicilio");
					String nif = rs.getString("nif");
					
					cliente = new Cliente(clienteid, nombre, domicilio, nif);
					sesion.setAttribute("cliente", cliente);
				}
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void getCliente(HttpSession sesion) {
		// TODO Auto-generated method stub
		Cliente cliente = (Cliente) sesion.getAttribute("cliente");
		System.out.println("El clientes es: " +cliente.getNombre());
	}
	
	

}
