package com.gmail.thecotlsdragon98.ServerProtect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import com.gmail.thecotlsdragon98.ServerProtect.ServerProtect;

class MobSpawnListener extends ServerProtect implements Listener
{
	ServerProtect plugin;
	 
	public MobSpawnListener(ServerProtect instance) {
	plugin = instance;
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void MobSpawn(CreatureSpawnEvent event)
	{
		if(plugin.getConfig().getBoolean("prevent.mob-spawning"))
		{
			event.setCancelled(true);
		}
	}
}