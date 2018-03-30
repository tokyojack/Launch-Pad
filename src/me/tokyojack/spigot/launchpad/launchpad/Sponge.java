package me.tokyojack.spigot.launchpad.launchpad;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import me.tokyojack.spigot.launchpad.utils.LaunchPad;

public class Sponge extends LaunchPad{

	public Sponge() {
		super(Material.SPONGE, "&eSponge");
	}

	@Override
	public void onJump(Player player) {
		player.setVelocity(new Vector(0, 4, 0));
	}

	@Override
	public void particlePulse(Location location) {
		
	}

}
