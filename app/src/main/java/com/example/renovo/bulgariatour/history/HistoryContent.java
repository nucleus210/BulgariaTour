package com.example.renovo.bulgariatour.history;

import android.content.Context;

import com.example.renovo.bulgariatour.viewmodel.DataHolderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class HistoryContent {

    public static final List<HistoryItem> ITEMS = new ArrayList<>();
    private static int[] imageHistoryRes = new int[0];
    private static int[] dataHistoryDesc = new int[0];
    private static int[] titleHistoryDesc = new int[0];
    private static int[] licenseHistoryDesc = new int[0];

    public HistoryContent(Context context) {

        imageHistoryRes = DataHolderModel.getInstance(context).getHistoryImageDesc();
        dataHistoryDesc = DataHolderModel.getInstance(context).getHistoryDataDesc();
        titleHistoryDesc = DataHolderModel.getInstance(context).getHistoryTitleDesc();
        licenseHistoryDesc =DataHolderModel.getInstance(context).getHistoryLicenseDesc();
        int COUNT = titleHistoryDesc.length;

        clearItem();
        // Add some sample items.
        for (int i = 0; i <= COUNT - 1; i++) {
            addItem(createHistoryItem(i));
        }
    }

    private static void addItem(HistoryItem item) {
        ITEMS.add(item);
    }

    private static void clearItem() {
        ITEMS.clear();
    }

    private static HistoryItem createHistoryItem(int position) {
        return new HistoryItem(
                makeImage(position),
                makeTitle(position),
                makeDetails(position),
                makeLicense(position));
    }

    private static int makeImage(int position) {
        return imageHistoryRes[position];
    }

    private static int makeDetails(int position) { return dataHistoryDesc[position]; }

    private static int makeTitle(int position) { return titleHistoryDesc[position]; }

    private static int makeLicense(int position) { return licenseHistoryDesc[position]; }

    /**
     * A history item representing a piece of content.
     */
    public static class HistoryItem {

        public final int image;
        public final int title;
        public final int content;
        public final int license;


        HistoryItem(int image, int title, int content, int license) {
            this.image = image;
            this.title = title;
            this.content = content;
            this.license = license;
        }
    }
}
