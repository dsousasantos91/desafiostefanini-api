package com.desafiostefanini.utils;

import java.text.Normalizer;

public class RemoverAcentos {

	public static String remover(String str) {
	    str = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	    return str;
	}
}
