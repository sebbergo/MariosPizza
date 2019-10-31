/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariopizza;
//@author Sebastian
import org.junit.Test;
import static org.junit.Assert.*;


public class PizzaTest {
    
    public PizzaTest() {
    }

    /**
     * Test of getPris method, of class Pizza.
     */
    @Test
    public void testGetPris() {
        System.out.println("getPris");
        Pizza pizTest = new Pizza("Vesuvio", 54, "ost, tomat, pepperoni, gorgonzola");        
        int expResult = 54;
        int result = pizTest.getPris();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFyld method, of class Pizza.
     */
    @Test
    public void testGetFyld() {
        System.out.println("getFyld");
        Pizza pizTest = new Pizza("Vesuvio", 54, "ost, tomat, pepperoni, gorgonzola");
        String expResult = "ost, tomat, pepperoni, gorgonzola";
        String result = pizTest.getFyld();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNavn method, of class Pizza.
     */
    @Test
    public void testGetNavn() {
        System.out.println("getNavn");
        Pizza pizTest = new Pizza("Vesuvio", 54, "ost, tomat, pepperoni, gorgonzola");        
        String expResult = "Vesuvio";
        String result = pizTest.getNavn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNummer method, of class Pizza.
     */
    @Test
    public void testGetNummer() {
        System.out.println("getNummer");
        Pizza pizTest = new Pizza("Vesuvio", 54, "ost, tomat, pepperoni, gorgonzola");        
        int expResult = 5;
        int result = pizTest.getNummer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class Pizza.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Pizza pizTest = new Pizza("Vesuvio", 54, "ost, tomat, pepperoni, gorgonzola");        
        String expResult = "Navn: Vesuvio";
        String result = pizTest.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
