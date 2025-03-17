package com.leo.wildCore.Listeners;

import com.leo.wildCore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    private Main main;
    public QuitListener(Main main) {
        this.main = main;
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {

        e.setQuitMessage(null);
        Player player = e.getPlayer();
        Bukkit.broadcastMessage(ChatColor.GOLD + "\uD83D\uDD0C " + ChatColor.GRAY + e.getPlayer().getName() + " has left the server!");


    }


}
