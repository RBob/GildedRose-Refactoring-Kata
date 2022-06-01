package com.gildedrose.refactored1;

import com.gildedrose.Item;

public class FastAgeingItem extends AbstractItem {

    public FastAgeingItem(int qualityChangeRate, Item item) {
        super(qualityChangeRate, item);
    }

    public void updateQuality() {
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
    }

}
