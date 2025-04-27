package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.Dao_usuario;

public class Usuario {

	private int id;
	private String nombre;
	private String apellido_1;
	private String apellido_2;
	private String dni;
	private String cargo;
	private String sexo;
	
	public Usuario() {

	}

	public Usuario(int id, String nombre, String apellido_1, String apellido_2, String dni, String cargo,
			String sexo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido_1 = apellido_1;
		this.apellido_2 = apellido_2;
		this.dni = dni;
		this.cargo = cargo;
		this.sexo = sexo;
	}

	public Usuario(String nombre, String apellido_1, String apellido_2, String dni, String cargo, String sexo) {
		super();
		this.nombre = nombre;
		this.apellido_1 = apellido_1;
		this.apellido_2 = apellido_2;
		this.dni = dni;
		this.cargo = cargo;
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido_1;
	}

	public void setApellido1(String apellido_1) {
		this.apellido_1 = apellido_1;
	}

	public String getApellido2() {
		return apellido_2;
	}

	public void setApellido2(String apellido_2) {
		this.apellido_2 = apellido_2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	//------ Aqui van los Metodos del Objeto Usuario
	
	public void obtenerPorId(int id) throws SQLException {
		
		Dao_usuario dao = new Dao_usuario();
		Usuario aux = dao.obtenerPorID(id);
		
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setApellido1(aux.getApellido1());
		this.setApellido2(aux.getApellido2());
		this.setDni(aux.getDni());
		this.setCargo(aux.getCargo());
		this.setSexo(aux.getSexo());
	}
	
	
	public String dameJson() {
		String json = "";
		
		Gson gson = new Gson();
		
		json = gson.toJson(this);
		return json;
		
	}
	
	public void actualizar() throws SQLException {
		
		Dao_usuario dao = new Dao_usuario();
		dao.actualizar(this);
	}
	
	public void insertar() throws SQLException {
		
		Dao_usuario dao = new Dao_usuario();
		dao.insertar(this);
	}
	
	
	public void borrar(int id) throws SQLException {
		Dao_usuario dao = new Dao_usuario();
		dao.borrar(id);
		
		
	}
	
	//----- Fin Metodos del objeto Usuario
	@Override
	public String toString() {
		return "Dao_usuario [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido_1 + ", apellido2=" + apellido_2
				+ ", dni=" + dni + ", cargo=" + cargo + ", sexo=" + sexo + "]";
	}	

}
