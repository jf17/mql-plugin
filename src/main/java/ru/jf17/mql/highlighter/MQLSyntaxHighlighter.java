package ru.jf17.mql.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import ru.jf17.mql.lexer.MQLLexerAdapter;
import ru.jf17.mql.parser.MQLParserDefinition;
import ru.jf17.mql.psi.MQLTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class MQLSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey BUS_ID =
            createTextAttributesKey("MQL_BUSID", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey SYSTEM_TYPE =
            createTextAttributesKey("MQL_SYSTEM_TYPE", DefaultLanguageHighlighterColors.HIGHLIGHTED_REFERENCE);
    public static final TextAttributesKey BASIC_ATTRIBUTE =
            createTextAttributesKey("MQL_BASIC_ATTRIBUTE", DefaultLanguageHighlighterColors.INSTANCE_METHOD);
    public static final TextAttributesKey SELECTOR =
            createTextAttributesKey("MQL_SELECTOR", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey DIRECTION =
            createTextAttributesKey("MQL_DIRECTION", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("MQL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("MQL_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey CHAR =
            createTextAttributesKey("MQL_CHAR", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("MQL_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey TYPE =
            createTextAttributesKey("MQL_TYPE", DefaultLanguageHighlighterColors.INSTANCE_METHOD);
    public static final TextAttributesKey BRACKETS =
            createTextAttributesKey("MQL_BRACKETS", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey OPERATOR =
            createTextAttributesKey("MQL_OPERATOR", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("MQL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT =
            createTextAttributesKey("MQL_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey LINE_DOC =
            createTextAttributesKey("MQL_LINE_DOC", DefaultLanguageHighlighterColors.DOC_COMMENT);
    public static final TextAttributesKey BLOCK_DOC =
            createTextAttributesKey("MQL_BLOCK_DOC", DefaultLanguageHighlighterColors.DOC_COMMENT);
    public static final TextAttributesKey CONID =
            createTextAttributesKey("MQL_CONID", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey ACTION =
            createTextAttributesKey("MQL_ACTION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("MQL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BUS_IDS = new TextAttributesKey[]{BUS_ID};
    private static final TextAttributesKey[] SYSTEM_TYPES = new TextAttributesKey[]{SYSTEM_TYPE};
    private static final TextAttributesKey[] ACTIONS = new TextAttributesKey[]{ACTION};
    private static final TextAttributesKey[] SELECTORS = new TextAttributesKey[]{SELECTOR};
    private static final TextAttributesKey[] DIRECTIONS = new TextAttributesKey[]{DIRECTION};
    private static final TextAttributesKey[] BASIC_ATTRIBUTES = new TextAttributesKey[]{BASIC_ATTRIBUTE};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] CHAR_KEYS = new TextAttributesKey[]{CHAR};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] TYPE_KEYS = new TextAttributesKey[]{TYPE};
    private static final TextAttributesKey[] CONIDS = new TextAttributesKey[]{CONID};
    private static final TextAttributesKey[] BRACKETS_KEYS = new TextAttributesKey[]{BRACKETS};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[]{LINE_COMMENT};
    private static final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[]{BLOCK_COMMENT};
    private static final TextAttributesKey[] LINE_DOC_KEYS = new TextAttributesKey[]{LINE_DOC};
    private static final TextAttributesKey[] BLOCK_DOC_KEYS = new TextAttributesKey[]{BLOCK_DOC};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new MQLLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {

        if (MQLParserDefinition.KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (MQLParserDefinition.BRACKETS.contains(tokenType)) {
            return BRACKETS_KEYS;
        } else if (MQLParserDefinition.ACTIONS.contains(tokenType)) {
            return ACTIONS;
        } else if (MQLParserDefinition.OPERATORS.contains(tokenType)) {
            return OPERATOR_KEYS;
        } else if (MQLParserDefinition.NUMBERS.contains(tokenType)) {
            return NUMBER_KEYS;
        } else if (MQLParserDefinition.SELECTORS.contains(tokenType)) {
            return SELECTORS;
        } else if (MQLParserDefinition.DIRECTIONS.contains(tokenType)) {
            return DIRECTIONS;
        } else if (MQLParserDefinition.BASIC_ATTRIBUTES.contains(tokenType)) {
            return BASIC_ATTRIBUTES;
        } else if (MQLParserDefinition.SYSTEM_TYPES.contains(tokenType)) {
            return SYSTEM_TYPES;
        } else if (tokenType.equals(MQLTypes.CHAR)) {
            return CHAR_KEYS;
        } else if (MQLParserDefinition.STRING_KEYS.contains(tokenType)) {
            return STRING_KEYS;
        } else if (tokenType.equals(MQLTypes.BUSID)) {
            return BUS_IDS;
        } else if (MQLParserDefinition.TYPES.contains(tokenType)) {
            return TYPE_KEYS;
        } else if (tokenType.equals(MQLTypes.LINE_COMMENT)) {
            return LINE_COMMENT_KEYS;
        } else if (tokenType.equals(MQLTypes.BLOCK_COMMENT)) {
            return BLOCK_COMMENT_KEYS;
        } else if (tokenType.equals(MQLTypes.LINE_DOC)) {
            return LINE_DOC_KEYS;
        } else if (tokenType.equals(MQLTypes.BLOCK_DOC)) {
            return BLOCK_DOC_KEYS;
        } else if (tokenType.equals(MQLTypes.CONID)) {
            return CONIDS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
