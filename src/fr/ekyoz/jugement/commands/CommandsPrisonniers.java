package fr.ekyoz.jugement.commands;

import fr.ekyoz.jugement.EventsListener.Prisonners;
import fr.ekyoz.jugement.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsPrisonniers implements CommandExecutor {

    private final Main main;

    public CommandsPrisonniers(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("prison")){
            if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))){
                Player p = Bukkit.getPlayer(args[0]);
                Prisonners.prisonners.add(p);
                Prisonners.prisonners.forEach((player -> main.getConfig().set("prisonner.players", player.getName())));
                main.saveConfig();
                p.setOp(false);
            }
            else {
                sender.sendMessage("Le joueur n'existe pas ou n'est pas connecté.");
            }
        }

        if (cmd.getName().equalsIgnoreCase("sortie")){
            if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))){
                Player p = Bukkit.getPlayer(args[0]);
                Prisonners.prisonners.remove(p);
                Prisonners.prisonners.forEach((player -> main.getConfig().set("prisonner.players", player.getName())));
                main.saveConfig();
                p.setOp(true);

            }
            else {
                sender.sendMessage("Le joueur n'existe pas ou n'est pas connecté.");
            }
        }

        return false;

    }
}
