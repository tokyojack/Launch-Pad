package me.tokyojack.spigot.launchpad.events;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import me.tokyojack.spigot.launchpad.Core;
import me.tokyojack.spigot.launchpad.utils.LaunchPad;

public class LaunchpadPlace implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onLaunchpadPlace(BlockPlaceEvent event) {
		ItemStack blockItem = event.getItemInHand();

		if (!blockItem.hasItemMeta())
			return;

		if (!blockItem.getItemMeta().hasDisplayName())
			return;

		String blockName = ChatColor.stripColor(blockItem.getItemMeta().getDisplayName());

		Map<String, LaunchPad> launchpads = Core.getPlugin().getLaunchPads();

		if (launchpads.containsKey(blockName)) {
			event.getBlock().setMetadata("lp", new FixedMetadataValue(Core.getPlugin(),
					ChatColor.stripColor(launchpads.get(blockName).getItem().getItemMeta().getDisplayName())));
		}

	}

}
