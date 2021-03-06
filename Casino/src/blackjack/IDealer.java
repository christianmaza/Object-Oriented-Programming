
package blackjack;


public interface IDealer {
    public int hitOrStand();
    public Card deal(Deck deck);
}
