/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Database.*;
import java.util.ArrayList;


/**
 *
 * @author catharinebaker
 */ 
public class GameApplicationTest {
    
    public GameApplicationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    public ArrayList<Question> questionArrayList;
    public QuestionDB questionDatabase;

    @Before
    public void setupDB() {
        this.questionArrayList = new QuestionDB().questionListCreator();
    }
    
    
    
    /**
     * Make sure when we generate two games they are different each time
     */
    @Test
    public void testGameUnique() {
        GameApplication g1 = new GameApplication();
        GameApplication g2 = new GameApplication();

        assertNotEquals(g1, g2);
    }
    
    
    /**
     * Test of userFiftyFiftyLifeLine method, of class GameApplication.
     */
    @Test
    public void useFiftyFiftyLifeLine() {
        
        GameApplication instance = new GameApplication();
        instance.useFiftyFiftyLifeLine();
        boolean expResult = false;
        boolean result = instance.isHasFiftyFifty();
        
        assertEquals(expResult, result);
    }
    
    
     /**
     * Test of isHasFiftyFifty method, of class GameApplication.
     */
    @Test
    public void usePhoneAFriendLifeLine() {
       
        GameApplication instance = new GameApplication();
        instance.usePhoneAFriend();
        boolean expResult = false;
        boolean result = instance.isPhoneAFriend();
        
        assertEquals(expResult, result);
        
    }
    
      /**
     * Test of useAskAudience method, of class GameApplication.
     */
    @Test
    public void useAskAudience() {
   
        GameApplication instance = new GameApplication();
        instance.useAskAudience();
        boolean expResult = false;
        boolean result = instance.isAskTheAudience();
        
        assertEquals(expResult, result);
        
    }
    
    /*
     * Make sure when we generate game all linelifes are ture
     */
    @Test
    public void testGameLifeLines() {
        GameApplication g = new GameApplication();
        
        g.isPhoneAFriend();
        boolean expResult1 = true;
        boolean result1 = g.isPhoneAFriend();
        
        g.isAskTheAudience();
        boolean expResult2 = true;
        boolean result2 = g.isAskTheAudience();
        
        g.isHasFiftyFifty();
        boolean expResult3 = true;
        boolean result3 = g.isHasFiftyFifty();
        

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }
    

    
}
