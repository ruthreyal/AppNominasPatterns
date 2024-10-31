package com.aprendec.exceptions;

public class DatosNoCorrectosException extends Exception{

	public DatosNoCorrectosException () {
		
	}

	public DatosNoCorrectosException (String mensage) {
		
		System.out.println(mensage);
	}


}
