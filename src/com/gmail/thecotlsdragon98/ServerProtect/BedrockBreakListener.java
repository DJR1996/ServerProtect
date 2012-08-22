package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BedrockBreakListener implements Listener
{
	ServerProtect plugin;
	public BedrockBreakListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void BedrockBreak(BlockBreakEvent event)
	{
		if(event.getBlock().getType() == Material.BEDROCK && !event.getPlayer().hasPermission("serverprotect.breakbedrock"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.bedrock-break")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
