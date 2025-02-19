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
import java.net.URL;
import java.util.*;

public class ItemBuilder {
    private final ItemStack itemStack;
    private final ItemMeta meta;

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.meta = itemStack.getItemMeta();
    }

    public ItemBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder addEnchantment(String enchantment, int level) {
        Enchantment ench = Enchantment.getByName(enchantment.toUpperCase());
        if (ench != null) {
            meta.addEnchant(ench, level, true);
        }
        return this;
    }

    public ItemBuilder addDisplayName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder addLore(String... lines) {
        List<String> lore = new ArrayList<>(Arrays.asList(lines));
        meta.setLore(lore);
        return this;
    }

    public ItemBuilder addPersistentData(String key, String value) {
        NamespacedKey namespacedKey = new NamespacedKey(Bukkit.getPluginManager().getPlugins()[0], key);
        PersistentDataContainer dataContainer = meta.getPersistentDataContainer();
        dataContainer.set(namespacedKey, PersistentDataType.STRING, value);
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... flags) {
        meta.addItemFlags(flags);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        meta.setUnbreakable(unbreakable);
        return this;
    }

    public ItemBuilder setCustomModelData(int modelData) {
        meta.setCustomModelData(modelData);
        return this;
    }

    public ItemBuilder setLeatherArmorColor(Color color) {
        if (meta instanceof LeatherArmorMeta) {
            ((LeatherArmorMeta) meta).setColor(color);
        }
        return this;
    }

    public ItemBuilder setSkullOwner(UUID ownerUUID) {
        if (meta instanceof SkullMeta) {
            ((SkullMeta) meta).setOwningPlayer(Bukkit.getOfflinePlayer(ownerUUID));
        }
        return this;
    }

    public ItemBuilder setSkullTexture(String url) {
        if (meta instanceof SkullMeta) {
            SkullMeta skullMeta = (SkullMeta) meta;
            try {
                PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID());
                PlayerTextures textures = profile.getTextures();
                textures.setSkin(new URL(url));
                profile.setTextures(textures);
                skullMeta.setOwnerProfile(profile);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public ItemBuilder addTrim(ArmorTrim trim) {
        if (meta instanceof ArmorMeta) {
            ((ArmorMeta) meta).setTrim(trim);
        }
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
