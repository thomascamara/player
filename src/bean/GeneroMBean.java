package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.GeneroDAO;
import model.Genero;

@ManagedBean(name="generoMB")
@RequestScoped
public class GeneroMBean {
	
	private List<Genero> generosLista;
	private Genero genero;
	
	public GeneroMBean()
	{
		generosLista = new GeneroDAO().listarGeneros();
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Genero> getGenerosLista() {
		return generosLista;
	}	

}
