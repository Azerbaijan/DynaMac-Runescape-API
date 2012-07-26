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

public class ModelLD {
	public Object currentObject;
	public ClassHook currentHook;
	public ModelLD(Object o){
		currentObject = o;
		currentHook = Data.indentifiedClasses.get("ModelLD");
	}
	public Model getModel(){
		return new Model(currentObject);
	}
	public int[] getVerticiesX(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getVerticiesX")){
				Object data = fh.getData(currentObject);
				if(data!=null)
					return (int[])data;
			}
		}		
		return new int[]{};
	}
	public int[] getVerticiesY(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getVerticiesY")){
				Object data = fh.getData(currentObject);
				if(data!=null)
					return (int[])data;
			}
		}		
		return new int[]{};
	}
	public int[] getVerticiesZ(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getVerticiesZ")){
				Object data = fh.getData(currentObject);
				if(data!=null)
					return (int[])data;
			}
		}		
		return new int[]{};
	}
	public short[] getTriangleX(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getTriangleX")){
				Object data = fh.getData(currentObject);
				if(data!=null)
					return (short[])data;
			}
		}		
		return new short[]{};
	}
	public short[] getTriangleY(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getTriangleY")){
				Object data = fh.getData(currentObject);
				if(data!=null)
					return (short[])data;
			}
		}		
		return new short[]{};
	}
	public short[] getTriangleZ(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getTriangleZ")){
				Object data = fh.getData(currentObject);
				if(data!=null)
					return (short[])data;
			}
		}		
		return new short[]{};
	}
	public short[] getTriangleColor(){
		for(FieldHook fh : currentHook.getFieldHooks()){
			if(fh.getRefactoredName().equals("getTriangleColor")){
				Object data = fh.getData(currentObject);
				if(data!=null)
					return (short[])data;
			}
		}		
		return new short[]{};
	}
	public int[][] projectVertices(int localX, int localY) {
		RenderLD renderData = Client.getRenderLD();
		Viewport render = renderData.getViewport();
		float[] data = render.getFloats();
		double locX = (localX+0.5)*512;
		double locY = (localY+0.5)*512;
		int numVertices = Math.min(getVerticiesX().length, Math.min(getVerticiesY().length, getVerticiesZ().length));
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
			int vertexX = (int) (getVerticiesX()[index] + locX);
			int vertexY = getVerticiesY()[index] + height;
			int vertexZ = (int) (getVerticiesZ()[index] + locY);
			
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
