/*Author: Sean Egger, Alev Ruvlev
        Class: CSI-340-01
        Assignment: Lab 3
        Due Date: October 7 2pm
        Description:
        An auctioneer program implementing the observer pattern
        Certification of Authenticity:
        I certify that this is entirely my own work, except where I have given
        fully-documented references to the work of others. I understand the definition and
        consequences of plagiarism and acknowledge that the assessor of this assignment
        may, for the purpose of assessing this assignment:
        - Reproduce this assignment and provide a copy to another member of academic
        - staff; and/or Communicate a copy of this assignment to a plagiarism checking
        - service (which may then retain a copy of this assignment on its database for the
        - purpose of future plagiarism checking)
        ● If the section number is not available, it may be
        */
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
