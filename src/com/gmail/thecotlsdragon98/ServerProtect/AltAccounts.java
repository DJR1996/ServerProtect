package com.gmail.thecotlsdragon98.ServerProtect;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;

public class AltAccounts implements Listener
{
	ServerProtect plugin;
	public AltAccounts(ServerProtect instance){
		plugin = instance;
	}
	File usersFile;
	FileWriter outputFile;
	PrintWriter out;
	Scanner in;
	@EventHandler
	public void newUsersFile(PluginEnableEvent event) throws IOException{
		if(event.getPlugin() == plugin){
			usersFile = new File("plugins\\ServerProtect\\users.yml");
			if(!usersFile.exists()){
				usersFile.createNewFile();
			}
		}
	}
	@EventHandler
	public void CheckForUsedIP(PlayerLoginEvent event) throws IOException{
		outputFile = new FileWriter(usersFile, true);
		out = new PrintWriter(outputFile);
		in = new Scanner(new FileReader(usersFile));
		String[] nameandIP;
		String name;
		String IP;
		HashSet<String> players = new HashSet<String>();
		while(in.hasNextLine() && in.nextLine().isEmpty()){
			players.add(in.nextLine().split(": ")[0]);
			players.add(in.nextLine().split(": ")[1]);
			if(!players.contains(event.getPlayer().getName())){
				out.println(event.getPlayer().getName() + ": " + event.getAddress().getHostAddress());
				players.clear();
				out.close();
			}
		}
		if(!in.hasNextLine()){
			out.println(event.getPlayer().getName() + ": " + event.getAddress().getHostAddress());
			out.close();
		}
		if(!plugin.getConfig().getBoolean("alts.kick-on-login")){
			while(in.hasNextLine()){
				nameandIP = in.nextLine().split(": ");
				name = nameandIP[0];
			    IP = nameandIP[1];
				if(event.getAddress().getHostAddress().equalsIgnoreCase(IP) && !event.getPlayer().getName().equals(name)){
					for(final Player player : plugin.getServer().getOnlinePlayers()){
						if(player.hasPermission("serverprotect.alts.notify")){
							player.sendMessage(ChatColor.RED + event.getPlayer().getName() + " has the same IP as " + name + " (" + event.getAddress().getHostAddress() + ")");
						}
					}
				}
			}
		}
		else if(plugin.getConfig().getBoolean("alts.kick-on-login")){
			while(in.hasNextLine()){
				nameandIP = in.nextLine().split(": ");
				name = nameandIP[0];
				IP = nameandIP[1];
				if(event.getAddress().getHostAddress().equalsIgnoreCase(IP)){
					event.setKickMessage("The IP address you've logged in with is used. Alternate account?");
					event.setResult(Result.KICK_OTHER);
				}
			}
		}
	}
	public void Disable(PluginDisableEvent event)throws IOException{
		if(event.getPlugin() == plugin){
			in.close();
		}
	}
}
