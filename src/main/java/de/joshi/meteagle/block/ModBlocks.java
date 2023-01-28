package de.joshi.meteagle.block;

import de.joshi.meteagle.MetEagle;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MetEagle.MODID);

	public static final RegistryObject<Block> MET_BLOCK = BLOCKS.register("met_block", () -> new Block(BlockBehaviour.Properties.of(Material.CAKE)));
	public static final RegistryObject<Block> MEAT_GRINDER = BLOCKS.register("meat_grinder", () -> new MeatGrinderBlock());

	public static void register(IEventBus modEventBus) {

		BLOCKS.register(modEventBus);
	}
}
