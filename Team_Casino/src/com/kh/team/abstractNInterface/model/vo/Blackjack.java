package com.kh.team.abstractNInterface.model.vo;

public class Blackjack extends Game{
	private int j = 2;
	int[] Dealdeck = new int[5];
	int[] Mydeck = new int[5];
	public int[] getDealdeck() {
		return Dealdeck;
	}
	public void setDealdeck(int[] dealdeck) {
		Dealdeck = dealdeck;
	}
	public int[] getMydeck() {
		return Mydeck;
	}
	public void setMydeck(int[] mydeck) {
		Mydeck = mydeck;
	}
	public void start() {
		for (int i = 0; i < 2; i++) {
			Mydeck[i] = (int) ((Math.random() * 13) + 1);
			Dealdeck[i] = (int) ((Math.random() * 13) + 1);
		}
	}
	public void hit() {
				if(j < 5) {
				Mydeck[j] = (int) ((Math.random() * 13) + 1);
				Dealdeck[j] = (int) ((Math.random() * 13) + 1);
				this.j++;
				}
		}
	@Override
	public int payFee() {
		return 30000;
	}
}