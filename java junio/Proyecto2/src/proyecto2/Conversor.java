/*
 * Clase conversor 
 */
package proyecto2;

/**
 *
 * @author bryan
 */
public class Conversor {
    //metodo para convertir numeros enteros a letras
    public static String convertidorNumeros(int num)
	{
		String texto = "";
                //miles 2
                if(num>=90000 && num <=99999) { texto += "noventa y "; num-=90000; }
                if(num>=80000 && num <=89999) { texto += "ochenta y "; num-=80000; }
                if(num>=70000 && num <=79999) { texto += "setenta y "; num-=70000; }
                if(num>=60000 && num <=69999) { texto += "sesenta y "; num-=60000; }
                if(num>=50000 && num <=59999) { texto += "cincuenta y "; num-=50000; }
		if(num>=40000 && num <=49999) { texto += "cuarenta y "; num-=40000; }
		if(num>=30000 && num <=39999) { texto += "treinta y "; num-=30000; }
		if(num>=21000 && num <=29999) { texto += "veinti"; num-=20000; }
                if(num>=20000 && num <=20999) { texto += "veinte mil"; num-=20000; }
                if(num>=16000 && num <=19000)  { texto += "dieci"; num-=10000; }
                
		//miles
                if(num>=15000 && num <=15999) { texto += "quince mil "; num-=15000; }
                if(num>=14000 && num <=14999) { texto += "catorce mil "; num-=14000; }
                if(num>=13000 && num <=13999) { texto += "trece mil "; num-=13000; }
                if(num>=12000 && num <=12999) { texto += "doce mil "; num-=12000; }
                if(num>=11000 && num <=11999) { texto += "once mil "; num-=11000; }
                if(num>=10000 && num <=10999) { texto += "diez mil "; num-=10000; }
                if(num>=9000 && num <=9999) { texto += "nueve mil "; num-=9000; }
                if(num>=8000 && num <=8999) { texto += "ocho mil "; num-=8000; }
                if(num>=7000 && num <=7999) { texto += "siete mil "; num-=7000; }
                if(num>=6000 && num <=6999) { texto += "seis mil "; num-=6000; }
                if(num>=5000 && num <=5999) { texto += "cinco mil "; num-=5000; }
		if(num>=4000 && num <=4999) { texto += "cuatro mil "; num-=4000; }
		if(num>=3000 && num <=3999) { texto += "tres mil "; num-=3000; }
		if(num>=2000 && num <=2999) { texto += "dos mil "; num-=2000; }
		if(num>=1000 && num <=1999) { texto += " un mil "; num-=1000; }
		//cientos
		if(num>=900 && num <=999) { texto += "novescientos "; num-=900; }
		if(num>=800 && num <=899) { texto += "ochocientos "; num-=800; }
		if(num>=700 && num <=799) { texto += "setescientos "; num-=700; }
		if(num>=600 && num <=699) { texto += "seiscientos "; num-=600; }
		if(num>=500 && num <=599) { texto += "quinientos "; num-=500; }
		if(num>=400 && num <=499) { texto += "cuatrocientos "; num-=400; }
		if(num>=300 && num <=399) { texto += "trescientos "; num-=300; }
		if(num>=200 && num <=299) { texto += "doscientos "; num-=200; }
		if(num>100 && num <=199)  { texto += "ciento "; num-=100; }
		//decenas
		if(num>=90 && num <=99)  { texto += "noventa "; num-=90; if(num>0)texto+="y "; }
		if(num>=80 && num <=89)  { texto += "ochenta "; num-=80; if(num>0)texto+="y "; }
		if(num>=70 && num <=79)  { texto += "setenta "; num-=70; if(num>0)texto+="y "; }
		if(num>=60 && num <=69)  { texto += "sesenta "; num-=60; if(num>0)texto+="y "; }
		if(num>=50 && num <=59)  { texto += "cincuenta "; num-=50; if(num>0)texto+="y "; }
		if(num>=40 && num <=49)  { texto += "cuarenta "; num-=40; if(num>0)texto+="y "; }
		if(num>=30 && num <=39)  { texto += "treinta "; num-=30; if(num>0)texto+="y "; }
		if(num>20 && num <=29)  { texto += "veinti"; num-=20; }
		if(num>15 && num <=19)  { texto += "dieci"; num-=10; }
		//unidades y casos especiales
		switch(num){
			case 100: texto += "cien"; break;
			case 20: texto += "veinte"; break;
			case 15: texto += "quince"; break;
			case 14: texto += "catorce"; break;
			case 13: texto += "trece"; break;
			case 12: texto += "doce"; break;
			case 11: texto += "once"; break;
			case 10: texto += "diez"; break;
			case 9: texto += "nueve"; break;
			case 8: texto += "ocho"; break;
			case 7: texto += "siete"; break;
			case 6: texto += "seis"; break;
			case 5: texto += "cinco"; break;
			case 4: texto += "cuatro"; break;
			case 3: texto += "tres"; break;
			case 2: texto += "dos"; break;
			case 1: texto += "uno"; break;
		}
		return texto;
	}
    public static String convertirMeses(int num){
     String texto="";
        switch(num){
			case 12: texto = " diciembre "; break;
			case 11: texto = " noviembre "; break;
			case 10: texto = " octubre "; break;
			case 9: texto = " septiembre "; break;
			case 8: texto = " agosto "; break;
			case 7: texto = " julio "; break;
			case 6: texto = " junio "; break;
			case 5: texto = " mayo "; break;
			case 4: texto = " abril "; break;
			case 3: texto = " marzo "; break;
			case 2: texto = " febrero "; break;
			case 1: texto = " enero "; break;
		}
     return texto;
    }
    
}
