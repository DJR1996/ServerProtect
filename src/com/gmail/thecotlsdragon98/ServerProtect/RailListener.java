package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class RailListener implements Listener
{
	ServerProtect plugin;
	public RailListener(ServerProtect instance){
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Rails(BlockPlaceEvent event){
		if(event.getBlockPlaced().getType() == Material.RAILS && !event.getPlayer().hasPermission("serverprotect.rails")){
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.rails").replaceAll("&([a-z0-9])", "\u00A7$1")));
		}
		else if(event.getBlockPlaced().getType() == Material.POWERED_RAIL && !event.getPlayer().hasPermission("serverprotect.rails")){
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.rails").replaceAll("&([a-z0-9])", "\u00A7$1")));
		}
		else if(event.getBlockPlaced().getType() == Material.DETECTOR_RAIL && !event.getPlayer().hasPermission("serverprotect.rails")){
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.rails").replaceAll("&([a-z0-9])", "\u00A7$1")));
		}
	}
}
