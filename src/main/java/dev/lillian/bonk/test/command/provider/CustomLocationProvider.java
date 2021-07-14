package dev.lillian.bonk.test.command.provider;

import dev.lillian.bonk.core.argument.CommandArg;
import dev.lillian.bonk.core.executor.CommandExecutor;
import dev.lillian.bonk.core.provider.ArgumentProvider;
import dev.lillian.bonk.test.model.CustomLocation;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.util.List;

public final class CustomLocationProvider implements ArgumentProvider<CustomLocation> {
    @Override
    public @NotNull CustomLocation provide(@NotNull CommandArg commandArg, @NotNull List<? extends Annotation> list) throws IllegalArgumentException {
        String[] split = commandArg.get().split(",");
        if (split.length != 3) {
            throw new IllegalArgumentException("Invalid location!");
        }

        double x;
        double y;
        double z;
        try {
            x = Double.parseDouble(split[0]);
            y = Double.parseDouble(split[1]);
            z = Double.parseDouble(split[2]);
        } catch (NumberFormatException ignored) {
            throw new IllegalArgumentException(commandArg.get() + " is invalid!");
        }

        return new CustomLocation(x, y, z);
    }

    @Override
    public @NotNull String argumentDescription() {
        return "x,y,z";
    }

    @Override
    public @NotNull List<String> provideSuggestions(@NotNull CommandExecutor<?> commandExecutor, @NotNull String s) {
        return List.of("0,0,0", "-583,70,125");
    }
}
