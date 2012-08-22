package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class WaterListener implements Listener
{
	ServerProtect plugin;
	public WaterListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Water(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getMaterial() == Material.WATER_BUCKET && !event.getPlayer().hasPermission("serverprotect.waterbucket"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.waterbucket")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
		else if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getMaterial() == Material.WATER_BUCKET && !event.getPlayer().hasPermission("serverprotect.waterbucket"))
		{
			event.setCancelled(true);
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Water2(BlockPlaceEvent water)
	{
		if(water.getBlockPlaced().getType() == Material.WATER && !water.getPlayer().hasPermission("serverprotect.water"))
		{
			water.setCancelled(true);
			water.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.water")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Water3(BlockPlaceEvent water2)
	{
		if(water2.getBlockPlaced().getType() == Material.STATIONARY_WATER && !water2.getPlayer().hasPermission("serverprotect.water"))
		{
			water2.setCancelled(true);
			water2.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.water")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
