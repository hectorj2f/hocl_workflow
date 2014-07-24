package fr.inria.hocl.core.hocli;


import java.util.*;

/**
 * 
 * HOCL interpreter
 * 
 * It reduces a given solution to a inert state. Strategies and debug messages
 * may be specified here.
 * 
 * Command line switches: [-s [FR|UFR|Rand|KSS]] [-v [n]]
 * 
 * [Strategies] A strategy to apply the rules may be specified between : - FR :
 * Fair Roundrobin (R1;R2;...;Rn)* - UFR : UnFair Roudrobin (R1*;R2*;...;Rn*)* -
 * Rand : select randomly a rule between the non inert ones - KSS : Keep Small
 * Solution, favorise Reducer over Optimiser over Unknown over Expanser
 * 
 * 
 * [Debugging] Verbose levels (each level assumes all lower ones): 0 -> quiet 1
 * -> initial and final inert states 2 -> all inert solutions 3 -> reactions 4
 * -> reactions statistics 5 -> intermediate solutions (non inert) states 6 ->
 * tested permutations 7 -> strategy choices 8 -> all permutations
 * 
 * By default, everything is turned off execept the initial state (argument) and
 * the last state (result).
 * 
 */
public class Hocli {

	static public Debug debug;

	static private String strategyTag;

	static private Hashtable<String, Class> allStrategies;


	/**
	 * Init the interpretor to defaults and with the command line options
	 * 
	 * @param args
	 *          command line options
	 */
	static public void init( final String args[] ) {
		initStrategies();
		setStrategy( "FR" );
		initDebugMessages();
		analyzeArguments( args );
	}


	static private void initStrategies() {
		allStrategies = new Hashtable<String, Class>();
		allStrategies.put( "FR", StrategyFairRoundRobin.class );
		allStrategies.put( "UFR", StrategyUnFairRoundRobin.class );
		allStrategies.put( "RAND", StrategyRandom.class );
		allStrategies.put( "KSS", StrategyKeepSmallSolution.class );
	}


	static private String allStrategies() {
		Enumeration it = allStrategies.keys();
		String s = new String();
		while( it.hasMoreElements() ) {
			s = s + it.nextElement() + "\n";
		}
		return s;
	}


	static private void initDebugMessages() {
		debug = new Debug();
		setVerboseLevel( 1 );
	}


	static public void setVerboseLevel( int level ) {
		debug.clearDebugSymbols();
		if( level >= 1 ) {
			debug.addDebugSymbol( Debug.DebugSymbol.SOLUTION_WHATISINSIDE );
		}
		if( level >= 2 ) {
			debug.addDebugSymbol( Debug.DebugSymbol.FIRST_LAST_STATES );
		}
		if( level >= 3 ) {
			debug.addDebugSymbol( Debug.DebugSymbol.SOLUTION_REDUCED );
		}
		if( level >= 4 ) {
			debug.addDebugSymbol( Debug.DebugSymbol.REACTIONS );
		}
		if( level >= 5 ) {
			debug.addDebugSymbol( Debug.DebugSymbol.REACTIONS_STATS );
		}
		if( level >= 6 ) {
			debug.addDebugSymbol( Debug.DebugSymbol.SOLUTION_PARTIAL );
		}
		if( level >= 7 ) {
			debug.addDebugSymbol( Debug.DebugSymbol.TESTED_PERM );
		}
		if( level >= 8 ) {
			debug.addDebugSymbol( Debug.DebugSymbol.STRATEGY );
		}
		if( level >= 9 ) {
			debug.addDebugSymbol( Debug.DebugSymbol.PERMUTATION );
		}
	}


	static public void setStrategy( String str ) {
		assert allStrategies.containsKey( str );
		strategyTag = str;
	}


	/**
	 * Return a new strategy (Design Pattern Abstract Factory)
	 * 
	 * @return a new strategy
	 */
	static public Strategy newStrategy() {
		Strategy strategy = null;
		Class stratClass;

		//FIXME: When you do a new Solution() it get an error because the strategies weren't initialized before to do a newStrategy().
		if(allStrategies == null){
			Hocli.initStrategies();
			setStrategy( "FR" );
		}
		stratClass = allStrategies.get( Hocli.strategyTag.toUpperCase() );
		if( stratClass == null ) {
			stopError( "Hocli.newStrategy(Solution) : Unknown strategy class '" + Hocli.strategyTag + "'" );
		}
		try {
			strategy = ( Strategy ) stratClass.newInstance();
		} catch( IllegalAccessException ex ) {
			stopError( ex.getMessage() );
		} catch( InstantiationException ex ) {
			stopError( ex.getMessage() );
		}
		return strategy;
	}


	static void stopError( String message ) {
		System.out.println( message );
		System.exit( 1 );
	}


	/**
	 * Analyze the command line options to extract the optional specified strategy
	 * and debug level.
	 * 
	 * 
	 * @param args
	 *          options to analyze
	 */
	static private void analyzeArguments( String args[] ) {
		int size = args.length;
		for( int i = 0; i < size; i++ ) {
			if( args[i].equals( "-s" ) ) {
				i++;
				if( i >= size || args[i].charAt( 0 ) == '-' ) {
					stopError( "Missing strategy after '-s'. May be one of:\n"
							+ allStrategies() );
				} else {
					Class strat = allStrategies.get( args[i] );
					if( strat == null ) {
						stopError( "Unknown strategy '" + args[i]
								+ "'. It should be one of:\n" + allStrategies() );
					} else {
						strategyTag = args[i];
					}
				}
			} else if( args[i].equals( "-v" ) ) {
				int verb = 1;
				i++;
				if( i < size && args[i].charAt( 0 ) != '-' ) {
					try {
						verb = Integer.decode( args[i] );
					} catch( NumberFormatException ex ) {
						stopError( "Non valid verbose level: " + ex.getMessage() );
					}
				}
				setVerboseLevel( verb );
			} else {
				stopError( "Unknown argument: " + args[i] );
			}
		}
	}

} // class Hocli
