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

public class NPC {
	private Object currentObject;
	private ClassHook currentHook;
	public int getAnimation(){
		return getCharacter().getAnimationID();
	}
	public int getLevel(){
		Object data = currentHook.getData("getLevel", currentObject);
		if(data!=null){
			return Integer.parseInt(data.toString()) * currentHook.getFieldHook("getLevel").getMultiplier();
		}
		return -1;
	}
	public NPCDef getNPCDef(){
		Object data = currentHook.getData("getNPCDef", currentObject);
		if(data!=null)
			return new NPCDef(data);
		return null;
	}
	public String getNPCName(){
		Object data = currentHook.getData("getNPCName", currentObject);
		if(data!=null)
			return data.toString();
		return "";
	}
	public Animable getAnimable(){
		return new Animable(currentObject);
	}
	public Character getCharacter(){
		return new Character(currentObject);
	}
	public Interactable getInteractable(){
		return new Interactable(currentObject);
	}
	public int getLocationX(){
		return getCharacter().getLocationX();
	}
	public int getLocationY(){
		return getCharacter().getLocationY();
	}
	public NPC(Object o){
		if(o==null)return;
		currentObject=o;
		currentHook = Data.indentifiedClasses.get("NPC");
	}
}
