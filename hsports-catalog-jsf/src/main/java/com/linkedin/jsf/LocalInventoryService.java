package com.linkedin.jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.inject.Alternative;

@ApplicationScoped
//@Alternative
public class LocalInventoryService implements InventoryService {

	private static final long serialVersionUID = 7537143093264901851L;
	
	private Map<Long, InventoryItem> items = new HashMap<>();
	
	
	@Override
	@ILoggingInterceptor
	public void createItem(Long catalogItemId, String name) {
		long newItemId = items.size() + 1;		
		this.items.put(newItemId, new InventoryItem(newItemId, catalogItemId, name, 0L));
		this.printInventory();
	}

	private void printInventory() {
		//ADDED THIS TO SEE WHAT IS IN THE LIST
		System.out.println("Local inventory contains:");
		for(Entry<Long,InventoryItem> entry: this.items.entrySet()) {
			System.out.println(entry.getValue().getName());
		}
		
	}

	@Override
	public Long getQuantity(Long catalogItemId) {
		return 0L;
	}

}
