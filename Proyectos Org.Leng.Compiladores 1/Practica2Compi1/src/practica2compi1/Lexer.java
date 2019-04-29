/* The following code was generated by JFlex 1.7.0 */

package practica2compi1;

import static practica2compi1.sym.*;
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
    "\10\26\1\47\1\31\1\30\1\0\1\44\1\27\16\26\4\0\1\31"+
    "\2\0\1\37\1\26\3\0\1\35\1\36\1\42\1\40\1\46\1\41"+
    "\1\0\1\43\1\50\11\51\1\45\2\0\1\32\3\0\1\1\1\2"+
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\26\1\12\1\13"+
    "\1\26\1\14\1\15\1\16\1\26\1\17\1\20\1\21\1\22\1\26"+
    "\1\23\1\24\1\25\1\26\1\33\1\0\1\34\1\0\1\26\1\0"+
    "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\26"+
    "\1\12\1\13\1\26\1\14\1\15\1\16\1\26\1\17\1\20\1\21"+
    "\1\22\1\26\1\23\1\24\1\25\1\26\4\0\41\26\2\0\4\26"+
    "\4\0\1\26\2\0\1\26\7\0\1\26\4\0\1\26\5\0\27\26"+
    "\1\0\37\26\1\0\u01ca\26\4\0\14\26\16\0\5\26\7\0\1\26"+
    "\1\0\1\26\21\0\165\26\1\0\2\26\2\0\4\26\10\0\1\26"+
    "\1\0\3\26\1\0\1\26\1\0\24\26\1\0\123\26\1\0\213\26"+
    "\1\0\5\26\2\0\236\26\11\0\46\26\2\0\1\26\7\0\47\26"+
    "\7\0\1\26\1\0\55\26\1\0\1\26\1\0\2\26\1\0\2\26"+
    "\1\0\1\26\10\0\33\26\5\0\3\26\15\0\5\26\6\0\1\26"+
    "\4\0\13\26\5\0\112\26\4\0\146\26\1\0\11\26\1\0\12\26"+
    "\1\0\23\26\2\0\1\26\17\0\74\26\2\0\145\26\16\0\66\26"+
    "\4\0\1\26\5\0\56\26\22\0\34\26\104\0\1\26\1\0\13\26"+
    "\67\0\33\26\1\0\144\26\2\0\12\26\1\0\7\26\1\0\7\26"+
    "\1\0\3\26\1\0\10\26\2\0\2\26\2\0\26\26\1\0\7\26"+
    "\1\0\1\26\3\0\4\26\2\0\11\26\2\0\2\26\2\0\4\26"+
    "\10\0\1\26\4\0\2\26\1\0\5\26\2\0\16\26\7\0\1\26"+
    "\5\0\3\26\1\0\6\26\4\0\2\26\2\0\26\26\1\0\7\26"+
    "\1\0\2\26\1\0\2\26\1\0\2\26\2\0\1\26\1\0\5\26"+
    "\4\0\2\26\2\0\3\26\3\0\1\26\7\0\4\26\1\0\1\26"+
    "\7\0\20\26\13\0\3\26\1\0\11\26\1\0\3\26\1\0\26\26"+
    "\1\0\7\26\1\0\2\26\1\0\5\26\2\0\12\26\1\0\3\26"+
    "\1\0\3\26\2\0\1\26\17\0\4\26\2\0\12\26\1\0\1\26"+
    "\17\0\3\26\1\0\10\26\2\0\2\26\2\0\26\26\1\0\7\26"+
    "\1\0\2\26\1\0\5\26\2\0\11\26\2\0\2\26\2\0\3\26"+
    "\10\0\2\26\4\0\2\26\1\0\5\26\2\0\12\26\1\0\1\26"+
    "\20\0\2\26\1\0\6\26\3\0\3\26\1\0\4\26\3\0\2\26"+
    "\1\0\1\26\1\0\2\26\3\0\2\26\3\0\3\26\3\0\14\26"+
    "\4\0\5\26\3\0\3\26\1\0\4\26\2\0\1\26\6\0\1\26"+
    "\16\0\12\26\11\0\1\26\7\0\3\26\1\0\10\26\1\0\3\26"+
    "\1\0\27\26\1\0\12\26\1\0\5\26\3\0\10\26\1\0\3\26"+
    "\1\0\4\26\7\0\2\26\1\0\2\26\6\0\4\26\2\0\12\26"+
    "\22\0\2\26\1\0\10\26\1\0\3\26\1\0\27\26\1\0\12\26"+
    "\1\0\5\26\2\0\11\26\1\0\3\26\1\0\4\26\7\0\2\26"+
    "\7\0\1\26\1\0\4\26\2\0\12\26\1\0\2\26\17\0\2\26"+
    "\1\0\10\26\1\0\3\26\1\0\51\26\2\0\10\26\1\0\3\26"+
    "\1\0\5\26\10\0\1\26\10\0\4\26\2\0\12\26\12\0\6\26"+
    "\2\0\2\26\1\0\22\26\3\0\30\26\1\0\11\26\1\0\1\26"+
    "\2\0\7\26\3\0\1\26\4\0\6\26\1\0\1\26\1\0\10\26"+
    "\22\0\2\26\15\0\72\26\4\0\20\26\1\0\12\26\47\0\2\26"+
    "\1\0\1\26\2\0\2\26\1\0\1\26\2\0\1\26\6\0\4\26"+
    "\1\0\7\26\1\0\3\26\1\0\1\26\1\0\1\26\2\0\2\26"+
    "\1\0\15\26\1\0\3\26\2\0\5\26\1\0\1\26\1\0\6\26"+
    "\2\0\12\26\2\0\4\26\40\0\1\26\27\0\2\26\6\0\12\26"+
    "\13\0\1\26\1\0\1\26\1\0\1\26\4\0\12\26\1\0\44\26"+
    "\4\0\24\26\1\0\22\26\1\0\44\26\11\0\1\26\71\0\112\26"+
    "\6\0\116\26\2\0\46\26\1\0\1\26\5\0\1\26\2\0\53\26"+
    "\1\0\u014d\26\1\0\4\26\2\0\7\26\1\0\1\26\1\0\4\26"+
    "\2\0\51\26\1\0\4\26\2\0\41\26\1\0\4\26\2\0\7\26"+
    "\1\0\1\26\1\0\4\26\2\0\17\26\1\0\71\26\1\0\4\26"+
    "\2\0\103\26\2\0\3\26\40\0\20\26\20\0\125\26\14\0\u026c\26"+
    "\2\0\21\26\1\0\32\26\5\0\113\26\3\0\3\26\17\0\15\26"+
    "\1\0\7\26\13\0\25\26\13\0\24\26\14\0\15\26\1\0\3\26"+
    "\1\0\2\26\14\0\124\26\3\0\1\26\3\0\3\26\2\0\12\26"+
    "\41\0\3\26\2\0\12\26\6\0\130\26\10\0\53\26\5\0\106\26"+
    "\12\0\35\26\3\0\14\26\4\0\14\26\12\0\50\26\2\0\5\26"+
    "\13\0\54\26\4\0\32\26\6\0\12\26\46\0\34\26\4\0\77\26"+
    "\1\0\35\26\2\0\13\26\6\0\12\26\15\0\1\26\130\0\114\26"+
    "\4\0\12\26\21\0\11\26\14\0\164\26\14\0\70\26\10\0\12\26"+
    "\3\0\61\26\122\0\3\26\1\0\43\26\11\0\347\26\25\0\u011a\26"+
    "\2\0\6\26\2\0\46\26\2\0\6\26\2\0\10\26\1\0\1\26"+
    "\1\0\1\26\1\0\1\26\1\0\37\26\2\0\65\26\1\0\7\26"+
    "\1\0\1\26\3\0\3\26\1\0\7\26\3\0\4\26\2\0\6\26"+
    "\4\0\15\26\5\0\3\26\1\0\7\26\16\0\5\26\32\0\5\26"+
    "\20\0\2\26\23\0\1\26\13\0\5\26\5\0\6\26\1\0\1\26"+
    "\15\0\1\26\20\0\15\26\3\0\33\26\25\0\15\26\4\0\1\26"+
    "\3\0\14\26\21\0\1\26\4\0\1\26\2\0\12\26\1\0\1\26"+
    "\3\0\5\26\6\0\1\26\1\0\1\26\1\0\1\26\1\0\4\26"+
    "\1\0\13\26\2\0\4\26\5\0\5\26\4\0\1\26\21\0\51\26"+
    "\u0a77\0\57\26\1\0\57\26\1\0\205\26\6\0\11\26\14\0\46\26"+
    "\1\0\1\26\5\0\1\26\2\0\70\26\7\0\1\26\17\0\30\26"+
    "\11\0\7\26\1\0\7\26\1\0\7\26\1\0\7\26\1\0\7\26"+
    "\1\0\7\26\1\0\7\26\1\0\7\26\1\0\40\26\57\0\1\26"+
    "\u01d5\0\3\26\31\0\17\26\1\0\5\26\2\0\5\26\4\0\126\26"+
    "\2\0\2\26\2\0\3\26\1\0\132\26\1\0\4\26\5\0\51\26"+
    "\3\0\136\26\21\0\33\26\65\0\20\26\u0200\0\u19b6\26\112\0\u51cd\26"+
    "\63\0\u048d\26\103\0\56\26\2\0\u010d\26\3\0\34\26\24\0\60\26"+
    "\4\0\12\26\1\0\31\26\7\0\123\26\45\0\11\26\2\0\147\26"+
    "\2\0\4\26\1\0\4\26\14\0\13\26\115\0\60\26\20\0\1\26"+
    "\7\0\64\26\14\0\105\26\13\0\12\26\6\0\30\26\3\0\1\26"+
    "\4\0\56\26\2\0\44\26\14\0\35\26\3\0\101\26\16\0\13\26"+
    "\46\0\67\26\11\0\16\26\2\0\12\26\6\0\27\26\3\0\2\26"+
    "\4\0\103\26\30\0\3\26\2\0\20\26\2\0\5\26\12\0\6\26"+
    "\2\0\6\26\2\0\6\26\11\0\7\26\1\0\7\26\221\0\53\26"+
    "\1\0\2\26\2\0\12\26\6\0\u2ba4\26\14\0\27\26\4\0\61\26"+
    "\u2104\0\u016e\26\2\0\152\26\46\0\7\26\14\0\5\26\5\0\14\26"+
    "\1\0\15\26\1\0\5\26\1\0\1\26\1\0\2\26\1\0\2\26"+
    "\1\0\154\26\41\0\u016b\26\22\0\100\26\2\0\66\26\50\0\15\26"+
    "\3\0\20\26\20\0\7\26\14\0\2\26\30\0\3\26\31\0\1\26"+
    "\6\0\5\26\1\0\207\26\2\0\1\26\4\0\1\26\13\0\12\26"+
    "\7\0\32\26\4\0\1\26\1\0\32\26\13\0\131\26\3\0\6\26"+
    "\2\0\6\26\2\0\6\26\2\0\3\26\3\0\2\26\3\0\2\26"+
    "\22\0\3\26\4\0\14\26\1\0\32\26\1\0\23\26\1\0\2\26"+
    "\1\0\17\26\2\0\16\26\42\0\173\26\105\0\65\26\210\0\1\26"+
    "\202\0\35\26\3\0\61\26\57\0\37\26\21\0\33\26\65\0\36\26"+
    "\2\0\44\26\4\0\10\26\1\0\5\26\52\0\236\26\2\0\12\26"+
    "\u0356\0\6\26\2\0\1\26\1\0\54\26\1\0\2\26\3\0\1\26"+
    "\2\0\27\26\252\0\26\26\12\0\32\26\106\0\70\26\6\0\2\26"+
    "\100\0\4\26\1\0\2\26\5\0\10\26\1\0\3\26\1\0\33\26"+
    "\4\0\3\26\4\0\1\26\40\0\35\26\203\0\66\26\12\0\26\26"+
    "\12\0\23\26\215\0\111\26\u03b7\0\107\26\37\0\12\26\20\0\73\26"+
    "\2\0\1\26\22\0\31\26\7\0\12\26\6\0\65\26\1\0\12\26"+
    "\100\0\105\26\13\0\12\26\u04a6\0\70\26\10\0\12\26\u0936\0\u036f\26"+
    "\221\0\143\26\u0b9d\0\u042f\26\u33d1\0\u0239\26\u04c7\0\105\26\13\0\57\26"+
    "\20\0\21\26\u4060\0\2\26\u2163\0\5\26\3\0\26\26\2\0\7\26"+
    "\36\0\4\26\224\0\3\26\u01bb\0\125\26\1\0\107\26\1\0\2\26"+
    "\2\0\1\26\2\0\2\26\2\0\4\26\1\0\14\26\1\0\1\26"+
    "\1\0\7\26\1\0\101\26\1\0\4\26\2\0\10\26\1\0\7\26"+
    "\1\0\34\26\1\0\4\26\1\0\5\26\1\0\1\26\3\0\7\26"+
    "\1\0\u0154\26\2\0\31\26\1\0\31\26\1\0\37\26\1\0\31\26"+
    "\1\0\37\26\1\0\31\26\1\0\37\26\1\0\31\26\1\0\37\26"+
    "\1\0\31\26\1\0\10\26\2\0\62\26\u1600\0\4\26\1\0\33\26"+
    "\1\0\2\26\1\0\1\26\2\0\1\26\1\0\12\26\1\0\4\26"+
    "\1\0\1\26\1\0\1\26\6\0\1\26\4\0\1\26\1\0\1\26"+
    "\1\0\1\26\1\0\3\26\1\0\2\26\1\0\1\26\2\0\1\26"+
    "\1\0\1\26\1\0\1\26\1\0\1\26\1\0\1\26\1\0\2\26"+
    "\1\0\1\26\2\0\4\26\1\0\7\26\1\0\4\26\1\0\4\26"+
    "\1\0\1\26\1\0\12\26\1\0\21\26\5\0\3\26\1\0\5\26"+
    "\1\0\21\26\u1144\0\ua6d7\26\51\0\u1035\26\13\0\336\26\u3fe2\0\u021e\26"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u05ee\0"+
    "\1\26\36\0\140\26\200\0\360\26\uffff\0\uffff\0\ufe12\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\12\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\1\1\16"+
    "\2\17\1\0\1\20\2\0\1\21\1\22\1\23\2\0"+
    "\1\24\1\0\1\25\1\26\2\0\1\27\2\0\1\30"+
    "\1\0\1\31\1\32\1\33\1\0\4\11\1\0\1\34"+
    "\16\0\1\11\11\0\1\35\1\36\6\0\1\11\3\0"+
    "\1\37\4\0\1\40\5\0\1\11\6\0\1\41\3\0"+
    "\1\11\6\0\2\42\5\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[129];
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
    "\0\0\0\52\0\124\0\176\0\250\0\322\0\374\0\u0126"+
    "\0\u0150\0\u017a\0\u01a4\0\52\0\52\0\52\0\52\0\52"+
    "\0\52\0\52\0\u01ce\0\52\0\52\0\52\0\52\0\u01f8"+
    "\0\52\0\52\0\u0222\0\u024c\0\52\0\u0276\0\u02a0\0\52"+
    "\0\52\0\52\0\u02ca\0\u02f4\0\52\0\u031e\0\52\0\52"+
    "\0\u0348\0\u0372\0\52\0\u039c\0\u03c6\0\52\0\u03f0\0\52"+
    "\0\52\0\52\0\u041a\0\u0444\0\u046e\0\u0498\0\52\0\u04c2"+
    "\0\u01f8\0\u04ec\0\u0516\0\u0540\0\u056a\0\u0594\0\u05be\0\u05e8"+
    "\0\u0612\0\u063c\0\u0666\0\u0690\0\u06ba\0\u06e4\0\u070e\0\u0738"+
    "\0\u0762\0\u078c\0\u07b6\0\u07e0\0\u080a\0\u0834\0\u085e\0\u0888"+
    "\0\u08b2\0\u08dc\0\52\0\u0906\0\u0930\0\u095a\0\u0984\0\u09ae"+
    "\0\u09d8\0\u0a02\0\u0a2c\0\u0a56\0\u0a80\0\52\0\u0aaa\0\u0ad4"+
    "\0\u0afe\0\u0b28\0\52\0\u0b52\0\u0b7c\0\u0ba6\0\u0bd0\0\u0bfa"+
    "\0\u0c24\0\u0c4e\0\u0c78\0\u0ca2\0\u0ccc\0\u0cf6\0\u0d20\0\52"+
    "\0\u0d4a\0\u0d74\0\u0d9e\0\u0dc8\0\u0df2\0\u0e1c\0\u0e46\0\u0e70"+
    "\0\u0e9a\0\u0ec4\0\u0444\0\52\0\u0eee\0\u0f18\0\u0f42\0\u0f6c"+
    "\0\u0f96";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[129];
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
    "\2\2\1\3\1\4\2\2\1\5\1\2\1\6\2\2"+
    "\1\7\2\2\1\10\1\11\1\12\1\13\5\2\1\14"+
    "\1\15\1\14\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\14\1\30\1\31\1\14"+
    "\1\32\1\33\53\0\1\34\10\0\1\35\52\0\1\36"+
    "\1\0\1\37\1\0\1\40\1\41\35\0\1\42\10\0"+
    "\1\43\45\0\1\44\7\0\1\45\35\0\1\46\13\0"+
    "\1\47\34\0\1\50\1\51\7\0\1\52\4\0\1\53"+
    "\34\0\1\54\3\0\1\55\7\0\1\56\40\0\1\57"+
    "\10\0\1\60\34\0\1\61\1\62\7\0\1\63\34\0"+
    "\1\64\26\65\1\66\1\67\13\64\1\0\2\64\1\70"+
    "\2\65\1\0\26\71\12\0\1\71\5\0\3\71\50\0"+
    "\2\33\3\0\1\72\53\0\1\73\57\0\1\74\55\0"+
    "\1\75\36\0\1\76\53\0\1\77\57\0\1\100\55\0"+
    "\1\101\47\0\1\102\42\0\1\103\57\0\1\104\37\0"+
    "\1\105\1\106\1\107\44\0\27\64\1\66\1\67\13\64"+
    "\1\0\2\64\1\0\3\64\26\110\1\66\1\67\13\64"+
    "\1\0\2\64\1\111\2\110\30\0\1\67\22\0\26\111"+
    "\20\0\3\111\12\0\1\112\40\0\1\113\65\0\1\114"+
    "\57\0\1\115\33\0\1\116\65\0\1\47\34\0\1\117"+
    "\15\0\1\120\40\0\1\121\12\0\1\122\1\123\31\0"+
    "\1\124\54\0\1\125\64\0\1\126\33\0\1\127\63\0"+
    "\1\130\51\0\1\131\32\0\1\64\26\132\1\66\1\67"+
    "\13\64\1\0\2\64\1\133\2\132\1\0\26\133\20\0"+
    "\3\133\23\0\1\134\45\0\1\135\51\0\1\136\33\0"+
    "\1\137\71\0\1\140\45\0\1\141\52\0\1\53\54\0"+
    "\1\142\55\0\1\143\25\0\1\144\71\0\1\56\51\0"+
    "\1\145\44\0\1\146\36\0\1\147\51\0\1\150\50\0"+
    "\1\64\26\151\1\66\1\67\13\64\1\0\2\64\1\152"+
    "\2\151\1\0\26\152\20\0\3\152\1\0\1\153\70\0"+
    "\1\41\50\0\1\154\54\0\1\155\52\0\1\156\37\0"+
    "\1\157\61\0\1\160\52\0\1\161\50\0\1\162\53\0"+
    "\1\61\46\0\1\163\31\0\1\64\26\164\1\66\1\67"+
    "\13\64\1\0\2\64\1\165\2\164\1\0\26\165\20\0"+
    "\3\165\17\0\1\166\36\0\1\42\64\0\1\167\46\0"+
    "\1\50\52\0\1\170\53\0\1\171\37\0\1\172\51\0"+
    "\1\62\44\0\1\64\26\173\1\66\1\67\13\64\1\0"+
    "\2\64\1\174\2\173\1\0\26\174\20\0\3\174\4\0"+
    "\1\35\66\0\1\175\44\0\1\176\56\0\1\177\47\0"+
    "\1\40\45\0\1\200\62\0\1\122\1\123\37\0\1\201"+
    "\43\0\1\45\51\0\1\60\44\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4032];
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
    "\1\0\1\11\11\1\7\11\1\1\4\11\1\1\2\11"+
    "\1\1\1\0\1\11\2\0\3\11\2\0\1\11\1\0"+
    "\2\11\2\0\1\11\2\0\1\11\1\0\3\11\1\0"+
    "\3\1\1\11\1\0\1\1\16\0\1\1\11\0\1\1"+
    "\1\11\6\0\1\1\3\0\1\11\4\0\1\11\5\0"+
    "\1\1\6\0\1\11\3\0\1\1\6\0\1\1\1\11"+
    "\5\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[129];
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

	private void error(String error, int linea, int columna) {
		String mensaje = "Se detecto un Error Lexico en la  Linea:" + linea + "  Columna: " + columna+"  El error:"+error;
		System.out.println(mensaje);
		this.textArea.append("\n" + mensaje);
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
    while (i < 2540) {
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
            { error(yytext(),yyline+1,yycolumn+1); return symbol(error, yytext());
            } 
            // fall through
          case 35: break;
          case 2: 
            { /* los ignoramos */
            } 
            // fall through
          case 36: break;
          case 3: 
            { System.out.printf(" SIGUIENTE INSTRUCCION: %s\n", yytext()); return symbol(SALTO, yytext());
            } 
            // fall through
          case 37: break;
          case 4: 
            { System.out.printf(" IGUAL: %s\n", yytext()); return symbol(IGUAL, yytext());
            } 
            // fall through
          case 38: break;
          case 5: 
            { System.out.printf(" CORCHETE_A: %s\n", yytext()); return symbol(CORCHETE_A, yytext());
            } 
            // fall through
          case 39: break;
          case 6: 
            { System.out.printf(" CORCHETE_C: %s\n", yytext()); return symbol(CORCHETE_C, yytext());
            } 
            // fall through
          case 40: break;
          case 7: 
            { System.out.printf(" PARENT_A: %s\n", yytext()); return symbol(PARENT_A, yytext());
            } 
            // fall through
          case 41: break;
          case 8: 
            { System.out.printf(" PARENT_C: %s\n", yytext()); return symbol(PARENT_C, yytext());
            } 
            // fall through
          case 42: break;
          case 9: 
            { System.out.printf(" COMENTARIO_LINEA: %s\n", yytext()); return symbol(COMENTARIO_LINEA, yytext());
            } 
            // fall through
          case 43: break;
          case 10: 
            { System.out.printf(" SUMA: %s\n", yytext()); return symbol(SUMA, yytext());
            } 
            // fall through
          case 44: break;
          case 11: 
            { System.out.printf(" RESTA: %s\n", yytext()); return symbol(RESTA, yytext());
            } 
            // fall through
          case 45: break;
          case 12: 
            { System.out.printf(" MULT: %s\n", yytext()); return symbol(MULT, yytext());
            } 
            // fall through
          case 46: break;
          case 13: 
            { System.out.printf(" DIV: %s\n", yytext()); return symbol(DIV, yytext());
            } 
            // fall through
          case 47: break;
          case 14: 
            { System.out.printf(" COMA: %s\n", yytext()); return symbol(COMA, yytext());
            } 
            // fall through
          case 48: break;
          case 15: 
            { System.out.printf(" NUMERO_ENTERO: %s\n", yytext()); return symbol(NUMERO_ENTERO, new Integer(yytext()));
            } 
            // fall through
          case 49: break;
          case 16: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(BACKWARD, yytext());
            } 
            // fall through
          case 50: break;
          case 17: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(TO_CENTER, yytext());
            } 
            // fall through
          case 51: break;
          case 18: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(CLEARS, yytext());
            } 
            // fall through
          case 52: break;
          case 19: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(FORWARD, yytext());
            } 
            // fall through
          case 53: break;
          case 20: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(HIDE_TURTLE, yytext());
            } 
            // fall through
          case 54: break;
          case 21: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(LEFT, yytext());
            } 
            // fall through
          case 55: break;
          case 22: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(PEN_DOWN, yytext());
            } 
            // fall through
          case 56: break;
          case 23: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(PEN_UP, yytext());
            } 
            // fall through
          case 57: break;
          case 24: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(RIGHT, yytext());
            } 
            // fall through
          case 58: break;
          case 25: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(SHOW_TURTLE, yytext());
            } 
            // fall through
          case 59: break;
          case 26: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(TO_DRAW, yytext());
            } 
            // fall through
          case 60: break;
          case 27: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(TO_ERASE, yytext());
            } 
            // fall through
          case 61: break;
          case 28: 
            { System.out.printf(" VARIABLE: %s\n", yytext()); return symbol(VARIABLE, yytext());
            } 
            // fall through
          case 62: break;
          case 29: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(POSITION_X, yytext());
            } 
            // fall through
          case 63: break;
          case 30: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(POSITION_Y, yytext());
            } 
            // fall through
          case 64: break;
          case 31: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(COLOR, yytext());
            } 
            // fall through
          case 65: break;
          case 32: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(POSITION_XY, yytext());
            } 
            // fall through
          case 66: break;
          case 33: 
            { System.out.printf(" INSTRUCCION: %s\n", yytext()); return symbol(REPEAT, yytext());
            } 
            // fall through
          case 67: break;
          case 34: 
            { System.out.printf(" COLOR: %s\n", yytext()); return symbol(CODIGO_COLOR, yytext());
            } 
            // fall through
          case 68: break;
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