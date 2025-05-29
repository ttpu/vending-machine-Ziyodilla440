import java.util.*;

public class VendingMachine {
    private static class Beverage {
        String name;
        double price;

        Beverage(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private static class Card {
        int id;
        double credit;

        Card(int id, double credit) {
            this.id = id;
            this.credit = credit;
        }
    }

    private static class Column {
        String beverageName;
        int cans;

        Column(String beverageName, int cans) {
            this.beverageName = beverageName;
            this.cans = cans;
        }
    }

    private Map<String, Beverage> beverages = new HashMap<>();
    private Map<Integer, Card> cards = new HashMap<>();
    private Column[] columns = new Column[4];

    public VendingMachine() {
        for (int i = 0; i < 4; i++) {
            columns[i] = new Column(null, 0);
        }
    }

    public void addBeverage(String name, double price) {
        beverages.put(name, new Beverage(name, price));
    }

    public double getPrice(String beverageName) {
        Beverage b = beverages.get(beverageName);
        return (b == null) ? -1.0 : b.price;
    }

    public void rechargeCard(int cardId, double credit) {
        Card card = cards.get(cardId);
        if (card == null) {
            cards.put(cardId, new Card(cardId, credit));
        } else {
            card.credit += credit;
        }
    }



        return -1; 
    }
}

