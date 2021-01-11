package com.zensar;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		LoginRepository loginRepository = new LoginRepository();
		Connection con = loginRepository.getDbConnection();
		System.out.println("con:"+con);

	}

}
