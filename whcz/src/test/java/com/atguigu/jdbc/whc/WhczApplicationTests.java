package com.atguigu.jdbc.whc;


import com.atguigu.jdbc.whc.po.User;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhczApplicationTests {

//    @Test
//    public void contextLoads() {
//        User user=new User();
//        user.setBU("信息中心事业部");
//        //Index index=new Index(user).builder().type("");
//    }
    //@Test
    public void file() {
        String filePath="C:\\Users\\Administrator\\Desktop\\text.txt";
        BufferedReader in = null;
        try {
            in=new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));
            String line = "";
            String content="";
            String a="";
            int i=0;
            while((line = in.readLine())!=null){
                i++;
                if (i==1){
                    a=line;
                }else{
                    content=content+line;
                }
            }
            System.out.println(content);
            System.out.println(a);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Autowired
    JestClient jestClient;
    @Test
    public void elasticsearch() {

       Map<String,Object> map =new HashMap<>();
       map.put("id",1);
       map.put("bu","信息中心事业部");
       Index index=new Index.Builder(map).index("bailidushu").type("person").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void search() {
       String json="{\n" +
               "    \"query\" : {\n" +
               "        \"match_phrase\" : {\n" +
               "            \"bu\" : \"中心\"\n" +
               "        }\n" +
               "    }\n" +
               "}";
        Search search=new Search.Builder(json).addIndex("bailidushu").addType("person").build();
        try {
            SearchResult execute = jestClient.execute(search);
            System.out.println(execute.getJsonString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
