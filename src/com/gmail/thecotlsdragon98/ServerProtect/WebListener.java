package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class WebListener implements Listener
{
	ServerProtect plugin;
	public WebListener(ServerProtect instance){
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Web(BlockPlaceEvent event){
		if(event.getBlockPlaced().getType() == Material.WEB && !event.getPlayer().hasPermission("serverprotect.webs")){
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.webs").replaceAll("&([a-z0-9])", "/u00A7$1")));
		}
	}
}
