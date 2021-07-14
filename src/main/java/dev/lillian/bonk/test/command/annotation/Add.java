package dev.lillian.bonk.test.command.annotation;

import dev.lillian.bonk.core.annotation.Modifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Modifier
public @interface Add {
    double value();
}
