package edu.cscc.javaadventure.commands;

import edu.cscc.javaadventure.Room;
import edu.cscc.javaadventure.engine.GameState;

import java.util.*;

/**
 * This class encapsulates the various commands that a user may take.
 */
public class Commands {

    private static Map<String, Command> commands;
    public static List<String> VALID_COMMANDS = new ArrayList<>();

    static {
        commands = buildCommands();
        /*
         * TODO Add valid command names to the VALID_COMMANDS list here.
         * VALID_COMMANDS.add(...);
         */
        VALID_COMMANDS.add("look");
        VALID_COMMANDS.add("exit");
        VALID_COMMANDS.add("up");
        VALID_COMMANDS.add("down");
        VALID_COMMANDS.add("north");
        VALID_COMMANDS.add("south");
        VALID_COMMANDS.add("east");
        VALID_COMMANDS.add("west");

    }

    /**
     * TODO Complete this method per the requirements.
     * Build a {@link Map} of {@link Command}s keyed by the command string.
     * @return
     */
    private static Map<String, Command> buildCommands() {
        //Do not use anonymous, inner, abstract, or subclasses when building a command.
        //To receive full credit you *must* add a command as a lambda.
        Map<String, Command> listCommand = new HashMap<>();

        listCommand.put("look", (gameState, commandPrinter, commandString) -> {
            String lookRoom = commandString.substring(4);
            Optional<String> found = gameState.getCurrentRoom().listContents()
                    .stream().filter(name -> name.equals(lookRoom)).findFirst();
            found.ifPresent(nameFound ->commandPrinter.printMessage(gameState.getCurrentRoom().getObject(nameFound).getDescription()));
            return gameState;
        });

        listCommand.put("exit", (gameState, commandPrinter, commandString) -> {
            Room nextRoom = gameState.getCurrentRoom().getRoom("exit");
            new GameState(gameState.getParty(), nextRoom, false);
            return gameState;

        });

        listCommand.put("up", (gameState, commandPrinter, commandString) ->{
            Room nextRoom = gameState.getCurrentRoom().getRoom("up");
            if(nextRoom == null)
            {commandPrinter.printMessage("You can't go that way.");}
            else {
                return new GameState(gameState.getParty(),nextRoom, true);

            }
            return gameState;
        });

        listCommand.put("down", (gameState, commandPrinter, commandString) ->{
            Room nextRoom = gameState.getCurrentRoom().getRoom("down");
            if(nextRoom == null)
            {commandPrinter.printMessage("You can't go that way.");}
            else {
                return new GameState(gameState.getParty(),nextRoom, true);

            }
            return gameState;
        });

        listCommand.put("north", (gameState, commandPrinter, commandString) ->{
            Room nextRoom = gameState.getCurrentRoom().getRoom("north");
            if(nextRoom == null)
            {commandPrinter.printMessage("You can't go that way.");}
            else {
                return new GameState(gameState.getParty(),nextRoom, true);

            }
            return gameState;
        });

        listCommand.put("south", (gameState, commandPrinter, commandString) ->{
            Room nextRoom = gameState.getCurrentRoom().getRoom("south");
            if(nextRoom == null)
            {commandPrinter.printMessage("You can't go that way.");}
            else {
                return new GameState(gameState.getParty(),nextRoom, true);

            }
            return gameState;
        });

        listCommand.put("east", (gameState, commandPrinter, commandString) ->{
            Room nextRoom = gameState.getCurrentRoom().getRoom("east");
            if(nextRoom == null)
            {commandPrinter.printMessage("You can't go that way.");}
            else {
                return new GameState(gameState.getParty(),nextRoom, true);

            }
            return gameState;
        });

        listCommand.put("west", (gameState, commandPrinter, commandString) ->{
            Room nextRoom = gameState.getCurrentRoom().getRoom("west");
            if(nextRoom == null)
            {commandPrinter.printMessage("You can't go that way.");}
            else {
                return new GameState(gameState.getParty(),nextRoom, true);

            }
            return gameState;
        });


        return listCommand;


    }

    /**
     * Retrieve a {@link Command} based on a valid command string.
     * @param commandString The full command string to match. An actual command
     *                      will always be the first part of the string, with the
     *                      remaining part of the string being any arguments
     *                      to the actual {@link Command} object.
     * @return The {@link Command} matching the command string. If a command
     * does not exist return a command that prints "Not a valid command" and returns the {@link edu.cscc.javaadventure.engine.GameState}
     * in its {@link Command#execute(GameState, CommandPrinter, String)} method.
     */
    public static Command getCommand(String commandString) {
        //TODO Complete this method per the requirements.
        String arrayOfCommands = (commandString.split("")[0]);
        if(arrayOfCommands.equals("look")) {
            return commands.get("look");
        }
        if(arrayOfCommands.equals("exit")) {
            return commands.get("exit");
        }
        if(arrayOfCommands.equals("up")) {
            return commands.get("up");
        }
        if(arrayOfCommands.equals("down")) {
            return commands.get("down");
        }
        if(arrayOfCommands.equals("north")) {
            return commands.get("north");
        }
        if(arrayOfCommands.equals("south")) {
            return commands.get("south");
        }
        if(arrayOfCommands.equals("east")) {
            return commands.get("east");
        }
        if(arrayOfCommands.equals("west")) {
            return commands.get("west");
        }
        return ((gameState, commandPrinter, commandString1) -> {
            commandPrinter.printMessage("Not a valid command");
            return gameState;
        });
    }

    /**
     * Get the map of {@link Command}s.
     * @return The map of commands keyed by command string.
     */
    public static Map<String, Command> getCommands() {
        return commands;
    }
}

