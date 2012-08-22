package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class RedstoneListener implements Listener
{
	ServerProtect plugin;
	public RedstoneListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Redstone(BlockPlaceEvent event)
	{
		if(event.getBlockPlaced().getType() == Material.REDSTONE_WIRE && !event.getPlayer().hasPermission("serverprotect.redstone"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.redstone")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
		else if(event.getBlockPlaced().getType() == Material.DIODE && !event.getPlayer().hasPermission("serverprotect.redstone"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.diode")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
		else if(event.getBlockPlaced().getType() == Material.REDSTONE_TORCH_ON && !event.getPlayer().hasPermission("serverprotect.redstone"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.redstonetorch")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
		else if(event.getBlockPlaced().getType() == Material.REDSTONE_TORCH_OFF && !event.getPlayer().hasPermission("serverprotect.redstone"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.redstonetorch")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
		else if(event.getBlockPlaced().getType() == Material.DIODE_BLOCK_OFF && !event.getPlayer().hasPermission("serverprotect.redstone"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.diode")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
		else if(event.getBlockPlaced().getType() == Material.DIODE_BLOCK_ON && !event.getPlayer().hasPermission("serverprotect.redstone"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.diode")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
