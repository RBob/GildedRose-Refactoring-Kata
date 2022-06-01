package com.gildedrose.refactored2;

@FunctionalInterface
public interface UpdateQualityFunction<MINQ, MAXQ, CHR, ITEM> {

    void apply(MINQ minQ, MAXQ maxQ, CHR chr, ITEM item);

}
