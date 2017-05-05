package parser;

//simple exp -> add exp -> term -> factor -> var
import compiler.CMinusCompiler;
import java.io.PrintStream;
import java.util.HashMap;
import lowlevel.CodeItem;
import lowlevel.Function;
import lowlevel.LowLevelException;
import lowlevel.Operand;
import lowlevel.Operation;

public class VarExp extends Expression {

    private String id;
    //var -> ID [ expression ]
    //(exp = null) if (var -> ID)
    private Expression exp;

    public VarExp(String i, Expression e) {
        super(Expression.type.VAR);
        id = i;
        exp = e;
    }

    public VarExp(String i) {
        this(i, null);
    }

    public String getID() {
        return id;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Variable Expression: " + id);
        if (exp != null) {
            exp.print(out, indent + 1);
        }
    }

    @Override
    public int genLLCode(Function fun, CompoundStmt cs) {
        if (cs != null) {
            HashMap localTable = cs.getTable();
            if (localTable.containsKey(id)) {
                return (Integer) localTable.get(id);
            } else {
                ParseObject parent = cs.getParent();
                while (parent != null) {
                    if (parent instanceof Statement) {
                        if (parent instanceof CompoundStmt) {
                            localTable = ((CompoundStmt) parent).getTable();
                            if (localTable.containsKey(id)) {
                                return (Integer) localTable.get(id);
                            }
                        }
                        parent = ((Statement)parent).getParent();
                    } else {
                        break;
                    }
                }
            }
        }

        if (fun.getTable().containsKey(id)) {
            return (Integer) fun.getTable().get(id);
        } else if (CMinusCompiler.globalHash.containsKey(id)) {
            int newReg = fun.getNewRegNum();
            Operation oper = new Operation(Operation.OperationType.LOAD_I, fun.getCurrBlock());
            Operand src = new Operand(Operand.OperandType.STRING, id);
            Operand dest = new Operand(Operand.OperandType.REGISTER, newReg);
            oper.setSrcOperand(0, src);
            oper.setDestOperand(0, dest);
            fun.getCurrBlock().appendOper(oper);
            return newReg;
        } else {
            throw new LowLevelException("Error: variable " + id + " was not declared prior to use.");
        }

    }
}