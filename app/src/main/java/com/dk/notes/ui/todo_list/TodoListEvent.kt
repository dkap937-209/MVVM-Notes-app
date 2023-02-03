package com.dk.notes.ui.todo_list

import com.dk.notes.data.Todo

sealed class TodoListEvent{

    data class OnDeleteClick(
        val todo: Todo
    ): TodoListEvent()

    data class OnDoneChange(
        val todo: Todo,
        val isDone: Boolean
    ): TodoListEvent()

    object OnUndoDeleteClick: TodoListEvent()

    data class OnTodoClick(
        val todo: Todo
    ): TodoListEvent()

    object OnAddTodoClick: TodoListEvent()
}
