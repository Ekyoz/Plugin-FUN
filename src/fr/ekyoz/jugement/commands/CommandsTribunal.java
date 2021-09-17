package fr.ekyoz.jugement.commands;

import fr.ekyoz.jugement.EventsListener.Prisonners;
import fr.ekyoz.jugement.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandsTribunal implements CommandExecutor {


    private final Main main;

    public CommandsTribunal(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("tribunal")) {
            if (args.length != 0) {

                if (args[0].equalsIgnoreCase("juge")) {
                    player.sendMessage("§aVous êtes devenu le juge de cet condamnation!");
                    double x = main.getConfig().getDouble("Juge.x");
                    double y = main.getConfig().getDouble("Juge.y");
                    double z = main.getConfig().getDouble("Juge.z");
                    Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
                    player.teleport(loc);
                }

                if (args[0].equalsIgnoreCase("avocat")) {
                    player.sendMessage("§aVous êtes devenu le juge de cet condamnation!");
                    double x = main.getConfig().getDouble("Avocat.x");
                    double y = main.getConfig().getDouble("Avocat.y");
                    double z = main.getConfig().getDouble("Avocat.z");
                    Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
                    player.teleport(loc);
                }

                if (args[0].equalsIgnoreCase("spectateur")) {
                    player.sendMessage("§aVous êtes devenu le juge de cet condamnation!");
                    double x = main.getConfig().getDouble("Spectateur.x");
                    double y = main.getConfig().getDouble("Spectateur.y");
                    double z = main.getConfig().getDouble("Spectateur.z");
                    Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
                    player.teleport(loc);
                }


                if (args.length >= 3) {
                    if (args[0].equalsIgnoreCase("condamnation")) {
                        StringBuilder bc = new StringBuilder();
                        for (String part : args) {
                            bc.append(part + " ");
                        }
                        bc.delete(0, args[0].length() + args[1].length() + 2);
                        Bukkit.broadcastMessage("§4§l" + args[1] + "§f§r a été convoqué par §3§l" + player.getName() + "§f§r au tribunal:");
                        Bukkit.broadcastMessage("§f§l--------------Cause--------------");
                        Bukkit.broadcastMessage("§c" + bc.toString());
                        Player po = Bukkit.getPlayer(args[1]);
                        double x = main.getConfig().getDouble("Condamne.x");
                        double y = main.getConfig().getDouble("Condamne.y");
                        double z = main.getConfig().getDouble("Condamne.z");
                        Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
                        po.teleport(loc);
                        po.sendMessage("\n§cVous avez été téléporté au tribunal!");
                    }
                }


            } else {
                player.sendMessage("§3Commandes pour le tribunal:");
                player.sendMessage("§l§2/tribunal §f§rcondamnation <Pseudo> <cause> §7: pour créer une acusation");
                player.sendMessage("§l§2/tribunal §f§rjuge §7: pour devenir juge de la condamnation");
                player.sendMessage("§l§2/tribunal §f§ravocat §7: pour devenir l'avocat du jugé");
                player.sendMessage("§l§2/tribunal §f§rspectateur §7: pour participer a la condamnation");
            }

        }
        return true;
    }
}
