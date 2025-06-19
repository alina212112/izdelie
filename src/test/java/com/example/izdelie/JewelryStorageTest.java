package com.example.izdelie;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JewelryStorageTest {

    @Test
    public void testSearchByName() {
        // 1. Создаем хранилище
        JewelryStorage storage = new JewelryStorage();

        // 2. Поиск по ключевому слову "Кольцо"
        ObservableList<JewelryItem> results = storage.searchByName("Кольцо");

        // 3. Проверяем, что найдено ровно 1 изделие
        assertEquals(1, results.size());

        // 4. Проверяем, что его имя содержит "Кольцо"
        assertTrue(results.get(0).getName().contains("Кольцо"));
    }
}