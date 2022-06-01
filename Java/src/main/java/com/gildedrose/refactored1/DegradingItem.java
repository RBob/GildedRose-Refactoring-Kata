package com.gildedrose.refactored1;

import com.gildedrose.Item;

public class DegradingItem extends AbstractItem {

    public DegradingItem(int qualityChangeRate, Item item) {
        super(qualityChangeRate, item);
    }

    public void updateQuality() {
        if (item.quality > minQuality) {
            int qualityChange = qualityChangeRate * (item.sellIn < 0 ? 2 : 1);
            if (item.quality + qualityChange > minQuality) {
                item.quality += qualityChange;
            } else {
                item.quality = minQuality;
            }
        }
        item.sellIn -= 1;
    }

}
