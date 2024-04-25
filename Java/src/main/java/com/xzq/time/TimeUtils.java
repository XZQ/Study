package com.xzq.time;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeUtils {
    public final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public final static SimpleDateFormat formatM = new SimpleDateFormat("MM月dd日", Locale.getDefault());
    public final static SimpleDateFormat formatHH = new SimpleDateFormat("HH", Locale.getDefault());
    public final static SimpleDateFormat formatHM = new SimpleDateFormat("HHmm", Locale.getDefault());

}
