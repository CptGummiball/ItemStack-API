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
import com.yourname.itemstackapi.ItemBuilder;
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

```java
import com.yourname.itemstackapi.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemFlag;

ItemAnalyzer analyzer = new ItemAnalyzer(myItem);
public class ExampleUsage {
  public static void main(String[] args) {
    System.out.println("Material: " + analyzer.getMaterial());
    System.out.println("Menge: " + analyzer.getAmount());
    System.out.println("Name: " + analyzer.getDisplayName());
    System.out.println("Verzauberungen: " + analyzer.getEnchantments());
    System.out.println("Unzerstörbar: " + analyzer.isUnbreakable());
    System.out.println("Lore: " + analyzer.getLore());
    System.out.println("Custom Model Data: " + analyzer.getCustomModelData());
    System.out.println("Persistent Data: " + analyzer.getPersistentData());
  }
}

````

## Features

### **Build an ItemStack**

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
  ```

### **Analyze an ItemStack**

- **Get the material type:**
  ```java
  analyzer.getMaterial(); // Returns Material.DIAMOND_SWORD
  ```

- **Get the item amount:**
  ```java
  analyzer.getAmount(); // Returns 1
  ```

- **Retrieve the display name:**
  ```java
  analyzer.getDisplayName(); // Returns "§6Epic Chestplate"
  ```

- **Get item lore:**
  ```java
  analyzer.getLore(); // Returns List<String> of lore lines
  ```

- **Check if item is unbreakable:**
  ```java
  analyzer.isUnbreakable(); // Returns true/false
  ```

- **Retrieve enchantments:**
  ```java
  analyzer.getEnchantments(); // Returns Map<Enchantment, Integer>
  ```

- **Get custom model data (if set):**
  ```java
  analyzer.getCustomModelData(); // Returns Integer or null
  ```

- **Retrieve leather armor color (if applicable):**
  ```java
  analyzer.getLeatherArmorColor(); // Returns Color or null
  ```

- **Get skull owner UUID (if applicable):**
  ```java
  analyzer.getSkullOwnerUUID(); // Returns UUID or null
  ```

- **Get skull texture URL:**
  ```java
  analyzer.getSkullTexture(); // Returns String or null
  ```

- **Retrieve armor trim details:**
  ```java
  analyzer.getTrim(); // Returns ArmorTrim or null
  ```

- **Get stored persistent data:**
  ```java
  analyzer.getPersistentData(); // Returns Map<String, String>
  ```


# [LICENSE](LICENSE)
  
