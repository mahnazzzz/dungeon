/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dungeon.Controler;

import dungenModel.Items;
import dungenModel.mapRooms;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mahnaz
 */
public class GameControlerTest {
    
    public GameControlerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**  
     * Test of goNorth method, of class GameControler.
     */
    @Test
    public void testGoNorth() {
       
        GameControler instance = new GameControler("messi") ;
        instance.goNorth();
        assertTrue(instance.rMap.getCurrentRoom()==instance.rMap.getR4());
//    assertTrue(instance.goNrth().equals("Room name: Room 4\nDiscribtion: it is dark"));
//        String expResult = "Room name: Room 4\nDiscribtion: it is dark";
//        String result = instance.goNorth();
//        assertEquals(result, expResult);
       
    }

    
}
