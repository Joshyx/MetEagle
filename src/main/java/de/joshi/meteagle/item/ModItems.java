package de.joshi.meteagle.item;

import de.joshi.meteagle.MetEagle;
import de.joshi.meteagle.block.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MetEagle.MODID);

	public static final RegistryObject<Item> MET_BLOCK_ITEM = ITEMS.register("met_block",
			() -> new BlockItem(ModBlocks.MET_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> BACON = ITEMS.register("bacon",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).build())));
	public static final RegistryObject<Item> SAUSAGE = ITEMS.register("sausage",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).build())));
	public static final RegistryObject<Item> MINCED_MEAT = ITEMS.register("minced_meat",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).build())));
	public static final RegistryObject<Item> KEBAB_MEAT = ITEMS.register("kebab_meat",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).build())));
	public static final RegistryObject<Item> SALAMI = ITEMS.register("salami",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).build())));
	public static final RegistryObject<Item> MEATBALL = ITEMS.register("meatball",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).build())));

	public static void register(IEventBus modEventBus) {

		ITEMS.register(modEventBus);
	}
}
