package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TNTListener implements Listener
{
	ServerProtect plugin;
	public TNTListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void TNT(BlockPlaceEvent event)
	{
		if(event.getBlockPlaced().getType() == Material.TNT && !event.getPlayer().hasPermission("serverprotect.tnt"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.tnt.place")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}	
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void TNTIgnite(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.TNT && event.getMaterial() == Material.FLINT_AND_STEEL)
		{
			if(!event.getPlayer().hasPermission("serverprotect.ignitetnt"))
			{
				event.setCancelled(true);
				event.setUseItemInHand(Event.Result.DENY);
				event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.tnt.ignite")).replaceAll("&([a-z0-9])", "\u00A7$1"));
			}
		}
	}
}