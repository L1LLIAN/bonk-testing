package dev.lillian.bonk.test;

import dev.lillian.bonk.core.CommandRegistry;
import dev.lillian.bonk.spigot.SpigotCommandRegistry;
import dev.lillian.bonk.test.command.BonkCommands;
import dev.lillian.bonk.test.command.annotation.Add;
import dev.lillian.bonk.test.command.middleware.LoggerMiddleware;
import dev.lillian.bonk.test.command.modifier.CustomLocationModifier;
import dev.lillian.bonk.test.command.provider.CustomLocationProvider;
import dev.lillian.bonk.test.model.CustomLocation;
import org.bukkit.plugin.java.JavaPlugin;

public final class BonkTest extends JavaPlugin {
    @Override
    public void onEnable() {
        CommandRegistry commandRegistry = new SpigotCommandRegistry(this);

        commandRegistry.bind(CustomLocation.class).toProvider(new CustomLocationProvider());
        commandRegistry.registerModifier(Add.class, CustomLocation.class, new CustomLocationModifier());
        commandRegistry.registerMiddleware(new LoggerMiddleware());

        commandRegistry.register(new BonkCommands(), "bonk");
    }
}
