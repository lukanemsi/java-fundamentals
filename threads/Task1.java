package threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task1 implements Runnable {
    private static final int NUM_THREADS = 10;

    private static int _from = 0;
    private static int _to = 0;
    private static int _count = 0;
    private static List<String> bothWestAndKenjiList= new LinkedList<>();

    public static List<String> generate(final int from, final int to, final int count) throws InterruptedException {
        if (from < 0 || to < 0 || !isInRange(count, 0, to - from + 1)) throw new IllegalArgumentException();

        List<String> generated = new ArrayList<>(count);

        // TODO
         _from = from;
        _to = to;
        _count = count;

        for (int i = 0; i < NUM_THREADS;i++)
        {
            Thread thread = new Thread(new Task1());
            thread.start();
            thread.join();

        }
        generated = bothWestAndKenjiList;
        return generated;
    }

    private static boolean isInRange(int count, int from, int to) {
        return from <= count && count <= to;
    }

    @Override
    public synchronized void run(){
        for(int i = 0; i < _count; i++)
        {
            if (bothWestAndKenjiList.stream().count() == _count)
                return;
            Random random = new Random();
            var westNumber = random.ints(_from,_to).findFirst().getAsInt();
            var kanjiNumber = KanjiLib.convert(westNumber);
            var bothWestAndKenjiText = westNumber + ", " + kanjiNumber;
            bothWestAndKenjiList.add(bothWestAndKenjiText);
        }
    }

    public static void main(String[] args) throws InterruptedException {
       var s =  generate(0,99999999,12300);
        for (var i:
           s  ) {
            System.out.println(i);
        }
    }

}