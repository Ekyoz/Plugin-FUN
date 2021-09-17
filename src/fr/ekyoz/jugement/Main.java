package fr.ekyoz.jugement;

import fr.ekyoz.jugement.EventsListener.PrisonnersListener;
import fr.ekyoz.jugement.EventsListener.PrisonnersTab;
import fr.ekyoz.jugement.commands.*;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //other
        getCommand("test").setExecutor(new CommandsOthers());
        getCommand("alert").setExecutor(new CommandsOthers());
        getCommand("day").setExecutor(new CommandsOthers());
        getCommand("night").setExecutor(new CommandsOthers());
        getCommand("wclear").setExecutor(new CommandsOthers());
        getCommand("wrain").setExecutor(new CommandsOthers());
        getCommand("wthunder").setExecutor(new CommandsOthers());
        //tribunal
        getCommand("tribunal").setExecutor(new CommandsTribunal(this));
        getCommand("tribunal").setTabCompleter(new CommandsTribunalTab());
        //settribunal
        getCommand("settribunal").setExecutor(new CommandsSetTribunal(this));
        getCommand("settribunal").setTabCompleter(new CommandsSetTribunalTab());
        //Prisonners
        getCommand("prison").setExecutor(new CommandsPrisonniers(this));
        getCommand("prison").setTabCompleter(new PrisonnersTab());
        getCommand("sortie").setExecutor(new CommandsPrisonniers(this));
        getCommand("sortie").setTabCompleter(new PrisonnersTab());
        //listener
        getServer().getPluginManager().registerEvents(new PluginListener(), this);
        getServer().getPluginManager().registerEvents(new PrisonnersListener(this), this);
        System.out.println("Le plugin est actif");

        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
    }

    @Override
    public void onDisable() {
        System.out.println("Le plugin est desactivé");
    }
}
