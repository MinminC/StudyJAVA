package com.kh.chap04_assist.part01_buffered.model.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BufferedDaoShort {
	public void fileRead() {
//		//방법 1. 수업시간에 한 내용. while을 통해서 null 전까지 돌리기
//		try(BufferedReader br=new BufferedReader(new FileReader("c_buffer.txt"))){
//			String str=null;
//			while((str=br.readLine())!=null) {
//				System.out.println(str);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		//방법 1-1. while 대신 for문에서 break로 탈출하는 구문 만들기
//		try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"));) {
//			for (;;) {
//				String str = br.readLine();
//				if (str == null)
//					break;
//				System.out.println(str);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		
		
//		//방법 2. 강사님이 올려주신 방법. 
		//br.lines()를 joining을 사용하여 합치는 stream.collect(Collectors.joining(문자열))을 사용
//		try(BufferedReader br=new BufferedReader(new FileReader("c_buffer.txt"))){
//			String s=br.lines().collect(Collectors.joining("\n"));//stream 요소들을 joining으로 결합
//			System.out.println(s);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		//방법 2-2. List 인스턴스에 집어넣기. 꺼내먹기
		try(BufferedReader br=new BufferedReader(new FileReader("c_buffer.txt"))){
			List<String> list = br.lines().collect(Collectors.toList());
			//String형 list를 만들고 stream 요소들을 리스트에 하나씩 할당
			for(String str:list) {
			System.out.println(str);//리스트를 하나씩 출력
			}
			System.out.println("리스트에 넣으면 이렇게 따로도 사용할 수 있게 됨 : "+list.get(2));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
//		
		
//		//방법 3. Path 클래스, ArrayList를 이용하여 파일의 내용을 출력하기. null인 지점을 찾을 필요없이 list에 배열 저장된 값을 출력
//		Path path = Paths.get("c_buffer.txt");// Path를 이용하여 해당 파일의 경로를 반환해온다
//
//		Charset cs = StandardCharsets.UTF_8;// UTF_8 포멧(지정가능)으로 받아오는 문자셋
//		List<String> list = new ArrayList<String>();// String형의 ArrayList를 생성
//
//		try {
//			list = Files.readAllLines(path, cs);// path 경로의 파일을 cs 문자셋으로 리스트에 모든 라인을 받는다.
//		} catch (IOException e) {// IOException 예외처리(readAllLines에 대한 예외처리)
//			e.printStackTrace();//오류가 나는 지점의 단계별로 에러를 출력.
//		}
//		for (String readLine : list) {//for each문.
//			System.out.println(readLine);// readLine에 list의 내용물을 하나씩 집어넣어 list의 끝까지 돌린다.
//		}
	}
}
