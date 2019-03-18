package lk.royalBank.service.impl;

import lk.royalBank.dto.DepositDTO;
import lk.royalBank.entity.Deposit;
import lk.royalBank.repository.DepositRepository;
import lk.royalBank.service.DepositService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DepositServiceImpl implements DepositService {

    @Autowired
    DepositRepository depositRepository;

//    String urlForserver1 = "http://192.168.1.104:8080/api/v1/checkBalance?accountNumber=";
    String urlForserver1 = "https://my-json-server.typicode.com/typicode/demo/db";
    private static final String USER_AGENT = "Mozilla/5.0";

    @Override
    public void depositMoney(DepositDTO depositDTO) throws MalformedURLException, IOException {

//        URL url = new URL(urlForserver1+depositDTO.getBankAccountDTO().getAccountNumber());
        URL url = new URL(urlForserver1);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine=in.readLine())!=null){
                response.append(inputLine);
            }
            in.close();





//            JSONObject jsonObject = new JSONObject(response.toString());

//            Map<String, Object> stringObjectMap = jsonObject.toMap();


//            stringObjectMap.forEach((s, o) -> {
//                System.out.print(s+" "+o.toString());
//                System.out.println();
//            });
//            List<Object> posts = jsonObject.getJSONArray("posts").toList();
//
//            for (Object p:posts){
//                System.out.println(p.toString());
//            }



//            Iterator<String> keys = jsonObject.keys();
//
//            while (keys.hasNext()){
//                System.out.println(jsonObject.get(keys.next()));
//            }
//            System.out.println(jsonObject);
//            System.out.println(response.toString());
        }

    }
}
