package ru.jf17.mql;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MQLFileType extends LanguageFileType {

    public static final MQLFileType INSTANCE = new MQLFileType();

    private MQLFileType() {
        super(MQLLanguage.INSTANCE);
    }

    @Override
    public @NonNls
    @NotNull String getName() {
        return "MQL File";
    }

    @Override
    public @NotNull String getDescription() {
        return "MQL language file";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "mql";
    }

    @Override
    public @Nullable Icon getIcon() {
        return MQLIcons.FILE;
    }
}