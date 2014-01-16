package dao;

import java.util.List;

import util.UtilEntityManager;
import model.Genero;
import model.Midia;

public class GeneroDAO extends UtilEntityManager{
	
	public GeneroDAO()
	{
		entityManager = super.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
    public List<Genero> listarGeneros() {
        return entityManager.createQuery("FROM " + Genero.class.getName() + " genero order by genero.nmGenero")
                .getResultList();
    }
	
	public Genero findGeneroById(Long cdGenero) {
    	String sql = "FROM " + Genero.class.getName() + " genero where cd_genero = " + cdGenero;
        return (Genero) entityManager.createQuery(sql).getResultList().get(0);
    }

}
