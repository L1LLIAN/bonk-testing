package dev.lillian.bonk.test.command;

import dev.lillian.bonk.core.annotation.Command;
import dev.lillian.bonk.core.annotation.Flag;
import dev.lillian.bonk.core.annotation.OptArg;
import dev.lillian.bonk.core.annotation.Sender;
import dev.lillian.bonk.test.command.annotation.Add;
import dev.lillian.bonk.test.model.CustomLocation;
import org.bukkit.command.CommandSender;

public final class BonkCommands {
    @Command(name = "", desc = "Bonk command!")
    public void bonk(@Sender CommandSender sender, CustomLocation location) {
        sender.sendMessage(location.toString());
    }

    @Command(name = "add", desc = "Bonk subcommand")
    public void add(@Sender CommandSender sender, @Add(5) CustomLocation location) {
        sender.sendMessage(location.toString());
    }

    @Command(name = "flag1", desc = "Bonk flag1")
    public void flag1(@Sender CommandSender sender, @Flag("f") boolean flag, @OptArg("uwu") String test) {
        if (flag) {
            sender.sendMessage("f is set");
        } else {
            sender.sendMessage("f isnt set");
        }

        sender.sendMessage(test);
    }

    @Command(name = "flag2", desc = "Bonk flag2")
    public void flag2(@Sender CommandSender sender, @Flag("flag") boolean flag, @OptArg("uwu") String test) {
        if (flag) {
            sender.sendMessage("flag is set");
        } else {
            sender.sendMessage("flag isnt set");
        }

        sender.sendMessage(test);
    }
}
