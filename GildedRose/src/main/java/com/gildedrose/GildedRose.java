package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (isSulfuras(item)) {
                continue;
            }

            updateQualityValue(item);
            updateSellIn(item);

            if (item.sellIn < 0) {
                updateExpiredItem(item);
            }
        }
    }

    private void updateQualityValue(Item item) {

        if (isAgedBrie(item)) {
            increaseQuality(item);
        } 
        else if (isBackstagePass(item)) {
            increaseQuality(item);

            if (item.sellIn <= 10) increaseQuality(item);
            if (item.sellIn <= 5) increaseQuality(item);
        } 
        else {
            decreaseQuality(item);
        }
    }

    private void updateExpiredItem(Item item) {

        if (isAgedBrie(item)) {
            increaseQuality(item);
        } 
        else if (isBackstagePass(item)) {
            item.quality = 0;
        } 
        else {
            decreaseQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}