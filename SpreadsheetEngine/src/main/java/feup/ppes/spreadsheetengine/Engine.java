/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feup.ppes.spreadsheetengine;

import feup.ppes.spreadsheetengine.expression.tree.Node;
import feup.ppes.spreadsheetengine.model.Cell;
import feup.ppes.spreadsheetengine.model.Spreadsheet;
import feup.ppes.spreadsheetengine.parsing.Parser;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Renato
 */
public final class Engine {

    private static final Map<String, Spreadsheet> SPREADSHEETS = new HashMap();

    public static void addSpreadsheet(String name) {
        if (SPREADSHEETS.containsKey(name)) {
            throw new IllegalArgumentException("Name for spreadsheet already used in "
                    + "another spreadsheet. Please choose a different name");
        }
        SPREADSHEETS.put(name, new Spreadsheet(name));
    }

    public static Spreadsheet getSpreadsheet(String name) {
        Spreadsheet spreadsheet = SPREADSHEETS.get(name);

        if (spreadsheet == null) {
            throw new NullPointerException("Spreadsheet not found.");
        }

        return spreadsheet;
    }

    public static void removeSpreadsheet(String name) {
        if (SPREADSHEETS.remove(name) == null) {
            throw new NullPointerException("Spreadsheet not found.");
        }
    }

    public static void clearSpreadsheets() {
        SPREADSHEETS.clear();
    }

    public static void addCellToSpreadsheet(String sname, Cell cell) {
        getSpreadsheet(sname).addCell(cell);
    }

    public static void addCellToSpreadsheet(String sname, String cname, double value) {
        getSpreadsheet(sname).addCell(cname, value);
    }

    public static Cell getCellFromSpreadsheet(String sname, String cname) {
        return getSpreadsheet(sname).getCell(cname);
    }

    public static double getCellValue(String sname, String cname) {
        Cell cell = getCellFromSpreadsheet(sname, cname);
        if (cell.getFormula() == null) {
            return cell.getValue();
        }
        Node root = Parser.parse(sname, cell.getFormula());
        Double result = root.operate();
        cell.setValue(result);
        return result;
    }

    public static void removeCellFromSpreadsheet(String sname, String cname) {
        getSpreadsheet(sname).removeCell(cname);
    }

    public static void clearSpreadsheetCells(String name) {
        getSpreadsheet(name).clearCells();
    }
}
