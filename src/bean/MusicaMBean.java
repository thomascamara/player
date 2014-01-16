package bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

import dao.MidiaDAO;
import model.Midia;

@ManagedBean(name="musicaMB")
@SessionScoped
public class MusicaMBean implements Serializable{

	private Midia selectedMidia;
	private List<Midia> musicasList;
	private List<Midia> musicasFiltradas;
	
	public MusicaMBean() throws IOException
	{
		listarMusicas();
	}
	
	public Long getPaginaGenero()
	{
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(request.getParameter("cdGenero") != null)
		{
			return Long.parseLong((String) request.getParameter("cdGenero"));
		}
		
		return new Long(0);
	}
	
	public List<Midia> getMusicasList() {
		return musicasList;
	}
	
	public List<Midia> getMusicasFiltradas()
	{
		return musicasFiltradas;
	}
	
	public void setMusicasFiltradas(List<Midia> musicasFiltradas)
	{
		this.musicasFiltradas = musicasFiltradas;
	}

	public Midia getSelectedMidia() {
		return selectedMidia;
	}
	
	public void setSelectedMidia(Midia selectedMidia) {
		this.selectedMidia = selectedMidia;
	}
	
	public void listarMusicas()
	{
		musicasList = new MidiaDAO().listarMusicasPorGenero(getPaginaGenero());
	}

	public void play()
	{
		RequestContext.getCurrentInstance().execute("reproduzir('" + selectedMidia.getDsUrl() +"')");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Loading", selectedMidia.getNmArtista() + " - " + selectedMidia.getNmMusica()));
	}
	
	public void nextTrack()
	{
		DataTable musicTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("form:musicTable");
		
		if(selectedMidia != null)
		{
			for(int pos = 0; pos < musicasList.size(); pos++)
			{
				if(musicasList.get(pos).getDsUrl().equals(selectedMidia.getDsUrl()))
				{
					if(pos < (musicasList.size() - 1))
					{
						RequestContext.getCurrentInstance().execute("reproduzir('" + musicasList.get(pos + 1).getDsUrl() +"')");
						musicTable.setSelection(musicasList.get(pos + 1));
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Loading", musicasList.get(pos+1).getNmArtista() + " - " + musicasList.get(pos+1).getNmMusica()));
					}
					else
					{
						RequestContext.getCurrentInstance().execute("reproduzir('" + musicasList.get(0).getDsUrl() +"')");
						musicTable.setSelection(musicasList.get(0));
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Loading", musicasList.get(0).getNmArtista() + " - " + musicasList.get(0).getNmMusica()));
					}				
					break;
				}
			}
		}
		else
		{
			RequestContext.getCurrentInstance().execute("reproduzir('" + musicasList.get(0).getDsUrl() +"')");
			musicTable.setSelection(musicasList.get(0));
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Loading", musicasList.get(0).getNmArtista() + " - " + musicasList.get(0).getNmMusica()));
		}
	}
	
	public void prevTrack()
	{
		DataTable musicTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("form:musicTable");

		if(selectedMidia != null)
		{
			for(int pos = 0; pos < musicasList.size(); pos++)
			{
				if(musicasList.get(pos).getDsUrl().equals(selectedMidia.getDsUrl()))
				{
					if(pos != 0)
					{
						RequestContext.getCurrentInstance().execute("reproduzir('" + musicasList.get(pos - 1).getDsUrl() +"')");
						musicTable.setSelection(musicasList.get(pos - 1));
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Loading", musicasList.get(pos-1).getNmArtista() + " - " + musicasList.get(pos-1).getNmMusica()));
					}
					else
					{
						RequestContext.getCurrentInstance().execute("reproduzir('" + musicasList.get(musicasList.size()-1).getDsUrl() +"')");
						musicTable.setSelection(musicasList.get(musicasList.size()-1));
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Loading", musicasList.get(musicasList.size()-1).getNmArtista() + " - " + musicasList.get(musicasList.size()-1).getNmMusica()));
					}				
					break;
				}
			}
		}
		else
		{
			RequestContext.getCurrentInstance().execute("reproduzir('" + musicasList.get(0).getDsUrl() +"')");
			musicTable.setSelection(musicasList.get(0));
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Loading", musicasList.get(0).getNmArtista() + " - " + musicasList.get(0).getNmMusica()));
		}
	}
	
	public void playByButton()
	{
		DataTable musicTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("form:musicTable");
		musicTable.setSelection(selectedMidia);
		RequestContext.getCurrentInstance().execute("reproduzir('" + selectedMidia.getDsUrl() +"')");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Loading", selectedMidia.getNmArtista() + " - " + selectedMidia.getNmMusica()));
	}
}

