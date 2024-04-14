package it.n1ckcode.insanelisteners.utils;

import it.n1ckcode.insanelisteners.InsaneListeners;
import org.bukkit.ChatColor;

public class CC {
    public static String colorize(final String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public static String getFormattedText(String path) {
        return CC.colorize(InsaneListeners.getFileManager().getMessages().getString(path));
    }
}
