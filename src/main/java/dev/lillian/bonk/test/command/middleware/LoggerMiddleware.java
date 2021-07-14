package dev.lillian.bonk.test.command.middleware;

import dev.lillian.bonk.core.command.WrappedCommand;
import dev.lillian.bonk.core.executor.CommandExecutor;
import dev.lillian.bonk.spigot.middleware.SpigotMiddleware;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class LoggerMiddleware implements SpigotMiddleware {
    @Override
    public @NotNull Result run(@NotNull CommandExecutor<CommandSender> executor, @NotNull WrappedCommand command) {
        System.out.println("Executing command: " + command.getName());
        return Result.OK;
    }
}
