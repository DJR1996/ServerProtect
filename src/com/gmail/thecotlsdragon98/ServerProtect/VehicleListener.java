package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class VehicleListener implements Listener
{
	ServerProtect plugin;
	public VehicleListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void VehicleCreate(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getMaterial() == Material.MINECART)
		{
			if(!event.getPlayer().hasPermission("serverprotect.minecarts"))
			{
				event.setCancelled(true);
				event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.minecarts").replaceAll("&([a-z0-9])", "\u00A7$1")));
			}
		}
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getMaterial() == Material.BOAT)
		{
			if(!event.getPlayer().hasPermission("serverprotect.boats"))
			{
				event.setCancelled(true);
				event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.boats")).replaceAll("&([a-z0-9])", "\u00A7$1"));
			}
		}
	}
}