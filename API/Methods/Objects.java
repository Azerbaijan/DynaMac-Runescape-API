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

import java.util.ArrayList;

import com.Marneus.Bot.API.Wrappers.AnimableObject;
import com.Marneus.Bot.API.Wrappers.BoundaryObject;
import com.Marneus.Bot.API.Wrappers.FloorObject;
import com.Marneus.Bot.API.Wrappers.Ground;
import com.Marneus.Bot.API.Wrappers.WallObject;

public class Objects {
	public static FloorObject[] getAllFloorObjects(){
		try{
			ArrayList<FloorObject> allObjects = new ArrayList<FloorObject>();
			Ground[][][] array = Client.getRSData().getGroundInfo().getGroundArray();
			Ground[][] a1 = array[Client.getPlane()];
			int x=0;
			for(Ground[] a2 : a1){
				int y=0;
				for(Ground gd : a2){
					if(gd.getFloorDecoration()!=null){
						FloorObject fo = new FloorObject(gd.getFloorDecoration().getFloorObject().currentObject, x, y);
						if(fo!=null)
							allObjects.add(fo);
					}
					y++;
				}
				x++;
			}
			return allObjects.toArray(new FloorObject[]{});
		}
		catch(Exception e){

		}
		return new FloorObject[]{};
	}
	public static WallObject[] getAllWallObjects(){
		try{
			ArrayList<WallObject> allObjects = new ArrayList<WallObject>();
			Ground[][][] array = Client.getRSData().getGroundInfo().getGroundArray();
			Ground[][] a1 = array[Client.getPlane()];
			int x=0;
			for(Ground[] a2 : a1){
				int y=0;
				for(Ground gd : a2){
					if(gd.getWallDecoration1()!=null){
						WallObject fo = new WallObject(gd.getWallDecoration1().getWallObject().currentObject, x, y);
						if(fo!=null)
							allObjects.add(fo);
					}
					if(gd.getWallDecoration2()!=null){
						WallObject fo = new WallObject(gd.getWallDecoration2().getWallObject().currentObject, x, y);
						if(fo!=null)
							allObjects.add(fo);
					}
					y++;
				}
				x++;
			}
			return allObjects.toArray(new WallObject[]{});
		}
		catch(Exception e){

		}
		return new WallObject[]{};
	}
	public static BoundaryObject[] getAllBoundaryObjects(){
		try{
			ArrayList<BoundaryObject> allObjects = new ArrayList<BoundaryObject>();
			Ground[][][] array = Client.getRSData().getGroundInfo().getGroundArray();
			Ground[][] a1 = array[Client.getPlane()];
			int x=0;
			for(Ground[] a2 : a1){
				int y=0;
				for(Ground gd : a2){
					if(gd.getBoundary1()!=null){
						BoundaryObject fo = new BoundaryObject(gd.getBoundary1().getBoundaryObject().currentObject, x, y);
						if(fo!=null)
							allObjects.add(fo);
					}
					if(gd.getBoundary2()!=null){
						BoundaryObject fo = new BoundaryObject(gd.getBoundary2().getBoundaryObject().currentObject, x, y);
						if(fo!=null)
							allObjects.add(fo);
					}
					y++;
				}
				x++;
			}
			return allObjects.toArray(new BoundaryObject[]{});
		}
		catch(Exception e){

		}
		return new BoundaryObject[]{};
	}
	public static AnimableObject[] getAllAnimableObjects(){
		try{
			ArrayList<AnimableObject> allObjects = new ArrayList<AnimableObject>();
			Ground[][][] array = Client.getRSData().getGroundInfo().getGroundArray();
			Ground[][] a1 = array[Client.getPlane()];
			for(Ground[] a2 : a1){
				for(Ground gd : a2){
					if(gd.getAnimableList()!=null){
						AnimableObject fo = new AnimableObject(gd.getAnimableList().getAnimable().currentObject);
						if(fo!=null)
							allObjects.add(fo);
					}
				}
			}
			return allObjects.toArray(new AnimableObject[]{});
		}
		catch(Exception e){

		}
		return new AnimableObject[]{};
	}
	public static Object[] getAllObjects(){
		try{
			ArrayList<Object> allObjects = new ArrayList<Object>();

			Ground[][][] array = Client.getRSData().getGroundInfo().getGroundArray();
			Ground[][] a1 = array[Client.getPlane()];
			int x=0;
			for(Ground[] a2 : a1){
				int y=0;
				for(Ground gd : a2){
					try{
						if(gd.getFloorDecoration()!=null){
							FloorObject fo = new FloorObject(gd.getFloorDecoration().getFloorObject().currentObject, x, y);
							if(fo!=null)
								allObjects.add(fo);
						}
						if(gd.getWallDecoration1()!=null){
							WallObject fo = new WallObject(gd.getWallDecoration1().getWallObject().currentObject, x, y);
							if(fo!=null)
								allObjects.add(fo);
						}
						if(gd.getWallDecoration2()!=null){
							WallObject fo = new WallObject(gd.getWallDecoration2().getWallObject().currentObject, x, y);
							if(fo!=null)
								allObjects.add(fo);
						}
						if(gd.getBoundary1()!=null){
							BoundaryObject fo = new BoundaryObject(gd.getBoundary1().getBoundaryObject().currentObject, x, y);
							if(fo!=null)
								allObjects.add(fo);
						}
						if(gd.getBoundary2()!=null){
							BoundaryObject fo = new BoundaryObject(gd.getBoundary2().getBoundaryObject().currentObject, x, y);
							if(fo!=null)
								allObjects.add(fo);
						}
						if(gd.getAnimableList()!=null){
							AnimableObject fo = new AnimableObject(gd.getAnimableList().getAnimable().currentObject);
							if(fo!=null)
								allObjects.add(fo);
						}
					}
					catch(Exception e){

					}
					y++;
				}
				x++;
			}
			return allObjects.toArray(new Object[]{});
		}
		catch(Exception e){

		}
		return new Object[]{};
	}
	public Object getObjectByID(int id){
		for(Object o : getAllObjects()){
			if(o instanceof AnimableObject && ((AnimableObject) o).getID()==id)
				return o;
			if(o instanceof WallObject && ((WallObject) o).getID()==id)
				return o;
			if(o instanceof FloorObject && ((FloorObject) o).getID()==id)
				return o;
			if(o instanceof BoundaryObject && ((BoundaryObject) o).getID()==id)
				return o;
		}
		return null;
	}
}
