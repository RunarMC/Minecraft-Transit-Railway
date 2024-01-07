package mtr.block;

import mtr.Items;
import mtr.SoundEvents;
import mtr.data.TicketSystem;
import mtr.data.remote.balance.database.UpdatePlayerBalance;
import mtr.mappings.Text;
import mtr.mappings.Utilities;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockTicketProcessorEnquiry extends BlockTicketProcessor {

	public BlockTicketProcessorEnquiry() {
		super(false, false, false);
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
		if (!world.isClientSide) {
			final int balance = TicketSystem.getRemote().getPlayerBalance(player);

			if (balance < 8) {
				player.displayClientMessage(new TextComponent("Your balance is insufficient."), true);
				world.playSound(null, pos, SoundEvents.TICKET_PROCESSOR_FAIL, SoundSource.BLOCKS, 1, 1);
				return InteractionResult.FAIL;
			}

			// Making a debit of 8
			TicketSystem.getRemote().updateBalance(player, UpdatePlayerBalance.Operation.DEBIT, 8);

			Utilities.getInventory(player).add(new ItemStack(Items.TICKET.get(), 1));

			player.displayClientMessage(new TextComponent("You paid 8₽ for 'Single-use ticket'").withStyle(ChatFormatting.GREEN), true);
			world.playSound(null, pos, SoundEvents.TICKET_PROCESSOR_ENTRY, SoundSource.BLOCKS, 1, 1);
		}
		return InteractionResult.SUCCESS;
	}
}
