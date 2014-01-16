import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import util.Utilidades;
import model.Genero;
import model.Midia;
import dao.GeneroDAO;
import dao.MidiaDAO;


public class Principal {
	
	
	
	public static void main(String args[]) throws IOException
	{		
		MidiaDAO m = new MidiaDAO();	
		
		List<Midia> midias = m.listarMusicasPorGenero(new Long(2));
		
		for(Midia mi : midias)
		{
			System.out.println(mi.getGenero().getNmGenero());
		}
	}

}
