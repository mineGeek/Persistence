package com.github.mineGeek.Persistence;

import java.io.File;

/**
 * Base object for saving/loading data
 * from flat file
 *
 */
public class FileStore extends DataStoreBase {

	
	/**
	 * Constructor - takes the data folder to work from
	 * @param dataFolder
	 */
	public FileStore( String location, String name  ) {
		super(location, name);
	}
		
	
	/**
	 * Convenience method for returning full read/write path
	 * @return
	 */
	public String getFullFileName() {

		String result = this.location + File.separator + this.name;
		return result;
	}
	
	private void checkFolderLocation() {
		
    	File file = new File( location );
    	
    	if ( !file.isDirectory() ) {
    		try {
    			
    			String sub = location.replace( File.separator, "@@@@" );
    			String[] parts = sub.split( "@@@@" );
    			String partBuild = null;
    			
    			for( String x : parts ) {
    				
    				if ( partBuild == null ) {
    					partBuild = x;
    				} else {
    					partBuild = partBuild + File.separator + x;
    				}
    				
    				file = new File( partBuild );
    				if ( !file.isDirectory() ) file.mkdir();
    				
    			}
    		} catch (Exception e ) {

    		}
    	}		
		
	}
	
	/* (non-Javadoc)
	 * @see com.github.mineGeek.Persistence.DataStore#save()
	 */
	@Override
	public Boolean save() {
		
		checkFolderLocation();
		
    	try {
			 SLAPI.save( this.data, this.getFullFileName() );
			 return true;
			 
		} catch (Exception e) { 
			e.printStackTrace();
		}		
		
    	return false;
	}
	
	
	/* (non-Javadoc)
	 * @see com.github.mineGeek.Persistence.DataStore#load()
	 */
	@Override
	public Boolean load() {
		
		try {
			this.data = SLAPI.load( this.getFullFileName() );
			return true;
			
		} catch ( Exception e ) {}
		
		return false;
		
	}

	
}
