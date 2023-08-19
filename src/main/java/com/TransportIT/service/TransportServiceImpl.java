package com.TransportIT.service;

import com.TransportIT.beans.Transport;
import com.TransportIT.dao.TransportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class TransportServiceImpl implements TransportService{
    @Autowired
    private TransportDao transportDao;

    @Autowired
    private Transport transport;
    @Override
    public void processTransport() {

        String myFilePath = "C:\\Intellij_WorSpace\\TransportationApp\\TransportationApp\\Transport.txt";

        try {

            Stream<String> lines = Files.lines(Paths.get(myFilePath));

            lines.forEach(s-> {
                String[] values =  s.split(",");

//                String id = values[0];
//                String FromLocation = values[1];
//                String ToLocation = values[2];
//                String TransportFee = values[3];

               //Transport t = new Transport();

                transport.setTransportId(Integer.parseInt(values[0]));
                transport.setFromLocation(values[1]);
                transport.setToLocation(values[2]);
                transport.setTransportFee(Double.parseDouble(values[3]));

                int cnt = transportDao.insertTransportDetails(transport);

                if(cnt>0){
                    System.out.println("Record got inserted");
                }

            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
