package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Редактирование заявки ===");
        System.out.print("Введите id: ");
        int id = input.askInt("Введите id: ");
        System.out.print("Введите имя: ");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка успешно изменена.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
