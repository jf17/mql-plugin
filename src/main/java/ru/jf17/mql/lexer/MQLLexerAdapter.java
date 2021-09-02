package ru.jf17.mql.lexer;

import com.intellij.lexer.FlexAdapter;

public class MQLLexerAdapter extends FlexAdapter  {

    public MQLLexerAdapter() {
        super(new MQLLexer(null));
    }
}
