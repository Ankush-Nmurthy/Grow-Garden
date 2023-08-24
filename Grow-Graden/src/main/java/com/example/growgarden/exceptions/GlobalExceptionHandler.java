package com.masai.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	  
	  @ExceptionHandler(LoginException.class)
		public ResponseEntity<ErrorDetails> loginExceptionHandler(LoginException se, WebRequest req){
			
			
			ErrorDetails err= new ErrorDetails();
				
				err.setMessage(se.getMessage());
				err.setDetails(req.getDescription(false));
					
			return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
			
		}
		
	  @ExceptionHandler(PlantNotFoundException.class)
	    public ResponseEntity<ErrorDetails> plantNotfoundExceptionHandler(PlantNotFoundException pnfe, WebRequest req ){
		   
			ErrorDetails err=new ErrorDetails();
			err.setDetails(req.getDescription(false));
			err.setMessage(pnfe.getMessage());
			
			return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	    }
		
		
		@ExceptionHandler(SeedNotFoundException.class)
	    public ResponseEntity<ErrorDetails> seedNotfoundExceptionHandler(SeedNotFoundException snfe, WebRequest req ){
		   
			ErrorDetails err=new ErrorDetails();
			err.setDetails(req.getDescription(false));
			err.setMessage(snfe.getMessage());
			
			return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	    }
	  
	  @ExceptionHandler(OrderException.class)
	   public ResponseEntity<ErrorDetails>  orderExceptionHandler(OrderException ex,WebRequest wr) {
		        
		   ErrorDetails md=new ErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.NOT_FOUND);
	   }
	  
	  
	  @ExceptionHandler(CartException.class)
	   public ResponseEntity<ErrorDetails>  cartExceptionHandler(CartException ex,WebRequest wr) {
		        
		   ErrorDetails md=new ErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.NOT_FOUND);
	   }
	
	  
	  
	   @ExceptionHandler(Exception.class)
	   public ResponseEntity<ErrorDetails>  globalExceptionHandler(Exception ex,WebRequest wr) {
		        
		   ErrorDetails md=new ErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.BAD_REQUEST);
	   }
	   
	   @ExceptionHandler(NoHandlerFoundException.class)
	   public ResponseEntity<ErrorDetails>  handlerNotFoundException(NoHandlerFoundException ex,WebRequest wr) {
		        
		   ErrorDetails md=new ErrorDetails();
		   md.setMessage(ex.getMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.BAD_REQUEST);
	   }
	   
	   
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<ErrorDetails>  noValidArgsException(MethodArgumentNotValidException ex,WebRequest wr) {
		        
		   ErrorDetails md=new ErrorDetails();
		   md.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
		   md.setDetails(wr.getDescription(false));
		   return new ResponseEntity<>(md,HttpStatus.BAD_REQUEST);
	   }

		
}