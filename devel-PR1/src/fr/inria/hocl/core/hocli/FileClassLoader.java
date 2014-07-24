package fr.inria.hocl.core.hocli;


import java.util.*;
import java.io.*;

public class FileClassLoader extends ClassLoader {

	String dirName;

	@SuppressWarnings( "unchecked" )
	Hashtable<String, Class> cache = new Hashtable<String, Class>();


	public FileClassLoader( String dirName ) {
		super();
		this.dirName = dirName;
	}


	private byte[] loadClassData( String className )
			throws ClassNotFoundException {
		String fileName = dirName
				+ ( dirName.endsWith( File.separator ) ? "" : File.separator )
				+ className.replace( '.', File.separatorChar ) + ".class";
		System.out.println( "Loading " + fileName + "..." );
		try {
			File file = new File( fileName );
			if( file.length() > Integer.MAX_VALUE ) {
				throw new ClassNotFoundException();

			}
			int len = ( int ) file.length();
			byte[] result = new byte[len];

			FileInputStream input = new FileInputStream( file );
			int offset = 0;
			int nb = 0;
			while( len != 0 && ( ( nb = input.read( result, offset, len ) ) != -1 ) ) {
				offset += nb;
				len -= nb;
			}
			input.close();
			return result;
		} catch( Exception e ) {
			System.out.println( "PROBLEMS: " + e );
			throw new ClassNotFoundException();
		}
	}


	@SuppressWarnings( "unchecked" )
	public synchronized Class loadClass( String name, boolean resolve )
			throws ClassNotFoundException {
		try {
			Class c = cache.get( name );
			if( c == null ) {
				byte data[] = loadClassData( name );
				System.out.println( "Name: " + name );
				System.out.println( "Length: " + data.length );
				c = defineClass( name, data, 0, data.length );
				cache.put( name, c );
			}
			if( resolve )
				resolveClass( c );
			return c;
		} catch( Exception e ) {
			System.out.println( "Problems: " + e );
			return null;
		}
	}

}
