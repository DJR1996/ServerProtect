package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class OpConfirm implements Listener
{
	ServerProtect plugin;
	
	public OpConfirm(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void CheckOp(PlayerMoveEvent event)
	{
		if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && !plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && !plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.getPlayer().setOp(false);
			event.getPlayer().sendMessage(ChatColor.DARK_GREEN + "[OpConfirm] " + ChatColor.DARK_RED + "You have been de-opped by the server!");
		}
		else if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && !plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.getPlayer().setOp(false);
			event.getPlayer().kickPlayer("[OpConfirm] You have been kicked and de-opped by the server!");
		}
		else if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && !plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.getPlayer().setOp(false);
			event.getPlayer().kickPlayer("[OpConfirm] You have been banned automatically by the server!");
			event.getPlayer().setBanned(true);
		}
		else if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.getPlayer().setOp(false);
			event.getPlayer().kickPlayer("[OpConfirm] You have been banned automatically by the server!");
			event.getPlayer().setBanned(true);
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void CheckOp2(PlayerCommandPreprocessEvent e)
	{
		if(e.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(e.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && !plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && !plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			e.getPlayer().setOp(false);
			e.getPlayer().sendMessage(ChatColor.DARK_GREEN + "[OpConfirm] " + ChatColor.DARK_RED + "You have been de-opped by the server!");
			e.setCancelled(true);
		}
		else if(e.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(e.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && !plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			e.getPlayer().setOp(false);
			e.setCancelled(true);
			e.getPlayer().kickPlayer("[OpConfirm] You have been kicked and de-opped by the server!");
		}
		else if(e.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(e.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && !plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			e.getPlayer().setOp(false);
			e.setCancelled(true);
			e.getPlayer().kickPlayer("[OpConfirm] You have been banned automatically by the server!");
			e.getPlayer().setBanned(true);
		}
		else if(e.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(e.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			e.getPlayer().setOp(false);
			e.setCancelled(true);
			e.getPlayer().kickPlayer("[OpConfirm] You have been banned automatically by the server!");
			e.getPlayer().setBanned(true);
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void CheckOp3(BlockBreakEvent event)
	{
		if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && !plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && !plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.setCancelled(true);
			event.getPlayer().setOp(false);
			event.getPlayer().sendMessage(ChatColor.DARK_GREEN + "[OpConfirm] " + ChatColor.DARK_RED + "You have been de-opped by the server!");
		}
		else if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && !plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.setCancelled(true);
			event.getPlayer().setOp(false);
			event.getPlayer().kickPlayer("[OpConfirm] You have been kicked and de-opped by the server!");
		}
		else if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && !plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.setCancelled(true);
			event.getPlayer().setOp(false);
			event.getPlayer().kickPlayer("[OpConfirm] You have been banned automatically by the server!");
			event.getPlayer().setBanned(true);
		}
		else if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.setCancelled(true);
			event.getPlayer().setOp(false);
			event.getPlayer().kickPlayer("[OpConfirm] You have been banned automatically by the server!");
			event.getPlayer().setBanned(true);
		}
		
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void CheckOp4(BlockPlaceEvent event)
	{
		if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && !plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && !plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.setCancelled(true);
			event.getPlayer().setOp(false);
			event.getPlayer().sendMessage(ChatColor.DARK_GREEN + "[OpConfirm] " + ChatColor.DARK_RED + "You have been de-opped by the server!");
		}
		else if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && !plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.setCancelled(true);
			event.getPlayer().setOp(false);
			event.getPlayer().kickPlayer("[OpConfirm] You have been kicked and de-opped by the server!");
		}
		else if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && !plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.setCancelled(true);
			event.getPlayer().setOp(false);
			event.getPlayer().kickPlayer("[OpConfirm] You have been banned automatically by the server!");
			event.getPlayer().setBanned(true);
		}
		else if(event.getPlayer().isOp() && !plugin.getConfig().getList("protection.OpConfirm.ops").contains(event.getPlayer().getName()) && plugin.getConfig().getBoolean("protection.OpConfirm.enabled") && plugin.getConfig().getBoolean("protection.OpConfirm.kick-bad-ops") && plugin.getConfig().getBoolean("protection.OpConfirm.ban-bad-ops"))
		{
			event.setCancelled(true);
			event.getPlayer().setOp(false);
			event.getPlayer().kickPlayer("[OpConfirm] You have been banned automatically by the server!");
			event.getPlayer().setBanned(true);
		}
		
	}
}