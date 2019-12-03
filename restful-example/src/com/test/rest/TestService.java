package com.test.rest;

import javax.ws.rs.*;

@Path("/")
public class TestService {
	
	public static int wins, losses, ties;
	
	@GET 
	@Path("/score/wins") 
	@Produces("text/plain")
	public int getWins() {return wins;}
	  
	
	@GET 
	@Path("/score/losses")
	@Produces("text/plain")
	public int getLosses() {return losses;}
	     
	
	@GET
	@Path("/score/ties")
	@Produces("text/plain")
	public int getTies() {return ties;}
	
	
	@GET
	@Path("/score")
	@Produces("application/json")
	public String getScore() {
	   String pattern = 
	      "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
	   return String.format(pattern,  wins, losses, ties );   
	}
	   
	
	@PUT
	@Path("/score")
	@Produces("application/json")
	public String update(@QueryParam("wins") int wins, 
	                        @QueryParam("losses") int losses, 
	                        @QueryParam("ties")   int ties) {
		TestService.wins   = wins;
		TestService.ties   = ties;
		TestService.losses = losses;
	   String pattern = 
	      "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
	   return String.format(pattern,  wins, losses, ties );   
	}


	@POST 
	@Path("/score/wins") 
	@Produces("text/plain")
	public int increaceWins() {
		return ++wins;
	}
	
	@POST
	@Path("/score/losses") 
	@Produces("text/plain")
	public int increaceLosses() {
		return ++losses;
	}
	
	@POST 
	@Path("/score/ties") 
	@Produces("text/plain")
	public int increaceTies() {
		return ++ties;
	}
	
	
//	public static int getWINS() {
//		return WINS;
//	}
//
//
//	public static int getLOSSES() {
//		return LOSSES;
//	}
//
//
//	public static int getTIES() {
//		return TIES;
//	}

}
