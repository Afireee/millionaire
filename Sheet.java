package millionaire;

public class Sheet {
    String prompt, answer;

    public Sheet (String prompt, String answer) { // Public constructor that accepts the question and answer
        this.prompt = prompt;
        this.answer = answer;
    }

    public void fiftyFifty(int index) {
        String[] fiftyFifty = {
                "[a] Paris\n" +                                     // Question #1
                "[b] Madrid",
                "         \t\t[c] Malt\n" +                         // Question #2
                "         \t\t[d] Vinegar",
                "      \t\t[c] By\n" +                              // Question #3
                "[b] Yet",
                "[a] James Cameron   \t\t[c] Oliver Stone\n",       // Question #4
                "\n[b] Madagascar\t\t[d] Greenland",                // Question #5
                "               \t\t[c] Transition\n" +             // Question #6
                "[b] Theme",
                "[a] Vatican City\n" +                              // Question #7
                "                 \t\t[d] Spain",
                "          \t\t[c] 2007\n" +                        // Question #8
                "[b] 2008",
                "\n[b] 93 million\t\t[d] 72 million",               // Question #9
                "[a] Mika Hakkinen\n" +
                "                    \t\t[d] Michael Schumacher\n", // Question #10
                "[a] 5,895 meters\n" +                              // Question #11
                "[b] 4,897 meters",
                "[a] Orange\n" +                                    // Question #12
                "         \t\t[d] White",
                "[a] July\t\t[c] June\n",                           // Question #13
                "                         \t\t[c] Big Ben\n" +      // Question #14
                "                         \t\t[d] Eiffel Tower",
                "\n[b] Johannes Kepler\t\t[d] Isaac Newton"         // Question #15
        };
        System.out.println("50/50 has been applied. Here are the remaining choices.");
        System.out.println(fiftyFifty[index]);
    }
}
