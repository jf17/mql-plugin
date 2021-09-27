package ru.jf17.mql.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import ru.jf17.mql.psi.MQLTypes;

%%

%class MQLLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

%{
    private int blockCommentDepth;
    private int blockDocDepth;
    private int blockCommentStartPos;
    private int blockDocStartPos;
%}

newline              = \r|\n|\r\n
whitespace           = \s

/* Number Literals */
digit                = \d
digits               = {digit}+
digitNonZero         = [1-9]
signs                = [+-]
decimal              = {signs}?(0 | {digitNonZero}((\d)*)({underscore}{digit}{digit}{digit})*)
hexChar              = [0-9A-Fa-f]
hex                  = 0[xX]{hexChar}({underscore}{hexChar}{hexChar}{hexChar})*
octalChar            = [0-7]
octal                = 0{octalChar}({underscore}{octalChar}{octalChar}{octalChar})*
int                  = {decimal} | {hex} | {octal}
intLong              = {int}[lL]
intBig               = {digit}+({underscore}{digit}{digit}{digit})*[nN]
integer              = {int} | {intLong} | {intBig}
superOrSubscript     = \u00B2 | \u00B3 | \u00B9 | \u2070 | \u2071 | [\u2074-\u209C]


exponentIndicator    = [eE]
exponentPart         = {exponentIndicator}{signs}{digits}
floatSuffix          = [fFdD]
float                = {digits}{dot}{whitespace}
                     | {digits}{dot}{floatSuffix}
                     | {digits}{dot}{exponentPart}{floatSuffix}?
                     | {digits}{dot}{digits}{exponentPart}?{floatSuffix}?
                     | {digits}{exponentPart}{floatSuffix}?
                     | {digits}{exponentPart}?{floatSuffix}

/* Char Literals */
octalEscape          = {backSlash}{octalChar} | {backSlash}{octalChar}{octalChar}
                     | {backSlash}[0-3]{octalChar}{octalChar}
escapeSequence       = {backSlash}\S
char                 = {quote}([^\'\\\n] | {escapeSequence})*{quote}

/* String Literal */
string               = {doubleQuote}([^\"\\] | {escapeSequence})*{doubleQuote}

/* Regex Literal */
regex                = \u00B4([^\u00B4\\] | {escapeSequence})*\u00B4
                     | \u0027([^\u0027\\] | {escapeSequence})*\u0027


/* Documentation */
lineDocStart         = {hash}
lineDoc              = {lineDocStart}[^\n]*
blockDocStart        = {leftBrace}{dash}{dash}
blockDocEnd          = {dash}{rightBrace}

/* Comments */
lineCommentStart     = {dash}{dash}
lineComment          = {lineCommentStart}[^\n]*
blockCommentStart    = {slash}{star}
blockCommentEnd      = {star}{slash}

/* Identifiers */
conid                = \p{Lu}(\d | {underscore} | \p{L})*{quote}*
varid                = \p{Ll}(\d | {underscore} | \p{L})*{quote}*

/* Operators */
aloneOps             = [\P{L}~~[\s\p{N}\"\'\`\u00B4\u0027\.,=|{}\[\]()_]]
notAloneOps          = {equal} | {verticalBar} | {doubleColon}
symop_not_first_dot  = {aloneOps} ({aloneOps} | {notAloneOps} | {dot})* | {notAloneOps} ({aloneOps} | {notAloneOps} | {dot})+

colon                = :
doubleColon          = :: | \u2237
rightArrow           = -> | \u2192
leftArrow            = <- | \u2190
doubleRightArrow     = => | \u21D2
ampersand            = \&
and                  = {ampersand}{ampersand}
verticalBar          = \|
or                   = {verticalBar}{verticalBar}
equal                = =
doubleEqual          = {equal}{equal}
notEqual             = {exlamationMark}{equal}
dash                 = -
hash                 = #
exlamationMark       = \!
questionMark         = \?
comma                = \,
semicolon            = ;
dot                  = \.
doubleDot            = \.\.
slash            = \/
backSlash            = \\
underscore           = _
star                 = \* | \u2605
at                   = @
tilda                = \~
forall               = \u2200
leq                  = \u2264
geq                  = \u2265

/* parentheses  */
leftParen            = \(
rightParen           = \)
leftBracket          = \[
rightBracket         = \]
leftBrace            = \{
rightBrace           = \}

/* quotes */
quote                = \'
doubleQuote          = \"
backQuote            = \`

busId                = {digits}{dot}{digits}{dot}{digits}{dot}{digits}

%state FIRST_DOT_OPERATOR, MAYBE_FIRST_DOT_OPERATOR, BLOCK_COMMENT, BLOCK_DOC

%%
    <YYINITIAL> {
    /* keywords */
        "delete"                     { return MQLTypes.DELETE; }
        "connect"                    { return MQLTypes.CONNECT; }
        "add"                        { return MQLTypes.ADD; }
        "print"                      { return MQLTypes.PRINT; }
        "trigger"                    { return MQLTypes.TRIGGER; }
        "temp"                       { return MQLTypes.TEMP; }
        "query"                      { return MQLTypes.QUERY; }
        "dump"                       { return MQLTypes.DUMP; }
        "escape"                     { return MQLTypes.ESCAPE; }
        "expand"                     { return MQLTypes.EXPAND; }
        "recurse"                    { return MQLTypes.RECURSE; }
        "compile"                    { return MQLTypes.COMPILE; }
        "exec"                       { return MQLTypes.EXEC; }
        "modify"                     { return MQLTypes.MODIFY; }
        "mod"                        { return MQLTypes.MODIFY; }
        "del"                        { return MQLTypes.DELETE; }

    /* selectors */
        "select"                     { return MQLTypes.SELECT; }
        "where"                      { return MQLTypes.WHERE; }
        "limit"                      { return MQLTypes.LIMIT; }

    /* basic attributes */
        "id"                          { return MQLTypes.ID; }
        "name"                        { return MQLTypes.NAME; }
        "type"                        { return MQLTypes.TYPE; }
        "revision"                    { return MQLTypes.REVISION; }
        "originated"                  { return MQLTypes.ORIGINATED; }
        "description"                 { return MQLTypes.DESCRIPTION; }
        "attribute"                   { return MQLTypes.ATTRIBUTE; }
        "file"                        { return MQLTypes.FILE; }
        "current"                     { return MQLTypes.CURRENT; }

    /* type */
        "bus"                            { return MQLTypes.BUS; }
        "connection"                     { return MQLTypes.CONNECTION; }
        "relationship"                   { return MQLTypes.RELATIONSHIP; }
        "program"                        { return MQLTypes.PROGRAM; }
        "prog"                           { return MQLTypes.PROGRAM; }
        "command"                        { return MQLTypes.COMMAND; }
        "table"                          { return MQLTypes.TABLE; }
        "insert"                         { return MQLTypes.INSERT; }
        "policy"                         { return MQLTypes.POLICY; }

    /* direction  */
        "to"                             { return MQLTypes.TO; }
        "from"                           { return MQLTypes.FROM; }
        "rel"                            { return MQLTypes.REL; }
        "fromrel"                        { return MQLTypes.FROMREL; }
        "torel"                          { return MQLTypes.TOREL; }
        "frommid"                        { return MQLTypes.FROMMID; }
        "tomid"                          { return MQLTypes.TOMID; }
        "fromtype"                       { return MQLTypes.FROMTYPE; }
        "totype"                         { return MQLTypes.TOTYPE; }

    /* actions  */
        "on"                            { return MQLTypes.ON; }
        "off"                           { return MQLTypes.OFF; }
        "promote"                       { return MQLTypes.PROMOTE; }
        "demote"                        { return MQLTypes.DEMOTE; }

    /* system types  */
        "history"                     { return MQLTypes.HISTORY; }
        "format"                      { return MQLTypes.FORMAT; }
        "force"                       { return MQLTypes.FORCE; }
        "update"                      { return MQLTypes.UPDATE; }
        "system"                      { return MQLTypes.SYSTEM; }
        "hidden"                      { return MQLTypes.HIDDEN; }
        "!hidden"                     { return MQLTypes.NOT_HIDDEN; }

        {lineDoc}                    { return MQLTypes.LINE_DOC; }
        {lineComment}                { return MQLTypes.LINE_COMMENT; }
        {blockDocStart}              { blockDocDepth = 0; blockDocStartPos = getTokenStart(); yybegin(BLOCK_DOC); }
        {blockCommentStart}          { blockCommentDepth = 0; blockCommentStartPos = getTokenStart(); yybegin(BLOCK_COMMENT); }
        {newline}                    { return MQLTypes.NEW_LINE; }
        {newline} / {dot}            { yybegin(MAYBE_FIRST_DOT_OPERATOR); return MQLTypes.NEW_LINE; }
        {whitespace}                 { return TokenType.WHITE_SPACE; }
        {whitespace} / {dot}         { yybegin(MAYBE_FIRST_DOT_OPERATOR); return TokenType.WHITE_SPACE; }

    /* literals */
        {integer}                    { return MQLTypes.INTEGER; }
        {char}                       { return MQLTypes.CHAR; }
        {string}                     { return MQLTypes.STRING; }


    /* parentheses */
        {leftParen}                  { return MQLTypes.LEFT_PAREN; }
        {leftParen} / {dot}          { yybegin(FIRST_DOT_OPERATOR); return MQLTypes.LEFT_PAREN; }
        {rightParen}                 { return MQLTypes.RIGHT_PAREN; }
        {leftBracket}                { return MQLTypes.LEFT_BRACKET; }
        {rightBracket}               { return MQLTypes.RIGHT_BRACKET; }
        {leftBrace}                  { return MQLTypes.LEFT_BRACE; }
        {rightBrace}                 { return MQLTypes.RIGHT_BRACE; }

    /* special symbols */
        {doubleColon}                { return MQLTypes.DOUBLE_COLON; }
        {colon}                      { return MQLTypes.COLON; }
        {rightArrow}                 { return MQLTypes.RIGHT_ARROW; }
        {leftArrow}                  { return MQLTypes.LEFT_ARROW; }
        {doubleRightArrow}           { return MQLTypes.DOUBLE_RIGHT_ARROW; }
        {verticalBar}                { return MQLTypes.VERTICAL_BAR; }
        {doubleEqual}                { return MQLTypes.EQUAL; }
        {notEqual}                   { return MQLTypes.NOT_EQUAL; }
        {exlamationMark}             { return MQLTypes.EXLAMATION_MARK; }
        {questionMark}               { return MQLTypes.QUESTION_MARK; }
        {comma}                      { return MQLTypes.COMMA; }
        {semicolon}                  { return MQLTypes.SEMICOLON; }
        {backSlash}                  { return MQLTypes.BACK_SLASH; }
        {underscore}                 { return MQLTypes.UNDERSCORE; }
        {star}                       { return MQLTypes.STAR; }
        {dash}                       { return MQLTypes.DASH; }
        {at}                         { return MQLTypes.AT; }
        {tilda}                      { return MQLTypes.TILDA; }
        {backQuote}                  { return MQLTypes.BACK_QUOTE; }
        {backQuote} / {dot}          { yybegin(FIRST_DOT_OPERATOR); return MQLTypes.BACK_QUOTE; }
        {dot}                        { return MQLTypes.DOT; }
        {forall}                     { return MQLTypes.FORALL; }
        {superOrSubscript}           { return MQLTypes.SUPER_OR_SUBSCRIPT; }
        {leq}                        { return MQLTypes.LEQ; }
        {geq}                        { return MQLTypes.GEQ; }
        {and}                        { return MQLTypes.AND; }
        {or}                         { return MQLTypes.OR; }

    /* operators */
        {dot} / {rightParen}         { return MQLTypes.SYMOP_NO_RESERVED; }
        {doubleDot}                  { return MQLTypes.DOUBLE_DOT; }
        {dot} /
          {dot}{symop_not_first_dot} { yybegin(FIRST_DOT_OPERATOR); return MQLTypes.DOT; }
        {symop_not_first_dot}        { return MQLTypes.SYMOP_NO_RESERVED; }
    /* identifiers */
        {conid}                      { return MQLTypes.CONID; }
        {varid}                      { return MQLTypes.VARID; }

         {busId}                      { return MQLTypes.BUSID; }
    }

    <FIRST_DOT_OPERATOR> {
        {dot}{dot}                   { yybegin(YYINITIAL); return MQLTypes.DOUBLE_DOT; }
        {dot}{symop_not_first_dot}?  { yybegin(YYINITIAL); return MQLTypes.SYMOP_NO_RESERVED; }
    }

    <MAYBE_FIRST_DOT_OPERATOR> {
        {dot} / {whitespace}         { yybegin(YYINITIAL); return MQLTypes.SYMOP_NO_RESERVED; }
        {dot} / {rightParen}         { yybegin(YYINITIAL); return MQLTypes.SYMOP_NO_RESERVED; }
        {dot}{dot}                   { yybegin(YYINITIAL); return MQLTypes.DOUBLE_DOT; }
        {dot}{symop_not_first_dot}   { yybegin(YYINITIAL); return MQLTypes.SYMOP_NO_RESERVED; }
        {dot}                        { yybegin(YYINITIAL); return MQLTypes.DOT; }
    }

    <BLOCK_DOC> {
        {blockDocStart} {
            blockDocDepth++;
        }
        <<EOF>> {
            yybegin(YYINITIAL);
            zzStartRead = blockDocStartPos;
            return TokenType.BAD_CHARACTER;
        }
        {blockDocEnd} {
            blockDocDepth--;
            if (blockDocDepth == -1) {
                yybegin(YYINITIAL);
                zzStartRead = blockDocStartPos;
                return MQLTypes.BLOCK_DOC;
            }
        }
        [^] {}
    }

    <BLOCK_COMMENT> {
        {blockCommentStart} {
            blockCommentDepth++;
        }
        <<EOF>> {
            yybegin(YYINITIAL);
            zzStartRead = blockCommentStartPos;
            return TokenType.BAD_CHARACTER;
        }
        {blockCommentEnd} {
            blockCommentDepth--;
            if (blockCommentDepth == -1) {
                yybegin(YYINITIAL);
                zzStartRead = blockCommentStartPos;
                return MQLTypes.BLOCK_COMMENT;
            }
        }
        [^] {}
    }

    [^]                              { return TokenType.BAD_CHARACTER; }