package com.gildedrose;

import com.gildedrose.refactored1.*;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                        if (items[i].quality > 0 && items[i].name.equals("Conjured Mana Cake")) {
                            items[i].quality -= 1;
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                                if (items[i].quality > 0 && items[i].name.equals("Conjured Mana Cake")) {
                                    items[i].quality -= 1;
                                }
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
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
