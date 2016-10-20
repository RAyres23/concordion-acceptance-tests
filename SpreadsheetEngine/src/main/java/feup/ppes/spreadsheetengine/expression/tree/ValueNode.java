/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feup.ppes.spreadsheetengine.expression.tree;

/**
 *
 * @author Renato
 */
public class ValueNode implements Node {

    private double value;

    public ValueNode(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double operate() {
        return this.value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ValueNode node = (ValueNode) obj;
        return Double.doubleToLongBits(this.value) == Double.doubleToLongBits(node.value);
    }

}
