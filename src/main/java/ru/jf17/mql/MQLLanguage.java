package ru.jf17.mql;

import com.intellij.lang.Language;

public class MQLLanguage extends Language{
    public static final MQLLanguage INSTANCE = new MQLLanguage();

    private MQLLanguage() {
        super("MQL");
    }
}