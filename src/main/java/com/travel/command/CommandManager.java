//package com.travel.command;
//
//import java.util.Stack;
//import com.travel.observer.*;
//
///**
// * CommandManager acts as the invoker and caretaker (Memento pattern).
// * It executes commands and stores pre-execution states for undo functionality.
// */
//public class CommandManager {
//    private TravelModel travelModel;
//    private Stack<Memento> undoStack;
//    // (Optional) private Stack<Memento> redoStack;
//
//    public CommandManager(TravelModel travelModel) {
//        this.travelModel = travelModel;
//        this.undoStack = new Stack<>();
//        // this.redoStack = new Stack<>();
//    }
//
//    public void executeCommand(Command command) {
//        // Save state before execution for undo
//        Memento beforeState = travelModel.createMemento();
//        command.execute();
//        // Push previous state onto undo stack (assuming state changed)
//        undoStack.push(beforeState);
//        // Clear redo stack on new command
//        // redoStack.clear();
//    }
//
//    public void undo() {
//        if (!undoStack.isEmpty()) {
//            Memento prevState = undoStack.pop();
//            travelModel.restore(prevState);
//            // If supporting redo:
//            // redoStack.push(model.createMemento());
//        }
//    }
//
//    // If redo functionality is needed in the future:
//    // public void redo() {
//    //     if (!redoStack.isEmpty()) {
//    //         Memento nextState = redoStack.pop();
//    //         // Save current state to undo stack before redo
//    //         undoStack.push(model.createMemento());
//    //         model.restore(nextState);
//    //     }
//    // }
//}
//
