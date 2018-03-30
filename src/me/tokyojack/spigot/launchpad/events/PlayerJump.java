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

		if (player.isSneaking())
			return;

		Block blockUnderPlayer = player.getLocation().subtract(0, 1, 0).getBlock();

		if (!blockUnderPlayer.hasMetadata("lp"))
			return;

		String launchpadName = blockUnderPlayer.getMetadata("lp").get(0).asString();

		Map<String, LaunchPad> launchpads = Core.getPlugin().getLaunchPads();

		if (launchpads.containsKey(launchpadName)) {
			launchpads.get(launchpadName).onJump(player);
		}
	}

}
