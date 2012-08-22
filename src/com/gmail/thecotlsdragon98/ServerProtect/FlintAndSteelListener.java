package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class FlintAndSteelListener implements Listener
{
	ServerProtect plugin;
	public FlintAndSteelListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Flint(BlockPlaceEvent event)
	{
		if(event.getBlockPlaced().getType() == Material.FLINT_AND_STEEL && !event.getPlayer().hasPermission("serverprotect.flintsteel"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.flintsteel")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
