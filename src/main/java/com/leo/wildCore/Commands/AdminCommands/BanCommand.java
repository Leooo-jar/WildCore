package com.leo.wildCore.Commands.AdminCommands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class BanCommand implements CommandExecutor {

    //  /ban <Player> <Reason> <Time>


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 2) {
                if (Bukkit.getOfflinePlayer(args[0]) != null) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);
                        String reason = String.join(" ", Arrays.copyOfRange(args, 1, args.length));


                        Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + reason, null, null);
                        player.kickPlayer(ChatColor.RED + reason);

                        player.sendMessage(ChatColor.GREEN + "Successfully Banned! " + target.getName() + " for: " + reason);
                    }
                }

            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! Use /ban <Player> <Reason>");
            }
        }




        return false;
    }
}
