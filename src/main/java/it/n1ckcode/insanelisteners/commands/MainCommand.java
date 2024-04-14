package it.n1ckcode.insanelisteners.commands;

import it.n1ckcode.insanelisteners.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(CC.colorize("&8• &7Running &cInsaneListeners v1.0 &7by &cN1ckCode (@onEnable) &8•"));
        return false;
    }
}
