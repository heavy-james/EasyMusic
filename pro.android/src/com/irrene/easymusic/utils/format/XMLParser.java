package com.irrene.easymusic.utils.format;

import java.io.InputStream;

public interface XMLParser<T> {
	public T parse(InputStream is) throws Exception;
	public String serialize(T t) throws Exception;
}
