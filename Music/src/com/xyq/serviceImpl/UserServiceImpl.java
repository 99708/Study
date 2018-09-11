package com.xyq.serviceImpl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.xyq.Util.TSUtility;
import com.xyq.dao.UserDao;
import com.xyq.daoImp.UserDaoImpl;
import com.xyq.entity.User;
import com.xyq.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao ud = new UserDaoImpl();
	
	@Override
	public void login() {
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
