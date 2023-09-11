package com.cssl.icewkment.util;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FontUtil {
    /**
     * 默认字体
     */
    public static final int DEFAULT_FONT = 1;
    /**
     * PingFangSC字体
     */
    public static final int PINGFANG_FONT = 2;
    /**
     * PingFangSCBold字体
     */
    public static final int PINGFANG_BOLD_FONT = 3;
    /**
     * 方正兰亭特黑GBK
     */
    public static final int FZLTTH_GBK_FONT = 4;


    /**
     * 根据字体类型获取字体
     */
    public static Font getFont(int type, float size) {
        // 字体路径
        ClassLoader classLoader = FontUtil.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("Font/youshe.ttf");

        try {
            assert inputStream != null;
            Font sPfBoldFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            sPfBoldFont = sPfBoldFont.deriveFont(size);
            return sPfBoldFont;
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
