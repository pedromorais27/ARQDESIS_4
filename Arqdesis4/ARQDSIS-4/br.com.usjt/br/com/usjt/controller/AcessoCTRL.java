package br.com.usjt.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import br.com.usjt.model.Acesso;
import br.com.usjt.model.Conta;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/Acesso.do")
public class AcessoCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Acesso acesso = new Acesso();
		Conta conta = new Conta();

		if (request.getParameter("OK") != null) {

			RequestDispatcher dispatcher = null;
			Boolean error = false;

			String agencia = request.getParameter("agencia");
			Boolean agenciaValida = agencia.matches("\\d{4}");
			
			String numConta = request.getParameter("conta");
			Boolean numContaValida = numConta.matches("\\d{6}");
			
			String senha = request.getParameter("senha");
			Boolean senhaValida = senha.matches("\\d{4}");
			
			try {			
				if (agenciaValida && numContaValida && senhaValida) {
					acesso.setConta(Integer.parseInt(numConta));
					conta.setNumConta(Integer.parseInt(numConta));					
					acesso.setSenha(Integer.parseInt(senha));
					conta.setSenha(Integer.parseInt(senha));					
					acesso.setAgencia(Integer.parseInt(agencia));
					conta.setAgencia(Integer.parseInt(agencia));

					if (acesso.validar(conta) == true) {
						dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/conteudo/home.jsp");
						Conta.conta = conta;
						Conta.conta.setNome(conta.recuperarNome());
						request.setAttribute("conta", Conta.conta);
					} else {
						error = true;
						request.setAttribute("error", error);
						dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/conteudo/Acesso.jsp");
					}
				} else {
					error = true;
					request.setAttribute("error", error);
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/conteudo/Acesso.jsp");
				}
				dispatcher.forward(request, response);

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "conta inexistente");
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}