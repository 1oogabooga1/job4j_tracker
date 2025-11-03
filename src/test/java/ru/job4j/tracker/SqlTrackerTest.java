package ru.job4j.tracker;

import org.junit.jupiter.api.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertNull;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
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

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()))
                .usingRecursiveComparison()
                .ignoringFields("created")
                .isEqualTo(item);
    }

    @Test
    public void whenReplaceItemThenItemIsReplaced() {
        SqlTracker tracker = new SqlTracker(connection);
        Item originalItem = new Item("originalItem");
        tracker.add(originalItem);
        Item newItem = new Item("newItem");
        newItem.setId(originalItem.getId());
        boolean replaced = tracker.replace(originalItem.getId(), newItem);
        Assertions.assertTrue(replaced);
        Item foundItem = tracker.findById(originalItem.getId());
        assertThat(newItem)
                .usingRecursiveComparison()
                .ignoringFields("created")
                .isEqualTo(foundItem);
    }

    @Test
    public void whenDeleteItemThenItemIsDeleted() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item secondItem = new Item("item2");
        Item thirdItem = new Item("item3");
        tracker.add(item);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        List<Item> expected = List.of(item, secondItem, thirdItem);
        assertThat(tracker.findAll())
                .usingRecursiveComparison()
                .ignoringFields("created")
                .isEqualTo(expected);
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item secondItem = new Item("item2");
        List<Item> expected = List.of(secondItem);
        tracker.add(item);
        tracker.add(secondItem);
        assertThat(tracker.findByName("item2"))
                .usingRecursiveComparison()
                .ignoringFields("created")
                .isEqualTo(expected);
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item secondItem = new Item("item2");
        tracker.add(item);
        tracker.add(secondItem);
        assertThat(tracker.findById(secondItem.getId()))
                .usingRecursiveComparison()
                .ignoringFields("created")
                .isEqualTo(secondItem);
    }
}