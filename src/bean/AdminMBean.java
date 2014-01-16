package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.GeneroDAO;
import dao.MidiaDAO;
import model.Genero;
import model.Midia;

@ManagedBean(name="adminMB")
@RequestScoped
public class AdminMBean {
	
	private Midia midia;
	private List<Genero> generos;
	
	public AdminMBean()
	{
		midia = new Midia();
		midia.setGenero(new Genero());
		generos = new GeneroDAO().listarGeneros();
	}

	public Midia getMidia() {
		return midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
	}
	
	public List<Genero> getGeneros()
	{
		return generos;
	}
	
	public void save()
	{
		midia.setTpMidia(1);
		new MidiaDAO().persist(midia);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inserido com Sucesso!", "Musica Salva com Sucesso!"));
		midia = new Midia();
	}

}
