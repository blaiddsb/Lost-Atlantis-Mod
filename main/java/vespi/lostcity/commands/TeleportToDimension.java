package vespi.lostcity.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.dimension.DimensionType;
import vespi.lostcity.dimensions.ModDimensions;

public class TeleportToDimension implements Command<CommandSource> {
    private static final TeleportToDimension CMD = new TeleportToDimension();


    public static ArgumentBuilder<CommandSource,?> register (CommandDispatcher<CommandSource> dispatcher){
        return Commands.literal("tplostdim").requires(cs-> cs.hasPermissionLevel(0)).executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().asPlayer();
        int x = player.getPosition().getX();
        int z = player.getPosition().getZ();
        return 0;
    }
}
