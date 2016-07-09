package com.example.ganesh.brokerapp.List;

import com.example.ganesh.brokerapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ListContent {

    /**
     * A dummy item representing a piece of content.
     */
    public static class Item {
        public final String id;
        public final String name;
        public final Integer details;

        public Item(String id, String content, Integer imgrsid) {
            this.id = id;
            this.name = content;
            this.details = imgrsid;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
