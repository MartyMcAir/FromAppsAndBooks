/*This is a Java Program to Implement Gale Shapley Algorithm. Gale Shapley Algorithm is used to solve the stable marriage problem (SMP). SMP is the problem of finding a stable matching between two sets of elements given a set of preferences for each element.
Algorithm is as follows :

function stableMatching {
    Initialize all m ∈ M and w ∈ W to free
    while ∃ free man m who still has a woman w to propose to {
       w = m's highest ranked such woman to whom he has not yet proposed
       if w is free
         (m, w) become engaged
       else some pair (m', w) already exists
         if w prefers m to m'
           (m, w) become engaged
           m' becomes free
         else
           (m', w) remain engaged
    }
}*/

/**
 *    Java Program to Implement Gale Shapley Algorithm
 **/

/** Class GaleShapley **/
public class GaleShapley
{
    private int N, engagedCount;
    private String[][] menPref;
    private String[][] womenPref;
    private String[] men;
    private String[] women;
    private String[] womenPartner;
    private boolean[] menEngaged;

    /** Constructor **/
    public GaleShapley(String[] m, String[] w, String[][] mp, String[][] wp)
    {
        N = mp.length;
        engagedCount = 0;
        men = m;
        women = w;
        menPref = mp;
        womenPref = wp;
        menEngaged = new boolean[N];
        womenPartner = new String[N];
        calcMatches();
    }
    /** function to calculate all matches **/
    private void calcMatches()
    {
        while (engagedCount < N)
            {
                int free;
                for (free = 0; free < N; free++)
                    if (!menEngaged[free])
                        break;
                for (int i = 0; i < N && !menEngaged[free]; i++)
                    {
                        int index = womenIndexOf(menPref[free][i]);
                        if (womenPartner[index] == null)
                            {
                                womenPartner[index] = men[free];
                                menEngaged[free] = true;
                                engagedCount++;
                            }
                        else
                            {
                                String currentPartner = womenPartner[index];
                                if (morePreference(currentPartner, men[free], index))
                                    {
                                        womenPartner[index] = men[free];
                                        menEngaged[free] = true;
                                        menEngaged[menIndexOf(currentPartner)] = false;
                                    }
                            }
                    }
            }
        printCouples();
    }
    /** function to check if women prefers new partner over old assigned partner **/
    private boolean morePreference(String curPartner, String newPartner, int index)
    {
        for (int i = 0; i < N; i++)
            {
                if (womenPref[index][i].equals(newPartner))
                    return true;
                if (womenPref[index][i].equals(curPartner))
                    return false;
            }
        return false;
    }
    /** get men index **/
    private int menIndexOf(String str)
    {
        for (int i = 0; i < N; i++)
            if (men[i].equals(str))
                return i;
        return -1;
    }
    /** get women index **/
    private int womenIndexOf(String str)
    {
        for (int i = 0; i < N; i++)
            if (women[i].equals(str))
                return i;
        return -1;
    }
    /** print couples **/
    public void printCouples()
    {
        System.out.println("Couples are : ");
        for (int i = 0; i < N; i++)
            {
                System.out.println(womenPartner[i] +" "+ women[i]);
            }
    }
    /** main function **/
    public static void main(String[] args)
    {
        System.out.println("Gale Shapley Marriage Algorithm\n");
        /** list of men **/
        String[] m = {"M1", "M2", "M3", "M4", "M5"};
        /** list of women **/
        String[] w = {"W1", "W2", "W3", "W4", "W5"};
        /** men preference **/
        String[][] mp = {{"W5", "W2", "W3", "W4", "W1"},
            {"W2", "W5", "W1", "W3", "W4"},
            {"W4", "W3", "W2", "W1", "W5"},
            {"W1", "W2", "W3", "W4", "W5"},
            {"W5", "W2", "W3", "W4", "W1"}
        };
        /** women preference **/
        String[][] wp = {{"M5", "M3", "M4", "M1", "M2"},
            {"M1", "M2", "M3", "M5", "M4"},
            {"M4", "M5", "M3", "M2", "M1"},
            {"M5", "M2", "M1", "M4", "M3"},
            {"M2", "M1", "M4", "M3", "M5"}
        };
        GaleShapley gs = new GaleShapley(m, w, mp, wp);
    }
}

/*

Couples are :
M4 W1
M2 W2
M5 W3
M3 W4
M1 W5
