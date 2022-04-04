package com.linkedin.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class Catalog
 */
@RequestScoped
@LocalBean	
public class Catalog implements CatalogLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public Catalog() {

    }

	@Override
	public List<CatalogItem> getItems() {
		return this.entityManager.createQuery("select c from CatalogItem c",CatalogItem.class).getResultList();
	}

	@Override
	public void addItem(CatalogItem item) {
		this.entityManager.persist(item);		
	}

}
