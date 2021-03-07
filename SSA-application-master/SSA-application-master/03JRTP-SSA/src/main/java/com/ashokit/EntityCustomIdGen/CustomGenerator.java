package com.ashokit.EntityCustomIdGen;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.ashokit.constants.AppConstants;

public class CustomGenerator implements IdentifierGenerator {

	public Serializable generate(SharedSessionContractImplementor session, Object object) {

		String prifix = "43212";
		String suffix =null;
		String sql = AppConstants.SQL_QUERRY;
		
		try {
			Connection con = session.connection();
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(sql);
			if (set.next()) {
				int seq = set.getInt(1);
				suffix = String.valueOf(seq);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  Long.parseLong(prifix + suffix);
	}

}
