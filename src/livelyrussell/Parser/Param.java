package livelyrussell.Parser;

public class Param {

    private boolean isvoid;
    private String id;
    //If id == VOID, there were no params
    //Also known as empty param-list.
    private boolean isArray;

    Param(String i, boolean a, Param p, boolean v) {
        id = i;
        isArray = a;
        isvoid = v;
    }

    Param(String i, boolean a, Param p) {
        id = i;
        isArray = a;
        isvoid = false;
    }

    Param(String i, boolean a) {
        this(i, a, null, false);
    }

    Param(String i) {
        this(i, false, null, false);
    }

    Param() {
        this("", false, null, true);
    }

}
