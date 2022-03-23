package com.linkedin.jsf;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.linkedin.ejb.CatalogItem;
import com.linkedin.ejb.CatalogLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class CatalogItemFormBean implements Serializable {
	private static final long serialVersionUID = -3563337822452565118L;
	@EJB
	private CatalogLocal catalogBean;	
	private CatalogItem item = new CatalogItem();
	private List<CatalogItem> itemsList = new ArrayList<>();
	public String addItem() {
		long itemId = this.catalogBean.getItems().size() + 1;
		this.catalogBean.addItem(new CatalogItem(itemId, this.item.getName(), this.item.getManufacturer(), this.item.getDescription(), this.item.getAvailableDate()));
		this.catalogBean.getItems().stream().forEach(i -> System.out.println(i.getName()));
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
