package ru.arvalon.coffeeorder.mainpage;

import org.junit.Ignore;
import org.junit.Test;

import ru.arvalon.coffeeorder.model.ICoffeeOrder;
import ru.arvalon.coffeeorder.trash.Foo;
import ru.arvalon.coffeeorder.trash.StubClass;
import ru.arvalon.coffeeorder.trash.Stuff;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class RealmCheck {

    @Test
    public void clearObject(){
        Stuff mock = mock(Stuff.class);
    }

    @Test
    @Ignore
    public void RealmObject(){
        Foo mock = mock(Foo.class);
    }

    @Ignore
    @Test
    public void SpyOnRealmObject(){
        Foo foo = new Foo();
        Foo spy_foo = spy(foo);

        System.out.println("Real method: "+foo.getNum());

        when(spy_foo.getNum()).thenReturn(2);

        System.out.println("Spy method: "+foo.getNum());
    }

    @Test
    @Ignore
    public void StubClass(){
        StubClass stubClass = mock(StubClass.class);
    }

    @Test
    public void testCoffeOrderInterface(){
        ICoffeeOrder mock = mock(ICoffeeOrder.class);
        when(mock.getCoffeeCount()).thenReturn(1);
        System.out.println(mock.getCoffeeCount());
    }
}
