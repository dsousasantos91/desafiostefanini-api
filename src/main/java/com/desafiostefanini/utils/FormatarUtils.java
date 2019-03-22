package com.desafiostefanini.utils;

import org.apache.commons.lang3.StringUtils;

import javax.swing.text.MaskFormatter;
import java.text.Normalizer;
import java.text.ParseException;

public class FormatarUtils {

    public static String formatarCPF(String cpf) {
        if (StringUtils.isNotBlank(cpf)) {
            try {
                MaskFormatter mf = new MaskFormatter("###.###.###-##");
                mf.setValueContainsLiteralCharacters(false);
                return mf.valueToString(cpf);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String formatarCEP(String cep) {
        if (StringUtils.isNotBlank(cep)) {
            try {
                MaskFormatter mf = new MaskFormatter("##.###-###");
                mf.setValueContainsLiteralCharacters(false);
                return mf.valueToString(cep);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String formatarDDD(String ddd) {
        if (StringUtils.isNotBlank(ddd)) {
            try {
                MaskFormatter mf = new MaskFormatter("(##) ");
                mf.setValueContainsLiteralCharacters(false);
                return mf.valueToString(ddd);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String formatarTelefoneFixo(String telefoneFixo) {
        if (StringUtils.isNotBlank(telefoneFixo)) {
            try {
                MaskFormatter mf = new MaskFormatter("####-####");
                mf.setValueContainsLiteralCharacters(false);
                return mf.valueToString(telefoneFixo);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String formatarCelular(String celular) {
        if (StringUtils.isNotBlank(celular)) {
            try {
                MaskFormatter mf = new MaskFormatter("#-####-####");
                mf.setValueContainsLiteralCharacters(false);
                return mf.valueToString(celular);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String removerAcentos(String str) {
	    str = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	    return str;
	}
}
