package invpeek.inv_peek;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Inv_peek extends JavaPlugin {
    private static Inv_peek INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("invpeek").setExecutor(new command());
        Bukkit.getPluginManager().registerEvents(new events(), this);
        INSTANCE = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Inv_peek getInstance() {
        return INSTANCE;
    }
}
