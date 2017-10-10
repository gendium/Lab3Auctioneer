import java.util.ArrayList;

public class Auctioneer {

    private Bidder highestBidder;
    private ArrayList<Bidder> bidders;
    private ItemForBid item;
    private float highestBid;
    private boolean auctionGoing;

    public boolean isAuctionGoing() {
        return auctionGoing;
    }

    public void setAuctionGoing(boolean auctionGoing) {
        this.auctionGoing = auctionGoing;
    }

    public Auctioneer(ArrayList<Bidder> bidders, ItemForBid item) {
        this.bidders = bidders;
        for (Bidder bidder: bidders)
        {
            bidder.setAuctioneer(this);
        }
        this.item = item;
        this.highestBid = item.getInitialPrice();
        this.auctionGoing = false;
    }

    public void update(boolean isAuctionStillGoing)
    {
        auctionGoing = isAuctionStillGoing;
    }

    private void notifyBidders()
    {
        for (Bidder bidder: bidders)
        {
            bidder.update(highestBid);
        }
    }

    public void takeBid(float amount, Bidder bidder)
    {
        if (!auctionGoing)
            return;
        if(bidder.equals(highestBidder))
            return;
        if(amount > highestBid)
        {
            highestBid = amount;
            highestBidder = bidder;
            notifyBidders();
        }
    }

    public void display()
    {
        System.out.println("-------------------------------");
        if(auctionGoing) {
            if (highestBidder != null) {
                System.out.println("Current Highest Bidder is: " +
                        highestBidder.getName() +
                        " with a bid of " +
                        highestBid);
            }
            else
                System.out.println("No highest bidder yet");
        }
        else
            System.out.println("Auction Over. Winner: " + highestBidder.getName());
    }

}
