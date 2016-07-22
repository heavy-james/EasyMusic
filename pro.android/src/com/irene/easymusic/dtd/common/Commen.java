package com.irene.easymusic.dtd.common;

/**
 * <!-- The common DTD module contains the entities and elements that are shared
 * among multiple component DTDs. -->
 *
 *
 * <!ENTITY % common PUBLIC "-//Recordare//ELEMENTS MusicXML 3.0 Common//EN"
 * "common.mod"> %common;
 * 
 * <!-- This file contains entities and elements that are common across multiple
 * DTD modules. In particular, several elements here are common across both
 * notes and measures. -->
 */
public class Commen {

	public static final String NAME = "common";
	public static final String DESCRIPTION = "-//Recordare//ELEMENTS MusicXML 3.0 Common//EN";
	public static final String TAG = "CommenEntity";
	public static final String FILE_PATH = "common.mod";

	private Isolate1 mIsolate1;
	
	private Isolate2 mIsolate2;
	
	private Date mDate;
	
	/**
	 * <!-- Entities -->
	 */

	/**
	 * <!-- Data type entities. The ones that resolve to strings show intent for
	 * how data is formatted and used. -->
	 * 
	 * <!-- Calendar dates are represented yyyy-mm-dd format, following ISO
	 * 8601. -->
	 *
	 * <!ENTITY % yyyy-mm-dd "(#PCDATA)">
	 */
	public static class Date {
		private String mData;
		public Date(String pcdata){
			mData = pcdata;
		}
		
		public String getTime(){
			return mData;
		}
	}

	/**
	 * <!-- The tenths entity is a number representing tenths of interline space
	 * (positive or negative) for use in attributes. The layout-tenths entity is
	 * the same for use in elements. Both integer and decimal values are
	 * allowed, such as 5 for a half space and 2.5 for a quarter space.
	 * Interline space is measured from the middle of a staff line. -->
	 * 
	 * <!ENTITY % tenths "CDATA">
	 * 
	 * 行间距
	 */
	public static class Tenths {
		private String mData;
		public Tenths(String cdata){
			mData = cdata;
		}
		
		public int getTenths(){
			return Integer.valueOf(mData);
		}
	}

	/**
	 * 
	 * <!ENTITY % layout-tenths "(#PCDATA)">
	 */
	public static class LayoutTenths {
		private Tenths mTenths;
		public LayoutTenths(String pcdata){
			mTenths = new Tenths(pcdata);
		}
		
		public int getTenths(){
			return mTenths.getTenths();
		}
	}

	/**
	 * <!-- The start-stop and start-stop-continue entities are used for musical
	 * elements that can either start or stop, such as slurs, tuplets, and
	 * wedges. The start-stop-continue entity is used when there is a need to
	 * refer to an intermediate point in the symbol, as for complex slurs or for
	 * specifying formatting of symbols across system breaks. The
	 * start-stop-single entity is used when the same element is used for
	 * multi-note and single-note notations, as for tremolos.
	 * 
	 * The values of start, stop, and continue refer to how an element appears
	 * in musical score order, not in MusicXML document order. An element with a
	 * stop attribute may precede the corresponding element with a start
	 * attribute within a MusicXML document. This is particularly common in
	 * multi-staff music. For example, the stopping point for a slur may appear
	 * in staff 1 before the starting point for the slur appears in staff 2
	 * later in the document. -->
	 * 
	 * <!ENTITY % start-stop "(start | stop)">
	 */
	public static class StartStop {
		
		public static final String START = "start";
		public static final String STOP = "stop";
		protected String mEntry;
		public StartStop(String entry){
			mEntry = entry;
		}
		
		public String getEntry(){
			return mEntry;
		}
	}

	/**
	 * 
	 * <!ENTITY % start-stop-continue "(start | stop | continue)">
	 * 
	 */
	public static class StartStopConinue extends StartStop{
		public static final String CONTINUE = "continue";
		public StartStopConinue(String entry) {
			super(entry);
		}
		
	}

	/**
	 * <!ENTITY % start-stop-single "(start | stop | single)">
	 */
	public static class StartStopSingle extends StartStop{

		public static final String SINGLE = "single";
		public StartStopSingle(String entry) {
			super(entry);
			// TODO Auto-generated constructor stub
		}
		
	}

	/**
	 * <!-- The yes-no entity is used for boolean-like attributes. -->
	 * 
	 * <!ENTITY % yes-no "(yes | no)">
	 * 
	 */
	public static class YesNo {

	}

	/**
	 * <!-- The yes-no-number entity is used for attributes that can be either
	 * boolean or numeric values. Values can be "yes", "no", or numbers. -->
	 * 
	 * <!ENTITY % yes-no-number "NMTOKEN">
	 */
	public static class YesNoNumber {

	}

	/**
	 * <!-- The symbol-size entity is used to indicate full vs. cue-sized vs.
	 * oversized symbols. The large value for oversized symbols was added in
	 * version 1.1. -->
	 * 
	 * <!ENTITY % symbol-size "(full | cue | large)">
	 */
	public static class SymbolSize {

	}
}
