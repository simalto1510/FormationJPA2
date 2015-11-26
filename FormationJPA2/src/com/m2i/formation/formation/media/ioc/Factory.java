package com.m2i.formation.formation.media.ioc;

public class Factory {

	public Factory() {
		// TODO Auto-generated constructor stub
	}
	
	public Object genericFactory(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		//On fait un e factory generic
		//New instance envoit un object
		return Class.forName(name).newInstance(); //Le string est mieux car il peut etre saved dans un fichier
	}

}
