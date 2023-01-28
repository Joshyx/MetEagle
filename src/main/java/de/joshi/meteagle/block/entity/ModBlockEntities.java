package de.joshi.meteagle.block.entity;

import de.joshi.meteagle.MetEagle;
import de.joshi.meteagle.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
			DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MetEagle.MODID);

	public static final RegistryObject<BlockEntityType<MeatGrinderBlockEntity>> MEAT_GRINDER =
			BLOCK_ENTITIES.register("meat_grinder", () ->
					BlockEntityType.Builder.of(MeatGrinderBlockEntity::new,
							ModBlocks.MEAT_GRINDER.get()).build(null));


	public static void register(IEventBus eventBus) {
		BLOCK_ENTITIES.register(eventBus);
	}
}
