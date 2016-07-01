package com.irene.easymusic.dtd.parser;

import java.util.List;

public class ClassTemplate {
	
	public String packageName;
	public String className;
	public boolean isStatic;
	public boolean isInterface;
	public String fatherClass;
	public List<ClassTemplate> impelemtInterfaces;
	public List<ClassTemplate> subClasses;
	public List<FieldTemplate> fields;
	public List<MethodTemplate> methods;
	public String comment;
	public String owner;
	public String copyRight;
	
}
