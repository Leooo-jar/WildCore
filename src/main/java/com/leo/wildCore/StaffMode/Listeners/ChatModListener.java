package com.leo.wildCore.StaffMode.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChatModListener implements Listener {

    private boolean enabled;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (e.getPlayer().getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().equals(Material.NETHER_STAR)) {

            if (enabled) {
                enabled = false;
                player.sendMessage("You have disabled chat!");

            } else {
                enabled = true;
                player.sendMessage("You have enabled chat!");


            }



        }


    }



    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        if (!enabled) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "Chat is disabled right now!");

        }


    }

}
