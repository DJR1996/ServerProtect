//This is not the original code to this class, it's one of the things I tried to do to fix it

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
	ServerProtect plugin;
	public BowAndArrowListener(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void Bow(EntityShootBowEvent event)
	{
		if(event.getEntityType() == EntityType.PLAYER)
		{
			player = (Player) event.getEntity();
			if(player.hasPermission("serverprotect.bows"))
			{
				event.setCancelled(false);
				return;
			}
			else if(!player.hasPermission("serverprotect.bows"))
			{
				if(player.isOp())
				{
					event.setCancelled(false);
					return;
				}
				else if(!player.isOp())
				{
					event.setCancelled(true);
				}
			}
			if(!event.isCancelled())
			{
				return;
			}
			else if(event.isCancelled())
			{
				player.sendMessage(String.format(plugin.getConfig().getString("messages.blacklist.bows").replaceAll("&([a-z0-9])", "\u00A7$1")));
			}
		}
	}
}
