import java.util.ArrayList;

public class Demo {

    public static void main(String[] args)
    {
        //create list of bidders
        ArrayList<Bidder> BidderList = new ArrayList<Bidder>();
        Bidder bidder1 = new Bidder("a");
        Bidder bidder2 = new Bidder("b");
        Bidder bidder3 = new Bidder("c");
        BidderList.add(bidder1);
        BidderList.add(bidder2);
        BidderList.add(bidder3);
        //create item
        ItemForBid item = new ItemForBid(10.0f);
        //create auctioneer
        Auctioneer auctioneer = new Auctioneer(BidderList, item);
        //create timer
        Timer timer = new Timer(5, auctioneer);

        //start auction
        auctioneer.setAuctionGoing(true);
        //bid
        bidder1.bid(5);
        auctioneer.display();
        bidder1.bid(20);
        timer.countdown();
        auctioneer.display();
        bidder2.bid(15);
        auctioneer.display();
        bidder2.bid(25);
        timer.countdown();
        auctioneer.display();
        bidder2.bid(30);
        auctioneer.display();
        bidder3.bid(29);
        timer.countdown();
        auctioneer.display();
        while(auctioneer.isAuctionGoing())
            timer.countdown();
        auctioneer.display();


    }

}
