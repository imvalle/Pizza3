package clases;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletPrincipal
 */
@WebServlet("/ServletPrincipal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	public HttpSession sesion;
	public RequestDispatcher rd=null;
	public HashMap <Integer, Producto> map;
	HashMap<String, Integer> mp;
	String[] articulos;
	ClienteDaoImp cdi;
	ProductoDaoImp pdi;
	VentaDaoImp vdi;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPrincipal() {
		super();
		// TODO Auto-generated constructor stub
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

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		conectar();
		pdi = new ProductoDaoImp(con);
		mp = new HashMap <String, Integer> ();
		cdi = new ClienteDaoImp(con);
		vdi = new VentaDaoImp(con);
	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();

		sesion = request.getSession();
		
		if(sesion.isNew()){

			iniciarMapa();
			
		}

		try {
			pdi.listar(sesion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		String opcion = request.getParameter("opcion");
	

		switch (opcion) {
		
		case "0":
			 rd =  request.getRequestDispatcher("nosotros.jsp");
			 rd.forward(request, response);
			break;
		case "1":
			response.sendRedirect("productos.jsp");
			break;
		case "2":
			response.sendRedirect("login.jsp");
			break;
		case "3":
			String nif = request.getParameter("password");
			String nombre = request.getParameter("username");
			cdi.comprobarCliente(nif, nombre, sesion);
			if(sesion.getAttribute("cliente")!=null){
				/**
				 * Solucion al problema de iniciar los pedidos.
				 * Funciona Iniciar el Map, antes de redirigir.
				 */
				mp.clear();
				iniciarMapa();
				response.sendRedirect("comprar.jsp");
			}
			cdi.getCliente(sesion);
			break;
		case "4":
			// averiguar el producto seleccionado
			articulos = request.getParameterValues("articulo");
			// actualizar el mapa: sumando uno al producto seleccionado
			// actualizar la sesion: guardar el atributo carrito con el
			// valor del mapa
            System.out.println(articulos);
			if (articulos != null) {
				for (String s : articulos) {
					if (mp.containsKey(s)) {
						// Sumamos uno al valor del mapa con clave s
						Integer valor = mp.get(s) + 1;
						mp.put(s, valor);		
					}
					// Guardamos el atributo carrito con el valor
					sesion.setAttribute("carrito", mp);
				}	
			}	
			response.sendRedirect("comprar.jsp");
			break;

		case "5":
			vdi.factura(sesion);
			response.sendRedirect("sucompra.jsp");
			mp.clear();
			iniciarMapa();
			//sesion.invalidate();
			break;

		case "6":
			mp.clear();
			// Hemos borrado el mapa, y lo volvemos a crear.
			//Hay un problema con la sesion, intento reiniciar
			sesion = request.getSession();
			iniciarMapa();
			response.sendRedirect("comprar.jsp");
			break;

		case "7":
			sesion.invalidate();
			sesion = request.getSession();
			response.sendRedirect("login.jsp");
			break;

		case "8":
			request.setAttribute("articulos", mp);
			RequestDispatcher a = request
					.getRequestDispatcher("carrito.jsp");
			a.forward(request, response);
			break;
	
		case "9":
			response.sendRedirect("registro.jsp");
			break;
	
		case "10":
			cdi.save(new Cliente(request.getParameter("newuser"), request.getParameter("newdom"),request.getParameter("newnif")));
			response.sendRedirect("login.jsp");
			break;
		}

	}
	
	public void verCarrito(HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String enlacecss = "<link href='estilo.css' rel='stylesheet' type='text/css'>";

		Iterator<Entry<String, Integer>> lista = mp.entrySet().iterator();

		out.print("<html><head><title>Carrito</title>" + enlacecss
				+ "</head><body>");
		out.print("<h1>Su compra</h1>");
		out.print("<table border='1'><tr><th>Articulo</th><th>Cantidad</th></tr>");

		// Recorremos el mapa
		while (lista.hasNext()) {
			Map.Entry<String, Integer> entry = lista.next();
			// Si el valor es mayor de 0, lo imprimimos
			if (entry.getValue() > 0) {
				out.print("<tr>");
				out.print("<td>" + entry.getKey() + "</td>");
				out.print("<td>" + entry.getValue()+ "</td>");
				out.print("</tr>");
			}
		}
		out.print("</table></body></html>");
	}

	public void iniciarMapa() {

		mp.put("margarita", 0);
		mp.put("carbonara", 0);
		mp.put("4quesos", 0);
		mp.put("serrana", 0);

	}
	
	public void cargarProductos(HttpSession sesion){
		
		for(int i=0; i< pdi.verProductos(sesion).size(); i++){
			  map.put(pdi.verProductos(sesion).get(i).getProductoid(), pdi.verProductos(sesion).get(i));
			  sesion.setAttribute("map", map);
			}
		
	}

}
