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
import feup.ppes.spreadsheetengine.expression.tree.Subtraction;
import feup.ppes.spreadsheetengine.expression.tree.ValueNode;
import feup.ppes.spreadsheetengine.model.Cell;

/**
 *
 * @author Renato
 */
public class Parser {

    public static Node parse(String spreadsheet, String expression) {
        expression = expression.replaceAll("\\s+", "").replaceAll(",", ".").trim();
        int size = expression.length();
        for (int i = 0; i < size; i++) {
            if (expression.charAt(i) == '*') {
                Node node = new Multiplication(Parser.parse(spreadsheet, expression.substring(0, i)), Parser.parse(spreadsheet, expression.substring(i + 1)));
                return node;
            }
            if (expression.charAt(i) == '/') {
                Node node = new Division(Parser.parse(spreadsheet, expression.substring(0, i)), Parser.parse(spreadsheet, expression.substring(i + 1)));
                return node;
            }
            if (expression.charAt(i) == '-') {
                Node node = new Subtraction(Parser.parse(spreadsheet, expression.substring(0, i)), Parser.parse(spreadsheet, expression.substring(i + 1)));
                return node;
            }
            if (expression.charAt(i) == '+') {
                Node node = new Addition(Parser.parse(spreadsheet, expression.substring(0, i)), Parser.parse(spreadsheet, expression.substring(i + 1)));
                return node;
            }
        }

        if (!Character.isDigit(expression.charAt(0))) {
            Cell cell = Engine.getCellFromSpreadsheet(spreadsheet, expression);
            String formula = cell.getFormula();
            if (formula != null) {
                Node node = Parser.parse(spreadsheet, formula);
                return node;
            } else {
                return cell;
            }
        }

        return new ValueNode(Double.valueOf(expression));
    }
}
