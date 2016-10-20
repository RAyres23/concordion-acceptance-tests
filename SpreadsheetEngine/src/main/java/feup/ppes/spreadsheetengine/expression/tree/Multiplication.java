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
public class Multiplication extends ArithmeticNode {

    public Multiplication(Node left, Node right) {
        super(left, right);
    }

    @Override
    public double operate() {
        return getLeft().operate() * getRight().operate();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        return obj.getClass() != this.getClass(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
}
