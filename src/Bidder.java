public class Bidder {

    private String name;
    private float currentHighestBid;
    Auctioneer auctioneer;

    public String getName() {
        return name;
    }

    public Bidder(String name) {
        this.name = name;
    }

    public void setAuctioneer(Auctioneer auctioneer) {
        this.auctioneer = auctioneer;
    }

    public void update(float newHighestBid)
    {
        currentHighestBid = newHighestBid;
    }

    public void bid(float amount)
    {
        auctioneer.takeBid(amount, this);
    }
}
