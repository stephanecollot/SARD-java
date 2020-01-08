/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_rand_postinc_22b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-22b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: increment
 *    GoodSink: Ensure there will not be an overflow before incrementing data
 *    BadSink : Increment data, which can cause an overflow
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE190_Integer_Overflow.s06;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_rand_postinc_22b
{
    public void badSink(long data ) throws Throwable
    {
        if (CWE190_Integer_Overflow__long_rand_postinc_22a.badPublicStatic)
        {
            /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
            data++;
            long result = (long)(data);
            IO.writeLine("result: " + result);
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    public void goodB2G1Sink(long data ) throws Throwable
    {
        if (CWE190_Integer_Overflow__long_rand_postinc_22a.goodB2G1PublicStatic)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }
        else
        {

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Long.MAX_VALUE)
            {
                data++;
                long result = (long)(data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to increment.");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    public void goodB2G2Sink(long data ) throws Throwable
    {
        if (CWE190_Integer_Overflow__long_rand_postinc_22a.goodB2G2PublicStatic)
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < Long.MAX_VALUE)
            {
                data++;
                long result = (long)(data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to increment.");
            }
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(long data ) throws Throwable
    {
        if (CWE190_Integer_Overflow__long_rand_postinc_22a.goodG2BPublicStatic)
        {
            /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
            data++;
            long result = (long)(data);
            IO.writeLine("result: " + result);
        }
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0L;
        }
    }
}
