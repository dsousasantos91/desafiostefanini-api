package com.desafiostefanini.utils;

import org.apache.commons.lang3.StringUtils;

import javax.swing.text.MaskFormatter;
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
}
