package com.irene.easymusic.dtd.parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;

public class DTDDocument {

	public static final String TAG = "DTDDocument";
	private String mFilePath;
	private InputStream mInputStream;
	private BufferedInputStream mBufferedInputStream;
	private List<DTDNode> mDefinedNodes;
	private List<DTDNode> mEntitys;
	private List<DTDNode> mEntityReference;
	private byte[] mBuffer = new byte[1024];
	private String mCurrentParseString = null;
	private String mEncoding = null;

	private DTDDocument() {

	}

	public static DTDDocument loadFile(String filePath, String encoding) throws FileNotFoundException, IOException {
		DTDDocument instance = new DTDDocument();
		instance.mFilePath = filePath;
		File file = new File(filePath);
		instance.mInputStream = new FileInputStream(file);
		instance.mBufferedInputStream = new BufferedInputStream(instance.mInputStream);
		instance.mEncoding = encoding;
		instance.mDefinedNodes = new LinkedList<DTDNode>();
		instance.mEntitys = new LinkedList<DTDNode>();
		instance.mEntityReference = new LinkedList<DTDNode>();
		return instance;
	}

	public DTDNode getNextNode() throws DTDException {
		if (hasNextNode()) {
			int startPos = mCurrentParseString.indexOf("<!");
			int endPos = mCurrentParseString.indexOf(">");
			String content = mCurrentParseString.substring(startPos, endPos);
			DTDNode node = null;
			if (content.startsWith("<!--") && content.endsWith("-->")) {
				node = getCommentNode(content);
			} else if (content.startsWith("<!ATTLIST")) {

			} else if (content.startsWith("<!ENTITY") && content.contains("%")) {

			} else if (content.startsWith("<!ENTITY")) {

			} else if (content.startsWith("<!ELEMENT")) {

			} else {
				try {
					throw new DTDException(DTDException.ERROR_CODE_FORMAT, DTDException.ERROR_MSG_FORMAT);
				} catch (DTDException e) {
					e.printStackTrace();
				}
			}
			if (mCurrentParseString.length() >= endPos + 1) {
				mCurrentParseString = mCurrentParseString.substring(endPos + 1, mCurrentParseString.length());
			} else {
				mCurrentParseString = null;
			}
		}
		return null;
	}

	public boolean hasNextNode() {
		if (mCurrentParseString == null || !contanisNode(mCurrentParseString)) {
			String temp = null;
			StringBuffer sb = new StringBuffer(mCurrentParseString);
			do {
				temp = readNextString();
				sb.append(temp);
			} while (temp != null && !contanisNode(sb.toString()));
			mCurrentParseString = sb.toString();
		}
		if (mCurrentParseString != null && contanisNode(mCurrentParseString)) {
			return true;
		}
		return false;
	}

	private boolean contanisNode(String data) {
		if (data != null) {
			if (data.contains("<!") && data.contains(">")) {
				return true;
			}
		}
		return false;
	}

	private String readNextString() {
		if (mBufferedInputStream != null) {
			try {
				int length = mBufferedInputStream.read(mBuffer);
				if (length != -1) {
					return new String(mBuffer, mEncoding);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void release() throws IOException {
		if (mBufferedInputStream != null) {
			mBufferedInputStream.close();
		}
		if (mInputStream != null) {
			mInputStream.close();
		}
	}

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

	private static final String REGULAR_ATTR_CONTENT = "(\\s*" + REGULAR_ATTRI_NAME_VALUE_EXISTENCE + "|\\s*"
			+ REGULAR_ENTITY_REFERENCE + "\\s*)";

	private static final String REGULAR_ELEMENT_REFERENCE_NAME = "\\s*\\w+(-\\w+)*[\\?\\*\\+]\\s*";

	private static final String REGULAR_ELEMENT_SUB_ELEMENT_DEF = REGULAR_ELEMENT_REFERENCE_NAME + ",?\\s*|\\s*"
			+ REGULAR_ENTITY_REFERENCE + "\\s*,?\\s*";

	private static final String REGULAR_ELEMENT_CONTENT = "\\s*" + REGULAR_NAME + "\\s*\\(("
			+ REGULAR_ELEMENT_SUB_ELEMENT_DEF + ")+\\s*\\)\\s*";

	private static final String REGULAR_DOCTYPE_DECLARETION = "[^/]+(//[^/]+)+";

	private static final String REGULAR_FILE_URI = "\\s*.*\\s*|\\s*http.*\\s*";

	private static final String REGULAR_ENTITY_DEFINITION = "\\s*%\\s*" + REGULAR_NAME + "\\s*\"\\s*"
			+ REGULAR_ATTRI_NAME_VALUE_EXISTENCE + "\\s*\"\\s*";

	private static final String REGULAR_ENTITY_INSTRUMENT = "\\s*%\\s*" + REGULAR_NAME + "\\s*\""
			+ "(\\s*IGNORE|INCLUDE\\s*)" + "\\s*\"";

	private static final String REGULAR_ENTITY_DOCUMENT_DEF = "\\s*%\\s*" + REGULAR_NAME
			+ "\\s*(\\s*PUBLIC|SYSTEM\\s*)\\s*(\\s*\"\\s*" + REGULAR_DOCTYPE_DECLARETION + "\"\\s*)?\\s*\"\\s*"
			+ REGULAR_FILE_URI + "\\s*\"\\s*";

	private DTDNode getAttriNode(String content) throws DTDException {

		DTDNode node = null;
		if (content != null && content.startsWith("<!ATTLIST") && content.endsWith(">")) {
			content = content.substring("<!ATTLIST".length(), content.length() - ">".length());
			Pattern pattern = Pattern.compile(REGULAR_NAME);
			Matcher matcher = pattern.matcher(content);
			String elementName = null;
			if (matcher.find()) {
				elementName = matcher.group();
				content = content.substring(matcher.start() + elementName.length());
			} else {
				throw new DTDException(DTDException.ERROR_CODE_DEFINITION_NOT_FOUND,
						DTDException.ERROR_MSG_DEFINITION_NOT_FOUND + ",element name not found in attri list");
			}

			List<String> attriStrs = null;

			if (elementName != null) {
				pattern = Pattern.compile(REGULAR_ATTR_CONTENT);
				matcher = pattern.matcher(content);
				if (matcher.find()) {
					attriStrs = new ArrayList<String>();
					do {
						String attrStr = matcher.group();
						attriStrs.add(attrStr);
					} while (matcher.find());
				} else {
					throw new DTDException(DTDException.ERROR_CODE_DEFINITION_NOT_FOUND,
							DTDException.ERROR_MSG_DEFINITION_NOT_FOUND + ",no attri found in attri list");

				}
			}

			if (attriStrs != null) {
				Pattern attriDefPattern = Pattern.compile(REGULAR_ATTRI_NAME_VALUE_EXISTENCE);
				Pattern entityRefPattern = Pattern.compile(REGULAR_ENTITY_REFERENCE);
				node = new DTDNode(DTDNode.NODE_TYPE_ATTRIBUTE, elementName, mFilePath);

				for (String attrStr : attriStrs) {
					Matcher attriMatcher = attriDefPattern.matcher(attrStr);
					String attrValue = attriMatcher.group(3);
					if (attriMatcher.matches()) {
						AttriInfo attri = null;
						if (Pattern.matches(REGULAR_ENUM_NAMES, attrValue)) {
							// 值定义
							attri = new AttriInfo(elementName, AttriInfo.TYPE_TEXT, attriMatcher.group(1));
							String[] values = attrValue.substring("(".length(), attrValue.length() - ")".length())
									.split("|");
							for (String value : values) {
								// 此处包含了被引用的实体名称，后续还需要处理
								attri.addAttriValue(value);
							}

						} else if (Pattern.matches(REGULAR_ENTITY_REFERENCE, attrValue)) {
							// 实体引用
							attri = new AttriInfo(elementName, AttriInfo.TYPE_ENTITY_REFERENCE, attriMatcher.group(1));
							DTDNode entityRef = new DTDNode(DTDNode.NODE_TYPE_ENTITY_REFERENCE, attrValue, mFilePath);
							node.addChild(entityRef);

						} else {
							// 固定类型
							attri = new AttriInfo(elementName, AttriInfo.parseAttriType(attrValue), attrValue);

						}
					} else if (entityRefPattern.matcher(attrStr).matches()) {
						DTDNode entityRef = new DTDNode(DTDNode.NODE_TYPE_ENTITY_REFERENCE, attrValue, mFilePath);
						node.addChild(entityRef);
					}
				}
			}

		}
		return node;
	}

	private DTDNode getElementNode(String content) throws DTDException {

		if (content != null && content.startsWith("<!ELEMENT") && content.endsWith(">")) {

			Matcher matcher = Pattern.compile(REGULAR_ELEMENT_CONTENT).matcher(content);
			DTDNode node = null;
			if (matcher.matches()) {
				matcher = Pattern.compile(REGULAR_NAME).matcher(content);
				String elementName = null;
				int startPos = 0;
				if (matcher.find()) {
					elementName = matcher.group();
					node = new DTDNode(DTDNode.NODE_TYPE_ELEMENT, elementName, mFilePath);
					Log.d(TAG, "find element name-->" + elementName);
					startPos = matcher.start() + elementName.length();
					Log.d(TAG, "sub element def position-->" + startPos);
				}
				if (node != null) {
					Pattern entityRefPattern = Pattern.compile(REGULAR_ENTITY_REFERENCE);
					Pattern subElementRefPattern = Pattern.compile(REGULAR_ELEMENT_REFERENCE_NAME);
					matcher = Pattern.compile(REGULAR_ELEMENT_SUB_ELEMENT_DEF).matcher(content);
					boolean res = matcher.find(startPos);
					List<ElementInfo> subElementInfos = null;
					while (res) {
						Matcher entityMatcher = entityRefPattern.matcher(matcher.group());
						Matcher subElementMatcher = subElementRefPattern.matcher(matcher.group());
						if (entityMatcher.find()) {
							Log.d(TAG, "find entity ref-->" + matcher.group());
							DTDNode entityRefNode = new DTDNode(DTDNode.NODE_TYPE_ENTITY_REFERENCE,
									entityMatcher.group(), mFilePath);
							node.addChild(entityRefNode);
						} else if (subElementMatcher.find()) {
							int existenceFlag = 0;
							if (matcher.group().contains("*")) {
								existenceFlag = DTDNode.EXISTENCE_FLAG_ANY;
							} else if (matcher.group().contains("?")) {
								existenceFlag = DTDNode.EXISTENCE_FLAG_ONCE;
							} else if (matcher.group().contains("+")) {
								existenceFlag = DTDNode.EXISTENCE_FLAG_NOT_NULL;
							} else {
								throw new DTDException(DTDException.ERROR_CODE_DEFINITION_NOT_FOUND,
										"no existence definitionFound");
							}
							ElementInfo elementInfo = new ElementInfo(subElementMatcher.group(), existenceFlag);
							if (subElementInfos == null) {
								subElementInfos = new LinkedList<ElementInfo>();
							} else {
								subElementInfos.add(elementInfo);
							}
							Log.d(TAG, "find sub element ref-->" + matcher.group());
						}
						res = matcher.find();
					}
					if (subElementInfos != null) {
						node.setObjData(subElementInfos);
					}
				}
			}
			return node;
		}
		return null;
	}

	private DTDNode getCommentNode(String content) {
		DTDNode node = null;
		if (content != null) {
			node = new DTDNode(DTDNode.NODE_TYPE_COMMENT, null, mFilePath);
			node.setStringData(content.substring("<!--".length(), content.length() - "-->".length()));
		}
		return node;
	}

	private DTDNode getEntityNode(String content) {
		if (content != null) {

		}
		return null;
	}

	private boolean processEntityRef(DTDNode parent, String ref) {
		return false;
	}
}
