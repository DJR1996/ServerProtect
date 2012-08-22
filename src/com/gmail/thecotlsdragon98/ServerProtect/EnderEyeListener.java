package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

class EnderEyeListener implements Listener
{
	ServerProtect plugin;
	public EnderEyeListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void EnderEye(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			if(event.getMaterial() == Material.EYE_OF_ENDER && event.getPlayer().hasPermission("serverprotect.endereye"))
			{
				event.setCancelled(true);
				event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.endereye")).replaceAll("&([a-z0-9])", "\u00A7$1"));
			}
		}
	}
}
