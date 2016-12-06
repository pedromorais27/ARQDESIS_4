package br.com.usjt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.model.Conta;
import br.com.usjt.model.Saque;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/Saque")
public class SaqueCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/conteudo/saque.jsp");
		request.setAttribute("conta", Conta.conta);
		dispatcher.forward(request, response);
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		RequestDispatcher dispatcher;
		Boolean sucesso = false;
		String parameter = request.getParameter("valor");
		request.setAttribute("conta", Conta.conta);
		request.setAttribute("resposta", sucesso);
	
		if (parameter != null) {
			
			Saque saque = new Saque();
			Double valorDoSaque = Double.parseDouble(parameter);
			
			if (saque.fazerSaque(Conta.conta, valorDoSaque)) {
				sucesso = true;
			}

			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/conteudo/resposta-saque.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/conteudo/saque.jsp");
		}
		dispatcher.forward(request, response);
	}
}