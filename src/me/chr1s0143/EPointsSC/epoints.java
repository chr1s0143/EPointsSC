package me.chr1s0143.EPointsSC;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
/**
 * Created by chris on 11/09/2014.
 */
public class epoints extends JavaPlugin {

    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (commandLabel.equalsIgnoreCase("epreload")) {
                if (player.hasPermission("epoints.reload")) {
                    reloadConfig();
                    player.sendMessage(ChatColor.DARK_GREEN + "Config File Has Been Reloaded!");
                }
                else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                }
            }
            else if (commandLabel.equalsIgnoreCase("epoints")) {
                if (player.hasPermission("epoints.use")) {
                    if (args.length == 0)
                        player.sendMessage(ChatColor.DARK_GREEN + player.getName() + ", try doing " + ChatColor.GOLD + "/epoints {player name}");
                    else if (args.length == 1) {
                        if (player.getServer().getPlayer(args[0]) != null) {
                            Player targetPlayer = player.getServer().getPlayer(args[0]);
                            getServer().dispatchCommand(getServer().getConsoleSender(), "enjin addpoints " + args[0] + " " + getConfig().getInt("Points"));

                            player.sendMessage(ChatColor.GOLD + " " + getConfig().getInt("Points") + " Points Added to " + ChatColor.GREEN + args[0] + "'s" + ChatColor.GOLD + " Enjin Account!"); }
                        else player.sendMessage(ChatColor.GOLD + "Player " + ChatColor.DARK_GREEN + args[0] + ChatColor.DARK_RED + " is not currently online. Please wait until they are online before using this command!" );
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                }
            }
        }
        return true;
    }
}
