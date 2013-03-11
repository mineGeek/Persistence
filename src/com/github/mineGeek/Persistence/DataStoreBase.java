package com.github.mineGeek.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class DataStoreBase implements DataStore {
	
	/**
	 *  Map of columnName => Object to store
	 */
	public Map<String, Object> data = new HashMap<String, Object>();
		
	
	/**
	 * Default file name.
	 */
	public String name 	= "data.bin";
		
	
	/**
	 * Path to save/load from
	 */
	public 	String location = null;
	
	
	/**
	 * Constructor - takes the data folder to work from
	 * @param dataFolder
	 */
	public DataStoreBase( String location, String name  ) {
		this.location = location;
		this.name = name;
	}
	
	public String getLocation() { return location; }
	public String getName() { return name; }
	
	
	/* (non-Javadoc)
	 * @see com.github.mineGeek.Persistence.DataStore#set(java.lang.String, java.lang.Object)
	 */
	@Override
	public void set( String ColumnName, Object value ) {
		this.data.put(ColumnName, value);
	}

	
	/* (non-Javadoc)
	 * @see com.github.mineGeek.Persistence.DataStore#get(java.lang.String)
	 */
	@Override
	public Object get( String columnName ) {		
		return this.data.get( columnName );		
	}
	
	
	/* (non-Javadoc)
	 * @see com.github.mineGeek.Persistence.DataStore#getAsInteger(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Integer getAsInteger( String columnName, Integer defaultValue ) {
		
		Object value = this.get( columnName );		
		if ( value == null ) return defaultValue;
		return (Integer)this.get( columnName );
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.github.mineGeek.Persistence.DataStore#getAsLong(java.lang.String, java.lang.Long)
	 */
	@Override
	public Long getAsLong( String columnName, Long defaultValue ) {
		Object value = this.get( columnName );
		if ( value == null ) return defaultValue;
		return (Long)this.get( columnName );
	}
	
	
	/* (non-Javadoc)
	 * @see com.github.mineGeek.Persistence.DataStore#getAsStringList(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getAsStringList( String columnName ) {
		
		Object value = this.get(columnName);
		
		try 				{ return ( ArrayList<String> )value; }
		catch (Exception e ){ return new ArrayList<String>(); }
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.github.mineGeek.Persistence.DataStore#getAsBoolean(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public Boolean getAsBoolean( String columnName, Boolean defaultValue ) {
		
		Object value = this.get( columnName );
		if ( value == null ) return defaultValue;
		return (Boolean)value;
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.github.mineGeek.Persistence.DataStore#getAsString(java.lang.String, java.lang.String)
	 */
	@Override
	public String getAsString( String columnName, String defaultValue ) {
		
		Object value = this.get( columnName );
		if ( value == null ) return defaultValue;
		return value.toString();
		
	}



	@Override
	public void setLocation(String path) {
		location = path;
		
	}


	@Override
	public void setName(String fileName ) {
		name = fileName;		
	}
}
