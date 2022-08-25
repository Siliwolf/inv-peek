package invpeek.inv_peek;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class events implements Listener {
    @EventHandler
    void inv_close(InventoryCloseEvent c) {
        NamespacedKey key = new NamespacedKey(Inv_peek.getInstance(), "PeekedInv");

        if(c.getPlayer().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            Player p = Bukkit.getPlayer(c.getPlayer().getPersistentDataContainer().get(key, PersistentDataType.STRING));

            c.getPlayer().getPersistentDataContainer().remove(key);

            ItemStack[] contents = Arrays.copyOf(c.getInventory().getContents(), 41);

            p.getInventory().setContents(contents);
        }
    }
}
