package com.github.magicsky.sya.unittests;

import junit.framework.TestCase;

import java.io.IOException;
import java.net.URL;

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class Test extends TestCase {
    // const int x = 10;
	// int y [ const static x ];
    public void testDo() throws IOException {
        URL location = Test.class.getProtectionDomain().getCodeSource().getLocation();
        CharSequence[] charSequences = TestSourceReader.getContentsForTest(
            "/Users/wul/zone/sya/src/main/java",
            getClass(), getName(), 1
        );
        String code = charSequences[0].toString();
        System.out.println(code);
    }

}
