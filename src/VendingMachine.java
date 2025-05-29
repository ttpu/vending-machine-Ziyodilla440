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
    public double getCredit(int cardId) {
        Card card = cards.get(cardId);
        return (card == null) ? -1.0 : card.credit;
    }

    public void refillColumn(int column, String beverageName, int cans) {
        if (column >= 1 && column <= 4) {
            columns[column - 1] = new Column(beverageName, cans);
        }
    }

    public int availableCans(String beverageName) {
        int total = 0;
        for (Column col : columns) {
            if (beverageName.equals(col.beverageName)) {
                total += col.cans;
            }
        }
        return total;
    }

    public int sell(String beverageName, int cardId) {
        Beverage beverage = beverages.get(beverageName);
        Card card = cards.get(cardId);

        if (beverage == null || card == null) return -1;
        if (card.credit < beverage.price) return -1;
    
        for (int i = 0; i < 4; i++) {
            Column col = columns[i];
            if (beverageName.equals(col.beverageName) && col.cans > 0) {
                col.cans--;
                card.credit -= beverage.price;
                return i + 1; 
            }
        }


        return -1; 
    }
}

