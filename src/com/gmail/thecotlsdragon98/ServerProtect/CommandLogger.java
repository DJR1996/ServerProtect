package com.gmail.thecotlsdragon98.ServerProtect;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandLogger implements Listener
{
	ServerProtect plugin;
	public CommandLogger(ServerProtect instance)
	{
		plugin = instance;
	}
	@EventHandler
	public void LogPlayerCommands(PlayerCommandPreprocessEvent event)
	{
		if(plugin.getConfig().getBoolean("logging.commands.enabled"))
		{
			File commandLog = new File("plugins/ServerProtect/commands.log");
			try
			{
				FileWriter outputFile = new FileWriter(commandLog, true);
				PrintWriter log = new PrintWriter(outputFile);
				if(!commandLog.exists()){
					commandLog.createNewFile();	
				}
				
				log.println(event.getPlayer().getName() + ": " + event.getMessage());
				log.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	    }
	}
}