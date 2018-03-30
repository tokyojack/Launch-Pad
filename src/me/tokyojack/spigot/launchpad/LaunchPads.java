package me.tokyojack.spigot.launchpad;

import lombok.Getter;
import me.tokyojack.spigot.launchpad.launchpad.Sponge;
import me.tokyojack.spigot.launchpad.utils.LaunchPad;

@Getter
public enum LaunchPads {
	SPONGE(new Sponge());

	private LaunchPad launchPad;

	private LaunchPads(LaunchPad launchpad) {
		this.launchPad = launchpad;
	}

}
