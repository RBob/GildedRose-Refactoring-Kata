package com.gildedrose;

import com.gildedrose.refactored1.*;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                        if (item.quality > 0 && item.name.equals("Conjured Mana Cake")) {
                            item.quality -= 1;
                        }
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                                if (item.quality > 0 && item.name.equals("Conjured Mana Cake")) {
                                    item.quality -= 1;
                                }
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    public void updateQualityRefactored1() {

        GoblinItem goblinItem;

        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    goblinItem = new AgeingItem(1, item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    goblinItem = new LegendaryItem(0, 80, item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    goblinItem = new FastAgeingItem(1, item);
                    break;
                case "Conjured Mana Cake":
                    goblinItem = new DegradingItem(-2, item);
                    break;
                default:
                    goblinItem = new DegradingItem(-1, item);
                    break;
            }

            goblinItem.updateQuality();
        }
    }

}
