package com.leo.wildCore.Commands.AdminCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ProfileCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

           Inventory inv = Bukkit.createInventory(player, 53, ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Profile Menu");










            // Friends

            ItemStack fid = new ItemStack(Material.COOKIE);
            ItemMeta fidMeta = fid.getItemMeta();
            fidMeta.setDisplayName(ChatColor.GOLD.toString() + ChatColor.BOLD + "Friends");
            fid.setItemMeta(fidMeta);
            inv.setItem(30, fid);



            player.openInventory(inv);

        }


        return false;
    }
}
