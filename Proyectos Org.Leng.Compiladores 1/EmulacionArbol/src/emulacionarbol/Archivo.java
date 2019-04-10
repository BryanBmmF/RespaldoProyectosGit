/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emulacionarbol;

import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class Archivo {
        private static final String WRITE = "w";
	private static final String READ = "r";
	private static final String EXECUTE = "x";
	private static final String IS_DIRECTORY = "d";
	private static final String NO_DATA = "-";
	private static final char ADD_PERISSION = '+';
	private static final char REMOVE_PERISSION = '-';
	
	private String name;
	private int sizeKb;
	private boolean directory;
	private boolean write;
	private boolean read;
	private boolean execute;
	private LocalDate creationDate;
        
        public Archivo(String name, int sizeKb, boolean directory) {
		this.name = name;
		this.sizeKb = sizeKb;
		this.directory = directory;
		creationDate = LocalDate.now();
	}
}
