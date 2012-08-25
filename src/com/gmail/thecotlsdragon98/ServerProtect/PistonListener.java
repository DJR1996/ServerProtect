package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PistonListener implements Listener
{
	ServerProtect plugin;
	public PistonListener(ServerProtect instance){
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Piston(BlockPlaceEvent event){
		if(event.getBlockPlaced().getType() == Material.PISTON_BASE && !event.getPlayer().hasPermission("serverprotect.pistons")){
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.pistons").replaceAll("&([a-z0-9])", "\u00A7$1")));
		}
		else if(event.getBlockPlaced().getType() == Material.PISTON_STICKY_BASE && !event.getPlayer().hasPermission("serverprotect.pistons")){
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.pistons").replaceAll("&([a-z0-9])", "\u00A7$1")));
		}
	}
}
