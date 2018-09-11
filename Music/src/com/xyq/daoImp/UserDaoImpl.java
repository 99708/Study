package com.xyq.daoImp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.xyq.dao.UserDao;
import com.xyq.entity.User;

public class UserDaoImpl implements UserDao {
	
	public static void main(String[] args) {
		BufferedReader br = null;
		ServerSocket ss = null;
		try {
			br = new BufferedReader(
					new FileReader(new File("User.txt")));
			String str = br.readLine();
			
			ss = new ServerSocket(9999);
			Socket s = ss.accept();
			InputStream os = s.getInputStream();
			ObjectInputStream oos = new ObjectInputStream(os);
			User user = (User) oos.readObject();
			
			while(str != null) {
				String[] sm = str.split("#");
				if(user.getUserName().equals(sm[0]) && user.getPassWord().equals(sm[1])) {
					System.out.println("登录成功");
					return;
				}
			}
			System.out.println("登录失败");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void login() {
	}
	
}
