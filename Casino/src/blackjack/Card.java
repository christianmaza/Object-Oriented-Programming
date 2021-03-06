package blackjack;
import constants.Constants.Colors;
import constants.Constants.FaceValue;
import constants.Constants.Suits;


public class Card {
    private FaceValue Face;
    private Colors Color; 
    private Suits Suit; 

    public FaceValue getFace() {
        return Face;
    }

    public void setFace(FaceValue Face) {
        this.Face = Face;
    }

    public Colors getColor() {
        return Color;
    }

    public void setColor(Colors Color) {
        this.Color = Color;
    }

    public Suits getSuit() {
        return Suit;
    }

    public void setSuit(Suits Suit) {
        this.Suit = Suit;
    }
    
    
    public int hashCode(){
        int hashCode = 0; 
        return hashCode;
    }
    
    
    public boolean equals(Object obj){
        if(obj instanceof Card){
            Card card = (Card)obj;
            return (card.Face.equals(this.Face) && card.Suit.equals(this.Suit) && card.Color.equals(this.Color));
        }
        else{
            return false;
        }
    }
    
}
