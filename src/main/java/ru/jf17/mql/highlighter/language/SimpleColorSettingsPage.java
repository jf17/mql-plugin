package ru.jf17.mql.highlighter.language;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.jf17.mql.MQLIcons;
import ru.jf17.mql.highlighter.MQLSyntaxHighlighter;

import javax.swing.*;
import java.util.Map;

public class SimpleColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", MQLSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Direction", MQLSyntaxHighlighter.DIRECTION),
            new AttributesDescriptor("Basic attributes", MQLSyntaxHighlighter.BASIC_ATTRIBUTE),
            new AttributesDescriptor("Selector", MQLSyntaxHighlighter.SELECTOR),
            new AttributesDescriptor("Number", MQLSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Char", MQLSyntaxHighlighter.CHAR),
            new AttributesDescriptor("String", MQLSyntaxHighlighter.STRING),
            new AttributesDescriptor("Type", MQLSyntaxHighlighter.TYPE),
            new AttributesDescriptor("Brackets", MQLSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Operator", MQLSyntaxHighlighter.OPERATOR),
            new AttributesDescriptor("Line comment", MQLSyntaxHighlighter.LINE_COMMENT),
            new AttributesDescriptor("Block comment", MQLSyntaxHighlighter.BLOCK_COMMENT),
            new AttributesDescriptor("Bad value", MQLSyntaxHighlighter.BAD_CHARACTER),
            new AttributesDescriptor("Type name", MQLSyntaxHighlighter.CONID),
            new AttributesDescriptor("Bus id", MQLSyntaxHighlighter.BUS_ID),
            new AttributesDescriptor("Actions", MQLSyntaxHighlighter.ACTION),
            new AttributesDescriptor("System type", MQLSyntaxHighlighter.SYSTEM_TYPE)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return MQLIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new MQLSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "# Examples \n" +
                "print bus 123123.123123.123123.123123 select type name revision dump |; \n" +
                "add connection 'Approval' to 10496.23564.8546.234 fromrel 654.3652.3258.98; \n" +
                "temp query bus 'Products' * *  where id==10496.23564.8546.234 && current=='Active' select name history.promote; \n" +
                "print bus 123123.123123.123123.123123 select from[Development].to[Team].id; \n" +
                "print bus 123123.123123.123123.123123 select from[Development].to[Team].type; \n" +
                "print bus 123123.123123.123123.123123 select from[Development].to[Team].attribute[Value]; \n" +
                "trigger on; \n" +
                "trigger off; \n" +
                "insert program XLSearch_mxJPO.java; \n" +
                "compile program XLSearch force update; \n" +
                "del command APRNewCommand; \n" +
                "   ";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "MQL";
    }
}