package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Generated Jun 17, 2007 5:12:14 PM by Hibernate Tools 3.2.0.b9


@Entity
@Table(name="w5_uploaded_data")
public class W5UploadedData implements java.io.Serializable {

	private int rowNo;
	private int fileAttachmentId;
	private int customizationId;
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
	private String a2;
	private String b2;
	private String c2;
	private String d2;
	private String e2;
	private String f2;
	private String g2;
	private String h2;
	private String i2;
	private String j2;
	private String k2;
	private String l2;
	private String m2;
	private String n2;
	private String o2;
	private String p2;
	private String q2;
	private String r2;
	private String s2;
	private String t2;
	private String u2;
	private String v2;	
	private String w2;
	private String x2;
	private String y2;
	private String z2;
	
	public void setCell(int id, String val){
		switch(id){
		case 0:a=val;break;
		case 1:b=val;break;
		case 2:c=val;break;
		case 3:d=val;break;
		case 4:e=val;break;
		case 5:f=val;break;
		case 6:g=val;break;
		case 7:h=val;break;
		case 8:i=val;break;
		case 9:j=val;break;
		case 10:k=val;break;
		case 11:l=val;break;
		case 12:m=val;break;
		case 13:n=val;break;
		case 14:o=val;break;
		case 15:p=val;break;
		case 16:q=val;break;
		case 17:r=val;break;
		case 18:s=val;break;
		case 19:t=val;break;
		case 20:u=val;break;
		case 21:v=val;break;
		case 22:w=val;break;
		case 23:x=val;break;
		case 24:y=val;break;
		case 25:z=val;break;
		case 26:a2=val;break;
		case 27:b2=val;break;
		case 28:c2=val;break;
		case 29:d2=val;break;
		case 30:e2=val;break;
		case 31:f2=val;break;
		case 32:g2=val;break;
		case 33:h2=val;break;
		case 34:i2=val;break;
		case 35:j2=val;break;
		case 36:k2=val;break;
		case 37:l2=val;break;
		case 38:m2=val;break;
		case 39:n2=val;break;
		case 40:o2=val;break;
		case 41:p2=val;break;
		case 42:q2=val;break;
		case 43:r2=val;break;
		case 44:s2=val;break;
		case 45:t2=val;break;
		case 46:u2=val;break;
		case 47:v2=val;break;
		case 48:w2=val;break;
		case 49:x2=val;break;
		case 50:y2=val;break;
		case 51:z2=val;break;
		}
	}
	
	@Column(name="o")
	public String getO() {
		return o;
	}
	public void setO(String o) {
		this.o = o;
	}
	@Id
	@Column(name="row_no")
	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
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

	@Column(name="a2")
	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	@Column(name="b2")
	public String getB2() {
		return b2;
	}

	public void setB2(String b2) {
		this.b2 = b2;
	}

	@Column(name="c2")
	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	@Column(name="d2")
	public String getD2() {
		return d2;
	}

	public void setD2(String d2) {
		this.d2 = d2;
	}

	@Column(name="e2")
	public String getE2() {
		return e2;
	}

	public void setE2(String e2) {
		this.e2 = e2;
	}

	@Column(name="f2")
	public String getF2() {
		return f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	@Column(name="g2")
	public String getG2() {
		return g2;
	}

	public void setG2(String g2) {
		this.g2 = g2;
	}

	@Column(name="h2")
	public String getH2() {
		return h2;
	}

	public void setH2(String h2) {
		this.h2 = h2;
	}

	@Column(name="i2")
	public String getI2() {
		return i2;
	}

	public void setI2(String i2) {
		this.i2 = i2;
	}

	@Column(name="j2")
	public String getJ2() {
		return j2;
	}

	public void setJ2(String j2) {
		this.j2 = j2;
	}

	@Column(name="k2")
	public String getK2() {
		return k2;
	}

	public void setK2(String k2) {
		this.k2 = k2;
	}

	@Column(name="l2")
	public String getL2() {
		return l2;
	}

	public void setL2(String l2) {
		this.l2 = l2;
	}

	@Column(name="m2")
	public String getM2() {
		return m2;
	}

	public void setM2(String m2) {
		this.m2 = m2;
	}

	@Column(name="n2")
	public String getN2() {
		return n2;
	}

	public void setN2(String n2) {
		this.n2 = n2;
	}

	@Column(name="o2")
	public String getO2() {
		return o2;
	}

	public void setO2(String o2) {
		this.o2 = o2;
	}

	@Column(name="p2")
	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	@Column(name="q2")
	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	@Column(name="r2")
	public String getR2() {
		return r2;
	}

	public void setR2(String r2) {
		this.r2 = r2;
	}

	@Column(name="s2")
	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	@Column(name="t2")
	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	@Column(name="u2")
	public String getU2() {
		return u2;
	}

	public void setU2(String u2) {
		this.u2 = u2;
	}

	@Column(name="v2")
	public String getV2() {
		return v2;
	}

	public void setV2(String v2) {
		this.v2 = v2;
	}

	@Column(name="w2")
	public String getW2() {
		return w2;
	}

	public void setW2(String w2) {
		this.w2 = w2;
	}

	@Column(name="x2")
	public String getX2() {
		return x2;
	}

	public void setX2(String x2) {
		this.x2 = x2;
	}

	@Column(name="y2")
	public String getY2() {
		return y2;
	}

	public void setY2(String y2) {
		this.y2 = y2;
	}

	@Column(name="z2")
	public String getZ2() {
		return z2;
	}

	public void setZ2(String z2) {
		this.z2 = z2;
	}

	@Column(name="file_attachment_id")
	public int getFileAttachmentId() {
		return fileAttachmentId;
	}
	public void setFileAttachmentId(int fileAttachmentId) {
		this.fileAttachmentId = fileAttachmentId;
	}
	@Id
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}
}
