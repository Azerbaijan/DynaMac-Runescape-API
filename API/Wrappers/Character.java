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

import java.lang.reflect.Array;

import com.Marneus.Bot.API.Methods.Client;
import com.Marneus.Enviroment.Data;
import com.Marneus.Enviroment.Hook.ClassHook;

public class Character {
	private Object currentObject;
	private ClassHook currentHook;
	public Animable getAnimable(){
		return new Animable(currentObject);
	}
	public Animator getAnimator(){
		Object data = currentHook.getData("getAnimator", currentObject);
		if(data!=null)
			return new Animator(data);		
		return null;
	}
	public int getAnimationID(){
		try{
			return getAnimator().getAnimation().getID();
		}
		catch(Exception e){
			
		}
		return -1;
	}
	public int getLocationX(){
		try{
			return new Animable(currentObject).getMaxX()+Client.getRSData().getBaseInfo().getX();
		}
		catch(Exception e){
			return -1;
		}
	}
	public int getLocationY(){
		try{
			return new Animable(currentObject).getMaxY()+Client.getRSData().getBaseInfo().getY();
		}
		catch(Exception e){
			return -1;
		}
	}
	public int getLocalX(){
		try{
			return new Animable(currentObject).getMaxX();
		}
		catch(Exception e){
			return -1;
		}
	}
	public int getLocalY(){
		try{
			return new Animable(currentObject).getMinY();
		}
		catch(Exception e){
			return -1;
		}
	}
	public int getHeight(){
		Object data = currentHook.getData("getHeight", currentObject);
		if(data!=null)
			return Integer.parseInt(data.toString()) * currentHook.getFieldHook("getHeight").getMultiplier();		
		return -1;		
	}
	public ModelLD[] getLDModels(){
		Object data = currentHook.getData("getModels", currentObject);
		if(data!=null){
			ModelLD[] models = new ModelLD[Array.getLength(data)];
			for(int i=0;i<models.length;++i)
				models[i]=new ModelLD(Array.get(data, i));
			
			return models;
		}
		return new ModelLD[]{};
	}
	public Character(Object o){
		if(o==null)return;
		currentObject=o;
		currentHook = Data.indentifiedClasses.get("Character");
	}
}
