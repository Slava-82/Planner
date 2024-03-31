package ru.netology;

public class Epic extends Task {

    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;

    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        String[] subtask = new String[subtasks.length];

        for (int i = 0; i < subtask.length; i++) {
            subtask[i] = subtasks[i];


            if (subtask[i].contains(query)) {
                return true;
            }
        }


        return false;
    }
}