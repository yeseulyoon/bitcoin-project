package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MarketDAO;
import model.PeopleDAO;
import model.TablesDAO;
import model.domain.MarketDTO;
import model.domain.PeopleDTO;
import model.domain.TablesDTO;

public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
		System.out.println("-------------------Controller--------------------------" + command);
		
		String data = "";

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<String> list = null;
		  ArrayList<String> MarketList = null;
	      HashMap<String, TablesDTO> allData = null;
	      HashMap<String, MarketDTO> Data = null;

		try {
			if (command.equals("insert")) {// 회원가입정보저장
				clientInsert(request, response);
			} else if (command.equals("login")) {// 로그인
				System.out.println("------------- 로그인");
				clientLogin(request, response);
			} else if (command.equals("star")) {// 목차보여주기
				showContent(request, response);
			} else if(command.equals("code")) {
				 System.out.println("--------------------------------");
		         try {
		        	System.out.println("??????????????????????????????");
		            list = TablesDAO.getTablesNames();
		            System.out.println(list);
		            out.println(list);
		         } catch (Exception e) {
		            System.out.println("모든 table명 검색시 error");
		            e.printStackTrace();
		         }
			}else if(command.equals("select")) {
		         System.out.println("------------- " +  request.getParameter("tablesName"));
		         String tablesName = request.getParameter("tablesName");
		         try {
		            allData = TablesDAO.getTableAll(tablesName);
		            out.println(allData);
		         } catch (Exception e) {
		            System.out.println("특정 table명으로 해당 데이터 검색 ");
		            e.printStackTrace();
		         }
		      }	
			else if(command.equals("market")) {
				System.out.println("--------------------------------");
				try {
					MarketList = MarketDAO.getMarketNames();
					System.out.println(MarketList);
					out.println(MarketList);
				} catch (Exception e) {
					System.out.println("모든 table명 검색시 error");
					e.printStackTrace();
				}
			}else if(command.equals("selectMenu")) {
				System.out.println("------------- " +  request.getParameter("MarketName"));
				String MarketName = request.getParameter("MarketName");
				try {
					Data = MarketDAO.getMarketAll(MarketName);
					out.println(Data);
				} catch (Exception e) {
					System.out.println("특정 table명으로 해당 데이터 검색 ");
					e.printStackTrace();
				}
			}else if (command.equals("search")) {
	            BufferedReader in = null;
	            String value = null;
	            System.out.println("ppppppppppppppppppppppp");
	            try {
	            	System.out.println("ppppppppppppppppppppppp");
	               in = new BufferedReader(new FileReader("C:\\0.bigData\\4.web\\NEW4\\WebContent\\pairsTrading\\search\\find_pairs7.csv"));
	               value = in.readLine();
	               System.out.println(value);
	               while (value != null) {
	                  data = data + "\n" + value;
	                  value = in.readLine();
	               }
	               out.println(data);
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
			}// end of catch  
			else if(command.equals("Twin")){
/*                Process p = Runtime.getRuntime().exec("python C:/Users/user/Desktop/project/Twin.py");
                p.waitFor();*/
                BufferedReader in = null;
                String value = null;
                String filename; 
                filename = request.getParameter("first")+"-"+request.getParameter("second")+".csv";
                System.out.println("-------"+filename);
                try {
                   
                	in = new BufferedReader(new FileReader( "C:/0.bigData/4.web/NEW4/WebContent/pairsTrading/twin/"+filename));
                   value = in.readLine();
                   while (value != null) {
                	   data = data + "\n" + value;
                	   value = in.readLine();
					}
					out.println(data);
				} catch (IOException e) {
					e.printStackTrace();
				} // end of catch
			
			} else if(command.equals("Spread")) {
/*                Process p = Runtime.getRuntime().exec("python C:/Users/user/Desktop/project/Spread.py");
                p.waitFor();*/
                BufferedReader in = null;
                String value = null;
                String filename;
                filename = request.getParameter("first")+"-"+request.getParameter("second")+".csv";
                System.out.println(filename);
                try {
                   in = new BufferedReader(new FileReader( "C:/0.bigData/4.web/NEW4/WebContent/pairsTrading/spread/"+filename));
                   value = in.readLine();
                   while (value != null) {
                	   data = data + "\n" + value;
                	   value = in.readLine();
					}
					out.println(data);
				} catch (IOException e) {
					e.printStackTrace();
				} // end of catch
				
				
			} else if(command.equals("Coin")) {
/*                Process p = Runtime.getRuntime().exec("python C:/Users/user/Desktop/project/estimate.py");
                p.waitFor();*/
                BufferedReader in = null;
                String value = null;
                String filename;
                filename = request.getParameter("first")+"-"+request.getParameter("second")+".csv";
                try {
                   in = new BufferedReader(new FileReader( "C:/0.bigData/4.web/NEW4/WebContent/pairsTrading/priceEstimate/"+filename));
                   value = in.readLine();
                   while (value != null) {
                	   data = data + "\n" + value;
                	   value = in.readLine();
					}
					out.println(data);
				} catch (IOException e) {
					e.printStackTrace();
				} // end of catch
				
				
			} else if(command.equals("Estimate")) {
          
                BufferedReader in = null;
                String value = null;
                String filename;
                filename = request.getParameter("first")+"-"+request.getParameter("second")+".csv";
                try {
                   in = new BufferedReader(new FileReader( "C:/0.bigData/4.web/NEW4/WebContent/pairsTrading/spreadEstimate/"+filename));
                   value = in.readLine();
                   while (value != null) {
                	   data = data + "\n" + value;
                	   value = in.readLine();
					}
					out.println(data);
				} catch (IOException e) {
					e.printStackTrace();
				} // end of catch
				
				
			
			}else if (command.equals("comparison")) {
				System.out.println("comparison");
				BufferedReader in = null;
				String value = null;
				String filename;
				
					if (request.getParameter("method").equals("LSTM")) {
						filename = request.getParameter("method") + "_" + "future" + "_" + request.getParameter("future") + "_weight_date_" + request.getParameter("weight_future") + ".csv";
					} else {
						filename = request.getParameter("method") + "_" + "future" + "_" + request.getParameter("future") + ".csv";
					}
				
					
					
				try {
					in = new BufferedReader(new FileReader("C:/0.bigData/4.web/NEW4/WebContent/PerformanceTest/" + filename));
					value = in.readLine();
					while (value != null) {
						data = data + "\n" + value;
						value = in.readLine();
					}
					/*out.println(data);
					System.out.println("—————————" + data);*/
					
					in = new BufferedReader(new FileReader("C:/0.bigData/4.web/NEW4/WebContent/PerformanceTest/" + filename));
					value = in.readLine();
					while (value != null) {
						data = data + "\n" + value;
						value = in.readLine();
					}
					out.println(data);
					System.out.println("—————————" + data);
				} catch (IOException e) {
					e.printStackTrace();
				} // end of catch
				
			} else if (command.equals("investment1")) {
				System.out.println("investment");
				BufferedReader in = null;
				String value = null;
				String filename;
				
					if (request.getParameter("method").equals("LSTM")) {
						filename = request.getParameter("method") + "_" + "future" + "_" + request.getParameter("future") + "_weight_date_" + request.getParameter("weight_future") + ".csv";
					} else {
						filename = request.getParameter("method") + "_" + "future" + "_" + request.getParameter("future") + ".csv";
					}
				
					
				try {
					in = new BufferedReader(new FileReader("C:/0.bigData/4.web/NEW4/WebContent/CalculateWeights/" + filename));
					value = in.readLine();
					while (value != null) {
						data = data + "\n" + value + "," +  request.getParameter("money");
						value = in.readLine();
					}
					out.println(data);
					System.out.println("—————————" + data);
				} catch (IOException e) {
					e.printStackTrace();
				} // end of catch
			}

		} catch (Exception s) {
			s.printStackTrace();

			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("jsonHandling.jsp").forward(request, response);

		}
	}

	public void clientInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int x = PeopleDAO.joinCheck(request.getParameter("id"));
		try {
			if (x == -1) {// id 가 없을 경우 true
				PeopleDAO.insert(new PeopleDTO(request.getParameter("id"), request.getParameter("pw"),
						request.getParameter("name"), request.getParameter("gender"),
						request.getParameter("birthday")));
				request.setAttribute("message", "가입 성공 했습니다");
			} else {
				request.setAttribute("message", "이미 존재하는 id 입니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("joinAction.jsp").forward(request, response);
	}

	public void clientLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x = PeopleDAO.login(request.getParameter("loginid"), request.getParameter("loginpw"));
		System.out.println("로그인 후 "+x);
		request.setAttribute("login", x);
		request.getRequestDispatcher("loginAction.jsp").forward(request, response);
	}

	public void noshowContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("noshowContent.jsp").forward(request, response);
	}

	public void showContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("showContent.jsp").forward(request, response);
	}

}