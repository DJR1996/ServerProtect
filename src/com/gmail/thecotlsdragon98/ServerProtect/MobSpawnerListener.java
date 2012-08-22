package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MobSpawnerListener implements Listener 
{
	ServerProtect plugin;
	public MobSpawnerListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void MobSpawner(BlockPlaceEvent event)
	{
		if(event.getBlockPlaced().getType() == Material.MOB_SPAWNER && !event.getPlayer().hasPermission("serverprotect.mobspawner"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.mobspawner")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
