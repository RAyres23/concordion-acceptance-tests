/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feup.ppes.spreadsheetengine.model;

import feup.ppes.spreadsheetengine.expression.tree.ValueNode;
import java.security.InvalidParameterException;
import java.util.Objects;

/**
 *
 * @author Renato
 */
public class Cell extends ValueNode {

    private final String name;
    private String formula;

    public Cell(String name, double value) {
        super(value);
        if (Character.isDigit(name.trim().charAt(0))) {
            throw new InvalidParameterException("Name must not start by a number");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Cell temp = (Cell) obj;
        return this.name.equals(temp.name);
    }

}
