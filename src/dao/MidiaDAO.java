package dao;
import model.Midia;

import java.util.List;
 


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.UtilEntityManager;
 
public class MidiaDAO extends UtilEntityManager{
 
    public MidiaDAO() {
        entityManager = super.getEntityManager();
    }
 
    public Midia getById(final Long cdMidia) {
        return entityManager.find(Midia.class, cdMidia);
    }
 
    @SuppressWarnings("unchecked")
    public List<Midia> listarMusicasPorGenero(Long cdGenero) {
    	String sql = "FROM " + Midia.class.getName() + " musica where musica.tpMidia = 1 ";
    	
    	if(cdGenero != 0)
    	{
    		sql += " and musica.genero.cdGenero=" + cdGenero;
    	}
    	sql += " order by musica.nmArtista, musica.nmMusica ";
    	
        return entityManager.createQuery(sql).getResultList();
    }
 
    public void persist(Midia midia) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(midia);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}