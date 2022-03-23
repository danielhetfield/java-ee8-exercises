package com.linkedin.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class Catalog
 */
@Singleton
@LocalBean
public class Catalog implements CatalogLocal {
	private List<CatalogItem> items = new ArrayList<>();
	
	
    /**
     * Default constructor. 
     */
    public Catalog() {

    }

	@Override
	public List<CatalogItem> getItems() {
		return items;
	}

	@Override
	public void addItem(CatalogItem item) {
		items.add(item);		
	}

}
