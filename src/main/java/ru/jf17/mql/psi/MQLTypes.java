package ru.jf17.mql.psi;

import com.intellij.psi.tree.IElementType;

public interface MQLTypes {
    IElementType STRING = new MQLElementType("STRING");
    IElementType SYMOP_NO_RESERVED = new MQLElementType("SYMOP_NO_RESERVED");
    IElementType NEW_LINE = new MQLElementType("NEW_LINE");
    IElementType CONID = new MQLElementType("CONID");
    IElementType LINE_COMMENT = new MQLElementType("LINE_COMMENT");
    IElementType BLOCK_COMMENT = new MQLElementType("BLOCK_COMMENT");
    IElementType LINE_DOC = new MQLElementType("LINE_DOC");
    IElementType BLOCK_DOC = new MQLElementType("LINE_DOC");
    IElementType WHERE = new MQLElementType("WHERE");
    IElementType INTEGER = new MQLElementType("INTEGER");
    IElementType FLOAT = new MQLElementType("FLOAT");
    IElementType STAR = new MQLElementType("STAR");
    IElementType CHAR = new MQLElementType("CHAR");
    IElementType LEFT_BRACKET = new MQLElementType("LEFT_BRACKET");
    IElementType RIGHT_BRACKET = new MQLElementType("LEFT_BRACKET");
    IElementType VARID = new MQLElementType("VARID");
    IElementType SUPER_OR_SUBSCRIPT = new MQLElementType("SUPER_OR_SUBSCRIPT");
    IElementType BACK_SLASH = new MQLElementType("BACK_SLASH");
    IElementType COLON = new MQLElementType("COLON");
    IElementType DOUBLE_COLON = new MQLElementType("DOUBLE_COLON");
    IElementType DASH = new MQLElementType("DASH");
    IElementType RIGHT_ARROW = new MQLElementType("RIGHT_ARROW");
    IElementType LEFT_ARROW = new MQLElementType("LEFT_ARROW");
    IElementType EQUAL = new MQLElementType("EQUAL");
    IElementType DOUBLE_RIGHT_ARROW = new MQLElementType("DOUBLE_RIGHT_ARROW");
    IElementType VERTICAL_BAR = new MQLElementType("VERTICAL_BAR");
    IElementType EXLAMATION_MARK = new MQLElementType("EXLAMATION_MARK");
    IElementType QUESTION_MARK = new MQLElementType("QUESTION_MARK");
    IElementType COMMA = new MQLElementType("COMMA");
    IElementType SEMICOLON = new MQLElementType("SEMICOLON");
    IElementType DOT = new MQLElementType("DOT");
    IElementType UNDERSCORE = new MQLElementType("UNDERSCORE");
    IElementType AT = new MQLElementType("AT");
    IElementType TILDA = new MQLElementType("TILDA");
    IElementType FORALL = new MQLElementType("FORALL");
    IElementType LEQ = new MQLElementType("LEQ");
    IElementType GEQ = new MQLElementType("GEQ");
    IElementType LEFT_PAREN = new MQLElementType("LEFT_PAREN");
    IElementType RIGHT_PAREN = new MQLElementType("RIGHT_PAREN");
    IElementType LEFT_BRACE = new MQLElementType("LEFT_BRACE");
    IElementType RIGHT_BRACE = new MQLElementType("RIGHT_BRACE");
    IElementType BACK_QUOTE = new MQLElementType("BACK_QUOTE");
    IElementType DOUBLE_DOT = new MQLElementType("DOUBLE_DOT");
    IElementType TYPE = new MQLElementType("TYPE");
    IElementType ATTRIBUTE = new MQLElementType("ATTRIBUTE");
    IElementType BUSID = new MQLElementType("BUSID");

    IElementType ID = new MQLElementType("ID");
    IElementType ADD = new MQLElementType("ADD");
    IElementType NAME = new MQLElementType("NAME");
    IElementType DUMP = new MQLElementType("DUMP");
    IElementType TEMP = new MQLElementType("TEMP");
    IElementType LIMIT = new MQLElementType("LIMIT");
    IElementType PRINT = new MQLElementType("PRINT");
    IElementType DELETE = new MQLElementType("DELETE");
    IElementType SELECT = new MQLElementType("SELECT");
    IElementType TRIGGER = new MQLElementType("TRIGGER");
    IElementType CONNECT = new MQLElementType("CONNECT");
    IElementType ORIGINATED = new MQLElementType("ORIGINATED");
    IElementType DESCRIPTION = new MQLElementType("DESCRIPTION");
    IElementType TO = new MQLElementType("TO");
    IElementType BUS = new MQLElementType("BUS");
    IElementType REL = new MQLElementType("REL");
    IElementType FROM = new MQLElementType("FROM");
    IElementType TOREL = new MQLElementType("TOREL");
    IElementType TOMID = new MQLElementType("TOMID");
    IElementType FROMREL = new MQLElementType("FROMREL");
    IElementType FROMMID = new MQLElementType("FROMMID");
    IElementType CONNECTION = new MQLElementType("CONNECTION");
    IElementType RELATIONSHIP = new MQLElementType("RELATIONSHIP");
    IElementType REVISION = new MQLElementType("REVISION");
    IElementType ON = new MQLElementType("ON");
    IElementType OFF = new MQLElementType("OFF");
    IElementType FILE = new MQLElementType("FILE");
    IElementType DEMOTE = new MQLElementType("DEMOTE");
    IElementType PROMOTE = new MQLElementType("PROMOTE");
    IElementType HISTORY = new MQLElementType("HISTORY");
    IElementType QUERY = new MQLElementType("QUERY");
    IElementType NOT_EQUAL = new MQLElementType("NOT_EQUAL");
    IElementType MODIFY = new MQLElementType("MODIFY");
    IElementType EXEC = new MQLElementType("EXEC");
    IElementType PROGRAM = new MQLElementType("PROGRAM");
    IElementType FORCE = new MQLElementType("FORCE");
    IElementType TABLE = new MQLElementType("TABLE");
    IElementType EXPAND = new MQLElementType("EXPAND");
    IElementType ESCAPE = new MQLElementType("ESCAPE");
    IElementType FORMAT = new MQLElementType("FORMAT");
    IElementType TOTYPE = new MQLElementType("TOTYPE");
    IElementType UPDATE = new MQLElementType("UPDATE");
    IElementType SYSTEM = new MQLElementType("SYSTEM");
    IElementType HIDDEN = new MQLElementType("HIDDEN");
    IElementType NOT_HIDDEN = new MQLElementType("NOT_HIDDEN");
    IElementType COMPILE = new MQLElementType("COMPILE");
    IElementType COMMAND = new MQLElementType("COMMAND");
    IElementType CURRENT = new MQLElementType("CURRENT");
    IElementType RECURSE = new MQLElementType("RECURSE");
    IElementType FROMTYPE = new MQLElementType("FROMTYPE");
    IElementType AND = new MQLElementType("AND");
    IElementType OR = new MQLElementType("OR");
    IElementType INSERT = new MQLElementType("INSERT");
    IElementType POLICY = new MQLElementType("POLICY");
}
