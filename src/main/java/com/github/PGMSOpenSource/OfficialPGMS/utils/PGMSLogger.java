package com.github.PGMSOpenSource.OfficialPGMS.utils;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;

import com.github.PGMSOpenSource.OfficialPGMS.PGMS;

public class PGMSLogger {
	
	private static PGMS plugin;
	public PGMSLogger(PGMS instance){
		plugin = instance;
	}
	
	public static void log(String msg) {
		log("info", msg);
	}
        
        public static void info(String msg) {
            log("info",msg);
        }
        
        public static void warning(String msg) {
            log("warning",msg);
        }
        
        public static void severe(String msg) {
            log("severe",msg);
        }
        
        public static void debug(String msg) {
            log("debug",msg);
        }
	
	public static void log(String level, String msg) {
		Logger log = Bukkit.getLogger();
		PluginDescriptionFile pdf = plugin.getDescription();
		String prefix = "[" + pdf.getName() + "] ";
		switch(level){
		default:
		case "info":
			log.info(prefix + msg);
			break;
		case "warning":
			log.warning(prefix + msg);
			break;
		case "severe":
			log.severe(prefix + msg);
			break;
                case "debug":
                        prefix="[" + pdf.getName() + "-DEBUG]";
                        log.info(prefix + msg);
		}
	}
        
}
