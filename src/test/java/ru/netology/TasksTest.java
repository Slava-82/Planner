package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldTestSimpleTaskMatchesTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTestSimpleTaskMatchesFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Написать");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTestEpicMatchesTrue() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTestEpicMatchesFalse() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Сахар");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTestMeetingMatchesTopicTrue() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTestMeetingMatchesProjectTrue() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTestMeetingMatchesFalse() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Полет");

        Assertions.assertEquals(expected, actual);

    }

}

