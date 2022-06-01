package com.gildedrose.refactored2;

import com.gildedrose.Item;

public class ElfItem {

    static int minQuality = 0;
    int maxQuality = 50;
    int qualityChangeRate;

    Item item;

    UpdateQualityFunction<Integer, Integer, Integer, Item> updateQualityFunction;

    public ElfItem(int qualityChangeRate, Item item,
                   UpdateQualityFunction<Integer, Integer, Integer, Item> updateQualityFunction) {
        this.qualityChangeRate = qualityChangeRate;
        this.item = item;
        this.updateQualityFunction = updateQualityFunction;
    }

    public ElfItem(int qualityChangeRate, int maxQuality, Item item,
                   UpdateQualityFunction<Integer, Integer, Integer, Item> updateQualityFunction) {
        this.qualityChangeRate = qualityChangeRate;
        this.maxQuality = maxQuality;
        this.item = item;
        this.updateQualityFunction = updateQualityFunction;
    }

    public void updateQuality() {
        updateQualityFunction.apply(minQuality, maxQuality, qualityChangeRate, item);
    }

    public static UpdateQualityFunction<Integer, Integer, Integer, Item> ageingQualityFunction =

        (minQuality, maxQuality, qualityChangeRate, item) -> {
            if (item.quality < maxQuality) {
                if (item.quality + qualityChangeRate <= maxQuality) {
                    item.quality += qualityChangeRate;
                } else {
                    item.quality = maxQuality;
                }
            }
            item.sellIn -= 1;
        };

    public static UpdateQualityFunction<Integer, Integer, Integer, Item> degradingQualityFunction =

        (minQuality, maxQuality, qualityChangeRate, item) -> {
            if (item.quality > minQuality) {
                int qualityChange = qualityChangeRate * (item.sellIn < 0 ? 2 : 1);
                if (item.quality + qualityChange > minQuality) {
                    item.quality += qualityChange;
                } else {
                    item.quality = minQuality;
                }
            }
            item.sellIn -= 1;
        };

    public static UpdateQualityFunction<Integer, Integer, Integer, Item> fastAgeingQualityFunction =

        (minQuality, maxQuality, qualityChangeRate, item) -> {
            if (item.quality < maxQuality && item.quality > minQuality) {
                if (item.sellIn <= 0) {
                    item.quality = minQuality;
                } else {
                    int qualityChange = qualityChangeRate + (item.sellIn <= 5 ? 2 : (item.sellIn <= 10 ? 1 : 0));
                    if (item.quality + qualityChange < maxQuality) {
                        item.quality += qualityChange;
                    } else {
                        item.quality = maxQuality;
                    }
                }
            }
            item.sellIn -= 1;
        };

    public static UpdateQualityFunction<Integer, Integer, Integer, Item> nopQualityFunction =

        (minQuality, maxQuality, qualityChangeRate, item) -> {

        };
}
