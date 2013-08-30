package JEERanker;

public class searchObject implements Comparable<searchObject> {
	String course;
	String college;
	double collegeWeight;
	double courseWeight;
	double choice;
	double variance;
	searchObject(String s1,String s2, double i1, double i2, double i3,double i4){
		this.course=s1;
		this.college=s2;
		this.collegeWeight=i1;
		this.courseWeight=i2;
		this.choice=i3;
		this.variance=i4;
	}
	public int compareTo(searchObject o) {
		searchObject oo = this;
		double w_this = oo.choice*215/16*oo.courseWeight+(1-oo.choice)*oo.collegeWeight;
		double w_o = o.choice*215/16*o.courseWeight+(1-o.choice)*o.collegeWeight;
		if(w_this>w_o)
			return 1;
			else if(w_this<w_o)
			return -1;
			else
			return 0;
	}
}
