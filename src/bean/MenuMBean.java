package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.webapp.FacetTag;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import dao.GeneroDAO;
import model.Genero;

@ManagedBean(name="menuMB")
@RequestScoped
public class MenuMBean {
	
	private MenuModel model;
	
	public MenuMBean()
	{
		model = new DefaultMenuModel();
		
		MenuItem item = new MenuItem();
		item.setValue("Home");
		item.setUrl("/home.xhtml");
		model.addMenuItem(item);
		
		Submenu submenu = new Submenu();
		submenu.setLabel("Music");	
		
		item = new MenuItem();
		item.setValue("All");
		item.setUrl("/musica.xhtml?cdGenero=0");
		
		submenu.getChildren().add(item);
		
		for(Genero g : new GeneroDAO().listarGeneros())
		{
			item = new MenuItem();
			item.setValue(g.getNmGenero());
			item.setUrl("/musica.xhtml?cdGenero=" + String.valueOf(g.getCdGenero()));
			submenu.getChildren().add(item);
		}		
		model.addSubmenu(submenu);		
	}
	
	public MenuModel getModel()
	{
		return model;
	}

}
