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

import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.Marneus.Bot.API.Wrappers.HashTable;
import com.Marneus.Bot.API.Wrappers.Info;
import com.Marneus.Bot.API.Wrappers.Interface;
import com.Marneus.Bot.API.Wrappers.NPCNode;
import com.Marneus.Bot.API.Wrappers.ObjectDefLoader;
import com.Marneus.Bot.API.Wrappers.Player;
import com.Marneus.Bot.API.Wrappers.RenderLD;
import com.Marneus.Enviroment.Data;
import com.Marneus.Enviroment.Hook.ClassHook;
import com.Marneus.Enviroment.Hook.ClassHook.FieldHook;
import com.Marneus.RSApplet.Canvas.Canvas;

public class Client {
	public static int getCameraPitch(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getCameraPitch")){
					return Integer.parseInt(ch.getData("getCameraPitch").toString()) * ch.getFieldHook("getCameraPitch").getMultiplier();
				}
			}
		}
		catch(Exception e){
		}
		return -1;
	}
	public static int getCameraX(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getCameraX")){
					return Integer.parseInt(ch.getData("getCameraX").toString()) * ch.getFieldHook("getCameraX").getMultiplier();
				}
			}
		}
		catch(Exception e){
		}
		return -1;
	}
	public static int getCameraY(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getCameraY")){
					return Integer.parseInt(ch.getData("getCameraY").toString()) * ch.getFieldHook("getCameraY").getMultiplier();
				}
			}
		}
		catch(Exception e){
		}
		return -1;
	}
	public static int getCameraYaw(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getCameraYaw")){
					return Integer.parseInt(ch.getData("getCameraYaw").toString()) * ch.getFieldHook("getCameraYaw").getMultiplier();
				}
			}
		}
		catch(Exception e){
		}
		return -1;
	}
	public static Canvas getCanvas(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getCanvas")){
					return (Canvas)ch.getData("getCanvas");
				}
			}
		}
		catch(Exception e){
		}
		return null;
	}
	public static Object getClient(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getClient")){
					return ch.getData("getClient");
				}
			}
		}
		catch(Exception e){
		}
		return null;
	}
	public static int getClientState(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null){
				FieldHook fh = ch.getFieldHook("getClientState");
				if(fh!=null){
					return Integer.parseInt(ch.getData("getClientState").toString()) * fh.getMultiplier();
				}
			}
		}
		catch(Exception e){
		}
		return -1;
	}
	public static String getCurrentAction(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null && ch.containsFieldHook("getCurrentAction"))
				return ch.getData("getCurrentAction").toString();
		}
		catch(Exception e){
		}
		return "";
	}
	public static Rectangle[] getInterfaceBoundsArray(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null && ch.containsFieldHook("getInterfaceBoundsArray"))
				return (Rectangle[])ch.getData("getInterfaceBoundsArray");
		}
		catch(Exception e){
		}
		return new Rectangle[]{};
	}
	public static Interface[] getInterfaceHolder(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getInterfaceHolder")){
					Object data = ch.getData("getInterfaceHolder");
					if(data!=null){
						Interface[] array = new Interface[Array.getLength(data)];
						for(int i=0;i<array.length;++i){
							array[i]=new Interface(i, Array.get(data, i));
						}
						return array;
					}
				}
			}
		}
		catch(Exception e){
		}
		return new Interface[]{};
	}
	public static HashTable getInterfaceNodeCache(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null && ch.containsFieldHook("getInterfaceNodeCache")){
				Object data = ch.getData("getInterfaceNodeCache");
				if(data!=null){
					return new HashTable(data);
				}
			}
		}
		catch(Exception e){
		}
		return null;
	}
	public static int getInterfaceIndex(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null){
				FieldHook fh = ch.getFieldHook("getInterfaceIndex");
				if(fh!=null){
					int val = Integer.parseInt(ch.getData("getInterfaceIndex").toString());
					int mul = fh.getMultiplier();
					return val*mul;
				}
			}
		}
		catch(Exception e){
		}
		return -1;
	}
	public static int[] getLevelArray(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null && ch.containsFieldHook("getLevelArray"))
				return (int[])ch.getData("getLevelArray");
		}
		catch(Exception e){
		}
		return new int[]{};
	}
	public static int[] getLevelExpArray(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null && ch.containsFieldHook("getLevelExpArray"))
				return (int[])ch.getData("getLevelExpArray");
		}
		catch(Exception e){
		}
		return new int[]{};
	}
	public static int[] getMaxLevelArray(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getMaxLevelArray")){
					return (int[])ch.getData("getMaxLevelArray");
				}
			}
		}
		catch(Exception e){
		}
		return new int[]{};
	}
	public static boolean getMenuOpen(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getMenuOpen"))
					return Boolean.parseBoolean(ch.getData("getMenuOpen").toString());
			}
		}
		catch(Exception e){
		}
		return false;
	}
	public static String[] getMenuOptions(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null && ch.containsFieldHook("getMenuOptions"))
				return (String[])ch.getData("getMenuOptions");
		}
		catch(Exception e){
		}
		return new String[]{};
	}
	public static int getMenuY(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getMenuY")){
					return Integer.parseInt(ch.getData("getMenuY").toString()) * ch.getFieldHook("getMenuY").getMultiplier();
				}
			}
		}
		catch(Exception e){
		}
		return -1;
	}
	public static float getMinimapAngle(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null){
				FieldHook fh = ch.getFieldHook("getMinimapAngle");
				if(fh!=null){
					return Float.parseFloat(ch.getData("getMinimapAngle").toString());
				}
			}
		}
		catch(Exception e){
		}
		return -1;
	}
	public static int getMinimapOffset(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
				if(ch!=null){
					FieldHook fh = ch.getFieldHook("getMinimapOffset");
					if(fh!=null){
						int val = Integer.parseInt(ch.getData("getMinimapOffset").toString());
						int mul = fh.getMultiplier();
						return val*mul;
					}
				}
		}
		catch(Exception e){
		}
		return 1259255319;
	}
	public static int getMinimapScale(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
				if(ch!=null){
					FieldHook fh = ch.getFieldHook("getMinimapScale");
					if(fh!=null){
						int val = Integer.parseInt(ch.getData("getMinimapScale").toString());
						int mul = fh.getMultiplier();
						return val*mul;
					}
				}
		}
		catch(Exception e){
		}
		return -1803996982;
	}
	public static int getMinimapSetting(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null){
					FieldHook fh = ch.getFieldHook("getMinimapSetting");
					if(fh!=null){
						int val = Integer.parseInt(ch.getData("getMinimapSetting").toString());
						int mul = fh.getMultiplier();
						return val*mul;
					}
				}
			}
		}
		catch(Exception e){
		}
		return -334095207;
	}
	public static Object getMouse(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getMouse")){
					return ch.getData("getMouse");
				}
			}
		}
		catch(Exception e){
		}
		return null;
	}
	public static Player getMyPlayer(){
		return Players.getMyPlayer();
	}
	public static NPCNode[] getNPCNodeArray(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null && ch.containsFieldHook("getNPCNodeArray")){
				ArrayList<NPCNode> nodes = new ArrayList<NPCNode>();
				for(Object o : (Object[])ch.getData("getNPCNodeArray"))
					nodes.add(new NPCNode(o));
				return nodes.toArray(new NPCNode[]{});
			}
		}
		catch(Exception e){
		}
		return new NPCNode[]{};
	}
	public static ObjectDefLoader getObjectDefLoader(){
		for(ClassHook ch : Data.indentifiedClasses.values()){
			if(ch!=null && ch.containsFieldHook("getObjectDefLoader")){
				Object o = ch.getData("getObjectDefLoader");
				if(o!=null)
					return new ObjectDefLoader(o);
			}
		}
		return null;
	}
	public static String getPassword(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getPassword")){
					return ch.getData("getPassword").toString();
				}
			}
		}
		catch(Exception e){
		}
		return "";
	}
	public static int getPlane(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && !ch.getRefactoredName().equals("Interactable") && ch.containsFieldHook("getPlane")){
					return Integer.parseInt(ch.getData("getPlane").toString()) * ch.getFieldHook("getPlane").getMultiplier();
				}
			}
		}
		catch(Exception e){
		}
		return -1;
	}
	public static Player[] getPlayerArray(){
		return Players.getPlayerArray();
	}
	public static RenderLD getRenderLD(){
		for(ClassHook ch : Data.indentifiedClasses.values()){
			if(ch!=null && ch.containsFieldHook("getRender")){
				Object o = ch.getData("getRender");
				if(o!=null)
					return new RenderLD(o);
			}
		}
		return null;
	}
	public static Info getRSData(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getRSData")){
					Object data = ch.getData("getRSData");
					if(data!=null)
						return new Info(data);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getSelectedItemName(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null && ch.containsFieldHook("getSelectedItemName"))
				return ch.getData("getSelectedItemName").toString();
		}
		catch(Exception e){
		}
		return "";
	}
	public static float[] getTileData(){
		try{
			ClassHook ch = Data.indentifiedClasses.get("Client");
			if(ch!=null && ch.containsFieldHook("getTileData"))
				return (float[])ch.getData("getTileData");
		}
		catch(Exception e){
		}
		return new float[]{};
	}
	public static String getUsername(){
		try{
			for(ClassHook ch : Data.indentifiedClasses.values()){
				if(ch!=null && ch.containsFieldHook("getUsername")){
					return ch.getData("getUsername").toString();
				}
			}
		}
		catch(Exception e){
		}
		return "";
	}
}
