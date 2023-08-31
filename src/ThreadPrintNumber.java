public class ThreadPrintNumber extends Thread{
    int start, step, end;
    public ThreadPrintNumber(String name, int start, int step, int end) {
        super(name);
        this.start = start;
        this.step = step;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i += step) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + "\t" + "ended");
    }

    public static void main(String[] args) {
        ThreadPrintNumber t1 = new ThreadPrintNumber("奇数", 1, 2, 10);
        ThreadPrintNumber t2 = new ThreadPrintNumber("偶数", 2, 2, 10);
        t1.start();
        t2.start();
    }
}
