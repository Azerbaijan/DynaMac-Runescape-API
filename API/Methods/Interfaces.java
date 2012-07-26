/******************************************************
* Created by Marneus901                                *
* © 2012 MarneusScripts.com                            *
* **************************************************** *
* Access to this source is unauthorized without prior  *
* authorization from its appropriate author(s).        *
* You are not permitted to release, nor distribute this* 
* work without appropriate author(s) authorization.    *
********************************************************/
package com.Marneus.Bot.API.Methods;

import com.Marneus.Bot.API.Wrappers.InterfaceChild;

public class Interfaces {
	public static InterfaceChild getChild(final int id) {
		final int x = id >> 16;
		final int y = id & 0xffff;
		return Client.getInterfaceHolder()[x].getChildren()[y];
	}
}
