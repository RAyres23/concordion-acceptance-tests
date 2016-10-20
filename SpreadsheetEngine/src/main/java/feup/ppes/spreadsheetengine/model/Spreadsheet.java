/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feup.ppes.spreadsheetengine.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Renato
 */
public class Spreadsheet {

    private String name;
    private final Map<String, Cell> cells;

    public Spreadsheet(String name) {
        this.name = name;
        cells = new HashMap<String, Cell>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Cell> getCells() {
        return cells;
    }

    public void addCell(Cell cell) {
        if (cells.containsKey(cell.getName())) {
            throw new IllegalArgumentException("Name for cell already used in "
                    + "another cell. Please choose a different name");
        }
        cells.put(cell.getName(), cell);
    }

    public void addCell(String name, double value) {
        if (cells.containsKey(name)) {
            throw new IllegalArgumentException("Name for cell already used in "
                    + "another cell. Please choose a different name");
        }
        cells.put(name, new Cell(name, value));
    }

    public Cell getCell(String name) {
        Cell cell = cells.get(name);

        if (cell == null) {
            throw new NullPointerException("Cell not found.");
        }

        return cell;
    }

    public double getCellValue(String name) {
        if (!cells.containsKey(name)) {
            throw new NullPointerException("Cell not found");
        }

        return cells.get(name).getValue();
    }

    public void removeCell(String name) {
        if (cells.remove(name) == null) {
            throw new NullPointerException("Cell not found.");
        }
    }

    public void clearCells() {
        cells.clear();
    }
}
