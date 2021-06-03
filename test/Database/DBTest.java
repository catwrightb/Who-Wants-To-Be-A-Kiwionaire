/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.User;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author catharinebaker
 */
public class DBTest {
    
    public DBTest() {
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

  
     /**
     * Test user creation method, of class ScreenControl.
     */
    @Test
    public void testRetrievePlayer() {
        String testName = "Test";
        
        UserDB userDB = new UserDB();
        
        User instance = userDB.retrieveUser(testName);
       
        assertNotNull(instance);
    }
    
    /**
     * Test user creation method, of class ScreenControl.
     */
    @Test
    public void testUserUnique() {
        
        UserDB u1 = new UserDB();
        UserDB u2 = new UserDB();
        
        assertNotEquals(u1,u2);
    }
    
    
     /**
     * Test user creation method, of class ScreenControl.
     */
    @Test
    public void checkUserNameAvaliable() {
        String testName = "Hello World";
        
        UserDB userDB = new UserDB();
        
        Boolean instance = userDB.checkUsernameAvailability(testName);
       
        //should fail due to space in userName String
        assertEquals(instance, false);
    }

    
}
