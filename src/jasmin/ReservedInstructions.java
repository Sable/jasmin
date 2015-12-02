/* --- Copyright Alexandre Bartel 2015. All rights reserved. -----------------
 */

package jasmin;

import java.util.Hashtable;

import java_cup.runtime.Symbol;

abstract class ReservedInstructions {
	static Hashtable reserved_instructions;

	// we can't pull this hashtable trick anymore, no more recycling allowed!
	public static Symbol get(String name) {
		Symbol template = (Symbol) reserved_instructions.get(name);
		if (template != null)
			return new Symbol(template.sym);
		else
			return null;
	}

	public static boolean contains(String name) {
		return reserved_instructions.get(name) != null;
	}

	//
	// scanner initializer - sets up reserved_instructions table
	//
	static {
		reserved_instructions = new Hashtable();

		// Jasmin directives
		reserved_instructions.put("aaload", new Symbol(sym.i_aaload));
		reserved_instructions.put("aastore", new Symbol(sym.i_aastore));
		reserved_instructions.put("aconst_null", new Symbol(sym.i_aconst_null));
		reserved_instructions.put("aload", new Symbol(sym.i_aload));
		reserved_instructions.put("aload_0", new Symbol(sym.i_aload_0));
		reserved_instructions.put("aload_1", new Symbol(sym.i_aload_1));
		reserved_instructions.put("aload_2", new Symbol(sym.i_aload_2));
		reserved_instructions.put("aload_3", new Symbol(sym.i_aload_3));
		reserved_instructions.put("anewarray", new Symbol(sym.i_anewarray));
		reserved_instructions.put("areturn", new Symbol(sym.i_areturn));
		reserved_instructions.put("arraylength", new Symbol(sym.i_arraylength));
		reserved_instructions.put("astore", new Symbol(sym.i_astore));
		reserved_instructions.put("astore_0", new Symbol(sym.i_astore_0));
		reserved_instructions.put("astore_1", new Symbol(sym.i_astore_1));
		reserved_instructions.put("astore_2", new Symbol(sym.i_astore_2));
		reserved_instructions.put("astore_3", new Symbol(sym.i_astore_3));
		reserved_instructions.put("athrow", new Symbol(sym.i_athrow));
		reserved_instructions.put("baload", new Symbol(sym.i_baload));
		reserved_instructions.put("bastore", new Symbol(sym.i_bastore));
		reserved_instructions.put("bipush", new Symbol(sym.i_bipush));
		reserved_instructions.put("breakpoint", new Symbol(sym.i_breakpoint));
		reserved_instructions.put("caload", new Symbol(sym.i_caload));
		reserved_instructions.put("castore", new Symbol(sym.i_castore));
		reserved_instructions.put("checkcast", new Symbol(sym.i_checkcast));
		reserved_instructions.put("d2f", new Symbol(sym.i_d2f));
		reserved_instructions.put("d2i", new Symbol(sym.i_d2i));
		reserved_instructions.put("d2l", new Symbol(sym.i_d2l));
		reserved_instructions.put("dadd", new Symbol(sym.i_dadd));
		reserved_instructions.put("daload", new Symbol(sym.i_daload));
		reserved_instructions.put("dastore", new Symbol(sym.i_dastore));
		reserved_instructions.put("dcmpg", new Symbol(sym.i_dcmpg));
		reserved_instructions.put("dcmpl", new Symbol(sym.i_dcmpl));
		reserved_instructions.put("dconst_0", new Symbol(sym.i_dconst_0));
		reserved_instructions.put("dconst_1", new Symbol(sym.i_dconst_1));
		reserved_instructions.put("ddiv", new Symbol(sym.i_ddiv));
		reserved_instructions.put("dload", new Symbol(sym.i_dload));
		reserved_instructions.put("dload_0", new Symbol(sym.i_dload_0));
		reserved_instructions.put("dload_1", new Symbol(sym.i_dload_1));
		reserved_instructions.put("dload_2", new Symbol(sym.i_dload_2));
		reserved_instructions.put("dload_3", new Symbol(sym.i_dload_3));
		reserved_instructions.put("dmul", new Symbol(sym.i_dmul));
		reserved_instructions.put("dneg", new Symbol(sym.i_dneg));
		reserved_instructions.put("drem", new Symbol(sym.i_drem));
		reserved_instructions.put("dreturn", new Symbol(sym.i_dreturn));
		reserved_instructions.put("dstore", new Symbol(sym.i_dstore));
		reserved_instructions.put("dstore_0", new Symbol(sym.i_dstore_0));
		reserved_instructions.put("dstore_1", new Symbol(sym.i_dstore_1));
		reserved_instructions.put("dstore_2", new Symbol(sym.i_dstore_2));
		reserved_instructions.put("dstore_3", new Symbol(sym.i_dstore_3));
		reserved_instructions.put("dsub", new Symbol(sym.i_dsub));
		reserved_instructions.put("dup", new Symbol(sym.i_dup));
		reserved_instructions.put("dup2", new Symbol(sym.i_dup2));
		reserved_instructions.put("dup2_x1", new Symbol(sym.i_dup2_x1));
		reserved_instructions.put("dup2_x2", new Symbol(sym.i_dup2_x2));
		reserved_instructions.put("dup_x1", new Symbol(sym.i_dup_x1));
		reserved_instructions.put("dup_x2", new Symbol(sym.i_dup_x2));
		reserved_instructions.put("f2d", new Symbol(sym.i_f2d));
		reserved_instructions.put("f2i", new Symbol(sym.i_f2i));
		reserved_instructions.put("f2l", new Symbol(sym.i_f2l));
		reserved_instructions.put("fadd", new Symbol(sym.i_fadd));
		reserved_instructions.put("faload", new Symbol(sym.i_faload));
		reserved_instructions.put("fastore", new Symbol(sym.i_fastore));
		reserved_instructions.put("fcmpg", new Symbol(sym.i_fcmpg));
		reserved_instructions.put("fcmpl", new Symbol(sym.i_fcmpl));
		reserved_instructions.put("fconst_0", new Symbol(sym.i_fconst_0));
		reserved_instructions.put("fconst_1", new Symbol(sym.i_fconst_1));
		reserved_instructions.put("fconst_2", new Symbol(sym.i_fconst_2));
		reserved_instructions.put("fdiv", new Symbol(sym.i_fdiv));
		reserved_instructions.put("fload", new Symbol(sym.i_fload));
		reserved_instructions.put("fload_0", new Symbol(sym.i_fload_0));
		reserved_instructions.put("fload_1", new Symbol(sym.i_fload_1));
		reserved_instructions.put("fload_2", new Symbol(sym.i_fload_2));
		reserved_instructions.put("fload_3", new Symbol(sym.i_fload_3));
		reserved_instructions.put("fmul", new Symbol(sym.i_fmul));
		reserved_instructions.put("fneg", new Symbol(sym.i_fneg));
		reserved_instructions.put("frem", new Symbol(sym.i_frem));
		reserved_instructions.put("freturn", new Symbol(sym.i_freturn));
		reserved_instructions.put("fstore", new Symbol(sym.i_fstore));
		reserved_instructions.put("fstore_0", new Symbol(sym.i_fstore_0));
		reserved_instructions.put("fstore_1", new Symbol(sym.i_fstore_1));
		reserved_instructions.put("fstore_2", new Symbol(sym.i_fstore_2));
		reserved_instructions.put("fstore_3", new Symbol(sym.i_fstore_3));
		reserved_instructions.put("fsub", new Symbol(sym.i_fsub));
		reserved_instructions.put("getfield", new Symbol(sym.i_getfield));
		reserved_instructions.put("getstatic", new Symbol(sym.i_getstatic));
		reserved_instructions.put("goto", new Symbol(sym.i_goto));
		reserved_instructions.put("goto_w", new Symbol(sym.i_goto_w));
		reserved_instructions.put("i2d", new Symbol(sym.i_i2d));
		reserved_instructions.put("i2f", new Symbol(sym.i_i2f));
		reserved_instructions.put("i2l", new Symbol(sym.i_i2l));
		reserved_instructions.put("iadd", new Symbol(sym.i_iadd));
		reserved_instructions.put("iaload", new Symbol(sym.i_iaload));
		reserved_instructions.put("iand", new Symbol(sym.i_iand));
		reserved_instructions.put("iastore", new Symbol(sym.i_iastore));
		reserved_instructions.put("iconst_0", new Symbol(sym.i_iconst_0));
		reserved_instructions.put("iconst_1", new Symbol(sym.i_iconst_1));
		reserved_instructions.put("iconst_2", new Symbol(sym.i_iconst_2));
		reserved_instructions.put("iconst_3", new Symbol(sym.i_iconst_3));
		reserved_instructions.put("iconst_4", new Symbol(sym.i_iconst_4));
		reserved_instructions.put("iconst_5", new Symbol(sym.i_iconst_5));
		reserved_instructions.put("iconst_m1", new Symbol(sym.i_iconst_m1));
		reserved_instructions.put("idiv", new Symbol(sym.i_idiv));
		reserved_instructions.put("if_acmpeq", new Symbol(sym.i_if_acmpeq));
		reserved_instructions.put("if_acmpne", new Symbol(sym.i_if_acmpne));
		reserved_instructions.put("if_icmpeq", new Symbol(sym.i_if_icmpeq));
		reserved_instructions.put("if_icmpge", new Symbol(sym.i_if_icmpge));
		reserved_instructions.put("if_icmpgt", new Symbol(sym.i_if_icmpgt));
		reserved_instructions.put("if_icmple", new Symbol(sym.i_if_icmple));
		reserved_instructions.put("if_icmplt", new Symbol(sym.i_if_icmplt));
		reserved_instructions.put("if_icmpne", new Symbol(sym.i_if_icmpne));
		reserved_instructions.put("ifeq", new Symbol(sym.i_ifeq));
		reserved_instructions.put("ifge", new Symbol(sym.i_ifge));
		reserved_instructions.put("ifgt", new Symbol(sym.i_ifgt));
		reserved_instructions.put("ifle", new Symbol(sym.i_ifle));
		reserved_instructions.put("iflt", new Symbol(sym.i_iflt));
		reserved_instructions.put("ifne", new Symbol(sym.i_ifne));
		reserved_instructions.put("ifnonnull", new Symbol(sym.i_ifnonnull));
		reserved_instructions.put("ifnull", new Symbol(sym.i_ifnull));
		reserved_instructions.put("iinc", new Symbol(sym.i_iinc));
		reserved_instructions.put("iload", new Symbol(sym.i_iload));
		reserved_instructions.put("iload_0", new Symbol(sym.i_iload_0));
		reserved_instructions.put("iload_1", new Symbol(sym.i_iload_1));
		reserved_instructions.put("iload_2", new Symbol(sym.i_iload_2));
		reserved_instructions.put("iload_3", new Symbol(sym.i_iload_3));
		reserved_instructions.put("imul", new Symbol(sym.i_imul));
		reserved_instructions.put("ineg", new Symbol(sym.i_ineg));
		reserved_instructions.put("instanceof", new Symbol(sym.i_instanceof));
		reserved_instructions.put("int2byte", new Symbol(sym.i_int2byte));
		reserved_instructions.put("int2char", new Symbol(sym.i_int2char));
		reserved_instructions.put("int2short", new Symbol(sym.i_int2short));
		reserved_instructions.put("i2b", new Symbol(sym.i_i2b));
		reserved_instructions.put("i2c", new Symbol(sym.i_i2c));
		reserved_instructions.put("i2s", new Symbol(sym.i_i2s));
		reserved_instructions.put("invokeinterface", new Symbol(sym.i_invokeinterface));
		reserved_instructions.put("invokenonvirtual", new Symbol(sym.i_invokenonvirtual));
		reserved_instructions.put("invokespecial", new Symbol(sym.i_invokespecial));
		reserved_instructions.put("invokestatic", new Symbol(sym.i_invokestatic));
		reserved_instructions.put("invokevirtual", new Symbol(sym.i_invokevirtual));
		reserved_instructions.put("invokedynamic", new Symbol(sym.i_invokedynamic));
		reserved_instructions.put("ior", new Symbol(sym.i_ior));
		reserved_instructions.put("irem", new Symbol(sym.i_irem));
		reserved_instructions.put("ireturn", new Symbol(sym.i_ireturn));
		reserved_instructions.put("ishl", new Symbol(sym.i_ishl));
		reserved_instructions.put("ishr", new Symbol(sym.i_ishr));
		reserved_instructions.put("istore", new Symbol(sym.i_istore));
		reserved_instructions.put("istore_0", new Symbol(sym.i_istore_0));
		reserved_instructions.put("istore_1", new Symbol(sym.i_istore_1));
		reserved_instructions.put("istore_2", new Symbol(sym.i_istore_2));
		reserved_instructions.put("istore_3", new Symbol(sym.i_istore_3));
		reserved_instructions.put("isub", new Symbol(sym.i_isub));
		reserved_instructions.put("iushr", new Symbol(sym.i_iushr));
		reserved_instructions.put("ixor", new Symbol(sym.i_ixor));
		reserved_instructions.put("jsr", new Symbol(sym.i_jsr));
		reserved_instructions.put("jsr_w", new Symbol(sym.i_jsr_w));
		reserved_instructions.put("l2d", new Symbol(sym.i_l2d));
		reserved_instructions.put("l2f", new Symbol(sym.i_l2f));
		reserved_instructions.put("l2i", new Symbol(sym.i_l2i));
		reserved_instructions.put("ladd", new Symbol(sym.i_ladd));
		reserved_instructions.put("laload", new Symbol(sym.i_laload));
		reserved_instructions.put("land", new Symbol(sym.i_land));
		reserved_instructions.put("lastore", new Symbol(sym.i_lastore));
		reserved_instructions.put("lcmp", new Symbol(sym.i_lcmp));
		reserved_instructions.put("lconst_0", new Symbol(sym.i_lconst_0));
		reserved_instructions.put("lconst_1", new Symbol(sym.i_lconst_1));
		reserved_instructions.put("ldc", new Symbol(sym.i_ldc));
		reserved_instructions.put("ldc_w", new Symbol(sym.i_ldc_w));
		reserved_instructions.put("ldc2_w", new Symbol(sym.i_ldc2_w));
		reserved_instructions.put("ldiv", new Symbol(sym.i_ldiv));
		reserved_instructions.put("lload", new Symbol(sym.i_lload));
		reserved_instructions.put("lload_0", new Symbol(sym.i_lload_0));
		reserved_instructions.put("lload_1", new Symbol(sym.i_lload_1));
		reserved_instructions.put("lload_2", new Symbol(sym.i_lload_2));
		reserved_instructions.put("lload_3", new Symbol(sym.i_lload_3));
		reserved_instructions.put("lmul", new Symbol(sym.i_lmul));
		reserved_instructions.put("lneg", new Symbol(sym.i_lneg));
		reserved_instructions.put("lookupswitch", new Symbol(sym.i_lookupswitch));
		reserved_instructions.put("lor", new Symbol(sym.i_lor));
		reserved_instructions.put("lrem", new Symbol(sym.i_lrem));
		reserved_instructions.put("lreturn", new Symbol(sym.i_lreturn));
		reserved_instructions.put("lshl", new Symbol(sym.i_lshl));
		reserved_instructions.put("lshr", new Symbol(sym.i_lshr));
		reserved_instructions.put("lstore", new Symbol(sym.i_lstore));
		reserved_instructions.put("lstore_0", new Symbol(sym.i_lstore_0));
		reserved_instructions.put("lstore_1", new Symbol(sym.i_lstore_1));
		reserved_instructions.put("lstore_2", new Symbol(sym.i_lstore_2));
		reserved_instructions.put("lstore_3", new Symbol(sym.i_lstore_3));
		reserved_instructions.put("lsub", new Symbol(sym.i_lsub));
		reserved_instructions.put("lushr", new Symbol(sym.i_lushr));
		reserved_instructions.put("lxor", new Symbol(sym.i_lxor));
		reserved_instructions.put("monitorenter", new Symbol(sym.i_monitorenter));
		reserved_instructions.put("monitorexit", new Symbol(sym.i_monitorexit));
		reserved_instructions.put("multianewarray", new Symbol(sym.i_multianewarray));
		reserved_instructions.put("new", new Symbol(sym.i_new));
		reserved_instructions.put("newarray", new Symbol(sym.i_newarray));
		reserved_instructions.put("nop", new Symbol(sym.i_nop));
		reserved_instructions.put("pop", new Symbol(sym.i_pop));
		reserved_instructions.put("pop2", new Symbol(sym.i_pop2));
		reserved_instructions.put("putfield", new Symbol(sym.i_putfield));
		reserved_instructions.put("putstatic", new Symbol(sym.i_putstatic));
		reserved_instructions.put("ret", new Symbol(sym.i_ret));
		reserved_instructions.put("ret_w", new Symbol(sym.i_ret_w));
		reserved_instructions.put("return", new Symbol(sym.i_return));
		reserved_instructions.put("saload", new Symbol(sym.i_saload));
		reserved_instructions.put("sastore", new Symbol(sym.i_sastore));
		reserved_instructions.put("sipush", new Symbol(sym.i_sipush));
		reserved_instructions.put("swap", new Symbol(sym.i_swap));
		reserved_instructions.put("tableswitch", new Symbol(sym.i_tableswitch));
		reserved_instructions.put("wide", new Symbol(sym.i_wide));

	}
}
