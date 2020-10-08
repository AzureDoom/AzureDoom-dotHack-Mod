package mod.azure.dothack.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

public class HackChestBlock extends Block {

	public static final DirectionProperty direction = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty light = RedstoneTorchBlock.LIT;

	public HackChestBlock(AbstractBlock.Properties builder) {
		super(builder);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(direction, context.getPlacementHorizontalFacing());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(direction, rot.rotate(state.get(direction)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(direction)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(direction, light);
	}
}