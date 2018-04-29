package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html; charset=utf-8");
         
           String command = request.getParameter("command");
         System.out.println(command);
         try {
             if(command.equals("KOSPI")) { 
               Process p = Runtime.getRuntime().exec("python C:\\0.bigdata\\4.web\\Test\\python\\KOSPI.py");
               p.waitFor();
               BufferedReader in = null;
               BufferedReader in1 = null;
               ArrayList<Float> kospi = null;
               ArrayList<String> date = null;
               try {
                  in = new BufferedReader(new FileReader( "C:\\0.bigdata\\4.web\\Test\\python\\kospi_price.txt"));
                  String value = in.readLine();
                  System.out.println("1---------------"+value);
                  kospi = new ArrayList<Float>();
                  while (value != null) {
                     kospi.add(Float.parseFloat(value));
                     value = in.readLine();
                     System.out.println("2-----------"+value);
                  }
                  in1 = new BufferedReader(new FileReader( "C:\\0.bigdata\\4.web\\Test\\python\\kospi_date.txt"));
                  String value1 = in1.readLine();
                  System.out.println("1---------------"+value1);
                  date = new ArrayList<String>();
                  while (value1 != null) {
                     date.add(value1);
                     value1 = in1.readLine();
                     System.out.println("2-----------"+value1);   
               }
               }catch (IOException e) {
                  e.printStackTrace();
               } finally {
                  try {
                        in.close();
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
               }
               
               request.setAttribute("date", date);
               System.out.println("3 넘어가라~~---------------"+date);
               request.setAttribute("kospi", kospi);
               System.out.println("3 넘어가라~~---------------"+kospi);
               request.getRequestDispatcher("chart.html").forward(request, response);
             }
             else if(command.equals("USDT_BTC")){
                Process p = Runtime.getRuntime().exec("python C:\\0.bigdata\\4.web\\Test\\python\\USDT_BTC.py");
                  p.waitFor();
                  BufferedReader in = null;
                  BufferedReader in1 = null;
                  BufferedReader in2 = null;
                  BufferedReader in3 = null;
                  BufferedReader in4 = null;
                  
                  ArrayList<Float> close = null;
                  ArrayList<Float> open = null;
                  ArrayList<Float> high = null;
                  ArrayList<Float> low = null;
                  ArrayList<String> date = null;
                  
                  try {
                     in = new BufferedReader(new FileReader( "C:\\0.bigdata\\4.web\\Test\\python\\USDT_BTC_close.txt"));
                     String value = in.readLine();
                     System.out.println("1---------------"+value);
                     close = new ArrayList<Float>();
                     while (value != null) {
                        close.add(Float.parseFloat(value));
                        value = in.readLine();
                        System.out.println("2-----------"+value);
                     }
                     in1 = new BufferedReader(new FileReader( "C:\\0.bigdata\\4.web\\Test\\python\\USDT_BTC_date.txt"));
                     String value1 = in1.readLine();
                     System.out.println("1---------------"+value1);
                     date = new ArrayList<String>();
                     while (value1 != null) {
                        date.add(value1);
                        value1 = in1.readLine();
                        System.out.println("2-----------"+value1);   
                     }
                     in2 = new BufferedReader(new FileReader( "C:\\0.bigdata\\4.web\\Test\\python\\USDT_BTC_open.txt"));
                     String value2 = in.readLine();
                     System.out.println("1---------------"+value2);
                     open = new ArrayList<Float>();
                     while (value2 != null) {
                        open.add(Float.parseFloat(value2));
                        value = in.readLine();
                        System.out.println("2-----------"+value2);
                     }
                     in3 = new BufferedReader(new FileReader( "C:\\0.bigdata\\4.web\\Test\\python\\USDT_BTC_high.txt"));
                     String value3 = in.readLine();
                     System.out.println("1---------------"+value3);
                     high = new ArrayList<Float>();
                     while (value2 != null) {
                        high.add(Float.parseFloat(value3));
                        value = in.readLine();
                        System.out.println("2-----------"+value3);
                     }
                     in4 = new BufferedReader(new FileReader( "C:\\0.bigdata\\4.web\\Test\\python\\USDT_BTC_low.txt"));
                     String value4 = in.readLine();
                     System.out.println("1---------------"+value4);
                     low = new ArrayList<Float>();
                     while (value2 != null) {
                        low.add(Float.parseFloat(value4));
                        value = in.readLine();
                        System.out.println("2-----------"+value4);
                     }
                  }catch (IOException e) {
                     e.printStackTrace();
                  } finally {
                     try {
                           in.close();
                     } catch (IOException e) {
                        e.printStackTrace();
                     }
                  }
                  request.setAttribute("date", date);
                  System.out.println("3 넘어가라~~---------------"+date);
                  request.setAttribute("open", open);
                  System.out.println("3 넘어가라~~---------------"+open);
                  request.setAttribute("close", close);
                  System.out.println("3 넘어가라~~---------------"+close);
                  request.setAttribute("high", high);
                  System.out.println("3 넘어가라~~---------------"+high);
                  request.setAttribute("low", low);
                  System.out.println("3 넘어가라~~---------------"+low);
                  
                  request.getRequestDispatcher("NewFile.jsp").forward(request, response);
                }
            }catch(Exception e) {
            e.printStackTrace();
         }
   }
}