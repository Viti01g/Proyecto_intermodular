package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.Dao_usuario;

/**
 * Servlet implementation class gest_Emple
 */
public class gest_Emple extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public gest_Emple() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int opcion = Integer.parseInt(request.getParameter("op"));
		if (opcion == 2) {
			// Proceso lógica edición
			int id = Integer.parseInt(request.getParameter("id"));
			Usuario u = new Usuario();
			try {
				u.obtenerPorId(id);
				out.print(u.dameJson());
				System.out.println(u.dameJson());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (opcion == 1) {
			Dao_usuario usuarios;
			try {
				usuarios = new Dao_usuario();
				out.print(usuarios.listarJson());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (opcion == 3) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				Dao_usuario usuarios = new Dao_usuario();
				usuarios.borrar(id);
				out.print(usuarios.listarJson());
				response.sendRedirect("index.html");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String nombre = request.getParameter("nombre");
		 String apellido_1 = request.getParameter("apellido_1");
		 String apellido_2 = request.getParameter("apellido_2");
		 String dni = request.getParameter("dni");
		 String cargo = request.getParameter("cargo");
		 String sexo = request.getParameter("sexo");
		 String id = request.getParameter("id");

		 Usuario u;
		 try {
		 u = new Usuario(nombre, apellido_1, apellido_2, dni, cargo, sexo);
			if (id == null || id.isEmpty()) {
				Dao_usuario dao = new Dao_usuario();
				dao.insertar(u);
			} else {
				int idInt = Integer.parseInt(id);
				u.setId(idInt);
				u.actualizar();
			}
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		response.sendRedirect("index.html");
	}

}
