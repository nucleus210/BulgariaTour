package com.example.renovo.bulgariatour.places;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class PlacesContent {

    /**
     * An array of sample (place) items.
     */
    public static final List<PlaceItem> ITEMS = new ArrayList<>();
    private static int[] placesResult = new int[0];
    private static int[] detailResult = new int[0];

    public PlacesContent(int[] places, int[] details) {
        placesResult = places;
        detailResult = details;
        int COUNT = places.length;

        clearItem();
        // Add some sample items.
        for (int i = 0; i <= COUNT - 1; i++) {
            addItem(createPlaceItem(i));
        }
    }

    private static void addItem(PlaceItem item) {
        ITEMS.add(item);
    }

    private static void clearItem() {
        ITEMS.clear();
    }

    private PlaceItem createPlaceItem(int position) {
        return new PlaceItem(makeDetail(position), makeImage(position));
    }

    private int makeImage(int position) {
        return placesResult[position];
    }

    private int makeDetail(int position) { return detailResult[position]; }

    /**
     * A place item representing a piece of content.
     */
    public static class PlaceItem {
        public final int content;
        public final int mImage;

        PlaceItem(int content, int image) {
            this.content = content;
            this.mImage = image;
        }
    }
}
