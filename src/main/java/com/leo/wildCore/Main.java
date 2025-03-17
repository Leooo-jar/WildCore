package com.leo.wildCore;

import com.leo.wildCore.Commands.AdminCommands.*;
import com.leo.wildCore.Holograms.HologramCreate;
import com.leo.wildCore.Listeners.JoinListener;
import com.leo.wildCore.Listeners.QuitListener;
import com.leo.wildCore.StaffMode.Listeners.ChatModListener;
import com.leo.wildCore.StaffMode.Listeners.FreezeListener;
import com.leo.wildCore.TabCompleted.TempBanTab;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        getCommand("alert").setExecutor(new AlertCommand());
        getCommand("ban").setExecutor(new BanCommand());
        getCommand("tempban").setExecutor(new TempBanCommand());
        getCommand("tempban").setTabCompleter(new TempBanTab());
        getCommand("unban").setExecutor(new UnBanCommand());
        getCommand("settings").setExecutor(new SettingsCommand());
        getCommand("Hologramcreate").setExecutor(new HologramCreate());


        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new QuitListener(this), this);
        getServer().getPluginManager().registerEvents(new FreezeListener(), this);
        getServer().getPluginManager().registerEvents(new ChatModListener(), this);


    }
    //                       SCOREBOARD
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = board.registerNewObjective("Testboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "WildCore" + ChatColor.GRAY + " (Survival Core)" + ChatColor.WHITE + ChatColor.BOLD + " 1.0");

        Score website = obj.getScore(ChatColor.YELLOW + "scorch.gg");
        website.setScore(1);

        Score name = obj.getScore(ChatColor.GRAY + "Name: " + ChatColor.GOLD + player.getName());
        name.setScore(10);

        Score space = obj.getScore(" ");
        space.setScore(9);

        Score rank = obj.getScore(ChatColor.GRAY + "Rank: ");
        name.setScore(8);


        player.setScoreboard(board);
    }

}
