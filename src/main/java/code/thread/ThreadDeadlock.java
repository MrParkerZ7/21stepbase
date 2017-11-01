package code.thread;

public class ThreadDeadlock {

    private static class Trade {
        private final String coupleTrade;

        Trade(String coupleTrade) {
            this.coupleTrade = coupleTrade;
        }

        String getCouple() {
            return this.coupleTrade;
        }

        public synchronized void sentingMy(Trade trade) {
            System.out.printf("%s: %s" + " send item! \n", this.coupleTrade, trade.getCouple());
            trade.getingHis(this);
        }

        public synchronized void getingHis(Trade trade) {
            System.out.printf("%s: %s" + " got item! \n", this.coupleTrade, trade.getCouple());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Trade shella = new Trade("Macro");
        Trade macro = new Trade("Shella");

        new Thread(() -> {
            shella.sentingMy(macro);
        }).start();

        Thread.sleep(1000); // Two thread can be finish they task in one time! \\ try to comment

        new Thread(() -> {
            macro.sentingMy(shella);
        }).start();
    }
}