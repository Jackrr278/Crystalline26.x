package com.jackrr.crystalline.item;

import com.jackrr.crystalline.Crystalline;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Crystalline.MODID);

    public static final DeferredItem<Item> RUBY_GEMSTONE = ITEMS.registerItem("ruby_gemstone",
            ItemGem::new,
            properties -> properties
                    .stacksTo(1)
                    .fireResistant()
    );





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
