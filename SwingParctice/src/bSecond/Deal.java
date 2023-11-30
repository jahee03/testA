package bSecond;

import java.util.*;

public class Deal {
	public static void main(String[] args) {
		int numHands = Integer.parseInt(args[0]);
		int cardsPerHand = Integer.parseInt(args[1]);
		// 정상적인 52장 카드 묶음을 만든다
		String[] suit = new String[] { "♤", "♡", "◇", "♧" };
		String[] rank = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		List<String> deck = new ArrayList<String>();
		for (int i = 0; i < suit.length; i++)
			for (int j = 0; j < rank.length; j++)
				deck.add(suit[i] + rank[j]);
		// 카드 묶음을 섞는다.
		Collections.shuffle(deck);
		if (numHands * cardsPerHand > deck.size()) {
			System.out.println("Not enough cards.");
			return;
		}
		for (int i = 0; i < numHands; i++)
			System.out.println(dealHand(deck, cardsPerHand));
	}

	public static <E> List<E> dealHand(List<E> deck, int n) {
		int deckSize = deck.size();
		List<E> handView = deck.subList(deckSize - n, deckSize);
		List<E> hand = new ArrayList<E>(handView);
		handView.clear();
		return hand;
	}
}