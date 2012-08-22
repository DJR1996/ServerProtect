package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DevJoin implements Listener
{
	ServerProtect plugin;
	
	public DevJoin(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onDevJoin2(PlayerJoinEvent e)
	{
		if(e.getPlayer().getName().equalsIgnoreCase("Theway2cool1") && plugin.getConfig().getBoolean("for-teh-lolz.AnnounceDevJoin"))
		{
			e.getPlayer().getServer().broadcastMessage(ChatColor.DARK_AQUA + "[ServerProtect]" + ChatColor.DARK_GREEN + "The developer of ServerProtect(Theway2cool1) has joined!");		
		}
	}
}
