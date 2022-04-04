package com.linkedin.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.linkedin.ejb.CatalogItem;
import com.linkedin.ejb.CatalogLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class CatalogItemFormBean implements Serializable {
	private static final long serialVersionUID = -3563337822452565118L;
	@Inject
	private CatalogLocal catalogBean;
	@Inject
	private InventoryService inventoryService;
	private CatalogItem item = new CatalogItem();
	private List<CatalogItem> itemsList = new ArrayList<>();
	public String addItem() {
		this.catalogBean.addItem(new CatalogItem(this.item.getName(), this.item.getManufacturer(), this.item.getDescription(), this.item.getAvailableDate()));
		//NEW ROW
		this.inventoryService.createItem(this.item.getItemId(), this.item.getName());
		return "list?faces-redirect=true";
	}
	//This loads the bean data into the local variable. Need to <f:metadata><f:viewAction> to the jsf page list.xhtml. 
	public void init() {
		this.itemsList = catalogBean.getItems();

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
