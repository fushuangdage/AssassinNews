package com.fushuang.assassinnews;

import java.io.File;

/**
 * Created by fushuang on 2017/3/14.
 */

public class Constants {

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

   public static final String ARG_IS_ROOT = "fragmentation_arg_is_root";

    public static final String WXKEY="52b7ec3471ac3bec6846577e79f20e4c";
}
