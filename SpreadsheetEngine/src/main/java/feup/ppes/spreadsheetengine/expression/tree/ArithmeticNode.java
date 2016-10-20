/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feup.ppes.spreadsheetengine.expression.tree;

import java.util.Objects;

/**
 *
 * @author Renato
 */
public abstract class ArithmeticNode implements Node {

    private Node left;
    private Node right;

    public ArithmeticNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public abstract double operate();

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.left);
        hash = 89 * hash + Objects.hashCode(this.right);
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

        ArithmeticNode node = (ArithmeticNode) obj;
        if (!this.left.equals(node.left)) {
            return false;
        }
        return this.right.equals(node.right);
    }

}
