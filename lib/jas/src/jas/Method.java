/**
 * This is used to encapsulate a CodeAttr so it can be added
 * into a class.
 * @see ClassEnv#addMethod
 * @author $Author: fqian $
 * @version $Revision: 1.1 $
 */
package jas;

import java.io.*;
import java.util.*;

public class Method
{
  short acc;
  CP name, sig;
  CodeAttr code;
  ExceptAttr excepts;
  SyntheticAttr synthAttr = null;    
    Vector genericAttrs = new Vector();

  /**
   * @param macc method access permissions. It is a combination
   * of the constants provided from RuntimeConstants
   * @param name CP item representing name of method.
   * @param sig CP item representing signature for object
   * @param code The actual code for the object
   * @param ex Any exceptions associated with object
   */
  public Method (short macc, CP name, CP sig, CodeAttr cd, ExceptAttr ex)
  {
    acc = macc;
    this.name = name;
    this.sig = sig;
    code = cd; excepts = ex;
  }

  public Method (short macc, CP name, CP sig, CodeAttr cd, ExceptAttr ex, SyntheticAttr synth)
  {
    acc = macc;
    this.name = name;
    this.sig = sig;
    code = cd; excepts = ex;
    synthAttr = synth;
  }
    public void addGenericAttr(GenericAttr g)
    {
	genericAttrs.addElement(g);	
    }



  void resolve(ClassEnv e)
  {
    e.addCPItem(name);
    e.addCPItem(sig);
    if (code != null)  code.resolve(e);
    if (excepts != null)  excepts.resolve(e);
    if (synthAttr != null) synthAttr.resolve(e);
  }

  void write(ClassEnv e, DataOutputStream out)
    throws IOException, jasError
  {
    short cnt = 0;
    out.writeShort(acc);
    out.writeShort(e.getCPIndex(name));
    out.writeShort(e.getCPIndex(sig));
    if (code != null) cnt ++;
    if (excepts != null) cnt++;
    cnt += genericAttrs.size();
    if (synthAttr != null){
        cnt++;
    }
    out.writeShort(cnt);
    if (code != null) code.write(e, out);
    if (excepts != null) excepts.write(e, out);
    if (synthAttr != null) synthAttr.write(e, out);

    for(Enumeration enu = genericAttrs.elements(); enu.hasMoreElements();) {
	((GenericAttr)enu.nextElement()).write(e, out);
    }
    
  }
}
