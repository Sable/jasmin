/**
 * Used to make up new field entries. Fields for a class can have
 * an additional "ConstantValue" attribute associated them,
 * which the java compiler uses to represent things like
 * static final int blah = foo;
 *
 * @author $Author: fqian $
 * @version $Revision: 1.1 $
 */

package jas;

import java.io.*;
import java.util.*;


public class Var
{
  short var_acc;
  CP name, sig;
  ConstAttr const_attr;

    Vector genericAttrs = new Vector();
    

  /**
   * @param vacc access permissions for the field
   * @param name name of the field
   * @param sig type of the field
   * @param cattr Extra constant value information. Passing this as
   * null will not include this information for the record.
   * @see RuntimeConstants
   */

  public Var(short vacc, CP name, CP sig, ConstAttr cattr)
  {
    var_acc = vacc; this.name = name;
    this.sig = sig; const_attr = cattr;
  }

    public void addGenericAttr(GenericAttr g)
    {
        genericAttrs.addElement(g);
    }




  void resolve(ClassEnv e)
  {
    e.addCPItem(name);
    e.addCPItem(sig);
    if (const_attr != null)
      { const_attr.resolve(e); }
  }

  void write(ClassEnv e, DataOutputStream out)
    throws IOException, jasError
  {
    out.writeShort(var_acc);
    out.writeShort(e.getCPIndex(name));
    out.writeShort(e.getCPIndex(sig));
    int attrCnt = genericAttrs.size();

    if (const_attr != null)
      { out.writeShort(attrCnt +1); const_attr.write(e, out); }
    else
      { out.writeShort(attrCnt); }

    for(Enumeration enu = genericAttrs.elements(); enu.hasMoreElements();) {
        ((GenericAttr)enu.nextElement()).write(e, out);
    }
  }
}
