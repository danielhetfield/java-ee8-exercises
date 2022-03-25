package com.linkedin.jsf;

import java.time.LocalDateTime;

//import javax.enterprise.inject.Produces;

public class InventoryServiceFactory {
	
	//@Produces
	public InventoryService createInstance()
	{
		InventoryService invSvc = null;
		
		if(LocalDateTime.now().getHour() > 12)
		{
			invSvc = new LocalInventoryService();
		}
		else
		{
			invSvc = new RemoteInventoryService();
		}
		
		return invSvc;
	}
}
