package net.minestom.server.command.builder;

import org.jetbrains.annotations.NotNull;

public class CommandResult {

    protected Type type = Type.UNKNOWN;
    protected ParsedCommand parsedCommand;
    protected CommandData commandData;

    @NotNull
    public Type getType() {
        return type;
    }

    public enum Type {
        /**
         * Command and syntax successfully found.
         */
        SUCCESS,

        /**
         * Command found, but the syntax is invalid.
         * Executor sets to {@link Command#getDefaultExecutor()}.
         */
        INVALID_SYNTAX,

        /**
         * Command cancelled by an event listener.
         */
        CANCELLED,

        /**
         * Command is not registered, it is also the default result type.
         */
        UNKNOWN
    }

    @NotNull
    public static CommandResult withType(@NotNull Type type) {
        CommandResult result = new CommandResult();
        result.type = type;
        return result;
    }

}
