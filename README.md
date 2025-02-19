# ItemStack-API

A simple way to create ItemStacks in Spigot projects.

## Integration

Add the following repository and dependency to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.CptGummiball</groupId>
    <artifactId>ItemStack-API</artifactId>
    <version>1.0</version>
</dependency>
```

Alternatively, you can manually add the JAR file to the `/libs` folder of your project.

## Usage

```java
import com.yourname.itemstack-api.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemFlag;

public class ExampleUsage {
    public static void main(String[] args) {
        ItemStack myItem = new ItemBuilder(Material.DIAMOND_SWORD)
            .addEnchantment("DAMAGE_ALL", 5)
            .addDisplayName("&cLegendary Sword")
            .addLore("&7This sword is powerful!", "&eGrants incredible strength.")
            .addPersistentData("flag", "test")
            .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
            .setUnbreakable(true)
            .setCustomModelData(1234)
            .build();
    }
}
```

## Features

- **Set a custom name:**  
  ```java
  .addDisplayName("§6Epic Chestplate")
  ```

- **Add lore:**  
  ```java
  .addLore("§7This armor is indestructible!", "§eRadiates a legendary glow.")
  ```

- **Make unbreakable:**  
  ```java
  .setUnbreakable(true)
  ```

- **Apply armor trim (example for trims):**  
  ```java
  .addTrim(new ArmorTrim(Material.GOLD_INGOT, TrimPattern.WAVY))
  ```

- **Set leather armor color (if applicable):**  
  ```java
  .setLeatherArmorColor(Color.PURPLE)
  ```

- **Add enchantments:**  
  ```java
  .addEnchantment("PROTECTION_ENVIRONMENTAL", 4)
  ```

- **Store custom persistent data:**  
  ```java
  .addPersistentData("owner", "Player123")
  ```

- **Hide item attributes:**  
  ```java
  .addItemFlags(ItemFlag.HIDE_ENCHANTS)


# [LICENSE](LICENSE)
  
