package model;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loanService")
public class LoanServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amountStr = req.getParameter("price");
		String rateStr  = req.getParameter("rate");
		String periodStr  = req.getParameter("period");
		String typeStr  = req.getParameter("type");
		ArrayList<Loan> list = new ArrayList<Loan>();

		int amount = Integer.parseInt(amountStr);
		double rate = Double.parseDouble(rateStr);
		int period = Integer.parseInt(periodStr);
		int type = Integer.parseInt(typeStr);

		double mRate = rate / 100 / 12;

		int repayTotal,repayOrigin,interest,repaySum,repayRemain; 
		repayRemain = amount;  //ó�� �� �ܱ��� ���� �����ݾ�
		repaySum = 0;
		int repayMonth;
		if(type == 1){
			repayMonth = amount / period;
		} else{
			repayMonth = (int)((amount*mRate*Math.pow(1+mRate,period))
					/(Math.pow(1+mRate,period)-1));
		}

		for(int i = 1; i <= period; i++){
			interest = (int)(repayRemain*mRate);

			if(type == 1){
				//���� �յ��ȯ
				repayTotal = repayMonth + interest;  //�̹��� �� �ݾ��� ����
				repayOrigin = repayMonth;  //�̹��� �� ����
			}else{
				//������ �յ��ȯ
				repayTotal = repayMonth;
				repayOrigin = repayMonth - interest; //�̹��� �� ����
			}
			repayRemain = repayRemain - repayOrigin;
			repaySum = repaySum + repayTotal;
			
			list.add(new Loan(i,repayTotal,repayOrigin,interest,repaySum,repayRemain));
		}
		req.setAttribute("data", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("03loanResult.jsp");
		dispatcher.forward(req, resp);
		list = null;
	}

}
