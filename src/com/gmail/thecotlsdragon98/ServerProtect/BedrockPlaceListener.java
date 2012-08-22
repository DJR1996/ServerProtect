package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BedrockPlaceListener implements Listener
{
	ServerProtect plugin;
	public BedrockPlaceListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void BedrockPlace(BlockPlaceEvent event)
	{
		if(event.getBlockPlaced().getType() == Material.BEDROCK && !event.getPlayer().hasPermission("serverprotect.placebedrock"))
		{
			event.setCancelled(true);
			event.getPlayer().sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.bedrock-place")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
