/**
 * Models a CONSTANT_InvokeDynamic entry
 *
 * @author Eric Bodden
 */

package jas;
import java.io.*;


public class InvokeDynamicCP extends CP implements RuntimeConstants
{
  ClassCP bsmClass;
  NameTypeCP bsm;
  NameTypeCP method;

  /**
   * @param bsmClassName name of class holding the boostrap method
   * @param bsmName name of bootstrap method
   * @param bsmSig Signature of bootstrap method
   * @param bsmName uninterpreted name of called method
   * @param bsmSig Signature of calledmethod
   */
  public InvokeDynamicCP(String bsmClassName, String bsmName, String bsmSig, String methodName, String methodSig)
  {
	bsmClass = new ClassCP(bsmClassName);
    uniq = bsmName + "&%$91&" + bsmSig+ "*(012$" + methodName + "dfg8932" + methodSig;
    bsm = new NameTypeCP(bsmName, bsmSig);
    method = new NameTypeCP(methodName, methodSig);
  }

  void resolve(ClassEnv e)
  {
    e.addCPItem(bsmClass);
    e.addBootstrapMethod(bsm);//TODO what to do about arguments to bootstrap method?
    e.addCPItem(method);
  }

  void write(ClassEnv e, DataOutputStream out)
    throws IOException, jasError
  {
    out.writeByte(CONSTANT_INVOKE_DYNAMIC);
    out.writeShort(e.getCPIndex(bsmClass));
    out.writeShort(e.getCPIndex(method));
  }
}
