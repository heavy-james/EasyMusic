package com.irene.easymusic.dtd.attribute;

import com.irene.easymusic.dtd.DTDParser;

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
	 * 
	 * <!ENTITY % time-separator "separator (none | horizontal | diagonal |
	 * vertical | adjacent) #IMPLIED">
	 */
	public static class TimeSeparator {
		public static final String NAME = "time-separator";
		public static final String ELMT_SEPARATOR = NAME
				+ DTDParser.ENTITY_SEPARATOR + "separator";
		/**
		 * The none value represents no separator with the beats and beat-type
		 * arranged vertically
		 */
		public static final String CSTT_ELMT_SEPARATOR_NONE = ELMT_SEPARATOR
				+ DTDParser.VALUE_SEPARATOR + "none";
		/**
		 * horizontal line
		 */
		public static final String CSTT_ELMT_SEPARATOR_HORIZONTAL = ELMT_SEPARATOR
				+ DTDParser.VALUE_SEPARATOR + "horizontal";
		/**
		 * lower-left to upper-right line
		 */
		public static final String CSTT_ELMT_SEPARATOR_DIAGONAL = ELMT_SEPARATOR
				+ DTDParser.VALUE_SEPARATOR + "diagonal";
		/**
		 * vertical line
		 */
		public static final String CSTT_ELMT_SEPARATOR_VERTICAL = ELMT_SEPARATOR
				+ DTDParser.VALUE_SEPARATOR + "vertical";
		/**
		 * The none value represents no separator with the beats and beat-type
		 * arranged horizontally
		 */
		public static final String CSTT_ELMT_SEPARATOR_ADJACENT = ELMT_SEPARATOR
				+ DTDParser.VALUE_SEPARATOR + "adjacent";
	}

	/**
	 * <!-- The time-symbol entity indicates how to display a time signature.
	 * The normal value is the usual fractional display, and is the implied
	 * symbol type if none is specified. Other options are the common and cut
	 * time symbols, as well as a single number with an implied denominator. The
	 * note symbol indicates that the beat-type should be represented with the
	 * corresponding downstem note rather than a number. The dotted-note symbol
	 * indicates that the beat-type should be represented with a dotted downstem
	 * note that corresponds to three times the beat-type value, and a numerator
	 * that is one third the beats value. -->
	 * 
	 * <!ENTITY % time-symbol "symbol (common | cut | single-number | note |
	 * dotted-note | normal) #IMPLIED">
	 */
	public static class TimeSymbol {
		public static final String NAME = "time-symbol";

		public static final String ELMT_SYMBOL = NAME
				+ DTDParser.ENTITY_SEPARATOR + "symbol";

		public static final String CSTT_ELMT_SYMBOL_NORMAL = ELMT_SYMBOL
				+ DTDParser.VALUE_SEPARATOR + "normal";

		public static final String CSTT_ELMT_SYMBOL_CUT = ELMT_SYMBOL
				+ DTDParser.VALUE_SEPARATOR + "cut";

		public static final String CSTT_ELMT_SYMBOL_SINGLE_NUMBER = ELMT_SYMBOL
				+ DTDParser.VALUE_SEPARATOR + "single-number";

		public static final String CSTT_ELMT_SYMBOL_NOTE = ELMT_SYMBOL
				+ DTDParser.VALUE_SEPARATOR + "note";

		public static final String CSTT_ELMT_SYMBOL_DOTTED_NOTE = ELMT_SYMBOL
				+ DTDParser.VALUE_SEPARATOR + "dotted-note";

		public static final String CSTT_ELMT_SYMBOL_NORMAL_COMMON = ELMT_SYMBOL
				+ DTDParser.VALUE_SEPARATOR + "common";
		
		public String symbol = CSTT_ELMT_SYMBOL_NORMAL;
	}

	/**
	 * <!-- Elements -->
	 */

	/**
	 * 
	 <!-- The attributes element contains musical information that typically
	 * changes on measure boundaries. This includes key and time signatures,
	 * clefs, transpositions, and staving. When attributes are changed
	 * mid-measure, it affects the music in score order, not in MusicXML
	 * document order. -->
	 * 
	 * <!ELEMENT attributes (%editorial;, divisions?, key*, time*, staves?,
	 * part-symbol?, instruments?, clef*, staff-details*, transpose*,
	 * directive*, measure-style*)>
	 */
	public String editorial = null;
	public String divisions = null;
	public String key = null;
	public String time = null;
	
}
