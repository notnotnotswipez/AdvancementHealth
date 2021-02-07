package me.swipez.advancementhealth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class AdvancementTrigger implements Listener {

    Advancementhealth plugin;

    public AdvancementTrigger(Advancementhealth plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerEarnAdvancement(PlayerAdvancementDoneEvent e){
        Player p = e.getPlayer();
        String adv = e.getAdvancement().getKey().toString();
        double maxhealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        if (!adv.contains("recipes")){
            if (plugin.gamestarted){
                p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxhealth-1);
            }
            Bukkit.broadcastMessage(p.getDisplayName()+" has just"+ ChatColor.GREEN+" [Decreased their health]");
        }
    }
}
