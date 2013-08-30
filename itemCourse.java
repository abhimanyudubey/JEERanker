package JEERanker;

public class itemCourse implements Comparable<itemCourse>{
	int closingRank;
	int openingRank;
	int year=0;
	String college;
	String department;
	String category;
	double collegeWeight;
	double departmentWeight;
	double bias;
	
	itemCourse(String s1, String s2, String s3, int i1, int i2, int i3){
		this.openingRank=i1;
		this.closingRank=i2;
		this.year=i3;
		this.college=s1;
		this.department=s2;
		this.category=s3;
		this.collegeWeight=0.0;
		this.departmentWeight=0.0;
		this.bias=0.0;
	}
	itemCourse(String s1, String s2, String s3){
		this.openingRank=0;
		this.closingRank=0;
		this.year=0;
		this.college=s1;
		this.department=s2;
		this.category=s3;
		this.collegeWeight=0.0;
		this.departmentWeight=0.0;
		this.bias=0.0;
	}
	itemCourse(String s1, String s2, String s3, int year){
		this.openingRank=0;
		this.closingRank=0;
		this.year=year;
		this.college=s1;
		this.department=s2;
		this.category=s3;
		this.collegeWeight=0.0;
		this.departmentWeight=0.0;
		this.bias=0.0;
	}
	itemCourse(item i){

		this.openingRank=i.openingRank;
		this.closingRank=i.closingRank;
		this.year=i.year;
		this.college=i.college;
		this.department=i.department;
		this.category=i.category;
		this.collegeWeight=i.collegeWeight;
		this.departmentWeight=i.departmentWeight;
		this.bias=i.bias;
	}
	public int compareTo(itemCourse o) {
		if (this.departmentWeight>o.departmentWeight)
			return 1;
		else if (this.departmentWeight<o.departmentWeight)
			return -1;
		else
			return 0;
	}
}