package dev.lillian.bonk.test.command.modifier;

import dev.lillian.bonk.core.command.CommandExecution;
import dev.lillian.bonk.core.modifier.ArgumentModifier;
import dev.lillian.bonk.core.parametric.CommandParameter;
import dev.lillian.bonk.test.command.annotation.Add;
import dev.lillian.bonk.test.model.CustomLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomLocationModifier implements ArgumentModifier<CustomLocation> {
    @Override
    public CustomLocation modify(@NotNull CommandExecution execution, @NotNull CommandParameter commandParameter, @Nullable CustomLocation argument) throws IllegalArgumentException {
        if (argument == null) {
            return null;
        }

        return commandParameter.getModifierAnnotations().stream()
                .filter(a -> a.annotationType().equals(Add.class))
                .findFirst()
                .map(Add.class::cast)
                .map(add -> new CustomLocation(argument.x() + add.value(), argument.y() + add.value(), argument.z() + add.value()))
                .orElse(null);
    }
}
