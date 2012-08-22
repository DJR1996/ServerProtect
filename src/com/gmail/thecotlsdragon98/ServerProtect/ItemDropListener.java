package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener
{
	ServerProtect plugin;
	public ItemDropListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler
	public void Drops(PlayerDropItemEvent event)
	{
		if(!event.getPlayer().hasPermission("serverprotect.drop"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.permissions.drops")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
	@EventHandler
	public void NaturalDrops(ItemSpawnEvent item)
	{
		if(plugin.getConfig().getBoolean("prevent.natural-item-drops"))
		{
			item.setCancelled(true);
		}
	}
}