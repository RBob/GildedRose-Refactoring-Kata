package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item[] items = new Item[] {
        new Item("+5 Dexterity Vest", 10, 20), //
        new Item("Aged Brie", 2, 0), //
        new Item("Elixir of the Mongoose", -1, 7), //
        new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
        new Item("Conjured Mana Cake", 3, 6),
        new Item("Conjured Mana Cake", -1, 6)
    };

    @Test
    void foo() {

        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void updateQualityTest() {

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertResults(app.items);
    }

    @Test
    void updateQualityRefactored1Test() {

        GildedRose app = new GildedRose(items);
        app.updateQualityRefactored1();

        assertResults(app.items);
    }

    @Test
    void updateQualityRefactored2Test() {

        GildedRose app = new GildedRose(items);
        app.updateQualityRefactored2();

        assertResults(app.items);
    }

    private void assertResults(Item[] items) {

        // degrading item
        assertEquals("+5 Dexterity Vest", items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);

        // ageing item
        assertEquals("Aged Brie", items[1].name);
        assertEquals(1, items[1].sellIn);
        assertEquals(1, items[1].quality);

        // degrading item
        assertEquals("Elixir of the Mongoose", items[2].name);
        assertEquals(-2, items[2].sellIn);
        assertEquals(5, items[2].quality);

        // legendary item
        assertEquals("Sulfuras, Hand of Ragnaros", items[3].name);
        assertEquals(0, items[3].sellIn);
        assertEquals(80, items[3].quality);

        // legendary item
        assertEquals("Sulfuras, Hand of Ragnaros", items[4].name);
        assertEquals(-1, items[4].sellIn);
        assertEquals(80, items[4].quality);

        // fast ageing item
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[5].name);
        assertEquals(14, items[5].sellIn);
        assertEquals(21, items[5].quality);

        // fast ageing item
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[6].name);
        assertEquals(9, items[6].sellIn);
        assertEquals(42, items[6].quality);

        // fast ageing item
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[7].name);
        assertEquals(4, items[7].sellIn);
        assertEquals(33, items[7].quality);

        // conjured (degrading) item
        assertEquals("Conjured Mana Cake", items[8].name);
        assertEquals(2, items[8].sellIn);
        assertEquals(4, items[8].quality);

        // conjured (degrading) item
        assertEquals("Conjured Mana Cake", items[9].name);
        assertEquals(-2, items[9].sellIn);
        assertEquals(2, items[9].quality);
    }

}
