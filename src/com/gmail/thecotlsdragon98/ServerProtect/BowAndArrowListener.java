package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class BowAndArrowListener implements Listener
{
	Player player;
	boolean shooterIsPlayer;
	ServerProtect plugin;
	public BowAndArrowListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Bow(EntityShootBowEvent event)
	{
		if(event.getEntity().getType() == EntityType.PLAYER)
		{
			player = (Player) event.getEntity();
			shooterIsPlayer = true;
		}
		else
		{
			shooterIsPlayer = false;
		}
		if(shooterIsPlayer && !player.hasPermission("serverprotect.bows"))
		{
			event.setCancelled(true);
			player.sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.bows")).replaceAll("&([a-z0-9])", "\u00A7$1"));
		}
	}
}
