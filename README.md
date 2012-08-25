<a name="top"></a><strong>Quick Links:</strong><br/>
<a href="#OpConfirm">OpConfirm</a><br/>
<a href="#cmd">Command Logging</a><br/>
<a href="#item">Item Blacklisting</a><br/>
<a href="#anti">Anti-Lag Features</a><br/>
<a href="#perms">Permissions</a><br/>
<a href="#uip">User-IP Authentication</a><br/>
<a href="http://dev.bukkit.org/server-mods/serverprotect">BukkitDev Page</a><br/>
<a href="http://dev.bukkit.org/server-mods/serverprotect/create-ticket">Submit a ticket</a><br/>
If you experience any issues, please post them at the link above and either me or Blitzace23 will respond ASAP. No tickets will be ignored under any circumstances. 
<br/>
<a name="OpConfirm"><h1>OpConfirm</h1></a>
This is to combot force op tools (Such as NoCheatPlusPlus, NOT to be confused with NoCheatPlus, which is a legitimate plugin)<br/>
If a user is not listed in ops in the config, they will be de-opped as soon as they move, type a command, break a block, or place a block. <br/>
<a href="#top">Top</a><br/>
<a name="cmd"><h1>Command Logging</h1></a>
All commands performed by players will be logged to plugins/ServerProtect/commands.log
<br/>
This is to make it less of a hassle to look through server.log to see if <x player> did <x command><br/>
<a href="#top">Top</a><br/>
<a name="item"><h1>Item Blacklisting</h1></a>
The item blacklist currently supports the following items:
<ul>
<li> TNT </li>
<li> Users cannot ignite TNT that already exists </li>
<li> Placed Bedrock </li>
<li> Broken Bedrock </li>
<li> Redstone(Includes Diodes and both redstone torches(on/off)) </li> 
<li> The ugly blocks that a lot of people like to make buildings out of (diamond blocks, gold blocks, iron blocks, lapis blocks, obsidian, glowstone) </li>
<li> Flint and steel </li>
<li> Fire charges </li>
<li> Fire blocks </li>
<li> Lava buckets, lava, stationary lava </li>
<li> Water buckets, water, stationary water </li>
<li> EXP Bottles </li>
<li> Eggs </li>
<li> Snowballs </li>
<li> Ender Pearls </li>
<li> Ender eyes </li>
<li> Nether Portals </li>
<li> End Portals </li>
<li> Mob spawners </li>
<li> Fired Bows </li>
<li> Dragon Eggs </li>
<li> Spawner Eggs </li>
<li> Minecarts </li>
<li> Boats </li>
<li> Emerald Blocks </li>
<li> Rails, Powered Rails, Detector Rails </li>
<li> Pistons, Sticky Pistons </li>
<li> Webs </li>
<li> Tripwires, Tripwire Hooks </li>
</ul>
<br/>
<a href="#top">Top</a><br/>
<a name="anti"><h1>Anti-Lag Features</h1></a>
Optionally disable all mob spawning<br/>
Optionally disable all drops<br/>
Only users with permissions can drop items<br/>
<a href="#top">Top</a><br/>
<a name="perms"><h1>Permissions</h1></a>
<ul>
<li> serverprotect.placebedrock - Allows placing of bedrock </li>
<li> serverprotect.breakbedrock - Allows breaking of bedrock </li>
<li> serverprotect.tnt - Allows placing of TNT </li>
<li> serverprotect.diamondblock - Allows placing of diamond blocks </li>
<li> serverprotect.goldblock - Allows placing of gold blocks </li>
<li> serverprotect.ironblock - Allows placing of iron blocks </li>
<li> serverprotect.obsidian - Allows placing of obsidian </li>
<li> serverprotect.glowstone - Allows placing of glowstone </li>
<li> serverprotect.redstone - Allows placing of redstone, diodes, and redstone torches </li>
<li> serverprotect.netherportals - Allows placing of nether portals (working on not allowing them to generate them using a frame) </li>
<li> serverprotect.eggs - Allows users to throw eggs </li>
<li> serverprotect.eggs.autokick.exempt - Users won't be autokicked after trying 5 times to throw eggs </li>
<li> serverprotect.eggs.autoban.exempt - Users won't be autobanned after being kicked 5 times for throwing eggs </li>
<li> serverprotect.exp - Allows users to throw EXP bottles </li>
<li> serverprotect.exp.autokick.exempt - Users won't be autokicked after trying 5 times to throw EXP bottles </li>
<li> serverprotect.exp.autoban.exempt - Users won't be autobanned after being kicked 5 times for throwing EXP bottles </li>
<li> serverprotect.snowball - Users can throw snowballs </li>
<li> serverprotect.enderpearl - Users can throw ender pearls </li>
<li> serverprotect.endereye - Users can throw ender eyes (Eye of ender) </li>
<li> serverprotect.mobspawner - Users can place mob spawners </li>
<li> serverprotect.lavabucket - Users can use lava buckets </li>
<li> serverprotect.lava - Users can place the actual item lava, as well as stationary lava </li>
<li> serverprotect.waterbucket - Users can use water buckets </li>
<li> serverprotect.water - Users can place the actual item water, as well as stationary lava </li>
<li> serverprotect.fire - Users can place the fire block </li>
<li> serverprotect.flintsteel - Users can use flint and steel </li>
<li> serverprotect.firecharge - Users can use fire charges (fireballs) </li>
<li> serverprotect.drop - Users can drop items </li>
<li> serverprotect.dragonegg - Users can place dragon eggs </li>
<li> serverprotect.minecarts - Users can place minecarts </li>
<li> serverprotect.boats - Users can place boats </li>
<li> serverprotect.ignitetnt - Users can ignite TNT that has already been placed. </li>
<li> serverprotect.spawneggs - Users can use spawner eggs </li>
<li> serverprotect.bows - Users can fire bows </li>
<li> serverprotect.emeraldblock - Users can place emerald blocks </li>
<li> serverprotect.rails - Users can place rails </li>
<li> serverprotect.pistons - Users can place pistons/sticky pistons </li>
<li> serverprotect.webs - Users can place webs </li>
<li> serverprotect.tripwire - Users can place trip wires/trip wire hooks </li>

</ul>
<br/>
<a href="#top">Top</a><br/>
<a name="uip"><h1>User-IP Authentication</h1></a>
In ServerProtect/IPAuth.yml, you can assign IP addresses to users. For example, <strong><i>Theway2cool1: localhost</i></strong>. With that, if a user tries to login as Theway2cool1, it checks if their IP is <strong><i>localhost</i></strong>. If not, they are kicked.<br/>
<a href="#top">Top</a><br/>