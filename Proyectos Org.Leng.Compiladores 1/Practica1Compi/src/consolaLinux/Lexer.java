/* The following code was generated by JFlex 1.7.0 */

package consolaLinux;

import static consolaLinux.sym.*;
import static consolaLinux.sym.error;
import java_cup.runtime.*;
import javax.swing.JTextArea;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>AnalizadorLexico.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\1\1\2\1\4\1\0\2\2\16\1\4\0\1\3\2\0\1\1"+
    "\1\1\1\0\1\27\3\0\1\1\1\32\1\0\1\13\1\1\1\5"+
    "\12\1\6\0\1\1\21\1\1\30\10\1\4\0\1\1\1\0\1\14"+
    "\1\1\1\15\1\10\1\33\2\1\1\21\1\24\1\1\1\23\1\11"+
    "\1\22\1\1\1\17\1\6\1\1\1\25\1\12\1\16\1\20\1\26"+
    "\1\7\1\31\2\1\4\0\41\1\2\0\4\1\4\0\1\1\2\0"+
    "\1\1\7\0\1\1\4\0\1\1\5\0\27\1\1\0\37\1\1\0"+
    "\u01ca\1\4\0\14\1\16\0\5\1\7\0\1\1\1\0\1\1\21\0"+
    "\165\1\1\0\2\1\2\0\4\1\10\0\1\1\1\0\3\1\1\0"+
    "\1\1\1\0\24\1\1\0\123\1\1\0\213\1\1\0\5\1\2\0"+
    "\236\1\11\0\46\1\2\0\1\1\7\0\47\1\7\0\1\1\1\0"+
    "\55\1\1\0\1\1\1\0\2\1\1\0\2\1\1\0\1\1\10\0"+
    "\33\1\5\0\3\1\15\0\5\1\6\0\1\1\4\0\13\1\5\0"+
    "\112\1\4\0\146\1\1\0\11\1\1\0\12\1\1\0\23\1\2\0"+
    "\1\1\17\0\74\1\2\0\145\1\16\0\66\1\4\0\1\1\5\0"+
    "\56\1\22\0\34\1\104\0\1\1\1\0\13\1\67\0\33\1\1\0"+
    "\144\1\2\0\12\1\1\0\7\1\1\0\7\1\1\0\3\1\1\0"+
    "\10\1\2\0\2\1\2\0\26\1\1\0\7\1\1\0\1\1\3\0"+
    "\4\1\2\0\11\1\2\0\2\1\2\0\4\1\10\0\1\1\4\0"+
    "\2\1\1\0\5\1\2\0\16\1\7\0\1\1\5\0\3\1\1\0"+
    "\6\1\4\0\2\1\2\0\26\1\1\0\7\1\1\0\2\1\1\0"+
    "\2\1\1\0\2\1\2\0\1\1\1\0\5\1\4\0\2\1\2\0"+
    "\3\1\3\0\1\1\7\0\4\1\1\0\1\1\7\0\20\1\13\0"+
    "\3\1\1\0\11\1\1\0\3\1\1\0\26\1\1\0\7\1\1\0"+
    "\2\1\1\0\5\1\2\0\12\1\1\0\3\1\1\0\3\1\2\0"+
    "\1\1\17\0\4\1\2\0\12\1\1\0\1\1\17\0\3\1\1\0"+
    "\10\1\2\0\2\1\2\0\26\1\1\0\7\1\1\0\2\1\1\0"+
    "\5\1\2\0\11\1\2\0\2\1\2\0\3\1\10\0\2\1\4\0"+
    "\2\1\1\0\5\1\2\0\12\1\1\0\1\1\20\0\2\1\1\0"+
    "\6\1\3\0\3\1\1\0\4\1\3\0\2\1\1\0\1\1\1\0"+
    "\2\1\3\0\2\1\3\0\3\1\3\0\14\1\4\0\5\1\3\0"+
    "\3\1\1\0\4\1\2\0\1\1\6\0\1\1\16\0\12\1\11\0"+
    "\1\1\7\0\3\1\1\0\10\1\1\0\3\1\1\0\27\1\1\0"+
    "\12\1\1\0\5\1\3\0\10\1\1\0\3\1\1\0\4\1\7\0"+
    "\2\1\1\0\2\1\6\0\4\1\2\0\12\1\22\0\2\1\1\0"+
    "\10\1\1\0\3\1\1\0\27\1\1\0\12\1\1\0\5\1\2\0"+
    "\11\1\1\0\3\1\1\0\4\1\7\0\2\1\7\0\1\1\1\0"+
    "\4\1\2\0\12\1\1\0\2\1\17\0\2\1\1\0\10\1\1\0"+
    "\3\1\1\0\51\1\2\0\10\1\1\0\3\1\1\0\5\1\10\0"+
    "\1\1\10\0\4\1\2\0\12\1\12\0\6\1\2\0\2\1\1\0"+
    "\22\1\3\0\30\1\1\0\11\1\1\0\1\1\2\0\7\1\3\0"+
    "\1\1\4\0\6\1\1\0\1\1\1\0\10\1\22\0\2\1\15\0"+
    "\72\1\4\0\20\1\1\0\12\1\47\0\2\1\1\0\1\1\2\0"+
    "\2\1\1\0\1\1\2\0\1\1\6\0\4\1\1\0\7\1\1\0"+
    "\3\1\1\0\1\1\1\0\1\1\2\0\2\1\1\0\15\1\1\0"+
    "\3\1\2\0\5\1\1\0\1\1\1\0\6\1\2\0\12\1\2\0"+
    "\4\1\40\0\1\1\27\0\2\1\6\0\12\1\13\0\1\1\1\0"+
    "\1\1\1\0\1\1\4\0\12\1\1\0\44\1\4\0\24\1\1\0"+
    "\22\1\1\0\44\1\11\0\1\1\71\0\112\1\6\0\116\1\2\0"+
    "\46\1\1\0\1\1\5\0\1\1\2\0\53\1\1\0\u014d\1\1\0"+
    "\4\1\2\0\7\1\1\0\1\1\1\0\4\1\2\0\51\1\1\0"+
    "\4\1\2\0\41\1\1\0\4\1\2\0\7\1\1\0\1\1\1\0"+
    "\4\1\2\0\17\1\1\0\71\1\1\0\4\1\2\0\103\1\2\0"+
    "\3\1\40\0\20\1\20\0\125\1\14\0\u026c\1\2\0\21\1\1\0"+
    "\32\1\5\0\113\1\3\0\3\1\17\0\15\1\1\0\7\1\13\0"+
    "\25\1\13\0\24\1\14\0\15\1\1\0\3\1\1\0\2\1\14\0"+
    "\124\1\3\0\1\1\3\0\3\1\2\0\12\1\41\0\3\1\2\0"+
    "\12\1\6\0\130\1\10\0\53\1\5\0\106\1\12\0\35\1\3\0"+
    "\14\1\4\0\14\1\12\0\50\1\2\0\5\1\13\0\54\1\4\0"+
    "\32\1\6\0\12\1\46\0\34\1\4\0\77\1\1\0\35\1\2\0"+
    "\13\1\6\0\12\1\15\0\1\1\130\0\114\1\4\0\12\1\21\0"+
    "\11\1\14\0\164\1\14\0\70\1\10\0\12\1\3\0\61\1\122\0"+
    "\3\1\1\0\43\1\11\0\347\1\25\0\u011a\1\2\0\6\1\2\0"+
    "\46\1\2\0\6\1\2\0\10\1\1\0\1\1\1\0\1\1\1\0"+
    "\1\1\1\0\37\1\2\0\65\1\1\0\7\1\1\0\1\1\3\0"+
    "\3\1\1\0\7\1\3\0\4\1\2\0\6\1\4\0\15\1\5\0"+
    "\3\1\1\0\7\1\16\0\5\1\32\0\5\1\20\0\2\1\23\0"+
    "\1\1\13\0\5\1\5\0\6\1\1\0\1\1\15\0\1\1\20\0"+
    "\15\1\3\0\33\1\25\0\15\1\4\0\1\1\3\0\14\1\21\0"+
    "\1\1\4\0\1\1\2\0\12\1\1\0\1\1\3\0\5\1\6\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\4\1\1\0\13\1\2\0"+
    "\4\1\5\0\5\1\4\0\1\1\21\0\51\1\u0a77\0\57\1\1\0"+
    "\57\1\1\0\205\1\6\0\11\1\14\0\46\1\1\0\1\1\5\0"+
    "\1\1\2\0\70\1\7\0\1\1\17\0\30\1\11\0\7\1\1\0"+
    "\7\1\1\0\7\1\1\0\7\1\1\0\7\1\1\0\7\1\1\0"+
    "\7\1\1\0\7\1\1\0\40\1\57\0\1\1\u01d5\0\3\1\31\0"+
    "\17\1\1\0\5\1\2\0\5\1\4\0\126\1\2\0\2\1\2\0"+
    "\3\1\1\0\132\1\1\0\4\1\5\0\51\1\3\0\136\1\21\0"+
    "\33\1\65\0\20\1\u0200\0\u19b6\1\112\0\u51cd\1\63\0\u048d\1\103\0"+
    "\56\1\2\0\u010d\1\3\0\34\1\24\0\60\1\4\0\12\1\1\0"+
    "\31\1\7\0\123\1\45\0\11\1\2\0\147\1\2\0\4\1\1\0"+
    "\4\1\14\0\13\1\115\0\60\1\20\0\1\1\7\0\64\1\14\0"+
    "\105\1\13\0\12\1\6\0\30\1\3\0\1\1\4\0\56\1\2\0"+
    "\44\1\14\0\35\1\3\0\101\1\16\0\13\1\46\0\67\1\11\0"+
    "\16\1\2\0\12\1\6\0\27\1\3\0\2\1\4\0\103\1\30\0"+
    "\3\1\2\0\20\1\2\0\5\1\12\0\6\1\2\0\6\1\2\0"+
    "\6\1\11\0\7\1\1\0\7\1\221\0\53\1\1\0\2\1\2\0"+
    "\12\1\6\0\u2ba4\1\14\0\27\1\4\0\61\1\u2104\0\u016e\1\2\0"+
    "\152\1\46\0\7\1\14\0\5\1\5\0\14\1\1\0\15\1\1\0"+
    "\5\1\1\0\1\1\1\0\2\1\1\0\2\1\1\0\154\1\41\0"+
    "\u016b\1\22\0\100\1\2\0\66\1\50\0\15\1\3\0\20\1\20\0"+
    "\7\1\14\0\2\1\30\0\3\1\31\0\1\1\6\0\5\1\1\0"+
    "\207\1\2\0\1\1\4\0\1\1\13\0\12\1\7\0\32\1\4\0"+
    "\1\1\1\0\32\1\13\0\131\1\3\0\6\1\2\0\6\1\2\0"+
    "\6\1\2\0\3\1\3\0\2\1\3\0\2\1\22\0\3\1\4\0"+
    "\14\1\1\0\32\1\1\0\23\1\1\0\2\1\1\0\17\1\2\0"+
    "\16\1\42\0\173\1\105\0\65\1\210\0\1\1\202\0\35\1\3\0"+
    "\61\1\57\0\37\1\21\0\33\1\65\0\36\1\2\0\44\1\4\0"+
    "\10\1\1\0\5\1\52\0\236\1\2\0\12\1\u0356\0\6\1\2\0"+
    "\1\1\1\0\54\1\1\0\2\1\3\0\1\1\2\0\27\1\252\0"+
    "\26\1\12\0\32\1\106\0\70\1\6\0\2\1\100\0\4\1\1\0"+
    "\2\1\5\0\10\1\1\0\3\1\1\0\33\1\4\0\3\1\4\0"+
    "\1\1\40\0\35\1\203\0\66\1\12\0\26\1\12\0\23\1\215\0"+
    "\111\1\u03b7\0\107\1\37\0\12\1\20\0\73\1\2\0\1\1\22\0"+
    "\31\1\7\0\12\1\6\0\65\1\1\0\12\1\100\0\105\1\13\0"+
    "\12\1\u04a6\0\70\1\10\0\12\1\u0936\0\u036f\1\221\0\143\1\u0b9d\0"+
    "\u042f\1\u33d1\0\u0239\1\u04c7\0\105\1\13\0\57\1\20\0\21\1\u4060\0"+
    "\2\1\u2163\0\5\1\3\0\26\1\2\0\7\1\36\0\4\1\224\0"+
    "\3\1\u01bb\0\125\1\1\0\107\1\1\0\2\1\2\0\1\1\2\0"+
    "\2\1\2\0\4\1\1\0\14\1\1\0\1\1\1\0\7\1\1\0"+
    "\101\1\1\0\4\1\2\0\10\1\1\0\7\1\1\0\34\1\1\0"+
    "\4\1\1\0\5\1\1\0\1\1\3\0\7\1\1\0\u0154\1\2\0"+
    "\31\1\1\0\31\1\1\0\37\1\1\0\31\1\1\0\37\1\1\0"+
    "\31\1\1\0\37\1\1\0\31\1\1\0\37\1\1\0\31\1\1\0"+
    "\10\1\2\0\62\1\u1600\0\4\1\1\0\33\1\1\0\2\1\1\0"+
    "\1\1\2\0\1\1\1\0\12\1\1\0\4\1\1\0\1\1\1\0"+
    "\1\1\6\0\1\1\4\0\1\1\1\0\1\1\1\0\1\1\1\0"+
    "\3\1\1\0\2\1\1\0\1\1\2\0\1\1\1\0\1\1\1\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\2\1\1\0\1\1\2\0"+
    "\4\1\1\0\7\1\1\0\4\1\1\0\4\1\1\0\1\1\1\0"+
    "\12\1\1\0\21\1\5\0\3\1\1\0\5\1\1\0\21\1\u1144\0"+
    "\ua6d7\1\51\0\u1035\1\13\0\336\1\u3fe2\0\u021e\1\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u05ee\0"+
    "\1\1\36\0\140\1\200\0\360\1\uffff\0\uffff\0\ufe12\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\12\2\1\0"+
    "\1\4\1\0\1\2\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\3\2\1\15\1\16\1\17\1\2\1\0"+
    "\1\20\5\2\1\21\4\2\1\22\1\23\1\24\1\25"+
    "\1\26";

  private static int [] zzUnpackAction() {
    int [] result = new int[51];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\34\0\70\0\34\0\124\0\34\0\160\0\214"+
    "\0\250\0\304\0\340\0\374\0\u0118\0\u0134\0\u0150\0\u016c"+
    "\0\160\0\u0188\0\u01a4\0\u01c0\0\70\0\u01dc\0\u01f8\0\u01dc"+
    "\0\70\0\70\0\70\0\u0214\0\u0230\0\u024c\0\70\0\u0268"+
    "\0\u0150\0\u0284\0\u02a0\0\70\0\u02bc\0\u02d8\0\u02f4\0\u0310"+
    "\0\u032c\0\34\0\u0348\0\u0364\0\u0380\0\u039c\0\70\0\70"+
    "\0\70\0\70\0\70";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[51];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\3"+
    "\1\11\1\3\1\12\1\3\1\13\1\14\3\3\1\15"+
    "\2\3\1\16\1\3\1\2\2\3\1\17\1\20\35\0"+
    "\1\3\3\0\1\21\21\3\1\0\4\3\3\0\1\22"+
    "\23\0\1\23\5\0\1\3\4\0\21\3\1\0\4\3"+
    "\1\0\1\3\3\0\1\21\1\3\1\24\17\3\1\0"+
    "\4\3\1\0\1\3\3\0\1\21\4\3\1\25\14\3"+
    "\1\0\4\3\1\0\1\3\3\0\1\21\1\3\1\26"+
    "\1\3\1\27\2\3\1\27\10\3\1\30\1\3\1\0"+
    "\1\31\1\26\2\3\1\0\1\3\3\0\1\21\1\32"+
    "\1\3\1\33\10\3\1\34\5\3\1\0\4\3\1\0"+
    "\1\3\3\0\1\21\11\3\1\35\7\3\1\0\4\3"+
    "\1\0\1\3\3\0\1\21\15\3\1\36\2\3\1\37"+
    "\1\0\4\3\1\0\1\3\3\0\1\21\14\3\1\40"+
    "\4\3\1\0\4\3\1\0\1\3\3\0\1\21\1\3"+
    "\1\41\15\3\1\41\1\3\1\0\1\3\1\41\2\3"+
    "\1\0\1\3\3\0\1\21\21\3\1\0\1\3\1\42"+
    "\2\3\3\0\1\22\57\0\1\43\5\0\1\3\3\0"+
    "\1\21\2\3\1\44\16\3\1\0\4\3\1\0\1\3"+
    "\3\0\1\21\1\3\1\26\15\3\1\26\1\3\1\0"+
    "\1\3\1\26\2\3\1\0\1\3\3\0\1\21\3\3"+
    "\1\27\2\3\1\27\12\3\1\0\4\3\1\0\1\3"+
    "\3\0\1\21\14\3\1\45\4\3\1\0\4\3\1\0"+
    "\1\3\3\0\1\21\12\3\1\46\6\3\1\0\4\3"+
    "\1\0\1\3\3\0\1\21\2\3\1\47\16\3\1\0"+
    "\4\3\1\0\1\3\3\0\1\21\2\3\1\50\16\3"+
    "\1\0\4\3\1\0\1\3\3\0\1\21\16\3\1\51"+
    "\2\3\1\0\4\3\3\0\1\52\31\0\1\3\3\0"+
    "\1\21\11\3\1\53\7\3\1\0\4\3\1\0\1\3"+
    "\3\0\1\21\7\3\1\54\11\3\1\0\4\3\1\0"+
    "\1\3\3\0\1\21\16\3\1\55\2\3\1\0\4\3"+
    "\1\0\1\3\3\0\1\21\16\3\1\56\2\3\1\0"+
    "\4\3\1\0\1\3\3\0\1\21\10\3\1\57\10\3"+
    "\1\0\4\3\1\0\1\3\3\0\1\21\2\3\1\60"+
    "\16\3\1\0\4\3\1\0\1\3\3\0\1\21\13\3"+
    "\1\61\5\3\1\0\4\3\1\0\1\3\3\0\1\21"+
    "\17\3\1\62\1\3\1\0\4\3\1\0\1\3\3\0"+
    "\1\21\17\3\1\63\1\3\1\0\4\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[952];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\1\1\1\11\12\1\1\0"+
    "\1\1\1\0\17\1\1\0\6\1\1\11\11\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[51];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
	public String lexeme;
	public int linea;
	public int columna;
	public char c;
	JTextArea textArea;

	private Symbol symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn+1);
	}

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn+1, value);
	}

	private void error(String mensaje) {
		String error = "Se detecto un Error Lexico en la  posición " + (yycolumn + 1) + " : " + mensaje;
		System.out.println(error);
		this.textArea.append("\n" + error);
	}

	public Lexer (java.io.Reader entrada, JTextArea textArea) {
		this.zzReader = entrada;
		this.textArea = textArea;
	}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2474) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { error("Simbolo invalido <" + yytext() + ">"); return symbol(error, yytext());
            } 
            // fall through
          case 23: break;
          case 2: 
            { System.out.printf(" leido un path\n"); return symbol(PATH, yytext());
            } 
            // fall through
          case 24: break;
          case 3: 
            { /* los ignoramos */
            } 
            // fall through
          case 25: break;
          case 4: 
            { System.out.printf(" leido un espacio\n"); return symbol(ESPACIO, "[ ] (espacio)");
            } 
            // fall through
          case 26: break;
          case 5: 
            { System.out.printf(" leido un enter\n"); return symbol(SALTO);
            } 
            // fall through
          case 27: break;
          case 6: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(LS, yytext());
            } 
            // fall through
          case 28: break;
          case 7: 
            { System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(REMOVER_PERMISOS_CHMOD, yytext());
            } 
            // fall through
          case 29: break;
          case 8: 
            { System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(COMPLET_LS, yytext());
            } 
            // fall through
          case 30: break;
          case 9: 
            { System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(GUION_R_MINUS, yytext());
            } 
            // fall through
          case 31: break;
          case 10: 
            { System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(GUION_R_MAYUS, yytext());
            } 
            // fall through
          case 32: break;
          case 11: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(CP, yytext());
            } 
            // fall through
          case 33: break;
          case 12: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(CD, yytext());
            } 
            // fall through
          case 34: break;
          case 13: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(MV, yytext());
            } 
            // fall through
          case 35: break;
          case 14: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(RM, yytext());
            } 
            // fall through
          case 36: break;
          case 15: 
            { System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(AGREGAR_PERMISOS_CHMOD, yytext());
            } 
            // fall through
          case 37: break;
          case 16: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(PWD, yytext());
            } 
            // fall through
          case 38: break;
          case 17: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(ENCADENACION, yytext());
            } 
            // fall through
          case 39: break;
          case 18: 
            { System.out.printf(" instruccion leida: %s\n", yytext());  return symbol(EXIT, yytext());
            } 
            // fall through
          case 40: break;
          case 19: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(CHMOD, yytext());
            } 
            // fall through
          case 41: break;
          case 20: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(TOUCH, yytext());
            } 
            // fall through
          case 42: break;
          case 21: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(MKDIR, yytext());
            } 
            // fall through
          case 43: break;
          case 22: 
            { System.out.printf(" instruccion leida: %s\n", yytext()); return symbol(RMDIR, yytext());
            } 
            // fall through
          case 44: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Converts an int token code into the name of the
   * token by reflection on the cup symbol class/interface sym
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  private String getTokenName(int token) {
    try {
      java.lang.reflect.Field [] classFields = sym.class.getFields();
      for (int i = 0; i < classFields.length; i++) {
        if (classFields[i].getInt(null) == token) {
          return classFields[i].getName();
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return "UNKNOWN TOKEN";
  }

  /**
   * Same as next_token but also prints the token to standard out
   * for debugging.
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  public java_cup.runtime.Symbol debug_next_token() throws java.io.IOException {
    java_cup.runtime.Symbol s = next_token();
    System.out.println( "line:" + (yyline+1) + " col:" + (yycolumn+1) + " --"+ yytext() + "--" + getTokenName(s.sym) + "--");
    return s;
  }

  /**
   * Runs the scanner on input files.
   *
   * This main method is the debugging routine for the scanner.
   * It prints debugging information about each returned token to
   * System.out until the end of file is reached, or an error occured.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java Lexer [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        Lexer scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new Lexer(reader);
          while ( !scanner.zzAtEOF ) scanner.debug_next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
