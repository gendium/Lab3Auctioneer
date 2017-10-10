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
