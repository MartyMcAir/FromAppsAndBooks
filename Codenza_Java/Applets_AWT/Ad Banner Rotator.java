Ad Banner Rotator

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.Vector;

public class BhuBanner extends Applet
    implements Runnable {

    Thread A;
    int B;
    int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    int I;
    int J;
    int K;
    int L;
    int M;
    int N;
    int O;
    int P;
    int Q;
    int R;
    int S;
    int T;
    int U;
    Font V;
    String W;
    String X;
    String Y;
    String Z;
    FontMetrics a;
    Color b;
    Color c;
    Color d;
    Image e;
    Graphics f;
    char g[];
    Vector h;
    Vector i;
    Vector j;
    int k;
    int l;
    int m;
    int n;
    int o;
    int p;
    int q;
    boolean r;
    final int s = 0;
    final int t = 1;
    int u;
    int v[];

    public void init() {
        B = 0;
        h = new Vector(10, 10);
        i = new Vector(10, 10);
        j = new Vector(10, 10);
        B();
        W = (String)h.elementAt(0);
        setBackground(b);
        E = size().width;
        F = size().height;
        v = new int[Q];
        V = new Font(Y, S, I);
        a = getFontMetrics(V);
        J = a.getHeight();
        H = a.stringWidth(W);
        G = (F - a.getHeight()) / 2 + a.getAscent();
        e = createImage(E, F);
        f = e.getGraphics();
        f.setFont(V);
        g = W.toCharArray();
        L = g.length;
        K = (E - H) / 2;
        P = K;
        k = b.getRed();
        l = b.getGreen();
        m = b.getBlue();
        d = c;
        n = c.getRed();
        p = c.getGreen();
        o = c.getBlue();
        for(int i1 = 0; i1 < Q; i1++) {
            String s1 = (String)j.elementAt(i1);
            if(s1.equalsIgnoreCase("DROP"))
                v[i1] = 1;
            else
            if(s1.equalsIgnoreCase("SCROLL"))
                v[i1] = 0;
            else
                v[i1] = 0;
        }

        u = v[0];
    }

    public void B() {
        W = getParameter("TextToDisplay");
        if(W == null)
            W = "String not defined;";
        Q = D(W, h);
        W = getParameter("URLtoDisplay");
        if(W == null)
            W = "";
        D(W, i);
        W = getParameter("Effect");
        if(W == null)
            W = "DROP;SCROLL;DROP";
        D(W, j);
        X = getParameter("FontSize");
        if(X == null)
            I = 24;
        else
            I = Integer.parseInt(X);
        Y = getParameter("FontName");
        if(Y == null)
            Y = "TimesRoman";
        String s1 = getParameter("FontStyle");
        if(s1 == null)
            S = 1;
        else
        if(s1.equalsIgnoreCase("PLAIN"))
            S = 0;
        else
        if(s1.equalsIgnoreCase("BOLD"))
            S = 1;
        else
        if(s1.equalsIgnoreCase("ITALIC"))
            S = 2;
        else
        if(s1.equalsIgnoreCase("BOLDandITALIC"))
            S = 3;
        else
            S = 1;
        Z = getParameter("target");
        if(Z == null)
            Z = "_blank";
        String s2 = getParameter("speed");
        if(s2 == null)
            O = 5;
        else
            O = Integer.parseInt(s2);
        String s3 = getParameter("xStep");
        if(s3 == null)
            T = 20;
        else
            T = Integer.parseInt(s3);
        String s4 = getParameter("yStep");
        if(s4 == null)
            U = 10;
        else
            U = Integer.parseInt(s4);
        String s5 = getParameter("Delay");
        if(s5 == null)
            R = 3000;
        else
            R = Integer.parseInt(s5);
        String s6 = getParameter("bgCOLOR");
        if(s6 == null)
            b = Color.white;
        else
        if((b = C(s6)) == null)
            b = Color.white;
        String s7 = getParameter("textCOLOR");
        if(s7 == null)
            c = Color.black;
        else
        if((c = C(s7)) == null)
            c = Color.black;
        String s8 = getParameter("Author");
        if(s8 == null || !s8.equals("www")) {
            c = Color.black;
            b = Color.black;
        }
        String s9 = getParameter("Email");
        if(s9 == null || !s9.equals("x@xxx")) {
            c = Color.black;
            b = Color.black;
        }
    }

    public int D(String s1, Vector vector) {
        StringTokenizer stringtokenizer = new StringTokenizer(s1, ";", false);
        int i1;
        for(i1 = 0; stringtokenizer.hasMoreTokens(); i1++) {
            String s2 = stringtokenizer.nextToken().trim();
            vector.addElement(s2);
        }

        return i1;
    }

    public Color C(String s1) {
        int i1;
        int j1;
        int k1;
        try {
            i1 = Integer.parseInt(s1.substring(0, s1.indexOf(",")).trim());
            j1 = Integer.parseInt(s1.substring(s1.indexOf(",") + 1, s1.lastIndexOf(",")).trim());
            k1 = Integer.parseInt(s1.substring(s1.lastIndexOf(",") + 1).trim());
        }
        catch(NumberFormatException numberformatexception) {
            System.out.println("can't convert to integer, Switching to default colors" + numberformatexception);
            return null;
        }
        try {
            return new Color(i1, j1, k1);
        }
        catch(IllegalArgumentException illegalargumentexception) {
            System.out.println("can't create new color, Switching to default colors" + illegalargumentexception);
        }
        return null;
    }

    public void start() {
        if(A == null) {
            A = new Thread(this);
            A.start();
        }
    }

    public void stop() {
        if(A != null) {
            A.stop();
            A = null;
        }
    }

    public void destroy() {
        f.dispose();
    }

    public void run() {
        do {
            d = c;
            r = true;
            switch(u) {
            default:
                break;

            case 1: // '\001'
                M = 0;
                for(N = 0; M < L; N++) {
                    if(g[N] == ' ') {
                        M++;
                        N++;
                    }
                    P = K + a.charsWidth(g, 0, M);
                    D = -J;
                    C = P;
                    for(; G - D > U; D += U) {
                        repaint();
                        try {
                            Thread.sleep(O);
                        }
                        catch(InterruptedException interruptedexception) { }
                    }

                    D = G;
                    repaint();
                    try {
                        Thread.sleep(O);
                    }
                    catch(InterruptedException interruptedexception1) { }
                    M++;
                }

                for(int i1 = 0; i1 <= 100; i1 += q) {
                    r = false;
                    A(i1);
                    repaint();
                    try {
                        Thread.sleep(200L);
                    }
                    catch(InterruptedException interruptedexception2) { }
                }

                break;

            case 0: // '\0'
                M = 0;
                for(N = 0; M < L; N++) {
                    if(g[N] == ' ') {
                        M++;
                        N++;
                    }
                    P = K + a.charsWidth(g, 0, M);
                    C = E;
                    D = G;
                    for(; C - P > T; C -= T) {
                        repaint();
                        try {
                            Thread.sleep(O);
                        }
                        catch(InterruptedException interruptedexception3) { }
                    }

                    C = P;
                    repaint();
                    try {
                        Thread.sleep(O);
                    }
                    catch(InterruptedException interruptedexception4) { }
                    M++;
                }

                for(int j1 = 0; j1 <= 100; j1 += q) {
                    r = false;
                    A(j1);
                    repaint();
                    try {
                        Thread.sleep(200L);
                    }
                    catch(InterruptedException interruptedexception5) { }
                }

                break;
            }
            B++;
            if(B > Q - 1)
                B = 0;
            W = (String)h.elementAt(B);
            H = a.stringWidth(W);
            g = W.toCharArray();
            L = g.length;
            K = (E - H) / 2;
            u = v[B];
        } while(true);
    }

    public void A(int i1) {
        int j1 = ((k - n) * i1) / 100 + n;
        int k1 = ((l - p) * i1) / 100 + p;
        int l1 = ((m - o) * i1) / 100 + o;
        d = new Color(j1, k1, l1);
    }

    public void paint(Graphics g1) {
        f.setColor(b);
        f.fillRect(0, 0, E, F);
        f.setColor(d);
        if(r) {
            f.drawChars(g, 0, M, K, G);
            f.drawChars(g, N, 1, C, D);
        } else {
            f.drawString(W, K, G);
        }
        g1.drawImage(e, 0, 0, this);
    }

    public void update(Graphics g1) {
        paint(g1);
    }

    public boolean mouseDown(Event event, int i1, int j1) {
        try {
            getAppletContext().showDocument(new URL((String)i.elementAt(B)), Z);
        }
        catch(MalformedURLException malformedurlexception) {
            System.out.println("Wrong URL");
        }
        return true;
    }

    public BhuBanner() {
        q = 5;
        r = true;
    }
}
