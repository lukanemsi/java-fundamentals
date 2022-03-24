package threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task2 {
    private static final int NUM_THREADS = 10;
    private static final int CHANNEL_CAPACITY = 100;
    private static final int POISON_PILL = -1;

    public static List<String> generate(final int from, final int to, final int count) throws InterruptedException {
        if (from < 0 || to < 0 || !isInRange(count, 0, to - from + 1)) throw new IllegalArgumentException();

        List<String> generated = new ArrayList<>(count);
        CommunicationContainer communicationContainer = new CommunicationContainer(NUM_THREADS, CHANNEL_CAPACITY);
        // TODO 
        generated = communicationContainer.generate(from, to, count);

        return generated;
    }

    private static boolean isInRange(int count, int from, int to) {
        return from <= count && count <= to;
    }

    public static void main(String[] args) throws InterruptedException {
        var s = generate(0, 99999999, 99);
        for (var i :
                s) {
            System.out.println(i);
        }
    }

}


class CommunicationContainer {
    private static int _NUM_THREADS;
    private static int _CHANNEL_CAPACITY;
    public static List<Integer> container = new ArrayList<>();
    public static List<String> bothWestAndKenjiList = new ArrayList<>();

    public CommunicationContainer(int NUM_THREADS, int CHANNEL_CAPACITY) {
        _NUM_THREADS = NUM_THREADS;
        _CHANNEL_CAPACITY = CHANNEL_CAPACITY;
    }

    public synchronized static List<String> generate(final int from, final int to, final int count) throws InterruptedException {
        AThread aThread = new AThread(from, to, count);
        Thread threadA = new Thread(aThread);
        threadA.start();

        BThread bThread = new BThread(count);
        for (int i = 0; i < _NUM_THREADS; i++) {
            Thread threadB = new Thread(bThread);
            threadB.start();
            threadB.join();
        }

        while (aThread.westNumbersList.stream().count() != count) {

        }

        for (int i = 0; i < aThread.westNumbersList.stream().count(); i++) {
            bothWestAndKenjiList.add(aThread.westNumbersList.get(i) + ", " + bThread.kenjiNumbersList.get(i));
        }

        return bothWestAndKenjiList;
    }
}

class AThread implements Runnable {
    private int _from = 0;
    private int _to = 0;
    private int _count = 0;
    public List<Integer> westNumbersList = new LinkedList<>();

    public AThread(final int from, final int to, final int count) {
        _from = from;
        _to = to;
        _count = count;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < _count; i++) {
            if (westNumbersList.stream().count() == _count)
                return;

            Random random = new Random();
            var westNumber = random.ints(_from, _to).findFirst().getAsInt();
            int index = westNumbersList.indexOf(westNumber);
            if (index == -1) {
                westNumbersList.add(westNumber);
                if (CommunicationContainer.container.stream().count() != 100) {
                    CommunicationContainer.container.add(westNumber);
                } else {

                    while (CommunicationContainer.container.stream().count() == 100) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    notifyAll();
                }
            } else
                i--;
        }
    }
}

class BThread implements Runnable {
    public List<String> kenjiNumbersList = new LinkedList<>();
    private int _count = 0;

    public BThread(int count) {
        _count = count;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < CommunicationContainer.container.stream().count(); i++) {
            if (kenjiNumbersList.stream().count() == _count)
                return;

            while (CommunicationContainer.container.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notifyAll();
            kenjiNumbersList.add(KanjiLib.convert(CommunicationContainer.container.get(i)));
            CommunicationContainer.container.remove(i);

            i--;
        }
    }
}