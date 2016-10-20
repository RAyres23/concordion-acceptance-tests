/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feup.ppes.spreadsheetengine.parsing;

import feup.ppes.spreadsheetengine.Engine;
import feup.ppes.spreadsheetengine.expression.tree.Addition;
import feup.ppes.spreadsheetengine.expression.tree.Division;
import feup.ppes.spreadsheetengine.expression.tree.Multiplication;
import feup.ppes.spreadsheetengine.expression.tree.Node;
import feup.ppes.spreadsheetengine.expression.tree.ValueNode;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Renato
 */
public class ParserTest {

    private final String spreadsheet = "MockParseTest";

    public ParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            Engine.addSpreadsheet(spreadsheet);
        } catch (IllegalArgumentException ex) {
        }
    }

    @After
    public void tearDown() {
        try {
            Engine.removeSpreadsheet(spreadsheet);
        } catch (NullPointerException ex) {
        }
    }

    /**
     * Test of parse method, of class Parser.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        Double c1Value = 12.0;
        String f2 = "10*5/100";
        String f3 = "C1+C2";

        Engine.addCellToSpreadsheet(spreadsheet, "C1", c1Value);
        Engine.addCellToSpreadsheet(spreadsheet, "C2", 0);
        Engine.getCellFromSpreadsheet(spreadsheet, "C2").setFormula(f2);
        Engine.addCellToSpreadsheet(spreadsheet, "C3", 0);
        Engine.getCellFromSpreadsheet(spreadsheet, "C3").setFormula(f3);

        //C1/C2 root is division
        //left 12 + 10*5 / 100 right
        ValueNode ten = new ValueNode(10);
        ValueNode five = new ValueNode(5);
        ValueNode oneHundred = new ValueNode(100);
        Division div = new Division(five, oneHundred);
        Multiplication mult = new Multiplication(ten, div);
        ValueNode twelve = new ValueNode(12);
        Addition root = new Addition(twelve, mult);

        Node expResult = root;
        Node result = Parser.parse(spreadsheet, "C3");
        assertEquals(result.operate(), expResult.operate(), 0);
    }
}
