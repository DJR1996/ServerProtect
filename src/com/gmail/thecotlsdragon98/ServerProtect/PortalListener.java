package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PortalListener implements Listener
{
	ServerProtect plugin;
	public PortalListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void PortalPlace(BlockPlaceEvent event)
	{
		if(event.getBlockPlaced().getType() == Material.PORTAL && !event.getPlayer().hasPermission("serverprotect.netherportals"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(plugin.getConfig().getString("messages.blacklist.netherportal"));
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void EndPortalPlace(BlockPlaceEvent event)
	{
		if(event.getBlockPlaced().getType() == Material.ENDER_PORTAL && !event.getPlayer().hasPermission("serverprotect.endportals"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(plugin.getConfig().getString("messages.blacklist.endportal"));
		}
	}
}
