package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class FireBlockListener implements Listener
{
	ServerProtect plugin;
	public FireBlockListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void FireBlock(BlockPlaceEvent event)
	{
		if(event.getBlockPlaced().getType() == Material.FIRE && !event.getPlayer().hasPermission("serverprotect.fire"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.fire")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
