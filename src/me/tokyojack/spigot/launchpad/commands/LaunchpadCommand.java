package me.tokyojack.spigot.launchpad.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.CommandSender;

import me.tokyojack.spigot.launchpad.utils.kommand.Kommand;

public class LaunchpadCommand extends Kommand {

	public LaunchpadCommand() {
		super("launchpad", "launchpad command", Arrays.asList("launchpads", "lp", "lps"));
	}

	@Override
	public boolean execute(CommandSender commandSender, String label, String[] args) {
		return true;
	}

}
