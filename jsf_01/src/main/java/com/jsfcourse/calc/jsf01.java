package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class jsf01 {
	private String kwota;
	private String lata;
	private String raty;
	private Double result;

	@Inject
	FacesContext ctx;

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public String getLata() {
		return lata;
	}

	public void setLata(String lata) {
		this.lata = lata;
	}

	public String getRaty() {
		return raty;
	}

	public void setRaty(String raty) {
		this.raty = raty;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public boolean doTheMath() {
		try {
			double kwota = Double.parseDouble(this.kwota);
			double lata = Double.parseDouble(this.lata);
			double raty = Double.parseDouble(this.raty);
			
			result = (kwota + (kwota*(raty/100)))/(lata*12);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "wszystko ok", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "złe dane", null));
			return false;
		}
	}

	public String obliczanie() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

}