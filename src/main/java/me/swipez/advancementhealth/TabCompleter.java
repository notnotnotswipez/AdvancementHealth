package me.swipez.advancementhealth;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1){
            List<String> playernames = new ArrayList<>();
            playernames.add("start");
            playernames.add("stop");
            playernames.add("reset");
            if (args[0].startsWith("s")){
                playernames.remove("reset");
            }
            if (args[0].contains("sta")){
                playernames.remove("stop");
                playernames.remove("reset");
            }
            if (args[0].contains("sto")){
                playernames.remove("start");
                playernames.remove("reset");
            }
            if (args[0].startsWith("r")){
                playernames.remove("start");
                playernames.remove("stop");
            }
            return playernames;
        }
        else if (args.length >= 2){
            List<String> nothing = new ArrayList<>();
            return nothing;
        }
        return null;
    }
}
