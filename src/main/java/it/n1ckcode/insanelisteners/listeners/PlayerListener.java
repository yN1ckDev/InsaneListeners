package it.n1ckcode.insanelisteners.listeners;

import it.n1ckcode.insanelisteners.InsaneListeners;
import it.n1ckcode.insanelisteners.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (InsaneListeners.getFileManager().getConfig().getBoolean("enable-join-message")) {
            Bukkit.broadcastMessage(CC.colorize(CC.getFormattedText("join-message").replace("%player%", event.getPlayer().getName())));
            event.setJoinMessage(null);
        } else {
            event.setJoinMessage(null);
        }
    }

    @EventHandler
    public void onJoin2(PlayerJoinEvent event) {
        if(InsaneListeners.getFileManager().getConfig().getBoolean("enable-first-join-message")) {
            if(!event.getPlayer().hasPlayedBefore()) {
               Bukkit.broadcastMessage(CC.colorize(CC.getFormattedText("first-join-message").replace("%player%", event.getPlayer().getName())));
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (InsaneListeners.getFileManager().getConfig().getBoolean("enable-quit-message")) {
            Bukkit.broadcastMessage(CC.colorize(CC.getFormattedText("quit-message").replace("%player%", event.getPlayer().getName())));
        } else {
            event.setQuitMessage(null);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (InsaneListeners.getFileManager().getConfig().getBoolean("disable-block-place")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (InsaneListeners.getFileManager().getConfig().getBoolean("disable-block-break")) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
        if(event.getPlayer().getGameMode() == GameMode.CREATIVE) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHungerLose(FoodLevelChangeEvent event) {
        if (InsaneListeners.getFileManager().getConfig().getBoolean("disable-hunger-lose")) {
            event.setFoodLevel(20);
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerPickupItem(EntityPickupItemEvent event) {
        if (InsaneListeners.getFileManager().getConfig().getBoolean("disable-player-pickup-item")) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (InsaneListeners.getFileManager().getConfig().getBoolean("disable-player-drop-item")) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            if (InsaneListeners.getFileManager().getConfig().getBoolean("disable-player-hit")) {
                event.setCancelled(true);
            } else {
                event.setCancelled(false);
            }
        }
    }
}