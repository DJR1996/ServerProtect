package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpawnEggListener implements Listener
{
	ServerProtect plugin;
	public SpawnEggListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void SpawnEgg(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getMaterial() == Material.MONSTER_EGG && !event.getPlayer().hasPermission("serverprotect.spawneggs"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.spawnereggs").replaceAll("&([a-z0-9])", "\u00A7$1")));
		}
	}
}