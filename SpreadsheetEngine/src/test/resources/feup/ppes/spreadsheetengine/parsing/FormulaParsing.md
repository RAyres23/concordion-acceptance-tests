# Formula Parsing

When using this system, formulas can be used to represent a Cell value.
Formulas can take the following forms: 2*3+4/6 or C1+4*C2, C1 and C2 are cells with formulas or values assignated to.

### Example

So, [100*2](- "#formula") [equals](- "#result=calculate(#formula)") to 
[200.0](- "?=#result").
[1+2/5](- "#formula") [equals](- "#result=calculate(#formula)") to 
[1.4](- "?=#result").

### Exercise:

We want to be able to get the value of C1/C2. C1 is a cell with a formula and C2 is a cell with a value.

What do you do?

Add a Cell with name [C1](- "#name") and formula [15*4](- "#formula") to the [system](- "addCellWithFormula(#name, #formula)").

A Cell with [C2](- "#name") as a name and [5](- "#value") as a value is [added](- "addCell(#name, #value)").
[C1/C2](- "#formula") [equals](- "#result=calculate(#formula)") to [12.0](- "?=#result").