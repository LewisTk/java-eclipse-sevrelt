package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionEstado;
import model.Estado;

public class CboEstado extends TagSupport{
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			ArrayList<Estado> lstEstado = new GestionEstado().listaEstado();
			for (Estado e : lstEstado) {
				out.println(String.format("<option value='%s'>%s</option>", e.getCodEcivil(), e.geteCivil()));
			}
		} catch (IOException e) {
			System.out.println("Error en la etiqueta CboEstado: " + e.getMessage());
		}
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException{
		return EVAL_PAGE;
	}
}
