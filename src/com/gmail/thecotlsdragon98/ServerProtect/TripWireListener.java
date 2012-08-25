package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class TripWireListener implements Listener
{
	ServerProtect plugin;
	public TripWireListener(ServerProtect instance){
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void TripWires(BlockPlaceEvent event){
		if(event.getBlockPlaced().getType() == Material.TRIPWIRE && !event.getPlayer().hasPermission("serverprotect.tripwire")){
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.tripwire").replaceAll("&([a-z0-9])", "/u00A7$1")));
		}
		else if(event.getBlockPlaced().getType() == Material.TRIPWIRE_HOOK && !event.getPlayer().hasPermission("serverprotect.tripwire")){
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.tripwire").replaceAll("&([a-z0-9])", "/u00A7$1")));
		}
	}
}
