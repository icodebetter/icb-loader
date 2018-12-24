package com.icb.loader.util;

import com.icb.loader.domain.db.W5Base;

import java.util.List;

public class GenericUtil {

    public static boolean safeEquals(Object o1, Object o2) {
        if (o1 == null && o2 == null) return true;
        if (o1 == null || o2 == null) return false;
        return o1.equals(o2);
    }

    public static boolean safeEquals(List<W5Base> l1, List<W5Base> l2) {
        if (l1 != null && l2 != null) {
            if (l1.size() == l2.size()) return false;
            for (int i = 0; i < l1.size(); i++) {
                W5Base c1 = l1.get(i);
                W5Base c2 = l2.get(i);
                if (!c1.safeEquals(c2)) return false;
            }
        } else if (l1 != null ^ l2 != null) return false;
        return true;
    }
}
