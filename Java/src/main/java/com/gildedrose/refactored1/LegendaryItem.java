package com.gildedrose.refactored1;

import com.gildedrose.Item;

public class LegendaryItem extends AbstractItem {

    public LegendaryItem(int qualityChangeRate, int maxQuality, Item item) {
        super(qualityChangeRate, item);
        AbstractItem.maxQuality = maxQuality;
    }

}
