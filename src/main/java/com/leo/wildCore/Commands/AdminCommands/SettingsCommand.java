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

import java.util.Arrays;

public class SettingsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;


            Inventory inv = Bukkit.createInventory(player, 27, ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Settings menu!");

            // PRIVATE MESSAGES
            ItemStack tpm = new ItemStack(Material.REDSTONE);
            ItemMeta tpmmeta = tpm.getItemMeta();
            tpmmeta.setDisplayName(ChatColor.GOLD.toString() + ChatColor.BOLD + "Private Messages");
            tpmmeta.setLore(Arrays.asList(
                            "§7Yes",
                            "§7No"));
            tpm.setItemMeta(tpmmeta);
            inv.setItem(11, tpm);



            // LANGUAGUES
            ItemStack lang = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta langMeta = lang.getItemMeta();
            langMeta.setDisplayName(ChatColor.GOLD.toString() + ChatColor.BOLD + "LANGUAGES");
            langMeta.setLore(Arrays.asList(
                            "§7Español",
                            "§7English",
                            "§7Portugues"));
            lang.setItemMeta(langMeta);
            inv.setItem(13, lang);



            player.openInventory(inv);














        }


        return false;
    }
}
