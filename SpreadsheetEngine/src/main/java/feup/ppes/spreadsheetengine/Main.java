/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feup.ppes.spreadsheetengine;

/**
 *
 * @author Renato
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String spreadsheet = "Mock";
        Double c1Value = 12.0;
        String f2 = "10*5/100";
        String f3 = "C1*C2";
        String f4 = "C1*C3";
        String f5 = "C1*C3/C2";

        Engine.addSpreadsheet(spreadsheet);
        Engine.addCellToSpreadsheet(spreadsheet, "C1", c1Value);
        Engine.addCellToSpreadsheet(spreadsheet, "C2", 0);
        Engine.getCellFromSpreadsheet(spreadsheet, "C2").setFormula(f2);
        Engine.addCellToSpreadsheet(spreadsheet, "C3", 0);
        Engine.getCellFromSpreadsheet(spreadsheet, "C3").setFormula(f3);
        Engine.addCellToSpreadsheet(spreadsheet, "C4", 0);
        Engine.getCellFromSpreadsheet(spreadsheet, "C4").setFormula(f4);
        Engine.addCellToSpreadsheet(spreadsheet, "C5", 0);
        Engine.getCellFromSpreadsheet(spreadsheet, "C5").setFormula(f5);

        System.out.println("C1 Value: " + Engine.getCellValue(spreadsheet, "C1"));
        System.out.println("C2 Value: " + Engine.getCellValue(spreadsheet, "C2"));
        System.out.println("C3 Value: " + Engine.getCellValue(spreadsheet, "C3"));
        System.out.println("C4 Value: " + Engine.getCellValue(spreadsheet, "C4"));
        System.out.println("C5 Value: " + Engine.getCellValue(spreadsheet, "C5"));
    }

}
