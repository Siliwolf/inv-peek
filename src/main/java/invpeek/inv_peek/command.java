package invpeek.inv_peek;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class command implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "You don't have the required permissions!");
            return false;
        }

        Player p = Bukkit.getPlayer(args[0]);
        Player admin = (Player) sender;

        Inventory i = Bukkit.createInventory(admin, 45, p.getName() + "'s inventory");

        ItemStack[] contents = new ItemStack[45];

        // Inventory Items
        for(int b = 0; b < 41; b++)
        {
            ItemStack c = p.getInventory().getItem(b);

            if(c != null)
            {
                contents[b] = c;
            }
            else
            {
                contents[b] = new ItemStack(Material.AIR);
            }
        }

        i.setContents(contents);

        NamespacedKey key = new NamespacedKey(Inv_peek.getInstance(), "PeekedInv");
        admin.getPersistentDataContainer().set(key, PersistentDataType.STRING, p.getName());

        admin.openInventory(i);

        return true;
    }

    public static String[] get_descriptor_item_lore() {
        String[] data = { "Top line: Hotbar", "Next three: Inventory", "Bottom line: Armor (in order of Helmet, Chestplate, Leggings, Boots) and offhand"};

        return data;
    }
}