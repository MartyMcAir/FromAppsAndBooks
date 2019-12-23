/*
This is a java program to perform arithmetic operations on numbers which are greater than size of the integers.
*/


import java.util.Scanner;

public class BigNumber
{
    static final int MAXDIGITS = 100; /* maximum length bignum */
    static final int PLUS      = 1;  /* positive sign bit */
    static final int MINUS     = -1; /* negative sign bit */
    char             digits[];       /* represent the number */
    int              signbit;        /* 1 if positive, -1 if negative */
    int              lastdigit;      /* index of high-order digit */

    BigNumber()
    {
        digits = new char[MAXDIGITS];
        intToBigNumber(0);
    }

    void printBigNumber()
    {
        int i;
        if (signbit == MINUS)
            System.out.printf("- ");
        for (i = lastdigit; i >= 0; i--)
            System.out.printf("%c", '0' + digits[i]);
        System.out.printf("\n");
    }

    void intToBigNumber(int s)
    {
        if (s >= 0)
            signbit = PLUS;
        else
            signbit = MINUS;
        for (int i = 0; i < MAXDIGITS; i++)
            digits[i] = (char) 0;
        lastdigit = -1;
        int t = Math.abs(s);
        while (t > 0)
            {
                lastdigit++;
                digits[lastdigit] = (char) (t % 10);
                t /= 10;
            }
        if (s == 0)
            lastdigit = 0;
    }

    BigNumber addBigNumber(BigNumber b)
    {
        int carry, i;
        BigNumber c = new BigNumber();
        if (signbit == b.signbit)
            c.signbit = signbit;
        else
            {
                if (signbit == MINUS)
                    {
                        signbit = PLUS;
                        c = b.subtractBigNumber(this);
                        signbit = MINUS;
                    }
                else
                    {
                        b.signbit = PLUS;
                        c = this.subtractBigNumber(b);
                        b.signbit = MINUS;
                    }
                return c;
            }
        c.lastdigit = Math.max(lastdigit, b.lastdigit) + 1;
        carry = 0;
        for (i = 0; i <= c.lastdigit; i++)
            {
                c.digits[i] = (char) ((carry + digits[i] + b.digits[i]) % 10);
                carry = (carry + digits[i] + b.digits[i]) / 10;
            }
        c.zeroJustify();
        return c;
    }

    BigNumber subtractBigNumber(BigNumber b)
    {
        int borrow, v, i;
        BigNumber c = new BigNumber();
        if (signbit == MINUS || b.signbit == MINUS)
            {
                b.signbit = -b.signbit;
                c = addBigNumber(b);
                b.signbit = -b.signbit;
                return c;
            }
        if (compareBigNumber(b) == PLUS)
            {
                c = b.subtractBigNumber(this);
                c.signbit = MINUS;
                return c;
            }
        c.lastdigit = Math.max(lastdigit, b.lastdigit);
        borrow = 0;
        for (i = 0; i <= c.lastdigit; i++)
            {
                v = digits[i] - borrow - b.digits[i];
                if (digits[i] > 0)
                    borrow = 0;
                if (v < 0)
                    {
                        v = v + 10;
                        borrow = 1;
                    }
                c.digits[i] = (char) (v % 10);
            }
        c.zeroJustify();
        return c;
    }

    int compareBigNumber(BigNumber b)
    {
        int i;
        if (signbit == MINUS && b.signbit == PLUS)
            return PLUS;
        if (signbit == PLUS && b.signbit == MINUS)
            return MINUS;
        if (b.lastdigit > lastdigit)
            return PLUS * signbit;
        if (lastdigit > b.lastdigit)
            return MINUS * signbit;
        for (i = lastdigit; i >= 0; i--)
            {
                if (digits[i] > b.digits[i])
                    return MINUS * signbit;
                if (b.digits[i] > digits[i])
                    return PLUS * signbit;
            }
        return 0;
    }

    void zeroJustify()
    {
        while (lastdigit > 0 && digits[lastdigit] == 0)
            lastdigit--;
        if (lastdigit == 0 && digits[0] == 0)
            signbit = PLUS; /* hack to avoid -0 */
    }

    void digitShift(int d)
    {
        int i;
        if (lastdigit == 0 && digits[0] == 0)
            return;
        for (i = lastdigit; i >= 0; i--)
            digits[i + d] = digits[i];
        for (i = 0; i < d; i++)
            digits[i] = 0;
        lastdigit += d;
    }

    BigNumber multiplyBigNumber(BigNumber b)
    {
        BigNumber row = new BigNumber();
        BigNumber tmp = new BigNumber();
        BigNumber c = new BigNumber();
        int i, j;
        row.signbit = this.signbit;
        row.lastdigit = this.lastdigit;
        System.arraycopy(this.digits, 0, row.digits, 0, this.digits.length);
        for (i = 0; i <= b.lastdigit; i++)
            {
                for (j = 1; j <= b.digits[i]; j++)
                    {
                        tmp = c.addBigNumber(row);
                        c = tmp;
                    }
                row.digitShift(1);
            }
        c.signbit = signbit * b.signbit;
        c.zeroJustify();
        return c;
    }

    BigNumber divideBigNumber(BigNumber b)
    {
        BigNumber row = new BigNumber();
        BigNumber tmp = new BigNumber();
        BigNumber c = new BigNumber();
        int asign, bsign, i;
        c.signbit = signbit * b.signbit;
        asign = signbit;
        bsign = b.signbit;
        signbit = PLUS;
        b.signbit = PLUS;
        c.lastdigit = lastdigit;
        for (i = lastdigit; i >= 0; i--)
            {
                row.digitShift(1);
                row.digits[0] = digits[i];
                c.digits[i] = 0;
                while (row.compareBigNumber(b) != PLUS)
                    {
                        c.digits[i]++;
                        tmp = row.subtractBigNumber(b);
                        row = tmp;
                    }
            }
        c.zeroJustify();
        signbit = asign;
        b.signbit = bsign;
        return c;
    }
}

public class ArithmeticOpsBigNumbers
{
    public static void main(String[] args)
    {
        int a, b;
        BigNumber n1 = new BigNumber();
        BigNumber n2 = new BigNumber();
        BigNumber n3 = new BigNumber();
        BigNumber zero = new BigNumber();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt())
            {
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.printf("a = %d    b = %d\n", a, b);
                n1.intToBigNumber(a);
                n2.intToBigNumber(b);
                n3 = n1.addBigNumber(n2);
                System.out.printf("Addition: ");
                n3.printBigNumber();
                System.out.printf("Comparing Numbers a ? b: %d\n",
                                  n1.compareBigNumber(n2));
                n3 = n1.subtractBigNumber(n2);
                System.out.printf("Subtraction: ");
                n3.printBigNumber();
                n3 = n1.multiplyBigNumber(n2);
                System.out.printf("Multiplication: ");
                n3.printBigNumber();
                zero.intToBigNumber(0);
                if (zero.compareBigNumber(n2) == 0)
                    System.out.printf("Division: NaN \n");
                else
                    {
                        n3 = n1.divideBigNumber(n2);
                        System.out.printf("Division: ");
                        n3.printBigNumber();
                    }
            }
        sc.close();
    }
}

/*
12342424
12313423
a = 12342424    b = 12313423
Addition: 24655847
Comparing Numbers a ? b: -1
Subtraction: 29001
Multiplication: 151977487557352
Division: 1
