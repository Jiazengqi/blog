package com.example.blog.util;

import java.io.*;

public final class SerializeUtil {

	private SerializeUtil(){}
	/**
	 * 序列化的方法
	 * @param obj
	 * @return
	 */
	public static byte[] toSerialize(Object obj){
		ObjectOutputStream oos = null;
		ByteArrayOutputStream bos = null;
		try {
			bos=new ByteArrayOutputStream();
			oos=new ObjectOutputStream(bos);
			oos.writeObject(obj);
			byte[] b = bos.toByteArray();
			return b;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 反序列化
	 * @param bytes
	 * @return
	 */
	public static Object serializeToObj(byte[] bytes)
	{
		ByteArrayInputStream bin = null;
		ObjectInputStream bon = null;

		try {
			bin= new ByteArrayInputStream(bytes);
			bon = new ObjectInputStream(bin);
			return bon.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bon != null)
			{
				try {
					bon.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;

	}



}
