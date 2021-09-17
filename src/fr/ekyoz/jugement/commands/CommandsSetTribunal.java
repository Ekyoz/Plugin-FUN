package fr.ekyoz.jugement.commands;

import fr.ekyoz.jugement.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsSetTribunal implements CommandExecutor {

    private final Main main;

    public CommandsSetTribunal(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {

        Player player = (Player) sender;

        if (args[0].equalsIgnoreCase("juge")) {
            Location location = player.getLocation();
            main.getConfig().set("Juge.x", location.getX());
            main.getConfig().set("Juge.y", location.getY());
            main.getConfig().set("Juge.z", location.getZ());
            main.saveConfig();
            main.reloadConfig();
            player.sendMessage("La position pour le juge a été modifié :" + location.getX() + ", " + location.getY() + ", " + location.getZ());
        }

        if (args[0].equalsIgnoreCase("condamne")) {
            Location location = player.getLocation();
            main.getConfig().set("Condamne.x", location.getX());
            main.getConfig().set("Condamne.y", location.getY());
            main.getConfig().set("Condamne.z", location.getZ());
            main.saveConfig();
            main.reloadConfig();
            player.sendMessage("La position pour le juge a été modifié :" + location.getX() + ", " + location.getY() + ", " + location.getZ());
        }

        if (args[0].equalsIgnoreCase("avocat")) {
            Location location = player.getLocation();
            main.getConfig().set("Avocat.x", location.getX());
            main.getConfig().set("Avocat.y", location.getY());
            main.getConfig().set("Avocat.z", location.getZ());
            main.saveConfig();
            main.reloadConfig();
            player.sendMessage("La position pour le juge a été modifié :" + location.getX() + ", " + location.getY() + ", " + location.getZ());
        }

        if (args[0].equalsIgnoreCase("spectateur")) {
            Location location = player.getLocation();
            main.getConfig().set("Spectateur.x", location.getX());
            main.getConfig().set("Spectateur.y", location.getY());
            main.getConfig().set("Spectateur.z", location.getZ());
            main.saveConfig();
            main.reloadConfig();
            player.sendMessage("La position pour le juge a été modifié :" + location.getX() + ", " + location.getY() + ", " + location.getZ());
        }

        return false;
    }
}
