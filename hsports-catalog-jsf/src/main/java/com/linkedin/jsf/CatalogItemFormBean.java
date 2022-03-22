package com.linkedin.jsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class CatalogItemFormBean implements Serializable {

	private static final long serialVersionUID = -3563337822452565118L;

	private CatalogItem item = new CatalogItem();
	
	private List<CatalogItem> itemsList = new ArrayList<>();

	
	public String addItem() {
		//Add a fictitious id
		long itemId = this.itemsList.size() + 1;
		//Create item and add to list
		this.itemsList.add(new CatalogItem(itemId, this.item.getName(), this.item.getManufacturer(), this.item.getDescription(), this.item.getAvailableDate()));
		//Print for viewing purposes
		this.itemsList.stream().forEach(i -> System.out.println(i.getName()));
		//Return path to the next facelet
		return "list?faces-redirect=true";
	}
	
	public CatalogItem getItem() {
		return item;
	}

	public void setItem(CatalogItem item) {
		this.item = item;
	}

	public List<CatalogItem> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<CatalogItem> itemsList) {
		this.itemsList = itemsList;
	}
	
	
	
}
