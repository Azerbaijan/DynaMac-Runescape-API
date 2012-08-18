/******************************************************
* Created by Marneus901                                *
* � 2012 MarneusScripts.com                            *
* **************************************************** *
* Access to this source is unauthorized without prior  *
* authorization from its appropriate author(s).        *
* You are not permitted to release, nor distribute this* 
* work without appropriate author(s) authorization.    *
********************************************************/
package com.Marneus.Bot.API.Wrappers;

import com.Marneus.Enviroment.Data;
import com.Marneus.Enviroment.Hook.ClassHook;

public class ItemDefLoader {
	public final Object currentObject;
	public final ClassHook currentHook;
	
	public ItemDefLoader(final Object o){
		currentObject = o;
		currentHook = Data.indentifiedClasses.get("ItemDefLoader");
	}
	public boolean isMembers(){
		final Object data = currentHook.getData("isMembers", currentObject);
		return data!=null ? Boolean.parseBoolean(data.toString()) : false;	
	}
	public Cache getCache(){
		final Object data = currentHook.getData("getCache", currentObject);
		return data!=null ? new Cache(data) : null;
	}
}
