package com.irene.easymusic.dtd.parser;

import java.util.regex.Pattern;

public class DTDConstants {
	public static class DataType{
		
		public static final int TEXT = 0;
		// type "CDATA"
		public static final int CDATA = 1;
		//type "PCDATA"
		public static final int PCDATA = 2;
		// type "ID"
		public static final int ID = 3;
		// type "IDREF"
		public static final int IDREF = 4;
		// type "IDREFS"
		public static final int IDREFS = 5;
		// type "NMTOKEN"
		public static final int NMTOKEN = 6;
		// type "NMTOKENS"
		public static final int NMTOKENS = 7;
		// type "NOTATION"
		public static final int NOTATION = 8;
		//type "entity reference"
		public static final int ENTITY_REFERENCE = 9;

		public static int parseType(String typeName) throws DTDException {
			if ("CDATA".equals(typeName)) {
				return CDATA;
			} else if ("ID".equals(typeName)) {
				return ID;
			} else if ("IDREF".equals(typeName)) {
				return IDREF;
			} else if ("IDREFS".equals(typeName)) {
				return IDREFS;
			} else if ("NMTOKEN".equals(typeName)) {
				return NMTOKEN;
			} else if ("NMTOKENS".equals(typeName)) {
				return NMTOKENS;
			} else if ("NOTATION".equals(typeName)) {
				return NOTATION;
			} else if ("PCDATA".equals(typeName)) {
				return PCDATA;
			} else if ("ENTITY_REFERENCE".equals(typeName)) {
				return ENTITY_REFERENCE;
			} else {
				throw new DTDException(DTDException.ERROR_CODE_DEFINITION_NOT_FOUND,
						DTDException.ERROR_MSG_DEFINITION_NOT_FOUND);
			}
		}
	}
	
	
	public static class Patterns{
		
		public static final String REGULAR_NAME = "\\w+(-\\w+)*";

		public static final String REGULAR_XML_NAME = "\\s*xml:\\w+\\s*";

		public static final String REGULAR_ENUM_NAMES = "\\(\\s*" + REGULAR_NAME + "(\\s*\\|\\s*" + REGULAR_NAME
				+ "\\s*)*\\s*\\)";

		private static final String REGULAR_ENTITY_REFERENCE = "%\\w+(-\\w+)*;*";

		public static final String REGULAR_ATTRI_NAME = "(" + REGULAR_NAME + "|" + REGULAR_XML_NAME + ")";

		private static final String REGULAR_ATTR_ENUM_VALUE = "("
				+ REGULAR_ENUM_NAMES
				+ "|\\s*"
				+ REGULAR_ENTITY_REFERENCE
				+ "\\s*|\\s*CDATA\\s*|\\s*ID\\s*|\\s*IDREF\\s*|\\s*IDREFS\\s*|\\s*NMTOKEN\\s*|\\s*NMTOKENS\\s*|\\s*NOTATION\\s*)";

		private static final String REGULAR_ATTR_ENUM_EXISTENCE = "(\\s*#REQUIRED\\s*|\\s*#IMPLIED\\s*|\\s*#FIXED\\s*\\w*)";

		private static final String REGULAR_ATTRI_NAME_VALUE_EXISTENCE = "\\s*" + REGULAR_ATTRI_NAME + "\\s+"
				+ REGULAR_ATTR_ENUM_VALUE + "\\s+" + REGULAR_ATTR_ENUM_EXISTENCE + "\\s*";

		private static final String REGULAR_ATTR_CONTENT = "<!ATTLIST\\s*(" + REGULAR_NAME + ")\\s*((\\s*"
				+ REGULAR_ATTRI_NAME_VALUE_EXISTENCE + "|" + REGULAR_ENTITY_REFERENCE + "\\s*)+)\\s*>";

		private static final String REGULAR_ELEMENT_REFERENCE_NAME = "\\s*\\w+(-\\w+)*[\\?\\*\\+]\\s*";

		private static final String REGULAR_ELEMENT_SUB_ELEMENT_DEF = REGULAR_ELEMENT_REFERENCE_NAME + ",?\\s*|\\s*"
				+ REGULAR_ENTITY_REFERENCE + "\\s*,?\\s*";

		private static final String REGULAR_ELEMENT_CONTENT = "<!ELEMENT\\s*(" + REGULAR_NAME + ")\\s*\\((("
				+ REGULAR_ELEMENT_SUB_ELEMENT_DEF + ")+)\\s*\\)\\s*>";

		private static final String REGULAR_DOCTYPE_DECLARETION = "[^/]+(//[^/]+)+";

		private static final String REGULAR_FILE_URI = "\\s*.*\\s*|\\s*http.*\\s*";

		private static final String REGULAR_ENTITY_DEFINITION_VALUES_ONLY = "\\s*<!ENTITY\\s*%\\s*(" + REGULAR_NAME
				+ ")\\s*\"\\s*(" + REGULAR_ENUM_NAMES + ")\\s*\"\\s*>\\s*";

		private static final String REGULAR_ENTITY_DEFINITION_WITH_NAME = "\\s*<!ENTITY\\s*%\\s*(" + REGULAR_NAME
				+ ")\\s*\"\\s*((" + REGULAR_ATTRI_NAME_VALUE_EXISTENCE + ")+)\\s*\"\\s*>\\s*";

		private static final String REGULAR_ENTITY_INSTRUMENT = "\\s*<!ENTITY\\s*%\\s*(" + REGULAR_NAME + ")\\s*\""
				+ "(\\s*IGNORE|INCLUDE\\s*)" + "\\s*\"\\s*>\\s*";

		private static final String REGULAR_ENTITY_DOCUMENT_DEF = "\\s*<!ENTITY\\s*%\\s*(" + REGULAR_NAME
				+ ")\\s*(\\s*PUBLIC|SYSTEM\\s*)\\s*(\\s*\"\\s*" + REGULAR_DOCTYPE_DECLARETION + "\"\\s*)?\\s*\"\\s*("
				+ REGULAR_FILE_URI + ")\\s*\"\\s*>\\s*";

		
		public static Pattern mNameValueExistencePattern = null;
		
		public static Pattern getNameValueExistencePattern(){
			if(mNameValueExistencePattern == null){
				mNameValueExistencePattern = Pattern.compile(REGULAR_ATTRI_NAME_VALUE_EXISTENCE);
			}
			return mNameValueExistencePattern;
		}
		
		private static Pattern mEntityDefWithNamePattern = null;

		public static Pattern getEntityDefWithNamePattern() {
			if (mEntityDefWithNamePattern == null) {
				mEntityDefWithNamePattern = Pattern.compile(REGULAR_ENTITY_DEFINITION_WITH_NAME);
			}
			return mEntityDefWithNamePattern;
		}

		private static  Pattern mEntityDefValuesOnlyPattern = null;

		public static Pattern getEntityDefValuesOnlyPattern() {
			if (mEntityDefValuesOnlyPattern == null) {
				mEntityDefValuesOnlyPattern = Pattern.compile(REGULAR_ENTITY_DEFINITION_VALUES_ONLY);
			}
			return mEntityDefValuesOnlyPattern;
		}

		private static Pattern mEntityInstrumentPattern = null;

		public static Pattern getEntityInstrumentPattern() {
			if (mEntityInstrumentPattern == null) {
				mEntityInstrumentPattern = Pattern.compile(REGULAR_ENTITY_INSTRUMENT);
			}
			return mEntityInstrumentPattern;
		}

		private static Pattern mEntityDocumentDefPattern = null;

		public static Pattern getEntityDocDefPattern() {
			if (mEntityDocumentDefPattern == null) {
				mEntityDocumentDefPattern = Pattern.compile(REGULAR_ENTITY_DOCUMENT_DEF);
			}
			return mEntityDocumentDefPattern;
		}

		private static Pattern mCommonNamePattern = Pattern.compile(REGULAR_NAME);
		
		public static Pattern getCommonNamePattern(){
			return mCommonNamePattern;
		}
		
		private static Pattern mElementContentPattern = null;
		
		public static Pattern getElementContentPattern(){
			if(mElementContentPattern == null){
				mElementContentPattern = Pattern.compile(REGULAR_ELEMENT_CONTENT);
			}
			return mElementContentPattern;
		}
		
		private static Pattern mAttriContentPattern = null;
		public static Pattern getAttriContentPattern(){
			if(mAttriContentPattern == null){
				mAttriContentPattern = Pattern.compile(REGULAR_ATTR_CONTENT);
			}
			return mAttriContentPattern;
		}
	}
}
