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
import com.Marneus.Bot.API.Methods.Nodes;
import com.Marneus.Enviroment.Data;
import com.Marneus.Enviroment.Hook.ClassHook;
import com.Marneus.Enviroment.Hook.ClassHook.FieldHook;

public class AnimableObject {
	public Object currentObject;
	public ClassHook currentHook;
	public AnimableObject(Object o){
		currentObject = o;
		currentHook = Data.indentifiedClasses.get("AnimableObject");
	}
	public Interactable getInteractable(){
		return new Interactable(currentObject);
	}
	public Animable getAnimable(){
		return new Animable(currentObject);
	}
	public int getID(){
		Object data = currentHook.getData("getID", currentObject);
		if(data!=null)
			return Integer.parseInt(data.toString()) * currentHook.getFieldHook("getID").getMultiplier();		
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
			return new Animable(currentObject).getMinY()+Client.getRSData().getBaseInfo().getY();
		}
		catch(Exception e){
			return -1;
		}
	}
	public double getLocalX(){
		try{
			Animable o = new Animable(currentObject);
			return ((double)o.getMaxX());
		}
		catch(Exception e){
			return -1;
		}
	}
	public double getLocalY(){
		try{
			Animable o = new Animable(currentObject);
			return ((double)o.getMinY());
		}
		catch(Exception e){
			return -1;
		}
	}
	public ObjectDef getObjectDef(){
		try{
			Node ref = Nodes.lookup(Client.getObjectDefLoader().getCache().getTable(), (long)getID());
			if (ref.currentHook.getClassName().equals(Data.indentifiedClasses.get("HardReference").getClassName())) {
				HardReference hr = new HardReference(ref.currentObject);
				return new ObjectDef(hr.getHardReference());
			} 
			else if (ref.currentHook.getClassName().equals(Data.indentifiedClasses.get("SoftReference").getClassName())) {
				SoftReference sr = new SoftReference(ref.currentObject);
				Object def = sr.getReference().currentObject;
				if (def != null) {
					return new ObjectDef(def);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public ObjectDefLoader getObjectDefLoader(){
		FieldHook fh = currentHook.getFieldHook("getObjectDefLoader");
		if(fh!=null){
			Object data = fh.getData(currentObject);
			if(data!=null)
				return new ObjectDefLoader(data);
		}
		return null;
	}
	public ModelLD getLDModel(){
		FieldHook fh = currentHook.getFieldHook("getModel");
		if(fh!=null){
			Object data = fh.getData(currentObject);
			if(data!=null)
				return new ModelLD(data);
		}		
		return null;
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
