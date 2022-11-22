package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.ProductGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.Product;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collection;

@RequestScoped
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductGateway productGateway;

    @Override
    public Collection<Product> getAllProduct() {
        //On va dire au ProductGateway que l'on souhaite récupérer la liste de tous les produits
        return productGateway.getAllProduct();
    }
}
