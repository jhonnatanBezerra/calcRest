package br.com.calculadora.api;

import java.text.DecimalFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class Controllers {
	
	
	private DecimalFormat df = new DecimalFormat("0.00");
	
	@GetMapping()
	public String hello() {
		return "Calculadora REST";
	}
		
	@GetMapping("soma/{a}/{b}")
	public String somar(@PathVariable("a") Long a,@PathVariable("b") Long b) {
		return "" + df.format(a) + " somado com " + df.format(b) + " = "+df.format(a + b);
	}
	
	@GetMapping("sub/{a}/{b}")
	public String subtrair(@PathVariable("a") Long a,@PathVariable("b") Long b) {
		return "" + df.format(a) + " menos " + df.format(b) + " = "+df.format(a - b);
	}
	
	@GetMapping("mult/{a}/{b}")
	public String multiplicar(@PathVariable("a") Long a,@PathVariable("b") Long b) {
		return "" + df.format(a) + " multiplicado por " + df.format(b) + " = "+df.format(a * b);
	}
	
	@GetMapping("div/{a}/{b}")
	public String dividir(@PathVariable("a") Long a,@PathVariable("b") Long b) {
		if(a == 0) {
			return "Impossivel divisão por 0";
		}
		return "" + df.format(a) + " dividido por " + df.format(b) + " = "+df.format(a/b);
	}
	
}
