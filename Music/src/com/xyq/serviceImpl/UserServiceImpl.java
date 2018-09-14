package com.xyq.serviceImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.xyq.Util.TSUtility;
import com.xyq.daoImp.UserDaoImpl;
import com.xyq.entity.User;
import com.xyq.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDaoImpl ud = new UserDaoImpl();
	
	@Override
	public boolean login() {
		boolean flag = false;
		System.out.print("请输入用户名：");
		String userName = TSUtility.readString();
		System.out.print("请输入密码：");
		String passWord = TSUtility.readString();
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		Socket s = null;
		try {
			s = new Socket("localhost", 9999);
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(user);
			s.shutdownOutput();
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			flag = dis.readBoolean();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public void upload() {
		int j = 0;
		File fd = null;
		File f = new File("f:/Music");
		File[] fs = f.listFiles();
		File[] ft = new File[fs.length];
		System.out.println("\n******************上传***************************\n这是你的歌单，请查收");
		for(File file:fs) {
			if(file.getName().endsWith("mp3")) {
				ft[j++] = file;
			}
		}
		
		for(int i=0; ft[i] != null; i++) {
			System.out.println((i+1) + "\t\t" + ft[i].getName());
		}
		System.out.print("你想要上传的音乐是：(输入歌曲前面对应的序号)");
		int n = TSUtility.readInt();
		if(!(n > 0 && n < j)) {
			System.out.println("请检查你的输入");
		}else {
			fd = ft[n-1];
			Socket s = null;
			try {
				
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fd));
				byte[] b = new byte[1024];
				int len = bis.read(b);
				s = new Socket("localhost", 9999);
				OutputStream os = s.getOutputStream();
				BufferedOutputStream bos = new BufferedOutputStream(os);
				while(len > -1) {
					bos.write(b, 0, len);
					len = bis.read(b);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
