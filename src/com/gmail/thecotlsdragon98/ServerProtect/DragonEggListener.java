package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class DragonEggListener implements Listener
{
	ServerProtect plugin;
	public DragonEggListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void DragonEgg(BlockPlaceEvent event)
	{
		if(event.getBlockPlaced().getType() == Material.DRAGON_EGG && !event.getPlayer().hasPermission("serverprotect.dragonegg"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.dragon-eggs")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
