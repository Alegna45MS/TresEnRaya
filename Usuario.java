package TRESENRAYA;

public class Usuario {
	private String nombre;
	private String contraseña;
	private int puntos;
	
	public Usuario(String nombre,String contrasenya,int puntos) {
		this.nombre=nombre;
		this.contraseña=contrasenya;
		this.puntos=puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Nombre:" + nombre +"  "+"Puntos:" + puntos;
	}
	
}
