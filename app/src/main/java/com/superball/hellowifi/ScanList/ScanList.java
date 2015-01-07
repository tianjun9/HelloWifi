package com.superball.hellowifi.ScanList;

import android.net.wifi.ScanResult;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ScanList {

    /**
     * An array of sample (dummy) items.
     */
    public static List<ScanItem> ITEMS = new ArrayList<ScanItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static SparseArray<ScanItem> ITEM_MAP = new SparseArray<ScanItem>();

    public static void addItem(ScanItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.idx, item);
    }

    public static void clear() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ScanItem {

        private static int global_idx = 0;

        public int idx;
        public ScanResult content;

        public ScanItem(ScanResult content) {
            this.idx = ++global_idx;
            this.content = content;
        }

        @Override
        public String toString() {
            return content.SSID;
        }
    }
}