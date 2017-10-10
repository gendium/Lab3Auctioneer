public class Timer {

    private int timeLeft;
    private Auctioneer auctioneer;

    public Timer(int timeLeft, Auctioneer auctioneer) {
        this.timeLeft = timeLeft;
        this.auctioneer = auctioneer;
    }

    void countdown()
    {
        timeLeft--;
        if (timeLeft == 0)
            notifyWhenTimeRunsOut();
    }

    void notifyWhenTimeRunsOut()
    {
        auctioneer.update(false);
    }

}
