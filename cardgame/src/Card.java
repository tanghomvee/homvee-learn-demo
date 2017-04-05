import java.util.*;

/**
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @date:2016/6/13
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Card {
    private String color;
    private int cardNum;

    public Card(String color, int cardNum) {
        this.color = color;
        this.cardNum = cardNum;
    }

    public static void main(String[] args) {
        CardHeap cardHeap = new CardHeap();
        cardHeap.resetCards();

        CardHeap cardHeap1 = new CardHeap();
        cardHeap1.chooseCard(cardHeap.getCards(), 7);
        CardHeap cardHeap2 = new CardHeap();
        cardHeap2.chooseCard(cardHeap.getCards(), 7);
        System.out.println();
    }
}

class CardHeap {
    private List<Card> cards = new ArrayList<Card>();
    private int type;

    public CardHeap() {

    }

    public void resetCards() {
        String[] colors = new String[]{"红桃", "黑桃", "方片", "梅花"};
        List<Card> cardsTmp = new ArrayList<Card>();
        for (String color : colors) {
            for (int cardNum = 2; cardNum < 15; cardNum++) {
                cardsTmp.add(new Card(color, cardNum));
            }
        }
        for (int i = 0; i < 52; i++) {
            Random rd = new Random();
            int index = rd.nextInt(cardsTmp.size());
            cards.add(cardsTmp.remove(index));
        }
    }

    public void chooseCard(List<Card> cards, int num) {
        for (int i = 0; i < num; i++) {
            Random rd = new Random();
            int index = rd.nextInt(cards.size());
            this.cards.add(cards.remove(index));
        }
    }

    public void dropCard(Card card, List<Card> cardList) {
        this.cards.remove(card);
        cardList.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
