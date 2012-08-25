package com.gmail.thecotlsdragon98.ServerProtect;

import java.util.Arrays;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerProtect extends JavaPlugin
{
	public ServerProtect plugin;
	@Override
	public void onEnable()
	{
		getLogger().info("ServerProtect v1.5 enabled");
		getConfig().addDefault("blacklist.enabled", true);
		PluginManager manager = this.getServer().getPluginManager();
		if(getConfig().getBoolean("blacklist.enabled"))
		{
			manager.registerEvents(new EggListener(this), this);
			manager.registerEvents(new ExpBottleListener(this), this);
			manager.registerEvents(new TNTListener(this), this);
			manager.registerEvents(new FireBlockListener(this), this);
			manager.registerEvents(new FireChargeListener(this), this);
			manager.registerEvents(new FlintAndSteelListener(this), this);
			manager.registerEvents(new BedrockBreakListener(this), this);
			manager.registerEvents(new BedrockPlaceListener(this), this);
			manager.registerEvents(new RedstoneListener(this), this);
			manager.registerEvents(new LavaListener(this), this);
			manager.registerEvents(new WaterListener(this), this);
			manager.registerEvents(new UglyBlockListener(this), this);
			manager.registerEvents(new BowAndArrowListener(this), this);
			manager.registerEvents(new MobSpawnerListener(this), this);
			manager.registerEvents(new EnderPearlListener(this), this);
			manager.registerEvents(new SnowballListener(this), this);
			manager.registerEvents(new EnderEyeListener(this), this);
			manager.registerEvents(new PortalListener(this), this);
			manager.registerEvents(new DragonEggListener(this), this);
			manager.registerEvents(new SpawnEggListener(this), this);
			manager.registerEvents(new VehicleListener(this), this);
			manager.registerEvents(new BowAndArrowListener(this), this);
			manager.registerEvents(new RailListener(this), this);
			manager.registerEvents(new PistonListener(this), this);
			manager.registerEvents(new WebListener(this), this);
			manager.registerEvents(new TripWireListener(this), this);
		}
		manager.registerEvents(new ItemDropListener(this), this);
		manager.registerEvents(new OpConfirm(this), this);
		manager.registerEvents(new DevJoin(this), this);
		manager.registerEvents(new MobSpawnListener(this), this);
		manager.registerEvents(new CommandLogger(this), this);
		manager.registerEvents(new IPAuth(this), this);
		String[] operators = {"InsertOpNameHere"};
		FileConfiguration config = this.getConfig();
		config.options().header("Default ServerProtect Config.\nInstructions:\nprevent/mob-spawning: If set to true, no mobs will spawn in your server.\nprevent/natural-item-drops: Prevents items from dropping for any reason other than a player dropping them.\n" +
				"protection/OpConfirm/enabled: If true, OpConfirm will be enabled (This means that if a player name is not on OpConfirm/ops, they will get de-opped automatically.)\n" +
				"protection/OpConfrim/kick-bad-ops: If true, people who are op (but not on OpConfirm/ops) will be kicked and de-opped.\n" +
				"protection/OpConfirm/ban-bad-ops: You know the rest.\n" +
				"messages/blacklist/<item>: Sets the messages when a user tries to place/break/throw blacklisted items\n" +
				"logging/commands/enabled: Should player commands be logged? Commands will be logged to plugins/ServerProtect/commands.log");
		config.options().copyHeader(true);
		config.addDefault("prevent.mob-spawning", false);
		config.addDefault("prevent.natural-item-drops", false);
		config.addDefault("for-teh-lolz.AnnounceDevJoin", true);
		config.addDefault("protection.OpConfirm.enabled", true);
		config.addDefault("protection.OpConfirm.kick-bad-ops", false);
		config.addDefault("protection.OpConfirm.ban-bad-ops", false);
		config.addDefault("protection.OpConfirm.ops", Arrays.asList(operators));
		config.addDefault("messages.blacklist.snowball", "&cYou aren't allowed to throw snowballs!");
		config.addDefault("messages.blacklist.bedrock-place", "&cYou aren't allowed to place bedrock!");
		config.addDefault("messages.blacklist.bedrock-break", "&cYou aren't allowed to break bedrock!");
		config.addDefault("messages.blacklist.tnt.place", "&cYou aren't allowed to place TNT!");
		config.addDefault("messages.blacklist.tnt.ignite", "&cYou aren't allowed to ignite TNT!");
		config.addDefault("messages.blacklist.flintsteel", "&cYou aren't allowed to use flint and steel!");
		config.addDefault("messages.blacklist.fire", "&cYou aren't allowed to use flint and steel!");
		config.addDefault("messages.blacklist.firecharge", "&cYou aren't allowed to use fire charges!");
		config.addDefault("messages.blacklist.lavabucket", "&cYou aren't allowed to use lava buckets!");
		config.addDefault("messages.blacklist.lava", "&cYou aren't allowed to use lava!");
		config.addDefault("messages.blacklist.waterbucket", "&cYou aren't allowed to use water buckets!");
		config.addDefault("messages.blacklist.water", "&cYou aren't allowed to use water!");
		config.addDefault("messages.blacklist.mobspawner", "&cYou aren't allowed to use mob spawners!");
		config.addDefault("messages.blacklist.bows", "&cYou aren't allowed to fire bows!");
		config.addDefault("messages.blacklist.dragon-eggs", "&cYou aren't allowed to place dragon eggs!");
		config.addDefault("messages.blacklist.egg.not-allowed", "&cYou aren't allowed to throw eggs!");
		config.addDefault("messages.blacklist.egg.kick", "You have been kicked for spamming eggs!");
		config.addDefault("messages.blacklist.egg.ban", "You have been permanently banned for spamming eggs!");
		config.addDefault("messages.blacklist.exp.not-allowed", "&cYou aren't allowed to throw EXP bottles!");
		config.addDefault("messages.blacklist.exp.kick", "You have been kicked for spamming EXP bottles!");
		config.addDefault("messages.blacklist.exp.ban", "You have been permanently banned for spamming EXP bottles!");
		config.addDefault("messages.blacklist.enderpearl", "&cYou aren't allowed to throw ender pearls!");
		config.addDefault("messages.blacklist.endereye", "&cYou aren't allowed to throw ender eyes!");
		config.addDefault("messages.blacklist.netherportal", "&cYou aren't allowed to create nether portals!");
		config.addDefault("messages.blacklist.endportal", "&cYou aren't allowed to create end portals!");
		config.addDefault("messages.blacklist.redstone", "&cYou aren't allowed to place redstone!");
		config.addDefault("messages.blacklist.diode", "&cYou aren't allowed to place diodes!");
		config.addDefault("messages.blacklist.redstonetorch", "&cYou aren't allowed to place redstone torches!");
		config.addDefault("messages.blacklist.diamondblocks", "&cYou aren't allowed to place diamond blocks!");
		config.addDefault("messages.blacklist.goldblocks", "&cYou aren't allowed to place gold blocks!");
		config.addDefault("messages.blacklist.ironblocks", "&cYou aren't allowed to place iron blocks!");
		config.addDefault("messages.blacklist.lapisblocks", "&cYou aren't allowed to place lapis blocks!");
		config.addDefault("messages.blacklist.emeraldblocks", "&cYou aren't allowed to place emerald blocks!");
		config.addDefault("messages.blacklist.obsidian", "&cYou aren't allowed to place obsidian!");
		config.addDefault("messages.blacklist.glowstone", "&c You aren't allowed to place glowstone!");
		config.addDefault("messages.permissions.drops", "&3[ServerProtect] &cYou aren't allowed to drop items!");
		config.addDefault("messages.blacklist.spawnereggs", "&cYou aren't allowed to use spawner eggs!");
		config.addDefault("messages.blacklist.minecarts", "&cYou aren't allowed to place minecarts!");
		config.addDefault("messages.blacklist.boats", "&cYou aren't allowed to place boats!");
		config.addDefault("messages.blacklist.rails", "&cYou aren't allowed to place rails!");
		config.addDefault("messages.blacklist.webs", "&cYou aren't allowed to place webs!");
		config.addDefault("messages.blacklist.pistons", "&cYou aren't allowed to place pistons!");
		config.addDefault("messages.blacklist.tripwire", "&c You aren't allowed to use tripwires!");
		config.addDefault("logging.commands.enabled", true);
		config.options().copyDefaults(true);
		saveConfig();
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("ServerProtect v1.5 disabled");
	}
}
