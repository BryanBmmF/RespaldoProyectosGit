package codigo3d;

/**
 *
 * @author bryan
 */
public class Expr {
    private String lugarTemp;
    private String code;

    public Expr(String lugarTemp, String code) {
        this.lugarTemp = lugarTemp;
        this.code = code;
    }

    public Expr() {
    }

    public String getLugarTemp() {
        return lugarTemp;
    }

    public void setLugarTemp(String lugarTemp) {
        this.lugarTemp = lugarTemp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
}
