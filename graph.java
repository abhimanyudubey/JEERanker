package JEERanker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class graph {
	List<item> data;
	
	public List<item> getSubset(item[] AA){
		List<item> ret = new ArrayList<item>();
		for(int j=0;j<AA.length;j++){
			item A = AA[j];
			for(int i=0;i<this.data.size();i++){
				int score=0,checkscore=0;
				item B = this.data.get(i);
				if(A.college!=null){
					checkscore++;
					if(A.college==B.college)
						score++;
				}
				if(A.department!=null){
					checkscore++;
					if(A.department.contains(B.department))
						score++;
				}
				if(A.year!=0){
					checkscore++;
					if(A.year==B.year)
						score++;
				}
				if(A.category!=null){
					checkscore++;
					if(A.category.contains(B.category)){
						score++;
					}
				}
				if(checkscore==score && !(ret.contains(A)) && score!=0){
					ret.add(B);
				}	
			}
		}
		return ret;
	}
	
	public void loadData(String filename) throws IOException{
		@SuppressWarnings("resource")
		BufferedReader file = new BufferedReader(new FileReader(filename));
		String line;
		while((line = file.readLine())!=null){
			String[] aline = line.split(",");
			int i1=Integer.parseInt(aline[2]);
			int i2=Integer.parseInt(aline[3]);
			int i3=Integer.parseInt(aline[4]);
			String temp = aline[0];
			String college = helper.getCollege(temp.charAt(0));
			String course  = helper.getCourse(temp.substring(1));
			item A = new item(college,course,aline[1],i1,i2,i3);
			this.data.add(A);
		}
	}
	
	public void printData(){
		ListIterator<item> iter = this.data.listIterator();
		while(iter.hasNext()){
			item A =iter.next();
			System.out.println(A.college+" "+A.department+" "+A.year+" "+A.category+" "+A.openingRank+" "+A.closingRank+"\n");
		}
	}
	graph(){
		this.data=new ArrayList<item>();
	}	
	public double getCollegeWeight(String college, String category, double bias, int max){
		ListIterator<item> iter = this.data.listIterator();
		List<item> nl = new ArrayList<item>();
		double wsum=0;
		while(iter.hasNext()){
			item th = iter.next();
			if(th.college.contains(college) && th.category.contains(category)){
				th.collegeWeight=bias*th.openingRank+(1-bias)*th.closingRank;
				nl.add(th);
			}
		}
		for(int i=0;i<nl.size();i++){
			for(int j=i;j<nl.size();j++){
				item ii = nl.get(i);
				item jj = nl.get(j);
				if(ii.collegeWeight>jj.collegeWeight){
					nl.set(nl.indexOf(ii),jj);
					nl.set(nl.indexOf(jj),ii);
				}
			}
		}
		for(int i=0;i<Math.min(max,nl.size());i++){
			wsum+=nl.get(i).collegeWeight;
		}
		wsum/=Math.min(max, nl.size());
		ListIterator<item> reiter = this.data.listIterator();
		while(reiter.hasNext()){
			item th = reiter.next();
			if(th.college.contains(college) && th.category.contains(category)){
				th.collegeWeight=wsum;
			}
		}
		return wsum;
	}
	public double getCourseWeight(String department, String category, double bias, int max){
		ListIterator<item> iter = this.data.listIterator();
		double wsum=0;
		List<item> nl = new ArrayList<item>();
		while(iter.hasNext()){
			item th = iter.next();
			if(th.department.contains(department) && th.category.contains(category)){
				th.departmentWeight=bias*th.openingRank+(1-bias)*th.closingRank;
				nl.add(th);
			}
		}
		for(int i=0;i<nl.size();i++){
			for(int j=i;j<nl.size();j++){
				item ii = nl.get(i);
				item jj = nl.get(j);
				if(ii.departmentWeight>jj.departmentWeight){
					nl.set(nl.indexOf(ii),jj);
					nl.set(nl.indexOf(jj),ii);
				}
			}
		}
		for(int i=0;i<Math.min(max,nl.size());i++){
			wsum+=nl.get(i).departmentWeight;
		}
		wsum/=Math.min(max, nl.size());
		ListIterator<item> reiter = this.data.listIterator();
		while(reiter.hasNext()){
			item th = reiter.next();
			if(th.department.contains(department) && th.category.contains(category)){
				th.departmentWeight=wsum;
			}
		}
		return wsum;
	}
	public List<searchObject> getBestOptions(int rank, double choice) throws IOException{
		double variance,error;
		ListIterator<item> iter = this.data.listIterator();
		List<searchObject> sub = new ArrayList<searchObject>();
		double esum=0;
		while(iter.hasNext()){
			item x = iter.next();
			variance=(x.closingRank-x.openingRank)*(0.001);
			if(rank<x.closingRank+variance && rank>x.openingRank-variance){
				error = x.closingRank+variance-rank;
				esum+=error;
				if(error/rank>2)
					sub.add(new searchObject(x.department,x.college,x.collegeWeight,400,choice,error));
				//System.out.println(x.college+" "+helper.getCourseName(x.department)+" "+error+" "+x.collegeWeight+" "+x.departmentWeight);
				else
					sub.add(new searchObject(x.department,x.college,x.collegeWeight,x.departmentWeight,choice,error));
			}
		}
		ListIterator<searchObject> a = sub.listIterator();
		while(a.hasNext()){
			searchObject x = a.next();
			x.variance/=esum;
		}
		//Getting all likely outcomes.
		Collections.sort(sub);
		for(int i=0;i<sub.size();i++){
			//System.out.println(sub.get(i).college+" "+helper.getCourseName(sub.get(i).course));
		}
		
		return sub;
	}
	public void finalize(String category, double bias, int max) throws IOException{
		item[] init = {new item(null,null,category)};
		this.data=this.getSubset(init);
		List<String> courses = new ArrayList<String>();
		List<String> colleges = new ArrayList<String>();
		ListIterator<item> iter = this.data.listIterator();
		while(iter.hasNext()){
			item x = iter.next();
			if(!courses.contains(x.department))
				courses.add(x.department);
			if(!colleges.contains(x.college))
				colleges.add(x.college);
		}
		ListIterator<String> coliter = colleges.listIterator();
		double ov_colwt=0;
		while(coliter.hasNext()){
			String x = coliter.next();
			ov_colwt+=this.getCollegeWeight(x, category, bias,max);
		}
		ListIterator<item> fcol = this.data.listIterator();
		while(fcol.hasNext()){
			item x = fcol.next();
			x.collegeWeight/=ov_colwt;
		}
		ListIterator<String> depliter = courses.listIterator();
		double ov_depwt=0;
		while(depliter.hasNext()){
			String x = depliter.next();
			ov_depwt+=this.getCourseWeight(x, category, bias,max);
		}
		ListIterator<item> fcol2 = this.data.listIterator();
		while(fcol2.hasNext()){
			item x = fcol2.next();
			x.departmentWeight/=ov_depwt;
		}
		
	}
}
