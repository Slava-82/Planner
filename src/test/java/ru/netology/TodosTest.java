package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFromThreeTasksEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFromThreeTasksSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFromThreeTasksMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFromThreeTasksNullTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("Кокос");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForOneTaskEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForThreeDifferentTasksEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] subtasks1 = {"Сметана", "Курица", "Генка"};
        Epic epic1 = new Epic(57, subtasks1);

        String[] subtasks2 = {"Сыр", "Фарш", "Сухари"};
        Epic epic2 = new Epic(59, subtasks2);

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(epic1);
        todos.add(epic2);

        Task[] expected = {epic2};
        Task[] actual = todos.search("Фарш");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForThreeEqualTasksEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Сыр"};
        Epic epic = new Epic(55, subtasks);

        String[] subtasks1 = {"Сметана", "Курица", "Генка"};
        Epic epic1 = new Epic(57, subtasks1);

        String[] subtasks2 = {"Сыр", "Фарш", "Сухари"};
        Epic epic2 = new Epic(59, subtasks2);

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(epic1);
        todos.add(epic2);

        Task[] expected = {epic, epic2};
        Task[] actual = todos.search("Сыр");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForThreeDifferentTasksEpicNoTask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] subtasks1 = {"Сметана", "Курица", "Генка"};
        Epic epic1 = new Epic(57, subtasks1);

        String[] subtasks2 = {"Сыр", "Фарш", "Сухари"};
        Epic epic2 = new Epic(59, subtasks2);

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(epic1);
        todos.add(epic2);

        Task[] expected = {};
        Task[] actual = todos.search("Рыба");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForOneTaskMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForThreeDifferentTasksMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting1 = new Meeting(
                777,
                "Последняя версия",
                "Онлайн Магазин",
                "В пятницу, после встречи"
        );
        Meeting meeting2 = new Meeting(
                888,
                "Первая версия",
                "Полет на Марс",
                "В среду вечером"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = {meeting2};
        Task[] actual = todos.search("Полет на Марс");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForThreeEqualTasksMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting1 = new Meeting(
                777,
                "Первая версия",
                "Онлайн Магазин",
                "В пятницу, после встречи"
        );
        Meeting meeting2 = new Meeting(
                888,
                "Первая версия",
                "Полет на Марс",
                "В среду вечером"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = {meeting1, meeting2};
        Task[] actual = todos.search("Первая версия");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForThreeDifferentTasksMeetingNoTask() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting1 = new Meeting(
                777,
                "Последняя версия",
                "Онлайн Магазин",
                "В пятницу, после встречи"
        );
        Meeting meeting2 = new Meeting(
                888,
                "Первая версия",
                "Полет на Марс",
                "В среду вечером"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = {};
        Task[] actual = todos.search("Полет на Луну");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForOneTaskSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForThreeDifferentTasksSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask1 = new SimpleTask(7, "Поехать в горы");
        SimpleTask simpleTask2 = new SimpleTask(9, "Купить цветы");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask1);
        todos.add(simpleTask2);

        Task[] expected = {simpleTask1};
        Task[] actual = todos.search("Поехать в горы");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForThreeEqualTasksSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask1 = new SimpleTask(7, "Поехать в горы");
        SimpleTask simpleTask2 = new SimpleTask(9, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask1);
        todos.add(simpleTask2);

        Task[] expected = {simpleTask, simpleTask2};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForThreeDifferentTasksSimpleTaskNoTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask1 = new SimpleTask(7, "Поехать в горы");
        SimpleTask simpleTask2 = new SimpleTask(9, "Купить цветы");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask1);
        todos.add(simpleTask2);

        Task[] expected = {};
        Task[] actual = todos.search("Купить хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoTask() {

        Todos todos = new Todos();

        Task[] expected = {};
        Task[] actual = todos.search("Купить хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

}
