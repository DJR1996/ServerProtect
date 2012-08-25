package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

class ExpBottleListener implements Listener
{
	ServerProtect plugin;
	public ExpBottleListener(ServerProtect instance)
	{
		plugin = instance;
	}
	int allowed = 0;
	int kickcounter = 0;
	int bancounter = 0;
	@EventHandler()
	public void Egg(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if(event.getMaterial() == Material.EXP_BOTTLE && !event.getPlayer().hasPermission("serverprotect.exp"))
			{
				if(allowed <= plugin.getConfig().getInt("projectiles.exp.allowed"));
				{
					allowed++;
				}
				if(allowed == plugin.getConfig().getInt("projectiles.exp.allowed")){
					event.getPlayer().sendMessage(ChatColor.GREEN + "You've reached the maximum amount of EXP bottles you can throw for now.");
				}
				if(event.getPlayer().hasPermission("serverprotect.exp.autokick.exempt") && allowed > plugin.getConfig().getInt("projectiles.exp.allowed"))
				{
				event.setCancelled(true);
				event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.exp.not-allowed")).replaceAll("&([a-z0-9])", "\u00A7$1"));
				}
				else if(!event.getPlayer().hasPermission("serverprotect.exp.autokick.exempt") && allowed > plugin.getConfig().getInt("projectiles.exp.allowed"))
				{
					kickcounter++;
					event.setCancelled(true);
					event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.exp.not-allowed")).replaceAll("&([a-z0-9])", "\u00A7$1"));
					event.getPlayer().sendMessage(ChatColor.RED + "Your kick warning level is " + kickcounter + "/5");
				}
			}
		}
		if(kickcounter == 5 && bancounter <= 4 && !event.getPlayer().hasPermission("serverprotect.exp.autokick.exempt"))
		{
			if(event.getPlayer().hasPermission("serverprotect.exp.autoban.exempt"))
			{
				event.getPlayer().kickPlayer(plugin.getConfig().getString("messages.blacklist.exp.kick"));
				kickcounter = 0;
			}
			else if(!event.getPlayer().hasPermission("serverprotect.exp.autoban.exempt"))
			{
				bancounter++;
				event.getPlayer().kickPlayer(plugin.getConfig().getString("messages.blacklist.exp.kick") + " Your ban counter is: " + bancounter + "/5");
				kickcounter = 0;
			}
		}
		if(bancounter == 5 && !event.getPlayer().hasPermission("serverprotect.exp.autoban.exempt"))
		{
			event.getPlayer().setBanned(true);
			event.getPlayer().kickPlayer(plugin.getConfig().getString("messages.blacklist.exp.ban"));
		}
	}
}
