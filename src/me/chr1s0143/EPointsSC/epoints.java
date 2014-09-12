package me.chr1s0143.EPointsSC;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
/**
 * Created by chris on 11/09/2014.
 */
public class epoints extends JavaPlugin {

    public void onEnable() {
        PluginDescriptionFile pluginFile = getDescription();
        getLogger().info(pluginFile.getName() + " is now enabled!.");
    }

    public void onDisable() {
        PluginDescriptionFile pluginFile = getDescription();
        getLogger().info(pluginFile.getName() + " is now disabled.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("epoints")) {
                Player player = (Player) sender;
                if (player.hasPermission("epoints.use"))
                    if (args.length == 0)
                        player.sendMessage(ChatColor.GREEN + player.getName() +"," + " try doing " + ChatColor.GOLD + "/epoints {player name}");
                    else if (args.length == 1) {
                        getServer().dispatchCommand(getServer().getConsoleSender(), "enjin addpoints " + args[0] + " 2");

                        player.sendMessage(ChatColor.GOLD + "2 Points Added to " + ChatColor.GREEN + args[0] + "'s" + ChatColor.GOLD + " Enjin Account!");


                    }
            }
        }
        return false;

    }
}