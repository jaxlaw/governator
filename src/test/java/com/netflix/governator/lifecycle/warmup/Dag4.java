package com.netflix.governator.lifecycle.warmup;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netflix.governator.annotations.WarmUp;

public class Dag4
{
    /*
                    E
                  <   <
                D       \
              <   <     \
            B       F   \
          <             \
        A               \
          <             \
            C  - - - - -
     */

    @SuppressWarnings("UnusedParameters")
    @Singleton
    public static class A
    {
        private final Recorder recorder;

        @Inject
        public A(Recorder recorder, B b, C c)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("A");
        }
    }

    @Singleton
    @SuppressWarnings("UnusedParameters")
    public static class B
    {
        private final Recorder recorder;

        @Inject
        public B(Recorder recorder, D d)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("B");
        }
    }

    @Singleton
    @SuppressWarnings("UnusedParameters")
    public static class C
    {
        private final Recorder recorder;

        @Inject
        public C(Recorder recorder, E e)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("C");
        }
    }

    @Singleton
    @SuppressWarnings("UnusedParameters")
    public static class D
    {
        private final Recorder recorder;

        @Inject
        public D(Recorder recorder, E e, F f)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("D");
        }
    }

    @Singleton
    public static class E
    {
        private final Recorder recorder;

        @Inject
        public E(Recorder recorder)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("E");
        }
    }

    @Singleton
    public static class F
    {
        private final Recorder recorder;

        @Inject
        public F(Recorder recorder)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("F");
        }
    }
}
