package TRESENRAYA;

public class prueba {

	public static void main(String[] args) {
		InicioSesion inicio = new InicioSesion();
		Menu menu = new Menu();
		Estadisticas estats = new Estadisticas();
		
		menu.setInicio(inicio);
		menu.setEstadisticas(estats);
		inicio.setMenu(menu);
		estats.setMenu(menu);
		
	}

}
