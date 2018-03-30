package me.tokyojack.spigot.launchpad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.tokyojack.spigot.launchpad.commands.LaunchpadCommand;
import me.tokyojack.spigot.launchpad.commands.subcommands.Give;
import me.tokyojack.spigot.launchpad.events.LaunchpadBreak;
import me.tokyojack.spigot.launchpad.events.LaunchpadPlace;
import me.tokyojack.spigot.launchpad.events.PlayerJump;
import me.tokyojack.spigot.launchpad.utils.LaunchPad;
import me.tokyojack.spigot.launchpad.utils.PlayerJumpEvent;
import me.tokyojack.spigot.launchpad.utils.subkommand.SubKommandManager;

public class Core extends JavaPlugin {

	private static Core plugin;

	public static Core getPlugin() {
		return plugin;
	}

	@Getter
	private Map<String, LaunchPad> launchPads = new HashMap<String, LaunchPad>();

	public void onEnable() {
		plugin = this;
		PlayerJumpEvent.register(this);

		new SubKommandManager(new LaunchpadCommand(), true).addSubCommand(new Give()).build();

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new LaunchpadBreak(), this);
		pm.registerEvents(new LaunchpadPlace(), this);
		pm.registerEvents(new PlayerJump(), this);

		Arrays.asList(LaunchPads.values())
				.forEach(launchPad -> launchPads.put(
						ChatColor.stripColor(launchPad.getLaunchPad().getItem().getItemMeta().getDisplayName()),
						launchPad.getLaunchPad()));

	}

}
