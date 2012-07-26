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
import com.Marneus.Enviroment.Hook.ClassHook.FieldHook;

public class Player{
	private Object currentObject;
	private ClassHook currentHook;
	public int getAnimation(){
		return getCharacter().getAnimationID();
	}
	public int getLevel(){
		Object data = currentHook.getData("getLevel", currentObject);
		if(data!=null)
			return Integer.parseInt(data.toString()) * currentHook.getFieldHook("getLevel").getMultiplier();		
		return -1;
	}
	public String getTitle(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getTitle")){
				Object data = fh.getData(currentObject);
				if(data==null){
					return "";
				}
				else{
					return data.toString();
				}
			}
		}
		return "";
	}
	public byte getGender(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getGender")){
				Object data = fh.getData(currentObject);
				if(data==null){
					return -1;
				}
				else{
					return Byte.parseByte(data.toString());
				}
			}
		}
		return -1;
	}
	public String getPlayerName(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getPlayerName")){
				Object data = fh.getData(currentObject);
				if(data==null){
					return "";
				}
				else{
					return data.toString();
				}
			}
		}
		return "";
	}
	public PlayerDef getComposite(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getPlayerDef")){
				Object data = fh.getData(currentObject);
				if(data==null){
					return null;
				}
				else{
					return new PlayerDef(data);
				}
			}
		}
		return null;
	}
	public int getSkullIcon(){
		Object data = currentHook.getData("getSkullIcon", currentObject);
		if(data!=null)
			return Integer.parseInt(data.toString()) * currentHook.getFieldHook("getSkullIcon").getMultiplier();		
		return -1;	
	}
	public int getPrayerIcon(){
		Object data = currentHook.getData("getPrayerIcon", currentObject);
		if(data!=null)
			return Integer.parseInt(data.toString()) * currentHook.getFieldHook("getPrayerIcon").getMultiplier();		
		return -1;	
	}
	public PlayerDef getPlayerDef(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getPlayerName")){
				Object data = fh.getData(currentObject);
				if(data!=null){
					return new PlayerDef(data);
				}
			}
		}
		return null;
	}
	public int getTeam(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getTeam")){
				Object data = fh.getData(currentObject);
				if(data==null){
					return -1;
				}
				else{
					int val = Integer.parseInt(data.toString());
					int mul = fh.getMultiplier();
					return val*mul;
				}
			}
		}		
		return -1;		
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
	public int getLocalX(){
		return getCharacter().getLocalX();
	}
	public int getLocalY(){
		return getCharacter().getLocalY();
	}
	public Player(Object o){
		if(o==null)return;
		currentObject=o;
		currentHook = Data.indentifiedClasses.get("Player");
	}
}
