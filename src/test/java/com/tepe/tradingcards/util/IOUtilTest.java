package com.tepe.tradingcards.util;

import com.tepe.tradingcards.config.BaseTest;
import org.junit.Test;

public class IOUtilTest extends BaseTest {

    @Test
    public void testIOUtil() {
        IOUtil.getInstance().print("IOUtilTest");
    }
}
