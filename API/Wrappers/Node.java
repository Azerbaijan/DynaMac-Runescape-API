/******************************************************
* Created by Marneus901                                *
* © 2012 MarneusScripts.com                            *
* **************************************************** *
* Access to this source is unauthorized without prior  *
* authorization from its appropriate author(s).        *
* You are not permitted to release, nor distribute this* 
* work without appropriate author(s) authorization.    *
********************************************************/
package com.Marneus.Bot.API.Wrappers;

import com.Marneus.Enviroment.Data;
import com.Marneus.Enviroment.Hook.ClassHook;

public class Node {
	public Object currentObject;
	public ClassHook currentHook;
	public Node(Object o){
		currentObject = o;
		currentHook = Data.indentifiedClasses.get("Node");
	}
	public long getID(){
		Object data = currentHook.getData("getID", currentObject);
		if(data!=null){
			return Long.parseLong(data.toString()) * currentHook.getFieldHook("getID").getLongMultiplier();
		}
		return -1;
	}
	public Node getPrevious(){
		Object data = currentHook.getData("getPrevious", currentObject);
		if(data!=null)
			return new Node(data);
		return null;
	}
	public Node getNext(){
		Object data = currentHook.getData("getNext", currentObject);
		if(data!=null)
			return new Node(data);
		return null;
	}
}
