package me.swipez.advancementhealth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartGame implements CommandExecutor {

    Advancementhealth plugin;

    public StartGame(Advancementhealth plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("advancementchallenge.toggle")){
            if (sender instanceof Player){
                Player p = (Player) sender;
                if (args.length == 1){
                    if (args[0].equals("reset")){
                        Bukkit.broadcastMessage(ChatColor.GREEN+"Advancement challenge has reset and stopped!");
                        for (Player others : Bukkit.getOnlinePlayers()){
                            others.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                        }
                        plugin.gamestarted = false;
                    }
                    else if (args[0].equals("start")){
                        Bukkit.broadcastMessage(ChatColor.GREEN+"Advancement challenge has started!");
                        p.getWorld().setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
                        plugin.gamestarted = true;
                    }
                    else if (args[0].equals("stop")){
                        Bukkit.broadcastMessage(ChatColor.GREEN+"Advancement challenge has stopped!");
                        p.getWorld().setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, true);
                        plugin.gamestarted = true;
                    }
                    else{
                        p.sendMessage(ChatColor.RED+"/advchallenge <start/stop/reset>");
                    }
                }
                else {
                    p.sendMessage(ChatColor.RED+"/advchallenge <start/stop/reset>");
                }
            }
        }
        return true;
    }
}
