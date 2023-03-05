package plugin.recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class CraftingRecipes {
    Plugin plugin;

    public CraftingRecipes(Plugin plugin) {
        this.plugin = plugin;
    }

    public ShapedRecipe getSaddle() {
        ItemStack item = new ItemStack(Material.SADDLE);
        NamespacedKey key = new NamespacedKey(plugin, "saddle");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("CCC", "L L");
        recipe.setIngredient('C', Material.LEATHER);
        recipe.setIngredient('L', Material.LEAD);
        return recipe;
    }
}
