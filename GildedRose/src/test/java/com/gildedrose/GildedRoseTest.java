package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void normalItemDecreasesQualityAndSellIn() {
        Item[] items = { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void normalItemQualityNeverNegative() {
        Item[] items = { new Item("Normal Item", 10, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    void normalItemDegradesTwiceAfterExpiration() {
        Item[] items = { new Item("Normal Item", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void agedBrieIncreasesQuality() {
        Item[] items = { new Item("Aged Brie", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(21, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void agedBrieQualityNeverAbove50() {
        Item[] items = { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, items[0].quality);
    }

    @Test
    void agedBrieIncreasesTwiceAfterExpiration() {
        Item[] items = { new Item("Aged Brie", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, items[0].quality);
    }

    @Test
    void sulfurasNeverChanges() {
        Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, items[0].quality);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    void backstagePassIncreaseBy1WhenMoreThan10Days() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(21, items[0].quality);
    }

    @Test
    void backstagePassIncreaseBy2When10DaysOrLess() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, items[0].quality);
    }

    @Test
    void backstagePassIncreaseBy3When5DaysOrLess() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(23, items[0].quality);
    }

    @Test
    void backstagePassQualityDropsToZeroAfterConcert() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    void backstagePassQualityNeverAbove50() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(items[0].quality <= 50);
    }


    @Test
    void toStringItem() {
        Item item = new Item("Test Item", 5, 10);
        assertEquals("Test Item, 5, 10", item.toString());
    }
}