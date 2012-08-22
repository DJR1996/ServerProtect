package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class UglyBlockListener implements Listener
{
	ServerProtect plugin;
	public UglyBlockListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void DiamondBlocks(BlockPlaceEvent diamond)
	{
		if(diamond.getBlockPlaced().getType() == Material.DIAMOND_BLOCK && !diamond.getPlayer().hasPermission("serverprotect.diamondblock"))
		{
			diamond.setCancelled(true);
			diamond.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.diamondblocks")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void GoldBlocks(BlockPlaceEvent gold)
	{
		if(gold.getBlockPlaced().getType() == Material.GOLD_BLOCK && !gold.getPlayer().hasPermission("serverprotect.goldblock"))
		{
			gold.setCancelled(true);
			gold.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.goldblocks")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void LapisBlocks(BlockPlaceEvent lapis)
	{
		if(lapis.getBlockPlaced().getType() == Material.LAPIS_BLOCK && !lapis.getPlayer().hasPermission("serverprotect.lapisblock"))
		{
			lapis.setCancelled(true);
			lapis.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.lapisblocks")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Obsidian(BlockPlaceEvent ob)
	{
		if(ob.getBlockPlaced().getType() == Material.OBSIDIAN && !ob.getPlayer().hasPermission("serverprotect.obsidian"))
		{
			ob.setCancelled(true);
			ob.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.obsidian")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void IronBlocks(BlockPlaceEvent iron)
	{
		if(iron.getBlockPlaced().getType() == Material.IRON_BLOCK && !iron.getPlayer().hasPermission("serverprotect.ironblock"))
		{
			iron.setCancelled(true);
			iron.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.ironblocks")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Glowstone(BlockPlaceEvent glow)
	{
		if(glow.getBlockPlaced().getType() == Material.GLOWSTONE && !glow.getPlayer().hasPermission("serverprotect.glowstone"))
		{
			glow.setCancelled(true);
			glow.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.glowstone")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Emerald(BlockPlaceEvent em)
	{
		if(em.getBlockPlaced().getType() == Material.EMERALD_BLOCK && !em.getPlayer().hasPermission("serverprotect.emeraldblock"))
		{
			em.setCancelled(true);
			em.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.emeraldblocks")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
