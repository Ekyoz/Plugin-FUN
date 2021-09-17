package fr.ekyoz.jugement.EventsListener;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Prisonners {

    public static List<Player> prisonners = new ArrayList<>();

    public static List<Player> getPrisonners() {
        return prisonners;
    }

    public static void setPrisonners(List<Player> prisonners) {
        Prisonners.prisonners = prisonners;
    }
}
