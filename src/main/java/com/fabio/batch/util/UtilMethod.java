package com.fabio.batch.util;

public class UtilMethod {
	
	
	
	public static String generaCodiceUtente(String cf) {
		String codice="cens_";
		if(cf!=null) {
			for(int i=0;i<cf.length();i++) {
				codice=codice+String.valueOf((int)cf.charAt(i));
			}
		}
		return codice;
	}
}
