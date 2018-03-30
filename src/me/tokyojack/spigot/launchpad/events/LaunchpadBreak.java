package me.tokyojack.spigot.launchpad.events;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.tokyojack.spigot.launchpad.Core;
import me.tokyojack.spigot.launchpad.utils.LaunchPad;

public class LaunchpadBreak implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onLaunchpadBreak(BlockBreakEvent event) {
		Block block = event.getBlock();

		if (!block.hasMetadata("lp"))
			return;

		String launcpadName = event.getBlock().getMetadata("lp").get(0).asString();

		
		Map<String, LaunchPad> launchpads = Core.getPlugin().getLaunchPads();
		
		if(launchpads.containsKey(launcpadName)){	
			block.getWorld().dropItem(block.getLocation(), launchpads.get(launcpadName).getItem());
			Core.getPlugin().getLaunchPads().get(launcpadName);
			event.setCancelled(true);
			block.setType(Material.AIR);
		}
		
		
	}

}
