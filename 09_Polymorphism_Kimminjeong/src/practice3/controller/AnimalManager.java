package practice3.controller;

import practice3.model.vo.*;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] aArr = new Animal[5];
		
		aArr[0]=new Cat("나비", "고양이", "길", "노란색");
		aArr[1]=new Dog("보리", "강아지", 5);
		aArr[2]=new Cat("루나", "고양이", "공원", "남색");
		aArr[3]=new Dog("코코", "강아지", 3);
		aArr[4]=new Cat("키티", "고양이", "하얀색", "TV");
		
		//요렇게도 풀어보기~~ 이 경우는 위의 aArr[index] 0~4 할당을 모두 주석처리!
//		int countCat = 0;//고양이랑 강아지 각 받을 순서
//		int countDog = 0;
//		String name;
//		for (int i = 0; i < aArr.length; i++) {
//			if ((int) (Math.random() * 2) == 0) {//고양이,강아지 랜덤출력이 0이면 고양이
//				aArr[i] = new Cat();
//				String color;
//				String location;
//				switch (countCat) {
//				case 0: name = "나비";color = "노란색";location = "길";
//					break;
//				case 1:name = "루나";location = "공원";color = "남색";
//					break;
//				case 2:name = "키티";color = "하얀색";location = "TV";
//					break;
//				case 3:name = "초코";color = "갈색";location = "집";
//					break;
//				default:name = "실버";color = "회색";location = "학교";
//				}
//				aArr[i].setName(name);
//				aArr[i].setKinds("고양이");
//				((Cat) aArr[i]).setColor(color);
//				((Cat) aArr[i]).setLocation(location);
//				countCat++;//다음은 다른 이름으로 받기위해 고양이 count 추가
//			} else {
//				aArr[i] = new Dog();
//				aArr[i].setKinds("강아지");
//				int weight;
//				switch (countDog) {
//				case 0:name = "보리";weight=5;
//					break;
//				case 1:name = "코코";weight=3;
//					break;
//				case 2:name = "호두";weight=8;
//					break;
//				case 3:name = "맥스";weight=6;
//					break;
//				default:name = "루시";weight=9;
//				}
//				aArr[i].setName(name);
//				aArr[i].setKinds("강아지");
//				((Dog) aArr[i]).setWeight(weight);
//				countDog++;
//			}
//		}

		for (int i = 0; i < aArr.length; i++) {
			aArr[i].speak();
		}
	}
}
