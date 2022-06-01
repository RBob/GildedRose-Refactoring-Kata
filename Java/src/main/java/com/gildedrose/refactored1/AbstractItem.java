package com.gildedrose.refactored1;

import com.gildedrose.Item;

public abstract class AbstractItem implements GoblinItem {

    static int minQuality = 0;
    static int maxQuality = 50;

    int qualityChangeRate;

    Item item;

    public AbstractItem(int qualityChangeRate, Item item) {
        this.qualityChangeRate = qualityChangeRate;
        this.item = item;
    }

}
