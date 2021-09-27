package ru.jf17.mql.parser;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;
import ru.jf17.mql.psi.MQLTypes;

public class MQLParserDefinition {
    public static final TokenSet BRACKETS = TokenSet.create(MQLTypes.LEFT_BRACKET, MQLTypes.RIGHT_BRACKET);

    public static final TokenSet OPERATORS = TokenSet.create(MQLTypes.BACK_QUOTE, MQLTypes.DOUBLE_COLON,
            MQLTypes.COLON, MQLTypes.RIGHT_ARROW, MQLTypes.LEFT_ARROW, MQLTypes.DOUBLE_RIGHT_ARROW,
            MQLTypes.VERTICAL_BAR, MQLTypes.EQUAL, MQLTypes.EXLAMATION_MARK,
            MQLTypes.QUESTION_MARK, MQLTypes.COMMA, MQLTypes.SEMICOLON, MQLTypes.DOT,
            MQLTypes.BACK_SLASH, MQLTypes.STAR, MQLTypes.AT, MQLTypes.TILDA,
            MQLTypes.SYMOP_NO_RESERVED, MQLTypes.NOT_EQUAL, MQLTypes.AND, MQLTypes.OR);

    public static final TokenSet NUMBERS = TokenSet.create(MQLTypes.INTEGER, MQLTypes.FLOAT);

    public static final TokenSet KEYWORDS = TokenSet.create(MQLTypes.DELETE, MQLTypes.CONNECT, MQLTypes.ADD, MQLTypes.PRINT,
            MQLTypes.TRIGGER, MQLTypes.TEMP, MQLTypes.DUMP, MQLTypes.QUERY, MQLTypes.ESCAPE,
            MQLTypes.EXPAND, MQLTypes.RECURSE, MQLTypes.COMPILE, MQLTypes.EXEC, MQLTypes.MODIFY, MQLTypes.INSERT);

    public static final TokenSet SELECTORS = TokenSet.create(MQLTypes.SELECT, MQLTypes.WHERE, MQLTypes.LIMIT);

    public static final TokenSet BASIC_ATTRIBUTES = TokenSet.create(MQLTypes.ID, MQLTypes.NAME, MQLTypes.TYPE,
            MQLTypes.ORIGINATED, MQLTypes.DESCRIPTION, MQLTypes.ATTRIBUTE, MQLTypes.REVISION, MQLTypes.FILE, MQLTypes.CURRENT, MQLTypes.POLICY);

    public static final TokenSet TYPES = TokenSet.create(MQLTypes.BUS, MQLTypes.CONNECTION, MQLTypes.RELATIONSHIP,
            MQLTypes.PROGRAM, MQLTypes.COMMAND, MQLTypes.TABLE);

    public static final TokenSet DIRECTIONS = TokenSet.create(MQLTypes.TO, MQLTypes.FROM, MQLTypes.REL,
            MQLTypes.FROMREL, MQLTypes.TOREL, MQLTypes.FROMMID, MQLTypes.TOMID, MQLTypes.FROMTYPE, MQLTypes.TOTYPE);

    public static final TokenSet STRING_KEYS = TokenSet.create(MQLTypes.STRING, MQLTypes.CHAR);

    public static final TokenSet ACTIONS = TokenSet.create(MQLTypes.ON, MQLTypes.OFF, MQLTypes.PROMOTE, MQLTypes.DEMOTE);

    public static final TokenSet SYSTEM_TYPES = TokenSet.create(MQLTypes.HISTORY, MQLTypes.FORMAT,
            MQLTypes.FORCE, MQLTypes.UPDATE, MQLTypes.SYSTEM, MQLTypes.HIDDEN, MQLTypes.NOT_HIDDEN);


}