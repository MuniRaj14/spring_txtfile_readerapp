package com.TransportIT.dao;

import com.TransportIT.beans.Transport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class TransportDaoImpl implements TransportDao {

    @Value("${DB_URL}")
    private String DB_URL;

    @Value("${DB_UNAME}")
    private String DB_UNAME;

    @Value(("${DB_PW}"))
    private String DB_PW;


    @Override
    public int insertTransportDetails(Transport transport) {

        try(Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PW);){


            PreparedStatement pstmt = con.prepareStatement("INSERT INTO TRANSPORT VALUES(?,?,?,?)");
            pstmt.setInt(1,transport.getTransportId());
            pstmt.setString(2,transport.getFromLocation());
            pstmt.setString(3,transport.getToLocation());
            pstmt.setDouble(4,transport.getTransportFee());

            int i = pstmt.executeUpdate();
            return i;

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

}
