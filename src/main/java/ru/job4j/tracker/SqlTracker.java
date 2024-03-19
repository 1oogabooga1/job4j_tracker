package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        init();
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO items(name, created) VALUES (?, ?)")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        init();
        Item oldItem = findById(id);
        if (oldItem != null) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format("UPDATE items SET name = %s, created = %s WHERE items.id = %s",
                        item.getName(),
                        item.getCreated(),
                        id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return oldItem != null;
    }

    @Override
    public void delete(int id) {
        init();
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM items where items.id = %s",
                    id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM items");
            while (result.next()) {
                list.add(new Item(result.getString(2), result.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> all = findAll();
        List<Item> list = new ArrayList<>();
        for (Item it : all) {
            if (it.getName() == key) {
                list.add(it);
            }
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        List<Item> all = findAll();
        List<Item> list = new ArrayList<>();
        for (Item it : all) {
            if (it.getId() == id) {
                return it;
            }
        }
        return null;
    }
}