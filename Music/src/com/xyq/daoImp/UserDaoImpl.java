package com.xyq.daoImp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.xyq.Util.TSUtility;
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
			
			List<User> ls = new ArrayList<User>();
			
			while(str != null) {
				String[] sm = str.split("#");
				User user2 = new User();
				user2.setUserName(sm[0]);
				user2.setPassWord(sm[1]);
				ls.add(user2);
				str = br.readLine();
			}
			
			ss = new ServerSocket(9999);
			while(true) {
				Socket s = ss.accept();
				
				InputStream is = s.getInputStream();
				ObjectInputStream oos = new ObjectInputStream(is);
				User user = (User) oos.readObject();
				
				boolean flag = false;
				for(User u:ls) {
					if(u.equals(user)) {
						flag = true;
					}
				}
				
				s.shutdownInput();
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeBoolean(flag);
			}
			
			
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
	public void upload() {
		
		
	}


	
}
