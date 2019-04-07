package ru.arvalon.coffeeorder.mainpage;

import android.content.Context;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ru.arvalon.coffeeorder.trash.FinalClass;
import ru.arvalon.coffeeorder.trash.Foo;
import ru.arvalon.coffeeorder.trash.Stuff;
import ru.arvalon.coffeeorder.trash.WaterSource;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by arvalon on 27.03.2018.
 */

public class MockitoExampleTests {

    @Test
    public void getContext(){

        Context ctx = mock(Context.class);
        System.out.println("Package name: "+ctx.getPackageName());
    }

    @Test
    public void iterator(){
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");
        String result = i.next()+" "+i.next();
        assertEquals("Hello World",result);

    }

    @Test(expected=IOException.class)
    public void OutputStreamWriter_rethrows_an_exception_from_OutputStream() throws IOException {

        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);

        doThrow(new IOException()).when(mock).close();
        osw.close();
    }

    @Test
    public void OutputStreamWriter_Closes_OutputStream_on_Close() throws IOException {

        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        osw.close();
        verify(mock).close();
    }

    @Test
    public void spyExample(){
        List list = new LinkedList();
        List spy = Mockito.spy(list);

        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        //using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        //prints "one" - the first element of a list
        System.out.println(spy.get(0));

        //size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        //optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");
    }

    @Test
    @Ignore
    public void smartNullExample(){
        Foo mock = mock(Foo.class,RETURNS_SMART_NULLS);
        when(mock.getStuff()).thenReturn(new Stuff());
        Stuff stuff = mock.getStuff();
        stuff.doSomething();
    }

    @Test
    @Ignore
    public void partialMockExample(){

        Foo mock = mock(Foo.class,CALLS_REAL_METHODS);
        int num = mock.getNum();
        assertEquals(1,num);

        when(mock.getNum()).thenReturn(2);
        assertEquals(2,mock.getNum());
    }

    @Test
    public void testMultipleCalls(){
        WaterSource mock = mock(WaterSource.class);
        given(mock.getWaterPressure()).willReturn(3,3,5);

        assertEquals(mock.getWaterPressure(),3);
        assertEquals(mock.getWaterPressure(),3);
        assertEquals(mock.getWaterPressure(),5);
        assertEquals(mock.getWaterPressure(),5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void stubbingVoidMethod(){
        WaterSource mock = mock(WaterSource.class);
        doThrow(new IllegalArgumentException("Wrong argument")).when(mock).doSelfCheck();
        mock.doSelfCheck();
    }

    /** работает при создании файла src\test\resources\mockito-extensions\mock-maker-inline */
    @Test
    public void mockFinalClass(){

        FinalClass finalClass = new FinalClass();

        FinalClass mockClass = mock(FinalClass.class);
        given(mockClass.finalMethod()).willReturn("not anymore");
        assertNotSame(mockClass.finalMethod(),finalClass.finalMethod());

        given(mockClass.finalMethod()).willReturn("something");
        assertEquals(mockClass.finalMethod(),finalClass.finalMethod());
    }
}
