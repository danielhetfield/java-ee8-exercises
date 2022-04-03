package com.linkedin.jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.inject.Alternative;

@ApplicationScoped
@RemoteService
//@Alternative
public class RemoteInventoryService implements InventoryService {

	private static final long serialVersionUID = 1846773733313939206L;
	private Map<Long, InventoryItem> items = new HashMap<Long, InventoryItem>();

	@Override
	@ILoggingInterceptor
	public void createItem(Long catalogItemId, String name) {
		long inventoryItemId = items.size() + 1;
		this.items.put(inventoryItemId, new InventoryItem(inventoryItemId, catalogItemId, name, 0L));
		this.printInventory();
	}

	public void printInventory() {
		System.out.println("Remote inventory contains:");
		for (Entry<Long, InventoryItem> entry : this.items.entrySet()) {
			System.out.println(entry.getValue().getName());
		}
	}

	@Override
	public Long getQuantity(Long catalogItemId) {
		Optional<InventoryItem> optInvItem = this.items.entrySet().stream().filter(i -> i.getKey().equals(catalogItemId)).map(Map.Entry::getValue).findFirst();
		if(optInvItem.isPresent())
			return optInvItem.get().getQuantity();
		return 0L;
	}
}