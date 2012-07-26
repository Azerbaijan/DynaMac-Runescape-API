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

import com.Marneus.Bot.API.Wrappers.HashTable;
import com.Marneus.Bot.API.Wrappers.Node;

public class Nodes {
	public static Node lookup(HashTable nc, long id) {
		try {
			if (nc == null || nc.getBuckets() == null || id < 0) {
				return null;
			}

			final Node n = nc.getBuckets()[(int) (id & nc.getBuckets().length - 1)];
			for (Node node = n.getPrevious(); node != n; node = node.getPrevious()) {
				if (node.getID() == id) {
					return node;
				}
			}
		} catch (final Exception ignored) {
		}
		return null;
	}
}
