package me.tokyojack.spigot.launchpad.commands.subcommands;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.spigot.launchpad.utils.subkommand.SubKommand;
import me.tokyojack.spigot.launchpad.Core;
import me.tokyojack.spigot.launchpad.LaunchPad;


public class Give extends SubKommand {

	public Give() {
		super("<type> (player)");
	}

	@Override
	public boolean execute(CommandSender commandSender, String[] args) {
		Map<String, LaunchPad> launchpads = Core.getPlugin().getLaunchPads();

		if (args.length <= 0) {
			
			// Get's all the launch pads key's (name),
			// Runs toString on them (just in case),
			// Removes "Launchpad" from the name, 
			// Joins them together with ", " between,
			// Removes "[" and "]" as it's a list
			String launchpadsList = Arrays.asList(launchpads.keySet()).stream().map(Object::toString)
					.map(item -> item.replace("Launchpad", "")).collect(Collectors.joining(", ")).toString().replace("[", "")
					.replace("]", "");

			commandSender.sendMessage("Launchpad list: " + launchpadsList);
			return false;
		}
		
		String launchpadType = WordUtils.capitalize(args[0]) + " Launchpad";

		if (!launchpads.containsKey(launchpadType)) {
			commandSender.sendMessage("That is not a valid launchpad!");
			return false;
		}

		ItemStack launchpadItem = launchpads.get(launchpadType).getItem();

		if (args.length >= 2) {
			Player targetPlayer = Bukkit.getPlayer(args[1]);

			if (targetPlayer == null) {
				commandSender.sendMessage("That player isn't online!");
				return false;
			}

			targetPlayer.getInventory().addItem(launchpadItem);
			return true;
		}

		if (commandSender instanceof Player) 
			((Player) commandSender).getInventory().addItem(launchpadItem);
		

		return true;
	}

}