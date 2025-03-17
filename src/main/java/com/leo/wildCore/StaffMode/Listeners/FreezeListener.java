package com.leo.wildCore.StaffMode.Listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashSet;
import java.util.Set;

public class FreezeListener implements Listener {


    private final Set<Player> frozenPlayers = new HashSet<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player) {
            Player staff = e.getPlayer(); // El jugador que hace click
            Player target = (Player) e.getRightClicked(); // El jugador clickeado

            // Verifica si el jugador tiene hielo en la mano
            if (staff.getInventory().getItemInMainHand().getType() == Material.ICE) {
                if (frozenPlayers.contains(target)) {
                    frozenPlayers.remove(target);
                    staff.sendMessage(ChatColor.AQUA + "You have unfrozen " + target.getName());

                    target.sendMessage(ChatColor.GREEN + "You have been unfrozen");
                } else {
                    frozenPlayers.add(target);
                    staff.sendMessage(ChatColor.AQUA + "You have frozen " + target.getName());
                    target.sendMessage(ChatColor.RED + "Stop moving!");
                }
                e.setCancelled(true);
            }





        }

        }


        @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();

        if (frozenPlayers.contains(player)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Don't move! You are frozen.");
        }
        }

}
