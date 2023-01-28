package de.joshi.meteagle.item;

import de.joshi.meteagle.MetEagle;
import de.joshi.meteagle.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.event.CreativeModeTabEvent;

import java.util.Arrays;
import java.util.function.Supplier;

public class ModTabs {
	public static CreativeModeTab MET_EAGLE;

	public static void addTabItems(CreativeModeTabEvent.BuildContents event) {

		if (event.getTab() == MET_EAGLE) {
			event.acceptAll(Arrays.asList(
					ModItems.MET_BLOCK_ITEM.get().getDefaultInstance(),
					ModItems.BACON.get().getDefaultInstance(),
					ModItems.SAUSAGE.get().getDefaultInstance(),
					ModItems.MINCED_MEAT.get().getDefaultInstance(),
					ModItems.KEBAB_MEAT.get().getDefaultInstance(),
					ModItems.SALAMI.get().getDefaultInstance(),
					ModItems.MEATBALL.get().getDefaultInstance()
			));
		}
	}
	public static void registerItemTabs(CreativeModeTabEvent.Register event) {

		MET_EAGLE = event.registerCreativeModeTab(new ResourceLocation("tab." + MetEagle.MODID + ".meteagle"), builder -> {
			builder.icon(new Supplier<ItemStack>() {
				@Override
				public ItemStack get() {
					return ModItems.BACON.get().getDefaultInstance();
				}
			}).title(Component.translatable("tab." + MetEagle.MODID + ".meteagle"));
		});
	}
}
