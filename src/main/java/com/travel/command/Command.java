package com.travel.command;

public interface Command {
    void execute();
    void undo();
}