package com.buseduc.javacourse.tictactoe.enums;

public enum LowerCaseLetters {
    a(1),
    b(2),
    c(2),
    d(3),
    e(4),
    f(5) ,
    g(6) ,
    h(7),
    i(8),
    j(9),
    k(10),
    l(11),
    m(12),
    n(13),
    o(14),
    p(15),
    q(16),
    r(17),
    s(18),
    t(19),
    u(20),
    w(21),
    x(22),
    y(23),
    z(24);

    int num;

    LowerCaseLetters(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
