package com.michaelsnowden.yalcil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michael.snowden on 4/28/16.
 */
public class StackFrame {
    private final StackFrame parent;
    private final Map<String, RuntimeObject> objectMap;

    public StackFrame(StackFrame parent) {
        this.parent = parent;
        if (parent == null) {
            objectMap = new HashMap<>();
        } else {
            objectMap = new HashMap<>(parent.objectMap);
        }
    }

    RuntimeObject getObject(String key) {
        if (objectMap.containsKey(key)) {
            return objectMap.get(key);
        } else if (parent != null) {
            return parent.getObject(key);
        } else {
            return null;
        }
    }

    void setObject(String key, RuntimeObject value) {
        objectMap.put(key, value);
    }
}
