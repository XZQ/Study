package com.xzq.xzq;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeUtils {

    public final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public final static SimpleDateFormat format_Md = new SimpleDateFormat("MM月dd日", Locale.getDefault());
    public final static SimpleDateFormat format_HH = new SimpleDateFormat("HH", Locale.getDefault());

}
