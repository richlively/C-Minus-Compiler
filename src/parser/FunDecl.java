package parser;

import java.io.PrintStream;
import java.util.ArrayList;
import lowlevel.BasicBlock;
import lowlevel.CodeItem;
import lowlevel.Data;
import lowlevel.FuncParam;
import lowlevel.Function;

public class FunDecl extends Declaration {

    @Override
    public CodeItem genLLCode() {

        //get function stuff
        int t;
        if (kind == type.VOID) {
            t = Data.TYPE_VOID;
        } else {
            t = Data.TYPE_INT;
        }
        String name = id;

        //getting params
        FuncParam head;
        FuncParam tail;
        Function fun = new Function(t, name);
        if (params.size() > 0) {
            Param holder = params.get(0);
            int typer;
            if (holder.isVoid()) {
                typer = Data.TYPE_VOID;
            } else {
                typer = Data.TYPE_INT;
            }
            String pname = holder.id;
            head = new FuncParam(typer, pname);
            tail = head;
            fun.setFirstParam(head);
            fun.getTable().put(pname, fun.getNewRegNum());
        } else {
            head = null;
            tail = null;
        }
        for (int i = 1; i < params.size(); i++) {
            Param holder = params.get(i);
            int typer;
            if (holder.isVoid()) {
                typer = Data.TYPE_VOID;
            } else {
                typer = Data.TYPE_INT;
            }
            String pname = holder.id;
            tail.setNextParam(new FuncParam(typer, pname));
            tail = tail.getNextParam();
            fun.getTable().put(pname, fun.getNewRegNum());
        }

        fun.createBlock0();
        BasicBlock b = new BasicBlock(fun);
        fun.appendBlock(b);
        //parse the comp stmt
        fun.setCurrBlock(b);
        cs.genLLCode(fun);
        fun.appendBlock(fun.getReturnBlock());
        if (fun.getFirstUnconnectedBlock() != null) {
            fun.appendBlock(fun.getFirstUnconnectedBlock());
        }
        return fun;
    }

    public enum type {

        VOID, INT
    }
    private final FunDecl.type kind;
    private final CompoundStmt cs;
    private final ArrayList<Param> params;

    FunDecl(String i, CompoundStmt c, ArrayList<Param> p, FunDecl.type t) {
        super(i);
        cs = c;
        params = p;
        kind = t;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "FunDecl: " + kind + " " + id);

        for (Param param : params) {
            param.print(out, indent + 1);
        }

        cs.print(out, indent + 1);
    }
}
