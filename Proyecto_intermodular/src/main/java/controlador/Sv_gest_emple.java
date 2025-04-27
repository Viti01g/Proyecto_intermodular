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
 * Servlet implementation class Sv_gest_emple
 */
public class Sv_gest_emple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sv_gest_emple() {
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

		if(opcion == 2) {
			//proceso logica edicion
		
			int id = Integer.parseInt(request.getParameter("id"));
			Usuario u = new Usuario();
			try {
				u.obtenerPorId(id);
				out.print(u.dameJson());
				System.out.println(u.dameJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else if(opcion==1) {
			Dao_usuario usuarios;
			try {
				usuarios = new Dao_usuario();
				out.print(usuarios.listarJson());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion==3){
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				Dao_usuario usuarios = new Dao_usuario();
				usuarios.borrar(id);
				System.out.println("Estoy borrando " + id);
				System.out.println("Estoy opcion " + opcion);
				out.print(usuarios.listarJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		/*
		PrintWriter out = response.getWriter();
		System.out.println("aqui");
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
				System.out.println("llego");
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
				System.out.println("Estoy borrando " + id);
				System.out.println("Estoy opcion " + opcion);
				out.print(usuarios.listarJson());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String apellido_1 = request.getParameter("primerApellido");
		String apellido_2 = request.getParameter("segundoApellido");
		String dni = request.getParameter("dni");
		String cargo = request.getParameter("cargo");
		String sexo = request.getParameter("sexo");
		String id = request.getParameter("id");
		
		Usuario u;
		
		try {
			
			u = new Usuario(nombre, apellido_1, apellido_2, dni, cargo, sexo);
			if(id == "") {
				
				Dao_usuario dao = new Dao_usuario();
				dao.insertar(u);
				
				
				//u.insertar();
			}else {
				
				int idInt = Integer.parseInt(id);
				u.setId(idInt);		
				u.actualizar();	
				
				//u.actualizar(Integer.parseInt(id));	

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		response.sendRedirect("list_pers.html");
	}
/*
	String nombre = request.getParameter("nombre");
	 String apellido_1 = request.getParameter("primerApellido");
	 String apellido_2 = request.getParameter("segundoApellido");
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
}*/
}
