package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetTest {

    @Test
    public void testEpicGetSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSimpleTaskGetTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMeetingGetTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMeetingGetProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMeetingGetStart() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testTaskMeetingGetId() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        int expected = 555;
        int actual = meeting.getId();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testTaskEpicGetId() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        int expected = 55;
        int actual = epic.getId();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testTaskSimpleTaskGetId() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        int expected = 5;
        int actual = simpleTask.getId();

        Assertions.assertEquals(expected, actual);

    }

}
