package com.gil.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Filtering - One way to ignore a field from response
//JsonIgnoreProperties and JsonIgnore directly on the bean for static filtering
//@JsonIgnoreProperties(value= {"field1","field2"})
//Dynamic Filtering JsonFilter
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	private String field1;
	//i dont want this field to be sent in the response
	//Another way to ignore a field from response
	//@JsonIgnore
	private String field2;
	//Now only field3 will be sent back because field1 and 2 are being ignored
	private String field3;

	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

}
