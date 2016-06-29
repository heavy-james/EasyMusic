package com.irrene.easymusic.data;

/**
 * <!-- The attributes DTD module contains elements that usually change at the
 * start of a measure, such as key signatures, time signatures, and clefs. -->
 *
 * <!-- MusicXML™ attributes.mod module
 * 
 * Version 3.0
 * 
 * Copyright © 2004-2011 MakeMusic, Inc. http://www.makemusic.com/
 * 
 * This MusicXML™ work is being provided by the copyright holder under the
 * MusicXML Public License Version 3.0, available from:
 * 
 * http://www.musicxml.org/dtds/license.html -->
 * 
 * <!-- The attributes DTD module contains the attributes element and its
 * children, such as key and time signatures. -->
 */
public class Attributes {
	public static final String NAME = "attributes";
	public static final String DESCRIPTION = "-//Recordare//ELEMENTS MusicXML 3.0 Attributes//EN";
	public static final String TAG = "AttributesEntity";
	public static final String FILE_PATH = "attributes.mod";

	/**
	 * <!-- Entities -->
	 */

	/**
	 * <!-- The time-separator entity indicates how to display the arrangement
	 * between the beats and beat-type values in a time signature. The default
	 * value is none. The horizontal, diagonal, and vertical values represent
	 * horizontal, diagonal lower-left to upper-right, and vertical lines
	 * respectively. For these values, the beats and beat-type values are
	 * arranged on either side of the separator line. The none value represents
	 * no separator with the beats and beat-type arranged vertically. The
	 * adjacent value represents no separator with the beats and beat-type
	 * arranged horizontally. -->
	 */
	public static class TimeSeparator{
		private DataNode separator;
	}
}
