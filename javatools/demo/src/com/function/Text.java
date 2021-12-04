package com.function;

import java.util.ArrayList;

/*
 * @author WEN PENGFEI
 * @date 2021/11/23
 * 内容作成
 */
public class Text {
	
	//objectで内容を作成、戻り値はcom.entity.Objectの配列
	public ArrayList<com.entity.Object> createText(){
		com.entity.Object obj1 = new com.entity.Object("Hello!");
		com.entity.Object obj2 = new com.entity.Object("World!");
		ArrayList<com.entity.Object> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);
		return list;
	}
}
