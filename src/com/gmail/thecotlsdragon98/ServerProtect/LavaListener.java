package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class LavaListener implements Listener 
{
	ServerProtect plugin;
	public LavaListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void LavaBucket(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getMaterial() == Material.LAVA_BUCKET && !event.getPlayer().hasPermission("serverprotect.lavabucket"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.lavabucket")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
		else if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getMaterial() == Material.LAVA_BUCKET && !event.getPlayer().hasPermission("serverprotect.lavabucket"))
		{
			event.setCancelled(true);
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Lava1(BlockPlaceEvent lava1)
	{
		if(lava1.getBlockPlaced().getType() == Material.LAVA && !lava1.getPlayer().hasPermission("serverprotect.lava"))
		{
			lava1.setCancelled(true);
			lava1.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.lava")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void lava2(BlockPlaceEvent lava2)
	{
		if(lava2.getBlockPlaced().getType() == Material.STATIONARY_LAVA && !lava2.getPlayer().hasPermission("serverprotect.lava"))
		{
			lava2.setCancelled(true);
			lava2.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.lava")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
