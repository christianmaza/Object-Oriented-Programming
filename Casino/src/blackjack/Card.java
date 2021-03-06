package blackjack;
import constants.Constants.Colors;
import constants.Constants.FaceValue;
import constants.Constants.Suits;


public class Card {
    private FaceValue Face;
    private Colors Color; 
    private Suits Suit; 
    private int value = 0; 

    public int getValue() {
        
        switch(getFace()){
            case ACE: 
                value = 11;
                break;
            case TWO: 
                value = 2;
                break;
            case THREE: 
                value = 3;
                break;
            case FOUR: 
                value = 4;
                break;
            case FIVE: 
                value = 5;
                break;
            case SIX: 
                value = 6;
                break;
            case SEVEN: 
                value = 7;
                break;
            case EIGHT: 
                value = 8;
                break;
            case NINE: 
                value = 9;
                break; 
            case JACK: 
                value = 10;
                break;
            case QUEEN: 
                value = 10;
                break;
            case KING: 
                value = 10;
                break; 
            default: 
                return 0;   
        }
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    

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
    
    @Override
    public String toString(){
        String card = "" + getFace() + getSuit();
        return card;
    }
    
}
