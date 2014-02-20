package com.github.magicsky.sya.checkers;

import com.github.magicsky.sya.checkers.risk.BufferOverflowFunctionCheckerTest;
import com.github.magicsky.sya.checkers.style.SmartPointerCheckerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SmartPointerCheckerTest.class,
    BufferOverflowFunctionCheckerTest.class
})

/**
 * @author garcia.wul@alibaba-inc.com
 */
public class AllTests {

}
