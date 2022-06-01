package com.gildedrose.refactored1;

import com.gildedrose.Item;

public class AgeingItem extends AbstractItem {

    public AgeingItem(int qualityChangeRate, Item item) {
        super(qualityChangeRate, item);
    }

    public void updateQuality() {
        if (item.quality < maxQuality) {
            if (item.quality + qualityChangeRate <= maxQuality) {
                item.quality += qualityChangeRate;
            } else {
                item.quality = maxQuality;
            }
        }
        item.sellIn -= 1;
    }

}
