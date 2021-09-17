package fr.ekyoz.jugement.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandsTribunalTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {

        if (args.length == 1){
            List<String> commands = new ArrayList<>();
            commands.add("condamnation");
            commands.add("juge");
            commands.add("avocat");
            commands.add("spectateur");

            return commands;

        }

        if (args[1].equalsIgnoreCase("condamnation")){
            List<String> playersNames = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);
            for (int i = 0; i < players.length; i++){
                playersNames.add(players[i].getName());
            }
            return playersNames;

        }

        return null;

    }
}
