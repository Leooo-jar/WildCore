package com.leo.wildCore.Commands.AdminCommands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TempBanCommand implements CommandExecutor {

    //    /tempban <Player> <Reason> <Time>


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Optional: Add permission check here
            if (!player.hasPermission("wildcore.tempban")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return true;
            }
        }

        if (args.length < 3) {
            sender.sendMessage(ChatColor.RED + "Invalid command. Usage: /tempban <Player> <time> <Reason>");
            return true;
        }


        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
        if (target == null || (!target.hasPlayedBefore() && !target.isOnline())) {
            sender.sendMessage(ChatColor.GRAY + "The player was not found or never logged in.");
        }

        long duration = parseTime(args[1]);
        if (duration == -1) {
            sender.sendMessage(ChatColor.RED + "Format Time invalid! Usa M(Mounth), d(Days), h(Hours), m(Minutes).");
            return true;
        }

        String reason = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
        Long expireAt = System.currentTimeMillis() + duration;
        Date expireDate = new Date(expireAt);


        UUID tarrgetUUID;
        if (target.isOnline()) {
            tarrgetUUID = target.getPlayer().getUniqueId();
        } else {
            tarrgetUUID = UUID.nameUUIDFromBytes(("OfflinePlayers:" + target.getName()).getBytes(StandardCharsets.UTF_8));
        }

        Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), reason, expireDate, sender.getName());
        Bukkit.getBanList(BanList.Type.PROFILE).addBan(tarrgetUUID.toString(), reason, expireDate, sender.getName());

        if (target.isOnline()) {
            Player onlinePlayer = target.getPlayer();
            if (onlinePlayer != null) {
                onlinePlayer.kickPlayer(reason);
            }
        }

        sender.sendMessage(ChatColor.RED + "You have temporarily banned " + target.getName() + " for: " + args[1] + ".");
        Bukkit.broadcastMessage(ChatColor.RED + target.getName() + ChatColor.GRAY + " has been banned from the network for " + reason);
        return true;
    }

    public long parseTime(String input) {
        long totalMillis = 0;

        Pattern pattern = Pattern.compile("(\\d+)([dhsm])");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            int value = Integer.parseInt(matcher.group(1));
            String unit = matcher.group(2);

            switch (unit.toLowerCase()) {
                case "m":
                    return value * 2_592_000_000L; // 1 month ≈ 30 days
                case "d":
                    return value * 86_400_000L;   // 1 day = 86400000 ms
                case "h":
                    return value * 3_600_000L;   // 1 hour = 3600000 ms
                case "s":
                    return value * 60_000L;      // 1 minute = 60000 ms
                default:
                    return -1;
            }
        }
        return -1;
    }
}
