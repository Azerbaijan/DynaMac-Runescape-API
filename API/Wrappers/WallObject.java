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

import com.Marneus.Bot.API.Methods.Calculations;
import com.Marneus.Bot.API.Methods.Client;
import com.Marneus.Enviroment.Data;
import com.Marneus.Enviroment.Hook.ClassHook;
import com.Marneus.Enviroment.Hook.ClassHook.FieldHook;

public class WallObject {
	public Object currentObject;
	public ClassHook currentHook;
	public WallObject(Object o){
		currentObject = o;
		currentHook = Data.indentifiedClasses.get("WallObject");
	}
	public WallObject(Object o, int locx, int locy){
		currentObject = o;
		currentHook = Data.indentifiedClasses.get("WallObject");
		locX=locx;
		locY=locy;
	}
	public Interactable getInteractable(){
		return new Interactable(currentObject);
	}
	public WallDecoration getWallDecoration(){
		return new WallDecoration(currentObject);
	}
	private int locX;
	private int locY;
	public int getID(){
		Object data = currentHook.getData("getID", currentObject);
		if(data!=null)
			return Integer.parseInt(data.toString()) * currentHook.getFieldHook("getID").getMultiplier();		
		return -1;		
	}
	public ModelLD getLDModel(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getModel")){
				Object data = fh.getData(currentObject);
				if(data!=null)
					return new ModelLD(data);
			}
		}		
		return null;
	}
	public int getLocationX(){
		try{
			return locX+Client.getRSData().getBaseInfo().getX();
		}
		catch(Exception e){
			
		}
		return -1;
	}
	public int getLocationY(){
		try{
			return locY+Client.getRSData().getBaseInfo().getY();
		}
		catch(Exception e){
			
		}
		return -1;
	}
	public double getLocalX(){
		try{
			return locX;
		}
		catch(Exception e){
			return -1;
		}
	}
	public double getLocalY(){
		try{
			return locY;
		}
		catch(Exception e){
			return -1;
		}
	}
	public int[][] projectVertices() {
		RenderLD renderData = Client.getRenderLD();
		Viewport render = renderData.getViewport();
		float[] data = render.getFloats();
		ModelLD model = getLDModel();
		double locX = (getLocalX()+0.5)*512;
		double locY = (getLocalY()+0.5)*512;
		int numVertices = Math.min(model.getVerticiesX().length, Math.min(model.getVerticiesY().length, model.getVerticiesZ().length));
		int[][] screen = new int[numVertices][3];

		float xOff = data[12];
		float yOff = data[13];
		float zOff = data[15];
		float xX = data[0];
		float xY = data[4];
		float xZ = data[8];
		float yX = data[1];
		float yY = data[5];
		float yZ = data[9];
		float zX = data[3];
		float zY = data[7];
		float zZ = data[11];

		int height = Calculations.tileHeight((int)locX, (int)locY);
		for (int index = 0; index < numVertices; index++) {
			int vertexX = (int) (model.getVerticiesX()[index] + locX);
			int vertexY = model.getVerticiesY()[index] + height;
			int vertexZ = (int) (model.getVerticiesZ()[index] + locY);
			
			float _z = (zOff + (zX * vertexX + zY * vertexY + zZ * vertexZ));
			float _x = (xOff + (xX * vertexX + xY * vertexY + xZ * vertexZ));
			float _y = (yOff + (yX * vertexX + yY * vertexY + yZ * vertexZ));
			
			float fx = ((float)256.0 + ((float)256.0 * _x) / _z);
			float fy = ((float)166.0 + ((float)167.0 * _y) / _z);
			if(fx<520 && fx>0 && fy<390 && fy>50){
				screen[index][0] = (int)fx;
				screen[index][1] = (int)fy;
				screen[index][2] = 1;
			}
			else{
				screen[index][0] = -1;
				screen[index][1] = -1;
				screen[index][2] = 0;
			}
		}
		return screen;
	}
}
