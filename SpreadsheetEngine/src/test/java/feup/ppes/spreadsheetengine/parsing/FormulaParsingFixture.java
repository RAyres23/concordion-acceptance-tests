package feup.ppes.spreadsheetengine.parsing;

import feup.ppes.spreadsheetengine.Engine;
import feup.ppes.spreadsheetengine.model.Cell;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class FormulaParsingFixture {

    private static final String SPREADSHEET = "Mock";

    static {
        Engine.addSpreadsheet(SPREADSHEET);
    }

    public double calculate(String formula) {
        return Parser.parse(SPREADSHEET, formula).operate();
    }

    public void addCell(String cell, double value) {
        Engine.addCellToSpreadsheet(SPREADSHEET, cell, value);
    }

    public void addCellWithFormula(String name, String formula) {
        Cell cell = new Cell(name, 0.0);
        cell.setFormula(formula);
        Engine.addCellToSpreadsheet(SPREADSHEET, cell);
    }
}
