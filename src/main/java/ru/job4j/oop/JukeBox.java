package ru.job4j.oop;

public class JukeBox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("""
                    Пусть бегут неуклюже
                    Пешеходы по лужам,
                    А вода по асфальту рекой.
                    И не ясно прохожим
                    В этот день непогожий
                    Почему я весёлый такой.
                    Ах я играю на гармошке
                    У прохожих на виду,
                    К сожаленью, день рожденья
                    Только раз в году.
                    Прилетит вдруг волшебник
                    В голубом вертолёте
                    И бесплатно покажет кино.
                    С днём рожденья поздравит
                    И, наверно, оставит
                    Мне в подарок пятьсот эскимо.
                    Ах я играю на гармошке
                    У прохожих на виду,
                    К сожаленью, день рожденья
                    Только раз в году.
                    К сожаленью, день рожденья
                    Только раз в году.""");
        } else if (position == 2) {
            System.out.println("""

                    Спят усталые игрушки, книжки спят.
                    Одеяла и подушки ждут ребят.
                    Даже сказка спать ложится,
                    Что бы ночью нам присниться.
                    Ты ей пожелай:
                    Баю-бай.
                    Обязательно по дому в этот час
                    Тихо-тихо ходит дрема возле нас.""");
        } else if (position == 3) {
            System.out.println("\n" + "Песня не найден.");
        }
    }

    public static void main(String[] args) {
        JukeBox juke = new JukeBox();
        juke.music(1);
        juke.music(2);
        juke.music(3);
    }
}
