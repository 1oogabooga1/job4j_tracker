package ru.job4j.enumeration;

public enum Status {
    ACCEPTED("Принят") {
        private String message = "Авто на СТО";

        @Override
        public String getMessage() {
            return message;
        }
    },
    IN_WORK("В работе") {
        private String message = "Авто в работе";

        @Override
        public String getMessage() {
            return message;
        }
    },
    WAITING("Ожидание") {
        private String message = "Авто ожидает ремонта";

        @Override
        public String getMessage () {
            return message;
        }
    },
    FINISHED("Работы завершены") {
        private String message = "Авто готово";

        @Override
        public String getMessage() {
            return message;
        }
    };

    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public abstract String getMessage();
}
