package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

class EnderPearlListener implements Listener
{
	ServerProtect plugin;
	public EnderPearlListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void EnderPearl(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			if(event.getMaterial() == Material.ENDER_PEARL && !event.getPlayer().hasPermission("serverprotect.enderpearl"))
			{
				event.setCancelled(true);
				event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.enderpearl")).replaceAll("&([a-z0-9])", "\u00A7$1"));
			}
		}
	}
}
