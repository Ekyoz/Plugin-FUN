package fr.ekyoz.jugement.EventsListener;

import fr.ekyoz.jugement.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PrisonnersListener implements Listener {


    private final Main main;

    public PrisonnersListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        if (Prisonners.getPrisonners().contains(player)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if (main.getConfig().getList("prisonner.players").contains(e.getPlayer().getName())){
            Prisonners.prisonners.add(e.getPlayer());
        }
    }

}
