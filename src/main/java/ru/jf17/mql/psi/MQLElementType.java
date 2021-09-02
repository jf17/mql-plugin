package ru.jf17.mql.psi;

import com.intellij.psi.tree.IElementType;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ru.jf17.mql.MQLLanguage;

public class MQLElementType extends IElementType {

    public MQLElementType(@NotNull @NonNls String debugName) {
        super(debugName, MQLLanguage.INSTANCE);
    }
}