package com.leo.wildCore.Commands.AdminCommands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

    if (sender instanceof Player) {
        Player player = (Player) sender;

        if (args.length == 1) {
            String targetname = args[0];

            if (Bukkit.getBanList(BanList.Type.NAME).isBanned(targetname)) {
                    Bukkit.getBanList(BanList.Type.NAME).pardon(targetname);

                    player.sendMessage(ChatColor.GREEN + "Successfully UnBanned " + targetname);
            } else {
                player.sendMessage(ChatColor.RED + "This player is not banned!");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Invalid Command. Usage /unban <Player>");
        }

    }




        return false;
    }
}
