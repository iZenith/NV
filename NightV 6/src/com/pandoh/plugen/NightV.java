package com.pandoh.plugen;import org.bukkit.ChatColor;import org.bukkit.command.Command;import org.bukkit.command.CommandSender;import org.bukkit.entity.Player;import org.bukkit.permissions.Permission;import org.bukkit.plugin.PluginManager;import org.bukkit.plugin.java.JavaPlugin;import org.bukkit.potion.PotionEffect;import org.bukkit.potion.PotionEffectType;public class NightV extends JavaPlugin{public Permission nightV = new Permission("nightvision.access");@Override public void onEnable(){PluginManager perm = getServer().getPluginManager();perm.addPermission(nightV);}@Override public void onDisable(){	}public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){if (cmd.getName().equalsIgnoreCase("nv") && (sender instanceof Player)){Player p = (Player) sender;p.getServer().getWorld(getName());if (!(p.hasPermission("nightvision.access"))||!p.getServer().getWorld(getName()).equals("plots")||!p.getServer().getWorld(getName()).equals("plotworld")||!p.getServer().getWorld(getName()).equals("void")||!p.getServer().getWorld(getName()).equals("flatmap")){p.sendMessage(ChatColor.RED + "You don't have perms");return true;}else{if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)){p.removePotionEffect(PotionEffectType.NIGHT_VISION);p.sendMessage(ChatColor.RED + "Night Vision is now off");return true;}else{p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 10000000, 0, true, false));p.sendMessage(ChatColor.GREEN + "Night Vision is now on");return true;}}}return false;}}
