package net.javaguides.springboot.springsecurity.web;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	public class ServiceResponse<T> {
		
		private String status;
		private T data;
		
		public ServiceResponse(String status, T data) {
			super();
			this.status = status;
			this.data = data;
		}

		private String msg;

	}


