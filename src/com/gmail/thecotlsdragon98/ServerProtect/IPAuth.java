// This is not in the plugin yet. I'm working on this.

package com.gmail.thecotlsdragon98.ServerProtect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.server.PluginEnableEvent;

public class IPAuth implements Listener
{
	ServerProtect plugin;
	public IPAuth(ServerProtect instance)
	{
		plugin = instance;
	}
	File authFile;
	@EventHandler
	public void newAuthFile(PluginEnableEvent e) throws IOException
	{
		if(e.getPlugin() == plugin)
		{
			authFile = new File("plugins\\ServerProtect\\IPAuth.yml");
			if(!authFile.exists())
			{
				authFile.createNewFile();
			}
		}
	}
	BufferedReader reader;
	String IP;
	HashSet<String> users = new HashSet<String>();
	@EventHandler
	public void checkIP(PlayerLoginEvent event)
	{
		try {
			reader = new BufferedReader(new FileReader(authFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while(reader.readLine() != null)
			{
				users.add(reader.readLine());
				if(users.contains(event.getPlayer().getName()))
				{
					String[] nameandIP = reader.readLine().split(": ");
					if(!event.getAddress().getHostAddress().equals(nameandIP[1]));
					{
						event.setKickMessage("Your IP is invalid for the username you've logged in with.");
						event.setResult(Result.KICK_OTHER);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
