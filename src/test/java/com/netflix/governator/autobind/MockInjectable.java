package com.netflix.governator.autobind;

import com.google.inject.Inject;

public class MockInjectable
{
    private final String    str;
    private final int       value;

    @Inject
    public MockInjectable(String str, int value)
    {
        this.str = str;
        this.value = value;
    }

    public String getStr()
    {
        return str;
    }

    public int getValue()
    {
        return value;
    }
}
