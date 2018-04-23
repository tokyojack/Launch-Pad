package me.tokyojack.spigot.launchpad.utils;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;

@Getter
public abstract class LaunchPad {

	private Material blockType;
	private String name;
	private List<String> lore;

	public LaunchPad(Material blockType, String name, String... lore) {
		this.blockType = blockType;
		this.name = ChatColor.translateAlternateColorCodes('&', name + " &fLaunchpad");
		// Could stream and map if you'd like
		Arrays.asList(lore).forEach(loreLine -> this.lore.add(ChatColor.translateAlternateColorCodes('&', loreLine)));
	}

	public abstract void onJump(Player player);

	public abstract void particlePulse(Location location);

	public ItemStack getItem() {
		return new ItemBuilder(this.blockType).setName(this.name).setLore(this.lore).toItemStack();
	}

}