/**
 * Models a CONSTANT_InvokeDynamic entry
 *
 * @author Eric Bodden
 */

package jas;
import java.io.*;


public class InvokeDynamicCP extends CP implements RuntimeConstants
{
  MethodHandleCP bsm;
  NameTypeCP method;

  /**
   * @param kind the kind of call site 
   * @param bsmClassName name of class holding the boostrap method
   * @param bsmName name of bootstrap method
   * @param bsmSig Signature of bootstrap method
   * @param bsmName uninterpreted name of called method
   * @param bsmSig Signature of calledmethod
   */
  public InvokeDynamicCP(int kind, String bsmClassName, String bsmName, String bsmSig, String methodName, String methodSig)
  {
    uniq = kind + "fv0¤" + bsmClassName + "fv0¤" + bsmName + "&%$91&" + bsmSig+ "*(012$" + methodName + "dfg8932" + methodSig;
    bsm = new MethodHandleCP(kind, bsmClassName, bsmName, bsmSig);
    method = new NameTypeCP(methodName, methodSig);
  }

  void resolve(ClassEnv e)
  {
    e.addBootstrapMethod(bsm);//TODO what to do about arguments to bootstrap method?
    e.addCPItem(method);
  }

  void write(ClassEnv e, DataOutputStream out)
    throws IOException, jasError
  {
    out.writeByte(CONSTANT_INVOKE_DYNAMIC);
    out.writeShort(e.getBootstrapTableIndex(bsm));
    out.writeShort(e.getCPIndex(method));
  }
}
