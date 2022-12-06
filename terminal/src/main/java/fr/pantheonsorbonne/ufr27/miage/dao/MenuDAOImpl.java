package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Menu;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@ApplicationScoped
public class MenuDAOImpl implements MenuDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Menu findSingleMenu(Integer menuId){
        return (Menu) em.createQuery("Select m from Menu m where m.id=:menuId").setParameter("menuId", menuId).getSingleResult();

    }

    @Override
    public Collection<Menu> findAllMenu() {
        return em.createQuery("Select m from Menu m").getResultList();
    }

    @Override
    public Boolean availableMenu() {
        return null;
    }


}
