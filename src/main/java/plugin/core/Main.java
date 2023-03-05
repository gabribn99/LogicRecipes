package plugin.core;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.recipes.CraftingRecipes;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        setRecipes();
        Bukkit.getConsoleSender().sendMessage("Logic Recipes está activado");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Logic Recipes está desactivado");
    }

    public void setRecipes(){
        CraftingRecipes craftingRecipes = new CraftingRecipes(this);

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(craftingRecipes.getSaddle());

        recipes.forEach(recipe -> Bukkit.addRecipe(recipe));
    }
}
