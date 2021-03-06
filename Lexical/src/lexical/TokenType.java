/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical;

/**
 *
 * @author Gustavo
 */
public enum TokenType {
    BlockComment,
    LineComment,
    WhiteSpace,
    String,
    Tab,
    NewLine,
    Carriage,
    CloseBrace,
    OpenBrace,
    OpeningCurlyBrace,
    ClosingCurlyBrace,
    DoubleConstant,
    IntConstant,
    Plus,
    Minus,
    Multiply,
    Divide,
    Point,
    EqualEqual,
    EqualEqualEqual,
    Equal,
    ExclameEqual,
    Greater,
    Less,
    Static,
    Function,
    Var,
    Break,
    Public,
    Private,
    Int,
    Double,
    Void,
    False,
    True,
    Null,
    Return,
    New,
    Class,
    If,
    While,
    Else,
    Semicolon,
    Comma,
    And,
    SingleAnd,
    Or,
    SingleOr,
    IfTernary,
    ElseTernary,
    FalseAbrev,
    InitArray,
    FinalArray,
    Property,
    Module,
    Undefined,
    RegExp,
    Identifier;

    /**
     * Determines if this token is auxiliary
     *
     * @return {@code true} if token is auxiliary, {@code false} otherwise
     */
    public boolean isAuxiliary() {
        return this == BlockComment || this == LineComment || this == NewLine || this == Tab
                || this == WhiteSpace;
    }
}
