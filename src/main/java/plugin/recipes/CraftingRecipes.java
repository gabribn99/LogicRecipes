package plugin.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import plugin.entities.Tool;
import plugin.utils.Utils;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ShapedRecipe getBread() {
        ItemStack item = new ItemStack(Material.BREAD);
        NamespacedKey key = new NamespacedKey(plugin, "bread");
        item.setAmount(9);
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("   ", "HHH");
        recipe.setIngredient('H', Material.HAY_BLOCK);

        return recipe;
    }

    public List<ShapedRecipe> getBlocksFromSlab() {
        List<ShapedRecipe> recipes = new ArrayList<>();
        Map<Material, Material> blocks = getSlabsBlocks();
        blocks.forEach((bloque, slab) -> {
            ItemStack item = new ItemStack(bloque);
            NamespacedKey key = new NamespacedKey(plugin, bloque.getKey().getKey().toLowerCase() + "_from_" + slab.getKey().getKey().toLowerCase());
            ShapedRecipe recipe = new ShapedRecipe(key, item);
            recipe.shape("S", "S");
            recipe.setIngredient('S', slab);
            recipes.add(recipe);
        });
        return recipes;
    }

    public List<ShapedRecipe> getBlocksFromStairs() {
        List<ShapedRecipe> recipes = new ArrayList<>();
        Map<Material, Material> blocks = getStairsBlocks();
        blocks.forEach((bloque, stairs) -> {
            ItemStack item = new ItemStack(bloque);
            item.setAmount(3);
            NamespacedKey key = new NamespacedKey(plugin, bloque.getKey().getKey().toLowerCase() + "_from_" + stairs.getKey().getKey().toLowerCase());
            ShapedRecipe recipe = new ShapedRecipe(key, item);
            recipe.shape("S", "S");
            recipe.setIngredient('S', stairs);
            recipes.add(recipe);
        });
        return recipes;
    }

    public List<ShapedRecipe> getCopperTools() {
        List<ShapedRecipe> copperTools = new ArrayList<>();
        List<Tool> tools = getTools();

        tools.forEach(tool -> {
            NamespacedKey key = tool.getKey();
            String name = Utils.capitalizeFully(key.getKey().replace("_", " "));
            Material material = tool.getMaterial();
            String[] shape = tool.getShape();

            ItemStack item = new ItemStack(material);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(name);
            item.setItemMeta(meta);
            item.addEnchantment(Enchantment.DURABILITY, 1);
            item.addEnchantment((material == Material.STONE_SWORD) ? Enchantment.DAMAGE_ALL : Enchantment.DIG_SPEED, 1);
            ShapedRecipe recipe = new ShapedRecipe(key, item);
            recipe.shape(shape[0], shape[1], shape[2]);
            recipe.setIngredient('C', Material.COPPER_INGOT);
            recipe.setIngredient('S', Material.STICK);
            copperTools.add(recipe);
        });
        return copperTools;
    }

    private List<Tool> getTools() {
        List<Tool> tools = new ArrayList<>();
        tools.add(new Tool(new String[]{" CC", " SC", " S "}, new NamespacedKey(plugin, "copper_axe"), Material.STONE_AXE));
        tools.add(new Tool(new String[]{"CCC", " S ", " S "}, new NamespacedKey(plugin, "copper_pickaxe"), Material.STONE_PICKAXE));
        tools.add(new Tool(new String[]{" CC", " S ", " S "}, new NamespacedKey(plugin, "copper_hoe"), Material.STONE_HOE));
        tools.add(new Tool(new String[]{" C ", " C ", " S "}, new NamespacedKey(plugin, "copper_sword"), Material.STONE_SWORD));
        tools.add(new Tool(new String[]{" C ", " S ", " S "}, new NamespacedKey(plugin, "copper_shovel"), Material.STONE_SHOVEL));
        return tools;
    }

    private Map<Material, Material> getSlabsBlocks() {

        Map<Material, Material> blocks = new HashMap<>();
        blocks.put(Material.OAK_PLANKS, Material.OAK_SLAB);
        blocks.put(Material.SPRUCE_PLANKS, Material.SPRUCE_SLAB);
        blocks.put(Material.BIRCH_PLANKS, Material.BIRCH_SLAB);
        blocks.put(Material.JUNGLE_PLANKS, Material.JUNGLE_SLAB);
        blocks.put(Material.ACACIA_PLANKS, Material.ACACIA_SLAB);
        blocks.put(Material.DARK_OAK_PLANKS, Material.DARK_OAK_SLAB);
        blocks.put(Material.MANGROVE_PLANKS, Material.MANGROVE_SLAB);
        blocks.put(Material.CRIMSON_PLANKS, Material.CRIMSON_SLAB);
        blocks.put(Material.WARPED_PLANKS, Material.WARPED_SLAB);
        blocks.put(Material.STONE, Material.STONE_SLAB);
        blocks.put(Material.COBBLESTONE, Material.COBBLESTONE_SLAB);
        blocks.put(Material.MOSSY_COBBLESTONE, Material.MOSSY_COBBLESTONE_SLAB);
        blocks.put(Material.SMOOTH_STONE, Material.SMOOTH_STONE_SLAB);
        blocks.put(Material.STONE_BRICKS, Material.STONE_BRICK_SLAB);
        blocks.put(Material.MOSSY_STONE_BRICKS, Material.MOSSY_STONE_BRICK_SLAB);
        blocks.put(Material.GRANITE, Material.GRANITE_SLAB);
        blocks.put(Material.POLISHED_GRANITE, Material.POLISHED_GRANITE_SLAB);
        blocks.put(Material.DIORITE, Material.DIORITE_SLAB);
        blocks.put(Material.POLISHED_DIORITE, Material.POLISHED_DIORITE_SLAB);
        blocks.put(Material.ANDESITE, Material.ANDESITE_SLAB);
        blocks.put(Material.POLISHED_ANDESITE, Material.POLISHED_ANDESITE_SLAB);
        blocks.put(Material.COBBLED_DEEPSLATE, Material.COBBLED_DEEPSLATE_SLAB);
        blocks.put(Material.POLISHED_DEEPSLATE, Material.POLISHED_DEEPSLATE_SLAB);
        blocks.put(Material.DEEPSLATE_BRICKS, Material.DEEPSLATE_BRICK_SLAB);
        blocks.put(Material.DEEPSLATE_TILES, Material.DEEPSLATE_TILE_SLAB);
        blocks.put(Material.BRICKS, Material.BRICK_SLAB);
        blocks.put(Material.MUD_BRICKS, Material.MUD_BRICK_SLAB);
        blocks.put(Material.SANDSTONE, Material.SANDSTONE_SLAB);
        blocks.put(Material.SMOOTH_SANDSTONE, Material.SMOOTH_SANDSTONE_SLAB);
        blocks.put(Material.CUT_SANDSTONE, Material.CUT_SANDSTONE_SLAB);
        blocks.put(Material.RED_SANDSTONE, Material.RED_SANDSTONE_SLAB);
        blocks.put(Material.SMOOTH_RED_SANDSTONE, Material.SMOOTH_RED_SANDSTONE_SLAB);
        blocks.put(Material.CUT_RED_SANDSTONE, Material.CUT_RED_SANDSTONE_SLAB);
        blocks.put(Material.PRISMARINE, Material.PRISMARINE_SLAB);
        blocks.put(Material.PRISMARINE_BRICKS, Material.PRISMARINE_BRICK_SLAB);
        blocks.put(Material.DARK_PRISMARINE, Material.DARK_PRISMARINE_SLAB);
        blocks.put(Material.NETHER_BRICKS, Material.NETHER_BRICK_SLAB);
        blocks.put(Material.RED_NETHER_BRICKS, Material.RED_NETHER_BRICK_SLAB);
        blocks.put(Material.BLACKSTONE, Material.BLACKSTONE_SLAB);
        blocks.put(Material.POLISHED_BLACKSTONE, Material.POLISHED_BLACKSTONE_SLAB);
        blocks.put(Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICK_SLAB);
        blocks.put(Material.END_STONE_BRICKS, Material.END_STONE_BRICK_SLAB);
        blocks.put(Material.PURPUR_BLOCK, Material.PURPUR_SLAB);
        blocks.put(Material.QUARTZ, Material.QUARTZ_SLAB);
        blocks.put(Material.SMOOTH_QUARTZ, Material.SMOOTH_QUARTZ_SLAB);
        blocks.put(Material.CUT_COPPER, Material.CUT_COPPER_SLAB);
        blocks.put(Material.EXPOSED_CUT_COPPER, Material.EXPOSED_CUT_COPPER_SLAB);
        blocks.put(Material.WEATHERED_CUT_COPPER, Material.WEATHERED_CUT_COPPER_SLAB);
        blocks.put(Material.OXIDIZED_CUT_COPPER, Material.OXIDIZED_CUT_COPPER_SLAB);
        blocks.put(Material.WAXED_CUT_COPPER, Material.WAXED_CUT_COPPER_SLAB);
        blocks.put(Material.WAXED_WEATHERED_CUT_COPPER, Material.WAXED_WEATHERED_CUT_COPPER_SLAB);
        blocks.put(Material.WAXED_OXIDIZED_CUT_COPPER, Material.WAXED_OXIDIZED_CUT_COPPER_SLAB);

        return blocks;
    }

    private Map<Material, Material> getStairsBlocks() {

        Map<Material, Material> blocks = new HashMap<>();
        blocks.put(Material.OAK_PLANKS, Material.OAK_STAIRS);
        blocks.put(Material.SPRUCE_PLANKS, Material.SPRUCE_STAIRS);
        blocks.put(Material.BIRCH_PLANKS, Material.BIRCH_STAIRS);
        blocks.put(Material.JUNGLE_PLANKS, Material.JUNGLE_STAIRS);
        blocks.put(Material.ACACIA_PLANKS, Material.ACACIA_STAIRS);
        blocks.put(Material.DARK_OAK_PLANKS, Material.DARK_OAK_STAIRS);
        blocks.put(Material.MANGROVE_PLANKS, Material.MANGROVE_STAIRS);
        blocks.put(Material.CRIMSON_PLANKS, Material.CRIMSON_STAIRS);
        blocks.put(Material.WARPED_PLANKS, Material.WARPED_STAIRS);
        blocks.put(Material.STONE, Material.STONE_STAIRS);
        blocks.put(Material.COBBLESTONE, Material.COBBLESTONE_STAIRS);
        blocks.put(Material.MOSSY_COBBLESTONE, Material.MOSSY_COBBLESTONE_STAIRS);
        blocks.put(Material.STONE_BRICKS, Material.STONE_BRICK_STAIRS);
        blocks.put(Material.MOSSY_STONE_BRICKS, Material.MOSSY_STONE_BRICK_STAIRS);
        blocks.put(Material.GRANITE, Material.GRANITE_STAIRS);
        blocks.put(Material.POLISHED_GRANITE, Material.POLISHED_GRANITE_STAIRS);
        blocks.put(Material.DIORITE, Material.DIORITE_STAIRS);
        blocks.put(Material.POLISHED_DIORITE, Material.POLISHED_DIORITE_STAIRS);
        blocks.put(Material.ANDESITE, Material.ANDESITE_STAIRS);
        blocks.put(Material.POLISHED_ANDESITE, Material.POLISHED_ANDESITE_STAIRS);
        blocks.put(Material.COBBLED_DEEPSLATE, Material.COBBLED_DEEPSLATE_STAIRS);
        blocks.put(Material.POLISHED_DEEPSLATE, Material.POLISHED_DEEPSLATE_STAIRS);
        blocks.put(Material.DEEPSLATE_BRICKS, Material.DEEPSLATE_BRICK_STAIRS);
        blocks.put(Material.DEEPSLATE_TILES, Material.DEEPSLATE_TILE_STAIRS);
        blocks.put(Material.BRICKS, Material.BRICK_STAIRS);
        blocks.put(Material.MUD_BRICKS, Material.MUD_BRICK_STAIRS);
        blocks.put(Material.SANDSTONE, Material.SANDSTONE_STAIRS);
        blocks.put(Material.SMOOTH_SANDSTONE, Material.SMOOTH_SANDSTONE_STAIRS);
        blocks.put(Material.RED_SANDSTONE, Material.RED_SANDSTONE_STAIRS);
        blocks.put(Material.SMOOTH_RED_SANDSTONE, Material.SMOOTH_RED_SANDSTONE_STAIRS);
        blocks.put(Material.PRISMARINE, Material.PRISMARINE_STAIRS);
        blocks.put(Material.PRISMARINE_BRICKS, Material.PRISMARINE_BRICK_STAIRS);
        blocks.put(Material.DARK_PRISMARINE, Material.DARK_PRISMARINE_STAIRS);
        blocks.put(Material.NETHER_BRICKS, Material.NETHER_BRICK_STAIRS);
        blocks.put(Material.RED_NETHER_BRICKS, Material.RED_NETHER_BRICK_STAIRS);
        blocks.put(Material.BLACKSTONE, Material.BLACKSTONE_STAIRS);
        blocks.put(Material.POLISHED_BLACKSTONE, Material.POLISHED_BLACKSTONE_STAIRS);
        blocks.put(Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BRICK_STAIRS);
        blocks.put(Material.END_STONE_BRICKS, Material.END_STONE_BRICK_STAIRS);
        blocks.put(Material.PURPUR_BLOCK, Material.PURPUR_STAIRS);
        blocks.put(Material.QUARTZ, Material.QUARTZ_STAIRS);
        blocks.put(Material.SMOOTH_QUARTZ, Material.SMOOTH_QUARTZ_STAIRS);
        blocks.put(Material.CUT_COPPER, Material.CUT_COPPER_STAIRS);
        blocks.put(Material.EXPOSED_CUT_COPPER, Material.EXPOSED_CUT_COPPER_STAIRS);
        blocks.put(Material.WEATHERED_CUT_COPPER, Material.WEATHERED_CUT_COPPER_STAIRS);
        blocks.put(Material.OXIDIZED_CUT_COPPER, Material.OXIDIZED_CUT_COPPER_STAIRS);
        blocks.put(Material.WAXED_CUT_COPPER, Material.WAXED_CUT_COPPER_STAIRS);
        blocks.put(Material.WAXED_WEATHERED_CUT_COPPER, Material.WAXED_WEATHERED_CUT_COPPER_STAIRS);
        blocks.put(Material.WAXED_OXIDIZED_CUT_COPPER, Material.WAXED_OXIDIZED_CUT_COPPER_STAIRS);

        return blocks;
    }
}
























