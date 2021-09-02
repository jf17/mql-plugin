package ru.jf17.mql.psi;

import com.intellij.psi.tree.IElementType;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ru.jf17.mql.MQLLanguage;

public class MQLTokenType extends IElementType {

    public MQLTokenType(@NotNull @NonNls String debugName) {
        super(debugName, MQLLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "MQLTokenType." + super.toString();
    }
}