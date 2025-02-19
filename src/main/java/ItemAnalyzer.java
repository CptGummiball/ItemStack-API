import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.util.*;

public class ItemAnalyzer {
    private final ItemStack itemStack;
    private final ItemMeta meta;

    public ItemAnalyzer(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.meta = itemStack.getItemMeta();
    }

    public Material getMaterial() {
        return itemStack.getType();
    }

    public int getAmount() {
        return itemStack.getAmount();
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return meta.getEnchants();
    }

    public String getDisplayName() {
        return meta.hasDisplayName() ? meta.getDisplayName() : "No Name";
    }

    public List<String> getLore() {
        return meta.hasLore() ? meta.getLore() : new ArrayList<>();
    }

    public Set<ItemFlag> getItemFlags() {
        return meta.getItemFlags();
    }

    public boolean isUnbreakable() {
        return meta.isUnbreakable();
    }

    public Integer getCustomModelData() {
        return meta.hasCustomModelData() ? meta.getCustomModelData() : null;
    }

    public Color getLeatherArmorColor() {
        if (meta instanceof LeatherArmorMeta) {
            return ((LeatherArmorMeta) meta).getColor();
        }
        return null;
    }

    public UUID getSkullOwnerUUID() {
        if (meta instanceof SkullMeta) {
            SkullMeta skullMeta = (SkullMeta) meta;
            if (skullMeta.getOwningPlayer() != null) {
                return skullMeta.getOwningPlayer().getUniqueId();
            }
        }
        return null;
    }

    public String getSkullTexture() {
        if (meta instanceof SkullMeta) {
            SkullMeta skullMeta = (SkullMeta) meta;
            PlayerProfile profile = skullMeta.getOwnerProfile();
            if (profile != null && profile.getTextures() != null) {
                return profile.getTextures().getSkin().toString();
            }
        }
        return null;
    }

    public ArmorTrim getTrim() {
        if (meta instanceof ArmorMeta) {
            return ((ArmorMeta) meta).getTrim();
        }
        return null;
    }

    public Map<String, String> getPersistentData() {
        Map<String, String> dataMap = new HashMap<>();
        PersistentDataContainer container = meta.getPersistentDataContainer();

        for (NamespacedKey key : container.getKeys()) {
            String value = container.get(key, PersistentDataType.STRING);
            if (value != null) {
                dataMap.put(key.getKey(), value);
            }
        }
        return dataMap;
    }
}

