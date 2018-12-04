package simple_text_editor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
    	start( new Scanner(System.in) );
    }
    
    public static void start( Scanner scanner ) {

    	scanner.nextLine();
    	
    	Programa p = new Programa();
    	
    	while( scanner.hasNext() ) {
	        p.execute( scanner.nextLine() );
    	}
    	
    	p.print();
    	
        scanner.close();
    }

}

class Programa {
	
	private static final int APPEND = 1;
	private static final int DELETE = 2;
	private static final int PRINT = 3;
	
	StringBuilder builder;
	Deque<Command> commands;
	StringBuilder output;
	
	public Programa() {
		this.commands = new LinkedList<>();
		builder = new StringBuilder();
		output = new StringBuilder();
	}
	
	public void execute( String command ) {
		
		String[] nd = command.split(" ");
		
        int a = Integer.parseInt(nd[0]);
        String par = null;
        if ( a < 4 ) {
        	par = nd[1];
        }
        
        if ( a == APPEND ) {
        	this.commands.push(new Append(this.builder,par));
        }
        else if ( a == DELETE ) {
        	this.commands.push(new Delete(this.builder,par));
        }
        else if ( a == PRINT ) {
        	output.append( builder.charAt( Integer.parseInt(par) -1 ) );
        	output.append("\n");
        }
        else {
        	this.commands.pop().undo();
        }
	}
	
	public void print() {
		System.out.println( this.output.toString() );
	}
	
}

interface Command {
	void apply( String parameter );
	void undo();
}

class Append implements Command {
	
	StringBuilder builder;
	String appended;
	
	public Append(StringBuilder builder, String parameter) {
		this.builder = builder;
		this.apply(parameter);
	}

	@Override
	public void apply(String parameter) {
		appended = parameter;
		builder.append(parameter);
	}

	@Override
	public void undo() {
		builder.setLength( (builder.length() - appended.length()) );
	}
	
}

class Delete implements Command {
	
	StringBuilder builder;
	String deleted;
	
	public Delete(StringBuilder builder, String parameter) {
		this.builder = builder;
		this.apply(parameter);
	}

	@Override
	public void apply(String parameter) {
		deleted = builder.substring((builder.length() -Integer.parseInt(parameter)), builder.length());
		builder.setLength( (builder.length() -Integer.parseInt(parameter)) );
	}

	@Override
	public void undo() {
		builder.append(deleted);
	}
	
}
