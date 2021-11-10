package com.kh.team.abstractNInterface.model.vo;

public abstract class Game implements Casino{
		private String gameName;
		public Game() {
			
		}
		
		public Game(String gameName) {
			this.gameName = gameName;
		}
		public String getGameName() {
			return gameName;
		}
		public void setGameName(String gameName) {
			this.gameName = gameName;
		}
		public String playGame() {
			return   gameName + " 게임 "	;
		}
		
		
		public abstract int payFee();
}
