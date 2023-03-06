package plugin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

@Data
@AllArgsConstructor
public class Tool {
    private String[] shape;
    private NamespacedKey key;
    private Material material;
}
