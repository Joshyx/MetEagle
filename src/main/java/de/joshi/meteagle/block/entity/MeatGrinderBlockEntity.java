package de.joshi.meteagle.block.entity;

import de.joshi.meteagle.MetEagle;
import de.joshi.meteagle.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MeatGrinderBlockEntity extends BlockEntity implements MenuProvider {

	private final ItemStackHandler itemStackHandler = new ItemStackHandler(3) {
		@Override
		protected void onContentsChanged(int slot) {
			setChanged();
		}
	};
	private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

	public MeatGrinderBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(ModBlockEntities.MEAT_GRINDER.get(), blockPos, blockState);
	}

	@Override
	public Component getDisplayName() {
		return Component.translatable("block." + MetEagle.MODID + ".meat_grinder");
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int p_39954_, Inventory inventory, Player player) {
		return null;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @NotNull Direction side) {
		if(cap == ForgeCapabilities.ITEM_HANDLER) {
			return lazyItemHandler.cast();
		}

		return super.getCapability(cap, side);
	}

	@Override
	public void onLoad() {
		super.onLoad();
		lazyItemHandler = LazyOptional.of(() -> itemStackHandler);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		lazyItemHandler.invalidate();
	}

	@Override
	protected void saveAdditional(CompoundTag nbt) {
		nbt.put("inventory", itemStackHandler.serializeNBT());
		super.saveAdditional(nbt);
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		itemStackHandler.deserializeNBT(nbt.getCompound("inventory"));
	}

	public void drops() {
		SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
		for (int i = 0; i < itemStackHandler.getSlots(); i++) {
			inventory.setItem(i, itemStackHandler.getStackInSlot(i));
		}

		Containers.dropContents(this.level, this.worldPosition, inventory);
	}

	public static void tick(Level level, BlockPos blockPos, BlockState blockState, MeatGrinderBlockEntity entity) {
		if(level.isClientSide) {
			return;
		}
	}
}
