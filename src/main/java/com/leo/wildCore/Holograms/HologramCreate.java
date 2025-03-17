package com.leo.wildCore.Holograms;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class HologramCreate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

if (sender instanceof Player) {
    Player player = (Player) sender;


    String[] lines = new String[]{
            ChatColor.RED + "Line",
            ChatColor.GREEN + "Line2",
            ChatColor.GREEN + "Line3",
            ChatColor.GREEN + "Line4",
            ChatColor.GREEN + "Line5",
            ChatColor.GREEN + "Line6",
            ChatColor.RED + "Line7"
    };


    Location location = player.getLocation();
    for (String line : lines) {

        ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(location.subtract(0, 0.7, 0), EntityType.ARMOR_STAND);
        stand.setInvisible(true);
        stand.setGravity(false);
        stand.setInvulnerable(true);

        stand.setCustomNameVisible(true);
        stand.setCustomName(line);
    }






}


        return false;
    }
}
