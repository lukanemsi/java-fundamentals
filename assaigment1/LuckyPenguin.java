package pgdp.pinguart;

import pgdp.MiniJava;

import java.io.Console;

import static pgdp.MiniJava.*;

public class LuckyPenguin extends MiniJava {

    public static void main(String[] args) {
        String[] StringedNumbers = new String[8];

        // darchenili Sicarielis nulebad gadaqceva start
        int index = 0;
        // rvajer ricxvebis sheyvana
        while (index < 8) {
            int rawNumbs = readInt("Please enter a Pingu Art number:");
            // ricxvis teqstad gadaqceva
            String toStringRawNumbers = String.valueOf(rawNumbs);
            //teqstshi myofi asoebis shemadgenlobis raodenoba
            //length Of Entered String
            int lofes = toStringRawNumbers.length();
            if (lofes <= 8) {

                //sicarielis raodenobis gamotvla :D
                //length For Zero Numbers
                int lfzn = 8 - lofes;

                //Es prosta ciklistvisaa
                //Index
                int i = 0;

                // es cikli nulebs aniwebs 'toStringRawNumbers' - cvlads
                while (i < lfzn) {
                    //123              =   0123
                    toStringRawNumbers = "0" + toStringRawNumbers;
                    i++;
                }
                StringBuilder forReverse = new StringBuilder();
                forReverse.append(toStringRawNumbers);
                forReverse.reverse();
                // rom ar dagvekargos ricxvebi vinaxavt masivshi
                StringedNumbers[index] = forReverse.toString();
                index++;
            } else {
                write("Enter only 8 digits number");
            }
        }
        // Axali faza

        int i = 0;
        String[] StringArray = new String[8];
        while (i < 8) {

            String str = StringedNumbers[i];//112300123

            String a = str.replace('0', ' ');//1123  123
            String b = a.replace('1', '-');
            String g = b.replace('2', '~');
            String d = g.replace('3', 'P');
            StringArray[i] = d;

            i++;
        }

        i = 0;
        String Sum = "";
        writeLineConsole("+---[LukaArt]---+");
        while (i < StringArray.length) {
            Sum += StringArray[i];
            i++;
            if (i == 2 || i == 4 || i == 6 || i == 8) {
                writeConsole("|" + Sum + "|");
                writeLineConsole();
                Sum = "";
            }
        }

        writeLineConsole("+----------------+");


    }
}
