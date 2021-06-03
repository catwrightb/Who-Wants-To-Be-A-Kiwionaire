/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Models.*;

/**
 *
 * @author catharinebaker
 */
public class ScreenControlTest {
    
    public ScreenControlTest() {
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
     * Test cardSwitch method, of class ScreenControl.
     */
    @Test
    public void testCardSwitch() {
        ScreenControl instance = new ScreenControl();
        
        JPanel newPanel = new JPanel();
        String name = "testPanel";
        instance.addCard(newPanel, name);
     
        JPanel oldPanel = new JPanel();
       
        boolean expResult = true;
        instance.cardSwitch(newPanel, name, oldPanel);
       
        assertEquals(expResult, true);
    }
    
    
     /**
     * Test cardSwitch method, of class ScreenControl.
     */
    @Test
    public void testScreenControler() {
        ScreenControl instance = new ScreenControl();
       
        assertNotNull(instance);
    }
    
    

}
