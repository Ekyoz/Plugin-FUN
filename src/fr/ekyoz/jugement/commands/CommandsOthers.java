package fr.ekyoz.jugement.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandsOthers implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("alert")){
                if (args.length == 0){
                    player.sendMessage("La commande manque d'argument : /alert <message>");
                }
                if (args.length >= 1){
                    StringBuilder bc = new StringBuilder();
                    for(String part : args){
                        bc.append(part +" ");
                    }
                    Bukkit.broadcastMessage("[" +player.getName() + "] " + ChatColor.BLUE + bc.toString());
                }

                return true;
            }
            if (cmd.getName().equalsIgnoreCase("day")){
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String command = "time set day";
                Bukkit.dispatchCommand(console, command);
            }
            if (cmd.getName().equalsIgnoreCase("night")){
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String command = "time set night";
                Bukkit.dispatchCommand(console, command);
            }
            if (cmd.getName().equalsIgnoreCase("wclear")){
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String command = "weather clear";
                Bukkit.dispatchCommand(console, command);
            }
            if (cmd.getName().equalsIgnoreCase("wrain")){
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String command = "weather rain";
                Bukkit.dispatchCommand(console, command);
            }
            if (cmd.getName().equalsIgnoreCase("wthunder")){
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String command = "weather thunder";
                Bukkit.dispatchCommand(console, command);
            }


        }

        return false;
    }
}
