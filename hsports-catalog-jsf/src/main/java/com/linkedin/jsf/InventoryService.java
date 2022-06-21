package com.linkedin.jsf;

import java.io.Serializable;
import java.util.concurrent.Future;

public interface InventoryService extends Serializable {

	public void createItem(Long catalogItemId, String name);
	
	public Long getQuantity(Long catalogItemId);
	//Added this to support async calls
	public Future<InventoryItem> asyncGetQuantity(Long catalogItemId);
	
}
