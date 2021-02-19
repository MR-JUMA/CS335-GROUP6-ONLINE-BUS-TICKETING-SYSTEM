package com.example.abc;

import com.example.abc.controllers.TripController;
import com.example.abc.models.Bus;
import com.example.abc.repositories.ScheduleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {


    @Test
    @Disabled("not implemented yet")
    void shouldShowSimpleAssertion(){
        assertEquals(1,1);
    }

    @Test
    void shouldShowSimp(){
        List<Integer> x=List.of(2,3,5,7);
        Assertions.assertAll(   ()-> assertEquals(2,x.get(0)),
                                ()-> assertEquals(2,x.get(1)),
                                ()-> assertEquals(2,x.get(2)),
                                ()-> assertEquals(2,x.get(3)));

//        assertEquals(2,x.get(0));
//        assertEquals(3,x.get(1));
//        assertEquals(2,x.get(2));
//        assertEquals(2,x.get(3));

    }

    @Test
    public void testSum(){
        TripController tripController=new TripController();
        assertEquals(5,tripController.sum(2,3));
    }
    @Test
    public void testMy(){
        TripController tripController=new TripController();
    }


}
