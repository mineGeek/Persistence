package com.github.mineGeek.Persistence;

import java.util.List;

public interface DataStore {

	/**
	 * Basic setting of an object to a column name. Whatever is set, is stored.
	 * @param ColumnName
	 * @param value
	 */
	public abstract void set(String ColumnName, Object value);

	/**
	 * Standard getting of object. Will return whatever has been set.
	 * @param columnName
	 * @return
	 */
	public abstract Object get(String columnName);

	/**
	 * gets an Object as an Integer
	 * @param columnName
	 * @param defaultValue
	 * @return
	 */
	public abstract Integer getAsInteger(String columnName, Integer defaultValue);

	public abstract Long getAsLong(String columnName, Long defaultValue);

	/**
	 * gets an object asserted to be a List<String>
	 * @param columnName
	 * @return
	 */
	public abstract List<String> getAsStringList(String columnName);

	/**
	 * gets an Object as a Boolean
	 * @param columnName
	 * @param defaultValue
	 * @return
	 */
	public abstract Boolean getAsBoolean(String columnName, Boolean defaultValue);

	/**
	 * Gets an Object as a string
	 * @param columnName
	 * @param defaultValue
	 * @return
	 */
	public abstract String getAsString(String columnName, String defaultValue);

	public abstract void setLocation( String pathOrDatabastName );
	public abstract void setName( String fileOrTableName );
	
	/**
	 * saves objects to a flat file
	 * @return
	 */
	public abstract Boolean save();

	/**
	 * loads objects from a flat file.
	 * @return
	 */
	public abstract Boolean load();

}