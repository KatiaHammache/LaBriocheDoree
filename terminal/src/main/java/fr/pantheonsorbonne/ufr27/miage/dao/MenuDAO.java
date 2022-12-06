package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Menu;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import java.util.Collection;

public interface MenuDAO {

    Menu findSingleMenu(Integer menuId);

    Collection<Menu> findAllMenu();

    Boolean availableMenu();
}
