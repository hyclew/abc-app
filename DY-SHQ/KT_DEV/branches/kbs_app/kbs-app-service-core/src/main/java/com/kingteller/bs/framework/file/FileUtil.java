package com.kingteller.bs.framework.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class FileUtil {

	private static final Logger logger = Logger.getLogger(FileUtil.class);
	
	/**
	 * 将字节数组转为文件写入到磁盘中
	 * @param buff 图片的二进制数据
	 * @param fileName 文件名
	 * @param path 此文件所在路径
	 * @throws Exception
	 */
	public static void writeFile(byte[] buff, String fileName, String path){
			File file = null;
			OutputStream os = null;
			try {
				File parentFile = new File(path);
				if(!parentFile.exists()){
					parentFile.mkdirs();
				}
				file = new File(parentFile, fileName);
				os = new FileOutputStream(file);
				os.write(buff);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("将字节数组写入硬盘出错,出错信息为:" + e.getLocalizedMessage(), e);
			} finally{
				if(null != os){
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
						logger.error("关闭文件数据流失败", e);
					}
				}
			}
	}
	
	/**
	 * 根据传入路径删除文件
	 * @param path
	 */
	public static boolean deleteFile(String path){
		File file = new File(path);
		if(file.exists() && file.isFile()){
			return file.delete();
		}
		return false;
	}
	
}
