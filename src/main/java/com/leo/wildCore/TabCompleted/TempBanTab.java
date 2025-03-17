package com.leo.wildCore.TabCompleted;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TempBanTab implements TabCompleter {


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {


        List<String> results = new ArrayList<>();


        if (args.length == 1) {
           for (Player player : Bukkit.getOnlinePlayers()) {
               results.add(player.getName());
           }

        } else if (args.length == 2) {
            results.add("1m");
            results.add("24h");
            results.add("30d");
            results.add("60s");
        } else if (args.length == 3) {
            results.add("Reason");
        }



        return results;
    }
}
