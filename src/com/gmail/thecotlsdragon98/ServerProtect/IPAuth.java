package com.gmail.thecotlsdragon98.ServerProtect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
	Scanner input;
	String name;
	String IP;
	String[] nameandIP;
	@EventHandler
	public void checkIP(PlayerLoginEvent event)
	{
		try{
			input = new Scanner(new FileReader(authFile));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		while(input.hasNextLine()){
			nameandIP = input.nextLine().split(": ");
			name = nameandIP[0];
			IP = nameandIP[1];
		}
		input.close();
		if(event.getPlayer().getName().equalsIgnoreCase(name) && !event.getAddress().getHostAddress().equalsIgnoreCase(IP)){
			if(IP.equalsIgnoreCase("localhost") && event.getAddress().getHostAddress().equalsIgnoreCase("127.0.0.1")){
				event.setResult(Result.ALLOWED);
			}
			else{
				event.setKickMessage("Invalid IP for username: " + event.getPlayer().getName() + ". You have been disconnected.");
				event.setResult(Result.KICK_OTHER);
			}
		}
	}
}
