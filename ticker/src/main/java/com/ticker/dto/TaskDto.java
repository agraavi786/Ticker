package com.ticker.dto;

import java.time.LocalDate;

public class TaskDto {
	 private Long id;
	    private String name;
	    private LocalDate dueDate;
	    private int priority;
	    private Status status;

	    public enum Status {
	        PENDING, COMPLETED
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}

		public int getPriority() {
			return priority;
		}

		public void setPriority(int priority) {
			this.priority = priority;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}
	    
	    
	    

}
