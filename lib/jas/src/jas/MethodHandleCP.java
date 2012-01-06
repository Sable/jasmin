/**
 * Models a CONSTANT_MethodHandle entry
 *
 * @author Eric Bodden
 */

package jas;
import java.io.*;


public class MethodHandleCP extends CP implements RuntimeConstants
{
  int kind;
  NameTypeCP fieldOrMethod;

  /**
   * @param cname Class in which method exists
   * @param varname name of field or method
   * @param sig Signature of field r method
   */
  public MethodHandleCP(int kind, String varname, String sig)
  {
    uniq = kind + "&%$91&" + varname + "*(012$" + sig;
    fieldOrMethod = new NameTypeCP(varname, sig);
  }

  void resolve(ClassEnv e)
  {
    e.addCPItem(fieldOrMethod);
  }

  void write(ClassEnv e, DataOutputStream out)
    throws IOException, jasError
  {
    out.writeByte(CONSTANT_METHOD_HANDLE);
    out.writeByte(kind);
    out.writeShort(e.getCPIndex(fieldOrMethod));
  }
}
