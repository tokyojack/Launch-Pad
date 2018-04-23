package me.tokyojack.spigot.launchpad.events;

import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.spigot.launchpad.Core;
import me.tokyojack.spigot.launchpad.utils.LaunchPad;
import me.tokyojack.spigot.launchpad.utils.PlayerJumpEvent;

public class PlayerJump implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onLaunchpadJump(PlayerJumpEvent event) {
		Player player = event.getPlayer();

		// Stops the player from being boosted if crouching
		if (player.isSneaking())
			return;

		// Get's block under person
		Block blockUnderPlayer = player.getLocation().subtract(0, 1, 0).getBlock();

		// Checks if the block has the metadata "lp" (Launchpad). (Given when placed)
		if (!blockUnderPlayer.hasMetadata("lp"))
			return;

		// Gets the launch pads name that is under the player
		String launchpadName = blockUnderPlayer.getMetadata("lp").get(0).asString();

		Map<String, LaunchPad> launchpads = Core.getPlugin().getLaunchPads();

		// Checks if the placed block has the same name as the available launch pads
		if (launchpads.containsKey(launchpadName))
			// Runs the onJump of the LaunchPad object (/launchpad)
			launchpads.get(launchpadName).onJump(player);
		
	}

}
