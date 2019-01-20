package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="w5_import_excel_csv_data",schema="iwb")
public class W5ImportExcelCsvData implements java.io.Serializable {

	private int rowNo;
	private int fileImportId;
	private int customizationId;
	private int importFlag;
	private int excelSheetNo;
	private String excelSheetName;
	private String errorMsg;
	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	private String f;
	private String g;
	private String h;
	private String i;
	private String j;
	private String k;
	private String l;
	private String m;
	private String n;
	private String o;
	private String p;
	private String q;
	private String r;
	private String s;
	private String t;
	private String u;
	private String v;	
	private String w;
	private String x;
	private String y;
	private String z;
	private String aa;
	private String ab;
	private String ac;
	private String ad;
	private String ae;
	private String af;
	private String ag;
	private String ah;
	private String ai;
	private String aj;
	private String ak;
	private String al;
	private String am;
	private String an;
	private String ao;
	private String ap;
	private String aq;
	private String ar;
	private String as;
	private String at;
	private String au;
	private String av;	
	private String aw;
	private String ax;
	private String ay;
	private String az;
	
	public void setCell(String column, String val){
		switch(column){
		case "A":a=val;break;
		case "B":b=val;break;
		case "C":c=val;break;
		case "D":d=val;break;
		case "E":e=val;break;
		case "F":f=val;break;
		case "G":g=val;break;
		case "H":h=val;break;
		case "I":i=val;break;
		case "J":j=val;break;
		case "K":k=val;break;
		case "L":l=val;break;
		case "M":m=val;break;
		case "N":n=val;break;
		case "O":o=val;break;
		case "P":p=val;break;
		case "Q":q=val;break;
		case "R":r=val;break;
		case "S":s=val;break;
		case "T":t=val;break;
		case "U":u=val;break;
		case "V":v=val;break;
		case "W":w=val;break;
		case "X":x=val;break;
		case "Y":y=val;break;
		case "Z":z=val;break;
		case "AA":aa=val;break;
		case "AB":ab=val;break;
		case "AC":ac=val;break;
		case "AD":ad=val;break;
		case "AE":ae=val;break;
		case "AF":af=val;break;
		case "AG":ag=val;break;
		case "AH":ah=val;break;
		case "AI":ai=val;break;
		case "AJ":aj=val;break;
		case "AK":ak=val;break;
		case "AL":al=val;break;
		case "AM":am=val;break;
		case "AN":an=val;break;
		case "AO":ao=val;break;
		case "AP":ap=val;break;
		case "AQ":aq=val;break;
		case "AR":ar=val;break;
		case "AS":as=val;break;
		case "AT":at=val;break;
		case "AU":au=val;break;
		case "AV":av=val;break;
		case "AW":aw=val;break;
		case "AX":ax=val;break;
		case "AY":ay=val;break;
		case "AZ":az=val;break;
		}
	}
	
	@Column(name="file_import_id")
	public int getFileImportId() {
		return fileImportId;
	}
	public void setFileImportId(int fileImportId) {
		this.fileImportId = fileImportId;
	}
	
	@Column(name="import_flag")
	public int getImportFlag() {
		return importFlag;
	}
	public void setImportFlag(int importFlag) {
		this.importFlag = importFlag;
	}
	
	@Id
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}
		
	@Id
	@Column(name="row_no")
	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	@Column(name="excel_sheet_no")
	public int getExcelSheetNo() {
		return excelSheetNo;
	}

	public void setExcelSheetNo(int excelSheetNo) {
		this.excelSheetNo = excelSheetNo;
	}
	
	@Column(name="excel_sheet_name")
	public String getExcelSheetName() {
		return excelSheetName;
	}

	public void setExcelSheetName(String excelSheetName) {
		this.excelSheetName = excelSheetName;
	}
	
	@Column(name="error_msg")
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	@Column(name="a")
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	@Column(name="b")
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	@Column(name="c")
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	@Column(name="d")
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	@Column(name="e")
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	@Column(name="f")
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	@Column(name="g")
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	@Column(name="h")
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	@Column(name="i")
	public String getI() {
		return i;
	}
	public void setI(String i) {
		this.i = i;
	}
	@Column(name="j")
	public String getJ() {
		return j;
	}
	public void setJ(String j) {
		this.j = j;
	}
	@Column(name="k")
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	@Column(name="l")
	public String getL() {
		return l;
	}
	public void setL(String l) {
		this.l = l;
	}
	@Column(name="m")
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	@Column(name="n")
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	@Column(name="o")
	public String getO() {
		return o;
	}
	public void setO(String o) {
		this.o = o;
	}	
	@Column(name="p")
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	@Column(name="q")
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	@Column(name="r")
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	@Column(name="s")
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	@Column(name="t")
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	@Column(name="u")
	public String getU() {
		return u;
	}
	public void setU(String u) {
		this.u = u;
	}
	@Column(name="v")
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	@Column(name="w")
	public String getW() {
		return w;
	}
	public void setW(String w) {
		this.w = w;
	}
	@Column(name="x")
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	@Column(name="y")
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	@Column(name="z")
	public String getZ() {
		return z;
	}
	public void setZ(String z) {
		this.z = z;
	}

	@Column(name="aa")
	public String getAA() {
		return aa;
	}

	public void setAA(String aa) {
		this.aa = aa;
	}

	@Column(name="ab")
	public String getAB() {
		return ab;
	}

	public void setAB(String ab) {
		this.ab = ab;
	}

	@Column(name="ac")
	public String getAC() {
		return ac;
	}

	public void setAC(String ac) {
		this.ac = ac;
	}

	@Column(name="ad")
	public String getAD() {
		return ad;
	}

	public void setAD(String ad) {
		this.ad = ad;
	}

	@Column(name="ae")
	public String getAE() {
		return ae;
	}

	public void setAE(String ae) {
		this.ae = ae;
	}

	@Column(name="af")
	public String getAF() {
		return af;
	}

	public void setAF(String af) {
		this.af = af;
	}

	@Column(name="ag")
	public String getAG() {
		return ag;
	}

	public void setAG(String ag) {
		this.ag = ag;
	}

	@Column(name="ah")
	public String getAH() {
		return ah;
	}

	public void setAH(String ah) {
		this.ah = ah;
	}

	@Column(name="ai")
	public String getAI() {
		return ai;
	}

	public void setAI(String ai) {
		this.ai = ai;
	}

	@Column(name="aj")
	public String getAJ() {
		return aj;
	}

	public void setAJ(String aj) {
		this.aj = aj;
	}

	@Column(name="ak")
	public String getAK() {
		return ak;
	}

	public void setAK(String ak) {
		this.ak = ak;
	}

	@Column(name="al")
	public String getAL() {
		return al;
	}

	public void setAL(String al) {
		this.al = al;
	}

	@Column(name="am")
	public String getAM() {
		return am;
	}

	public void setAM(String am) {
		this.am = am;
	}

	@Column(name="an")
	public String getAN() {
		return an;
	}

	public void setAN(String an) {
		this.an = an;
	}

	@Column(name="ao")
	public String getAO() {
		return ao;
	}

	public void setAO(String ao) {
		this.ao = ao;
	}

	@Column(name="ap")
	public String getAP() {
		return ap;
	}

	public void setAP(String ap) {
		this.ap = ap;
	}

	@Column(name="aq")
	public String getAQ() {
		return aq;
	}

	public void setAQ(String aq) {
		this.aq = aq;
	}

	@Column(name="ar")
	public String getAR() {
		return ar;
	}

	public void setAR(String ar) {
		this.ar = ar;
	}

	@Column(name="as1")
	public String getAS1() {
		return as;
	}

	public void setAS1(String as) {
		this.as = as;
	}

	@Column(name="at")
	public String getAT() {
		return at;
	}

	public void setAT(String at) {
		this.at = at;
	}

	@Column(name="au")
	public String getAU() {
		return au;
	}

	public void setAU(String au) {
		this.au = au;
	}

	@Column(name="av")
	public String getAV() {
		return av;
	}

	public void setAV(String av) {
		this.av = av;
	}

	@Column(name="aw")
	public String getAW() {
		return aw;
	}

	public void setAW(String aw) {
		this.aw = aw;
	}

	@Column(name="ax")
	public String getAX() {
		return ax;
	}

	public void setAX(String ax) {
		this.ax = ax;
	}

	@Column(name="ay")
	public String getAY() {
		return ay;
	}

	public void setAY(String ay) {
		this.ay = ay;
	}

	@Column(name="az")
	public String getAZ() {
		return az;
	}

	public void setAZ(String az) {
		this.az = az;
	}
}
